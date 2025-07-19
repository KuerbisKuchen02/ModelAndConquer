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
        StringBuilder entityDescription = new StringBuilder("\n**********************************************************\n\n"
                + healthBarString(true) + "\n\n");

        ArrayList<Item> inventory = getInventory();

        if (!inventory.isEmpty()) {
            entityDescription.append("> Items in inventory:\n");
            for(Item item : inventory){
                entityDescription.append("\t").append(item.toShortString()).append("\n");
            }
        }

        ArrayList<DamageModificator> damageModificators = getDamageModificators();

        if (!damageModificators.isEmpty()) {
            entityDescription.append("> Damage multipliers:\n");
            for(DamageModificator dm : damageModificators){
                entityDescription
                        .append("\t")
                        .append((dm.getMultiplicator() > 1.0) ? "weak" : "resistant")
                        .append("against")
                        .append(dm.getDamageType().toString())
                        .append("\n");
            }
        }

        ArrayList<Effect> effects = getEffects();

        if (!effects.isEmpty()) {
            entityDescription.append("> Current Effects:\n");
            for(Effect e : effects) entityDescription.append("\t").append(e.toString()).append("\n");
        }

        entityDescription
                .append("\n> You are in the ").append(position.getName())
                .append("\n\n**********************************************************\n");

        return entityDescription.toString();
    }
}
