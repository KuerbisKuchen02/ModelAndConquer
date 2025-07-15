package models._static;

import compiler.GameParser;
import models.generated.DungeonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends GenericElement {
    private static final String TAG = Game.class.getSimpleName();
    private final Player player;
    private boolean isRunning = true;
    private final Scanner sc = new Scanner(System.in);
    private final GameParser parser;
    private boolean inFight = false;
    private boolean wasATurn = false;

    public Game(String name, String description, Player player) {
        super(name, description);
        this.player = player;
        this.parser = new GameParser(this);
    }

    public static void main(String[] args) {
        new DungeonFactory().generate().gameLoop();
    }

    public void gameLoop() {
        help();  // Initially print help messages
        player.getPosition().setVisited(true);  // Set the Spawnpoint as visited
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
                // while in a fight, monsters turn to hit
                ArrayList<Monster> monsters = player.getPosition().getMonsters();
                if(!monsters.isEmpty()){
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
                    if(effect instanceof HealthEffect) effect.apply();
                }
            }
        }
    }


    private String fightHealthBars(Player player, ArrayList<Monster> monsters){
        StringBuilder ret = new StringBuilder(player.healthBarString(true));
        for(Monster monster : monsters){
            ret.append("\n").append(monster.healthBarString(false));
        }
        return ret.toString();
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
        Connection connection = player.getPosition().getConnections()[direction.getValue()];
        if(connection.tryTraverse()) {
            applyEffect(connection.getOnTraverse(), player, connection);
        	Area newArea = connection.getAreaA() == player.getPosition() ?
                            connection.getAreaB() : connection.getAreaA();
            player.setPosition(newArea);
        	newArea.setVisited(true);
        	System.out.println("You have entered the area: " + newArea.shortToString());
            if (newArea.getOnEnter() != null) {
                applyEffect(newArea.getOnEnter(), player, newArea);
            }
        }
    }

    /**
     * Lets the player attack the given entity with the given item.
     * @param entityString entity, which should be attacked
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

        double dmg = entity.takeDamage(item.getDamage(), item.getDamageType(), item.getAccuracy());
        if(dmg != -1) System.out.println("You hit " + entity.getName() + " for " + dmg);
        
        // Apply Effect from the used Item
        applyEffect(item.getOnUse(), player, entity);

        // Apply Effects if the entity is a monster
        if (entity instanceof Monster monster) {
            if(!inFight) inFight = true;
            applyEffect(monster.getOnHit(), monster, player);
            System.out.println(fightHealthBars(player, player.getPosition().getMonsters()));
        }

        if (!entity.hasHealthLeft()) {
            // Apply OnDeathEffect if the entity is a monster
        	System.out.println(entity.getName() + " has been defeated.");
            if (entity instanceof Monster) {
                applyEffect(((Monster) entity).getOnKill(), player, entity);
            }

            // Show dropped items
            if (!entity.getInventory().isEmpty()) {
                System.out.println(entity.getName() + " dropped the following items:");
                for (Item droppedItem : entity.getInventory()) {
                    System.out.println("\t" + droppedItem.toShortString());
                }
            }

            entity.dropItems(player.getPosition());
            player.getPosition().removeEntity((INonPlayerEntity) entity);
        }

        if (item.isConsumable()) {
            player.getInventory().remove(item);
        }
        wasATurn = true;
    }

    public void use(String itemString, String genericElementString) {
        GenericElement element;
        if (genericElementString == null
                || genericElementString.isEmpty()
                || genericElementString.equals("self")
                || genericElementString.equals("player")) {
            element = player;
        } else {
            element = getGenericElementInArea(genericElementString);
        }
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
            case Entity _:
                applyEffect(item.getOnUse(), player, element);
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
                        + getDescription() + "\n"
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
     * Makes the Player pick up a defined item.
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
            System.out.println("Picked up " + item.getName() + ".");
        } else {
            throw new IllegalArgumentException("The Player already has this item");
        }

        if (item.getOnPickup() != null) {
            applyEffect(item.getOnPickup(), player, item);
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
            System.out.println("Dropped " + item.getName() + ".");
        } else {
            throw new IllegalArgumentException("You can't drop an item that is not in your inventory");
        }

        if (item.getOnDrop() != null) {
            applyEffect(item.getOnDrop(), player, item);
        }

        wasATurn = true;
    }

    /**
     * Inspects a GenericGameElement and prints the name and description.
     * @param element The element to inspect.
     */
    public void inspect(String element) {
        switch (element) {
            case "area", "room", "location", "place":
                System.out.println(player.getPosition());
                return;
            case "player", "self":
                System.out.println(player);
                return;
        }
        if (player.getPosition().getName().toLowerCase().equals(element)) {
            System.out.println(player.getPosition());
            return;
        }

        Item item = getItemFromInventory(element);
        if (item != null) {
            System.out.println(item);
            return;
        }

        GenericElement genericElement = getGenericElementInArea(element);
        if (genericElement != null) {
            System.out.println((genericElement));
        } else {
            System.out.println("There is nothing to inspect which has this name.");
        }
    }

    public void applyEffect(Effect effect, GenericElement self, GenericElement other) throws RuntimeException {
    	if(effect == null) return;
        switch (effect) {
            case HealthEffect healthEffect -> {
                GenericElement target = healthEffect.isOnSelf() ? self : other;
                if (target instanceof IHealable) {
                    healthEffect.setTarget((IHealable) target);
                } else {
                   Logger.warn(TAG, target.getName() + " is not a healable!");
                   return;
                }
            }
            case DamageModificatorEffect damageModificatorEffect -> {
                GenericElement target = damageModificatorEffect.isOnSelf() ? self : other;
                if (target instanceof Entity) {
                    damageModificatorEffect.setTarget((Entity) target);
                } else {
                    Logger.warn(TAG, target.getName() + " is not a entity!");
                    return;
                }
            }
            case SpawnEffect spawnEffect -> {
                List<INonPlayerEntity> entities = spawnEffect.getNonPlayerEntities();
                for (INonPlayerEntity entity : entities) {
                    if (entity instanceof Monster monster) {
                        if (monster.getOnSpawn() != null) {
                            applyEffect(monster.getOnSpawn(), monster, spawnEffect.getArea());
                        }
                    }
                }
                applyEffect(spawnEffect, self, other);
            }
            case EndGameEffect _ -> {
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
            if (((GenericElement)e).getName().toLowerCase().contains(entity)) {
                return (Entity) e;
            }
        }
        return null;
    }


    private Item getItemFromArea(String item) {
        for (Item i : player.getPosition().getItems()) {
            if (i.getName().toLowerCase().contains(item)) {
                return i;
            }
        }
        return null;
    }

    private Item getItemFromInventory(String item) {
        for (Item i : player.getInventory()) {
            if (i.getName().toLowerCase().contains(item)) {
                return i;
            }
        }
        return null;
    }

    private EDirection getDirection(String direction) {
        return switch (direction.toLowerCase()) {
            case "north", "n" -> EDirection.NORTH;
            case "south", "s" -> EDirection.SOUTH;
            case "east", "e" -> EDirection.EAST;
            case "west", "w" -> EDirection.WEST;
            case "up", "u" -> EDirection.UP;
            case "down", "d" -> EDirection.DOWN;
            default -> null;
        };
    }
}
