package models._static;

import java.util.ArrayList;

public class Player extends Entity implements IHealable {
    private Area position;
    private static Player player;

    public Area getPosition() {
        return position;
    }

    public void setPosition(Area pos) {
        position = pos;
    }

    public Player(String name, String description, double maxHealth,  ArrayList<Item> inventory,
                   ArrayList<Effect> effects,  ArrayList<DamageModificator> damageModificators) {
        super(name, description, maxHealth, inventory, effects, damageModificators);
        Player.player = this;
    }

    @Override
    public String toString() {
        return super.toString() + "\n> You are in the area: " + position.getName() + "\n==========================================================";
    }

    public void heal(double amount){
        this.health+= amount;
        if(this.health > this.maxHealth) this.health = this.maxHealth;
    }

}
