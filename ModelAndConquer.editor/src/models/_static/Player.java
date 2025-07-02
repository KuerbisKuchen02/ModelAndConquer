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

    public Player(String name, String description, double health, double maxHealth,  ArrayList<Item> inventory,
                   Effect[] Effects,  ArrayList<DamageModificator> damageModificators) {
        super(name, description, health, maxHealth, inventory, Effects, damageModificators);
        Player.player = this;
    }

    @Override
    public String toString() {
        return super.toString() + "You are in the area: " + position.getName();
    }

    public void heal(double amount){
        this.health+= amount;
        if(this.health > this.maxHealth) this.health = this.maxHealth;
    }

}
