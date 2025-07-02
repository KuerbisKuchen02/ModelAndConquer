package models.generated;

import compiler.GameLexer;
import compiler.GameParser;
import models._static.*;

import java.util.Scanner;

public class Game extends GenericElement {
    private final Player player;
    private boolean isRunning = true;
    private GenericElement[] elements;
    private final Scanner sc = new Scanner(System.in);

    /**
     * Generated
     * */
    public Game() {
        // Temp for testing purposes
        super("Mega nice game", "My Description");
        Area startPos = new Area("Start", "This is the first room", null, null, null);

        this.player = new Player(null, null, 0.0, 0.0, null, null, null);
        player.setPosition(startPos);
    }

    /**
     * Static
     * */
    public void gameLoop() {
        while (isRunning){
            try {
                System.out.print("> ");
                String s = sc.nextLine();
                GameParser parser = new GameParser(new GameLexer(s));
                parser.parse();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Tries moving the player to a given direction.
     * @param direction The direction to move to.
     */
    public void move(EDirection direction) {
        Connection[] curConnections = player.getPosition().getConnections();
        curConnections[direction.getValue()].tryTraverse();
    }

    /**
     * Lets the player attack the given entity with the given item.
     * @param entity entity which should be attacked
     * @param item used item to attack
     */
    public void attack(Entity entity, Item item) {
        // TODO
        if (item != null && player.isInInventory(item)) {
            entity.takeDamage(item.getDamage(), item.getDamageType());

            // Apply Effects if entity is a monster
            if (entity instanceof Monster) {
                // TODO
                // applyEffect(monster.getOnHit(), );
            }

            if (!entity.hasHealthLeft()) {
                // Apply OnDeathEffect if entity is a monster
                if (entity instanceof Monster) {
                // TODO
                }
            }
        }
    }

    public void use(Item item) {
        if (!player.isInInventory(item)) {
            throw new IllegalArgumentException("You can't use an item that is not in your inventory");
        }

        // TODO: apply onUse Effect??

        if (item.isConsumable()) {
            player.getInventory().remove(item);
        }

    }

    /**
     * Makes the Player pickup a defined item.
     * Only possible when the item is located in the room the Player is currently in.
     * @param item The item to pickup
     */
    public void pickUp(Item item) {
        if (!player.isInInventory(item)) {
            player.getInventory().add(item);
            player.getPosition().removeItem(item);
        } else {
            throw new IllegalArgumentException("The Player already has this item");
        }

    }

    /**
     * Makes the Player drop a defined item. The item gets added to the room the player is currently in.
     * @param item The item to drop
     */
    public void drop(Item item) {
        if (player.isInInventory(item)) {
            player.getInventory().remove(item);
            player.getPosition().addItem(item);
        } else {
            throw new IllegalArgumentException("You can't drop an item that is not in your inventory");
        }
    }

    /**
     * Inspects a GenericGameElement and prints the name and description.
     * @param element
     */
    public void inspect(String element) {

        switch (element.toLowerCase()) {
            case "area":
            case "room":
                System.out.println(player.getPosition().toString());
                break;
            case "player":
                System.out.println(player.toString());

        }
        // TODO:
    }

    private void applyEffect(Effect effect, GenericElement element) {
        // TODO:
    }


}
