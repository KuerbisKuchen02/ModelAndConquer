package compiler;

import models.generated.Game;

public class GameParser {

    private final Game game;

    public GameParser(Game game) {
        this.game = game;
    }

    public void parse(String input) {
        String[] splits = input.split(" ", 1);
        String command = splits[0];
        String rest = splits[1];
        switch (command) {
            case "move", "go", "walk" -> move(rest);
            case "hit", "attack" -> attack(rest);
            case "use" -> use(rest);
            case "take" -> take(rest);
            case "drop" -> drop(rest);
            case "inspect", "look" -> inspect(rest);
            case "unlock" -> unlock(rest);
            case "help"  -> help();
            case "Schokokuchen" -> schokoKuchen();
        }
    }

    private String[] getNames(String input) {
        return input.split("on|with");
    }


    private void move(String input){
        game.move(input);
    }

    private void attack(String input){
        String[] parameters = getNames(input);
        if (parameters.length != 2) {
            throw new IllegalArgumentException();
        }
        game.attack(parameters[0], parameters[1]);
    }

    private void take(String input){

    }

    private void use(String input){

    }

    private void drop(String input) {

    }

    private void schokoKuchen(){

    }

    private void help(){
        // TODO write help message
        System.out.println("");
    }

    private void inspect(String input){

    }

    private void unlock(String input){

    }
}
