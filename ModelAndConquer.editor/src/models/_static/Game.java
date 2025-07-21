package models._static;

import compiler.GameParser;
import models.generated.DungeonFactory;

import java.util.ArrayList;
import java.util.Arrays;
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
        Logger.init();
        try {
            new DungeonFactory().generate().gameLoop();
        } catch (Exception e) {
            System.out.println("Game could not be started because of an error while generating: " + e.getMessage());
            Logger.error(TAG, Arrays.toString(e.getStackTrace()));
        }
    }


    public void gameLoop() throws InterruptedException {
    	System.out.println("\n" + AsciiArtPrinter.convertToAsciiArt(getName()));  
    	System.out.println(getDescription());
        help();  // Initially print help messages
        System.out.println("If you need help, type: help\n");
        
        player.getPosition().setVisited(true);  // Set the Spawnpoint as visited
        while (isRunning){
            wasATurn = false;
            try {
                System.out.print("> ");
                String s = sc.nextLine();
                parser.parse(s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Logger.error(TAG, Arrays.toString(e.getStackTrace()));
            }

            if(isRunning && inFight && wasATurn){
                // while in a fight, monsters turn to hit
                ArrayList<Monster> monsters = player.getPosition().getMonsters();
                if(!monsters.isEmpty()){
                    for(Monster monster : monsters){
                    	Thread.sleep(2000);
                        double dmg = player.takeDamage(monster.getDamage(), monster.getDamageType(), monster.getAccuracy());
                        if(dmg != -1){
                            applyEffect(monster.getOnDamage(), monster, player);
                            System.out.println("\nYou got hit by " + monster.getName() + " for " + dmg + "\n");
                        }

                        if (player.getHealth() <= 0) {
                        	System.out.println();
                            System.out.println(AsciiArtPrinter.convertToAsciiArt("Game Over!"));
                            isRunning = false;
                            return;
                        }
                    }
                    System.out.println(fightHealthBars(monsters));
                }
                else{
                    System.out.println("You have defeated all monsters in this area.\n");
                    inFight = false;
                }
            }
            // Apply Effects after the Player's turn
            if (wasATurn) {
                player.clearEffects();
                // Apply Effect for the Player
                for (Effect effect : player.getEffects()) {
                    // Only apply Effects which have a duration. Currently only HealthEffects and DamageModificatorEffects
                    if (effect instanceof HealthEffect) System.out.println(effect.apply());
                    if (effect instanceof DamageModificatorEffect) System.out.println(effect.apply());
                }

                // Apply Effects for all Monsters in the area
                for(Monster monster : player.getPosition().getMonsters()) {
                    monster.clearEffects();
                    for(Effect effect : monster.getEffects()) {
                        // Only apply Effects which have a duration. Currently only HealthEffects
                        if(effect instanceof HealthEffect) System.out.println(effect.apply());
                        if (effect instanceof DamageModificatorEffect) System.out.println(effect.apply());
                    }
                }
            }
        }
    }


    /**
     * String to display health bars during fight
     * @param monsters List of monsters to display
     * @return String containing players health bar left aligned and monster health bars right aligned
     */
    private String fightHealthBars(ArrayList<Monster> monsters){
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
        Logger.debug(TAG, "Player tries to move to direction: " + directionString);
        if (inFight){
            Logger.info(TAG, "Player tried to move while in a fight!");
            System.out.println("\nYou cannot move while you are in a fight!\n");
            return;
        }

        EDirection direction = getDirection(directionString);
        if (direction == null) {
            System.out.println("\nYou need to enter a valid direction!\n");
            Logger.warn(TAG, "Direction " + directionString + " not found!");
            return;
        }
        Connection connection = player.getPosition().getConnections()[direction.getValue()];
        if (connection == null) {
        	System.out.println("\nYou cannot go there...\n");
            Logger.warn(TAG, "Connection in direction " + direction + " not found!");
        	return;
        }
        if(connection.tryTraverse()) {
            applyEffect(connection.getOnTraverse(), connection, player);
        	Area newArea = connection.getAreaA() == player.getPosition() ?
                            connection.getAreaB() : connection.getAreaA();
            player.setPosition(newArea);
        	newArea.setVisited(true);
        	System.out.println("\n**********************************************************\n");
        	System.out.println("You have entered the area: " + newArea.getNameAndDescription());
        	System.out.println("\n**********************************************************\n");

            if (newArea.getOnEnter() != null) {
                applyEffect(newArea.getOnEnter(), player, newArea);
            }
            wasATurn = true;
        }
    }

    /**
     * Lets the player attack the given entity with the given item.
     * @param entityString entity, which should be attacked
     * @param itemString used item to attack
     */
    public void attack(String entityString, String itemString) {
        Logger.debug(TAG, "Player tries to attack entity: " + entityString + " with item: " + itemString);
        Entity entity = getEntityInArea(entityString);
        Item item = itemString.isEmpty() ? new Item("Hand", "", 1.0, false, 1) : getItemFromInventory(itemString);
        Logger.debug(TAG, "Entity: " + entity + ", Item: " + item);
        if (item == null) {
            System.out.println("\nYou need to enter a valid item!\n");
            Logger.warn(TAG, "Item " + itemString + " not found!");
            return;
        } else if (entity == null) {
            System.out.println("\nYou need to enter a valid entity!\n");
            Logger.warn(TAG, "Entity " +  entityString + " not found!");
            return;
        }

        double dmg = entity.takeDamage(item.getDamage(), item.getDamageType(), item.getAccuracy());
        if(dmg != -1) {
        	System.out.println("\n**********************************************************\n");
        	System.out.println("You hit " + entity.getName() + " for " + dmg + "\n");
        	
        	// Apply Effect from the used Item
            applyEffect(item.getOnUse(), player, entity);
            
            // Apply Effects if the entity is a monster
            if (entity instanceof Monster monster) {
                if(!inFight) inFight = true;
                applyEffect(monster.getOnHit(), monster, player);
                System.out.println(fightHealthBars(player.getPosition().getMonsters()));
            }
        }

        if (!entity.hasHealthLeft()) {
            // Apply OnDeathEffect if the entity is a monster
        	System.out.println(entity.getName() + " has been defeated.\n");
            if (entity instanceof Monster) {
                applyEffect(((Monster) entity).getOnKill(), player, entity);
            }

            // Show dropped items
            if (!entity.getInventory().isEmpty()) {
                System.out.println(entity.getName() + " dropped the following items:");
                for (Item droppedItem : entity.getInventory()) {
                    System.out.println("\t- " + droppedItem.toShortString());
                }
            	System.out.println("**********************************************************\n");
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
        Logger.debug(TAG, "Player tries to use item: " + itemString + " on element: " + genericElementString);
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
            System.out.println("\nYou need to enter a valid item!\n");
            Logger.warn(TAG, "Item " + itemString + " not found!");
            return;
        } else if (element == null) {
            System.out.println("\nYou need to enter a valid element!\n");
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
            case Entity a:
                applyEffect(item.getOnUse(), player, element);
                break;
            default:
                Logger.warn(TAG, "Element " + element.getName() + " is not usable with an item");
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
                """
                        
                        **********************************************************
                        
                        You are able to do the following actions:
                         - walk | go | move (north | south | west | east | up | down)
                         - hit | attack <Monster> [with <Item>]
                         - use <Item> [on <Monster | Connection>]
                         - take <Item>
                         - drop <Item>
                         - inspect, look area | player | item
                         - unlock <Connection> with <Item>
                        
                        **********************************************************
                        """
        );
    }

    /**
     * Makes the Player pick up a defined item.
     * Only possible when the item is located in the room the Player is currently in.
     * @param itemString The item to pickup
     */
    public void pickUp(String itemString) {
        Logger.debug(TAG, "Player tries to pick up item: " + itemString);
        Item item = getItemFromArea(itemString);
        if (item == null) {
            System.out.println("You need to enter an item which is inside the current room!");
            Logger.warn(TAG, "Item " + itemString + " not in this room!");
            return;
        }

        if (!player.isInInventory(item)) {
            player.getInventory().add(item);
            player.getPosition().removeItem(item);
            System.out.println("\nPicked up " + item.getName() + ".\n");
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
        Logger.debug(TAG, "Player tries to drop item: " + itemString);
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

        // Delete the effect which was given on pickup
        if (item.getOnPickup() != null) {
            deleteEffect(player, item.getOnPickup());
        }

        wasATurn = true;
    }

    /**
     * Inspects a GenericGameElement and prints the name and description.
     * @param element The element to inspect.
     */
    public void inspect(String element) {
        Logger.debug(TAG, "Player tries to inspect element: " + element);
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
            if(genericElement instanceof Item){
                System.out.println(((Item) genericElement).toShortString());
            }
            else{
                System.out.println(genericElement);
            }
        } else {
            System.out.println("\nThere is nothing to inspect which has this name.\n");
        }
    }

    public void applyEffect(Effect effect, GenericElement self, GenericElement other) throws RuntimeException {
        if (effect == null) {
            return;
        }
    	Logger.debug(TAG, "Applying effect: " + effect.getName() + " to " + other.getName() + " from " + self.getName());
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
            }
            case EndGameEffect a -> {
            	System.out.println();
                System.out.println(AsciiArtPrinter.convertToAsciiArt("Victory!"));
                isRunning = false;
                return;
            }
            case null, default -> throw new RuntimeException("How did we get here? endGameEffect");
        }

        System.out.println(effect.apply());
    }

    /**
     * Deletes an effect from the active effectlist of an entity.
     * @param entity The entity to delete the effect from.
     * @param effect The effect to delete.
     */
    public void deleteEffect(Entity entity, Effect effect) {
        entity.getEffects().removeIf(EntityEffect -> EntityEffect.getName().equals(effect.getName()));
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
