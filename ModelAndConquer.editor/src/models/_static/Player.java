package models._static;

import java.util.ArrayList;

public class Player extends Entity implements IHealable {
    private Area position;

    public Player(String name,
                  String description,
                  double maxHealth,
                  ArrayList<DamageModificator> damageModificators,
                  ArrayList<Item> inventory,
                  double evasionChance) {
        super(name, description, maxHealth, damageModificators, inventory, evasionChance);
    }

    public void heal(double amount){
        this.health+= amount;
        if(this.health > this.maxHealth) this.health = this.maxHealth;
    }

    public Area getPosition() {
        return position;
    }

    public void setPosition(Area position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + "\n> You are in the area: " + position.getName()
                + "\n==========================================================";
    }
}
