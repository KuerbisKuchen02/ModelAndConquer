package models.generated;

import compiler.GameParser;
import models._static.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game extends GenericElement {
    private static final String TAG = Game.class.getSimpleName();
    private Player player;
    private boolean isRunning = true;
    private Area[] areas;
    private Connection[] connections;
    private EDamageType[] damageTypes;
    private Effect[] effects;
    private final Scanner sc = new Scanner(System.in);
    private static Game game = null;
    private final GameParser parser;

    /**
     * Generated
     * */
    private Game() {
        // TODO objects need to be generated
        super("", "");
        parser = new GameParser(this);

    }

    public static void main(String[] args) {
        Game game = getGame();
        game.gameLoop();
    }

    public static Game getGame(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    /**
     * Static
     * */
    public void gameLoop() {
        help();  // Initially print help messages

        while (isRunning){
            try {
                System.out.print("> ");
                String s = sc.nextLine();
                parser.parse(s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            for(Monster monster : player.getPosition().getMonsters()) {
                for(Effect effect : monster.getEffects()) {
                    // Only apply Effects which have a duration. Currently only HealthEffects
                    if(effect instanceof HealthEffect) ((HealthEffect) effect).apply();
                }
            }
        }
    }

    /**
     * Tries moving the player to a given direction.
     * @param directionString The direction to move to.
     */
    public void move(String directionString) {
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

        entity.takeDamage(item.getDamage(), item.getDamageType());

        // Apply Effect from the used Item
        applyEffect(item.getOnUse(), player, entity);

        // Apply Effects if entity is a monster
        if (entity instanceof Monster monster) {
            applyEffect(monster.getOnHit(), monster, player);
        }

        if (!entity.hasHealthLeft()) {
            // Apply OnDeathEffect if entity is a monster
            if (entity instanceof Monster) {
                applyEffect(((Monster) entity).getOnKill(), player, entity);
            }
        }

        if (item.isConsumable()) {
            player.getInventory().remove(item);
        }
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
    }

    /**
     * Prints a help message describing the game.
     */
    public void help() {
        System.out.println("Welcome Player to " + getName() + "!\n" + getDescription() + "\n");
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
        } else {
            throw new IllegalArgumentException("The Player already has this item");
        }

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
    }

    /**
     * Inspects a GenericGameElement and prints the name and description.
     * @param element The element to inspect.
     */
    public void inspect(String element) {

        switch (element) {
            case "area":
                System.out.println(player.getPosition().toString());
                return;
            case "player":
                System.out.println(player.toString());
                return;
        }
        for (Item item : player.getInventory()) {
            if (item.getName().equals(element)) {
                System.out.println(item.toString());
                return;
            }
        }
        // Was ist denn mit Carsten los?...
        // ***** Boom *****
        // ...Das sieht gar nicht gut aus
        GenericElement genericElement = getGenericElementInArea(element);
        System.out.println((genericElement));
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

    /**
     * Has to be generated...
     * @param damageType
     * @return
     */
    private EDamageType getDamageTypeFromString(String damageType) {
        return null;
    }

    private Effect getEffectFromString(String effect) {
        for (Effect e : effects) {
            if (e.getName().equals(effect)) {
                return e;
            }
        }
        return null;
    }
}
