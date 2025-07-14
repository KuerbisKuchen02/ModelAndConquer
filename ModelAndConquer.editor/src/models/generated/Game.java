package models.generated;

import compiler.GameParser;
import models._static.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game extends GenericElement {
    private static final String TAG = Game.class.getSimpleName();
    private final Player player;
    private boolean isRunning = true;
    private final Scanner sc = new Scanner(System.in);
    private final GameParser parser;
    private boolean inFight = false;
    private boolean wasATurn = false;

    /**
     * Generated
     */
    public Game(String name, String description, Player player) {
        super(name, description);
        this.player = player;
        this.parser = new GameParser(this);
    }

    public static void main(String[] args) {
        DungeonGenerator.generate().gameLoop();
    }

    public void gameLoop() {
        help();  // Initially print help messages
        while (isRunning){
            wasATurn = false;
            try {
                System.out.print("> ");
                String s = sc.nextLine();
                parser.parse(s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if(inFight && wasATurn){
                // while in fight monsters turn to hit
                ArrayList<Monster> monsters = player.getPosition().getMonsters();
                if(monsters.isEmpty()){
                    for(Monster monster : monsters){
                        double dmg = player.takeDamage(monster.getDamage(), monster.getDamageType(), monster.getAccuracy());
                        if(dmg != -1){
                            applyEffect(monster.getOnDamage(), monster, player);
                            System.out.println("You got hit by " + monster.getName() + " for " + dmg);
                        }
                    }
                    System.out.println(fightHealthBars(player, monsters));
                }
                else{
                    System.out.println("You have defeated all monsters in this area");
                    inFight = false;
                }
            }

            for(Monster monster : player.getPosition().getMonsters()) {
                for(Effect effect : monster.getEffects()) {
                    // Only apply Effects which have a duration. Currently only HealthEffects
                    if(effect instanceof HealthEffect) ((HealthEffect) effect).apply();
                }
            }
        }
    }


    private String fightHealthBars(Player player, ArrayList<Monster> monsters){
        String ret = player.healthBarString(true);
        for(Monster monster : monsters){
            ret += "\n" + monster.healthBarString(false);
        }
        return ret;
    }


    /**
     * Tries moving the player to a given direction.
     * @param directionString The direction to move to.
     */
    public void move(String directionString) {
        if (inFight){
            System.out.println("You cannot move while you are in a fight!");
            return;
        }

        EDirection direction = getDirection(directionString);
        if (direction == null) {
            System.out.println("You need to enter a valid direction!");
            Logger.warn(TAG, "Direction " + directionString + " not found!");
            return;
        }

        Connection[] curConnections = player.getPosition().getConnections();
        curConnections[direction.getValue()].tryTraverse();
    }

    /**
     * Lets the player attack the given entity with the given item.
     * @param entityString entity which should be attacked
     * @param itemString used item to attack
     */
    public void attack(String entityString, String itemString) {
        Entity entity = getEntityInArea(entityString);
        Item item = getItemFromInventory(itemString);
        if (item == null) {
            System.out.println("You need to enter a valid item!");
            Logger.warn(TAG, "Item " + itemString + " not found!");
            return;
        } else if (entity == null) {
            System.out.println("You need to enter a valid entity!");
            Logger.warn(TAG, "Entity " +  entityString + " not found!");
            return;
        }

        entity.takeDamage(item.getDamage(), item.getDamageType(), item.getAccuracy());

        // Apply Effect from the used Item
        applyEffect(item.getOnUse(), player, entity);

        // Apply Effects if entity is a monster
        if (entity instanceof Monster monster) {
            if(!inFight) inFight = true;
            applyEffect(monster.getOnHit(), monster, player);
            System.out.println(fightHealthBars(player, player.getPosition().getMonsters()));
        }

        if (!entity.hasHealthLeft()) {
            // Apply OnDeathEffect if entity is a monster
            if (entity instanceof Monster) {
                applyEffect(((Monster) entity).getOnKill(), player, entity);
                player.getPosition().removeEntity((INonPlayerEntity) entity);
            }
        }

        if (item.isConsumable()) {
            player.getInventory().remove(item);
        }
        wasATurn = true;
    }

    public void use(String itemString, String genericElementString) {
        GenericElement element = getGenericElementInArea(genericElementString);
        Item item = getItemFromInventory(itemString);
        if (item == null) {
            System.out.println("You need to enter a valid item!");
            Logger.warn(TAG, "Item " + itemString + " not found!");
            return;
        } else if (element == null) {
            System.out.println("You need to enter a valid element!");
            Logger.warn(TAG, "Element " + genericElementString + " not found!");
            return;
        }

        if (!player.isInInventory(item)) {
            throw new IllegalArgumentException("You can't use an item that is not in your inventory");
        }

        switch(element) {
            case Connection connection:
                connection.tryUnlock(item);
                break;
            case Entity entity:
                item.getOnUse().apply();
                break;
            default:
                throw new IllegalStateException("How did you get here");
        }

        if (item.isConsumable()) {
            player.getInventory().remove(item);
        }
        wasATurn = true;
    }

    /**
     * Prints a help message describing the game and all available actions.
     */
    public void help() {
        System.out.println(
                "==========================================================\n"
                        + "Hello! Welcome to: "+ getName() + "!\n"
                        + getDescription()
                        + "==========================================================\n"
                        + "You are able to do the following actions:\n"
                        + "walk | go | walk (north | south | west | east | up | down)\n"
                        + "hit | attack <Monster> [with <Item>]\n"
                        + "use <Item> [on <Monster | Connection>]\n"
                        + "take <Item>\n"
                        + "drop <Item>\n"
                        + "inspect, look area | player | item\n"
                        + "unlock <Connection> with <Item>\n"
                        + "==========================================================\n"
                        + "If you need help, type: help\n"
        );
    }

    /**
     * Makes the Player pickup a defined item.
     * Only possible when the item is located in the room the Player is currently in.
     * @param itemString The item to pickup
     */
    public void pickUp(String itemString) {
        Item item = getItemFromArea(itemString);
        if (item == null) {
            System.out.println("You need to enter an item which is inside the current room!");
            Logger.warn(TAG, "Item " + itemString + " not in this room!");
            return;
        }

        if (!player.isInInventory(item)) {
            player.getInventory().add(item);
            player.getPosition().removeItem(item);
            System.out.println("Picked up " + itemString + ".");
        } else {
            throw new IllegalArgumentException("The Player already has this item");
        }

        wasATurn = true;
    }

    /**
     * Makes the Player drop a defined item. The item gets added to the room the player is currently in.
     * @param itemString The item to drop
     */
    public void drop(String itemString) {
        Item item = getItemFromInventory(itemString);
        if (item == null) {
            System.out.println("You need to enter an item which is inside your inventory!");
            Logger.warn(TAG, "Item " + itemString + " not in ths player inventory!");
            return;
        }

        if (player.isInInventory(item)) {
            player.getInventory().remove(item);
            player.getPosition().addItem(item);
        } else {
            throw new IllegalArgumentException("You can't drop an item that is not in your inventory");
        }
        wasATurn = true;
    }

    /**
     * Inspects a GenericGameElement and prints the name and description.
     * @param element The element to inspect.
     */
    public void inspect(String element) {
        switch (element) {
            case "area":
                System.out.println(player.getPosition());
                return;
            case "player":
                System.out.println(player.toString());
                return;
        }

        for (Item item : player.getInventory()) {
            if (item.getName().equals(element)) {
                System.out.println(item);
                return;
            }
        }

        GenericElement genericElement = getGenericElementInArea(element);
        if (genericElement != null) {
            System.out.println((genericElement));
        } else {
            System.out.println("There is nothing to inspect which has this name.");
        }
    }

    public void applyEffect(Effect effect, GenericElement self, GenericElement other) throws RuntimeException {
        switch (effect) {
            case HealthEffect healthEffect -> {
                GenericElement target = healthEffect.isOnSelf() ? self : other;
                if (target instanceof IHealable) {
                    healthEffect.setTarget((IHealable) target);
                } else {
                   Logger.warn(TAG, target + " is not a healable!");
                   return;
                }
            }
            case DamageModificatorEffect damageModificatorEffect -> {
                GenericElement target = damageModificatorEffect.isOnSelf() ? self : other;
                if (target instanceof Entity) {
                    damageModificatorEffect.setTarget((Entity) target);
                } else {
                    Logger.warn(TAG, target + " is not a entity!");
                    return;
                }
            }
            case EndGameEffect endGameEffect -> {
                isRunning = false;
                return;
            }
            case null, default -> throw new RuntimeException("How did we get here? endGameEffect");
        }

        effect.apply();
    }

    private GenericElement getGenericElementInArea(String genericElementString) {
        Area area = player.getPosition();
        GenericElement genericElement = getEntityInArea(genericElementString);
        if (genericElement != null) return genericElement;
        genericElement = getItemFromArea(genericElementString);
        if (genericElement != null) return genericElement;
        EDirection direction = getDirection(genericElementString);
        if (direction != null) {
            genericElement = area.getConnections()[direction.getValue()];
        }
        return genericElement;
    }

    private Entity getEntityInArea(String entity) {
        for (INonPlayerEntity e : player.getPosition().getEntities()) {
            if (((GenericElement)e).getName().equals(entity)) {
                return (Entity) e;
            }
        }
        return null;
    }


    private Item getItemFromArea(String item) {
        for (Item i : player.getPosition().getItems()) {
            if (i.getName().equals(item)) {
                return i;
            }
        }
        return null;
    }

    private Item getItemFromInventory(String item) {
        for (Item i : player.getInventory()) {
            if (i.getName().equals(item)) {
                return i;
            }
        }
        return null;
    }

    private EDirection getDirection(String direction) {
        return switch (direction.toLowerCase()) {
            case "north" -> EDirection.NORTH;
            case "south" -> EDirection.SOUTH;
            case "east" -> EDirection.EAST;
            case "west" -> EDirection.WEST;
            case "up" -> EDirection.UP;
            case "down" -> EDirection.DOWN;
            default -> null;
        };
    }
}
