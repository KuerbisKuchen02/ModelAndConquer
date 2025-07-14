package compiler;

import models._static.EndGameEffect;
import models._static.Game;

public class GameParser {

    private final Game game;

    public GameParser(Game game) {
        this.game = game;
    }

    public void parse(String input) {
        /*
        Commands:
        - walk | go | walk (north | south | west | east | up | down)
        - hit | attack <Monster> [with <Item>]
        - use <Item> [on <Monster | Connection>]
        - take <Item>
        - drop <Item>
        - inspect, look <GenericElement>
        - unlock <Connection> with <Item>
        - help
        - Schokokuchen -> End Game
        */
        String[] splits = input.split(" ", 2);

        String command = splits[0];  // This is the command to execute
        // This is the rest of the command which needs to be handled accordingly
        String rest = (splits.length == 2) ? splits[1].trim().toLowerCase() : "";

        switch (command) {
            case "move", "go", "walk", "m" -> move(rest);
            case "hit", "attack", "a" -> attack(rest);
            case "use", "u" -> use(rest);
            case "take", "t" -> take(rest);
            case "drop", "d" -> drop(rest);
            case "inspect", "look", "i" -> inspect(rest);
            case "unlock" -> unlock(rest);
            case "help", "h"  -> help();
            case "Schokokuchen" -> schokoKuchen();
            default -> System.out.println("This command does not exist!");
        }
    }

    /**
     * Splits a command to only returns objects.
     * F.e input {@code Sword on Goblin} returns {@code ["Sword", "Goblin"]}
     * @param input The command to split
     * @return
     */
    private String[] getNames(String input) {
    	String[] splits = input.split("on|with");
    	for (int i = 0; i < splits.length; i++) {
    		splits[i] = splits[i].trim();
    	}
        return splits;
    }


    private void move(String input){
        game.move(input);
    }

    private void attack(String input){
        String[] parameters = getNames(input);

        if (parameters.length != 2) {
            throw new IllegalArgumentException("Attacking requires exactly one item and entity to attack");
        }
        game.attack(parameters[0], parameters[1]);
    }

    private void take(String input){
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Taking Items must specify exactly one item to take");
        }
        game.pickUp(input);
    }

    private void use(String input){
        String[] parameters = getNames(input);

        if (parameters.length != 2) {
            throw new IllegalArgumentException("Using items requires exactly one item and entity");
        }
        game.use(parameters[0], parameters[1]);
    }

    private void drop(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Dropping Items must specify exactly one item to drop");
        }
        game.drop(input);
    }

    private void schokoKuchen(){
        EndGameEffect endGameEffect = new EndGameEffect("Congratulations", "You have won the game!");
        game.applyEffect(endGameEffect, null, null);
    }

    private void help(){
        game.help();
    }

    private void inspect(String input){
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Inspecting must contain exactly one thing.");
        }
        game.inspect(input);
    }

    private void unlock(String input){
        String[] parameters = getNames(input);

        if (parameters.length != 2) {
            throw new IllegalArgumentException("Unlocking requires exactly one item and one Connection");
        }
        game.use(parameters[0], parameters[1]);
    }
}
