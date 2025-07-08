package models._static;

import models.generated.EDamageType;

import java.util.ArrayList;

public abstract class Entity extends GenericElement {
    protected double health;
    protected double maxHealth;
    private ArrayList<Item> inventory;
    private Effect[] effects;
    private ArrayList<DamageModificator> damageModificators;

    public Entity (String name, String description, double maxHealth,  ArrayList<Item> inventory, Effect[] Effects,  ArrayList<DamageModificator> damageModificators) {
        super(name, description);

        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.inventory = inventory;
        this.effects = Effects;
        this.damageModificators = damageModificators;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Lets the entity take damage by the given amount.
     * The damage will be effected by the damageModifications of the Entity
     * @param damage base amount of damage
     * @param damageType type of the dealt damage
     */
    public void takeDamage(double damage, EDamageType damageType) {
        double endDamage = damage;

        // Calculate damage modifications
        if (damageType != null) {
            for (DamageModificator damageModificator : damageModificators) {
                if (damageModificator.getDamageType().equals(damageType)) {
                    endDamage = endDamage * damageModificator.getMultiplicator();
                }
            }
        }

        health -= endDamage;
    }

    /**
     * Whether the entity is destroyed / dead.
     * @return boolean whether entity is alive
     */
    public boolean hasHealthLeft() {
        return health > 0;
    }

    // Getter
    public double getHealth() { return this.health; }
    public double getMaxHealth() { return this.maxHealth; }
    public ArrayList<Item> getInventory() { return this.inventory; }
    public Effect[] getEffects() { return this.effects; }
    public ArrayList<DamageModificator> getDamageModificator() { return this.damageModificators; }

    public boolean isInInventory(Item item) {
        for (Item i : inventory) {
            if (i.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String entityDescription = "";
        entityDescription += "\nHealth" + getHealth() + "/" + getMaxHealth() + "\n";
        entityDescription += "Items in inventory:\n";
        for(Item item : inventory){
            entityDescription += "\t" + item.getName() + " - " + item.getDescription() + "\n";
        }
        entityDescription += "Damage multiplier:\n";
        for(DamageModificator dm : damageModificators){
            // TODO dm.getDamageType() returns Type DamageType not String
            entityDescription += "\t" + ((dm.getMultiplicator() > 1.0) ? "weak" : "resistant") +
                    "against" + dm.getDamageType() + "\n";
        }
        entityDescription += "Current Effects:\n";
        for(Effect e : effects){
            entityDescription += "\t" + e.toString() + "\n";
        }

        return super.toString() + entityDescription;
    }

    public void dropItems(Area area){
        for(Item item : inventory){
            area.addItem(item);
        }
    }
}
