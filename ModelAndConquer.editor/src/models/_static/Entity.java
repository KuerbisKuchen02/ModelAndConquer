package models._static;

import models.generated.EDamageType;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity extends GenericElement {
    protected double health;
    protected double maxHealth;
    private ArrayList<Item> inventory;
    private ArrayList<Effect> effects;
    private ArrayList<DamageModificator> damageModificators;
    private Double evasionChance;

    public Entity (String name,
                   String description,
                   double maxHealth,
                   ArrayList<DamageModificator> damageModificators,
                   ArrayList<Item> inventory,
                   double evasionChance) {
        super(name, description);

        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.effects =  new ArrayList<>();
        this.damageModificators = (damageModificators == null) ? new ArrayList<>() : damageModificators;
        this.inventory = (inventory == null) ? new ArrayList<>() : inventory;
    }

    /**
     * Lets the entity take damage by the given amount.
     * The damage will be effected by the damageModifications of the Entity
     * @param damage base amount of damage
     * @param damageType type of the dealt damage
     */
    public double takeDamage(double damage, EDamageType damageType, double hitProbability) {
        Random rand = new Random();
        double randChance = rand.nextDouble();
        if(randChance > hitProbability){
            System.out.println("Hit missed");
            return -1;
        }

        if (randChance > (1-evasionChance) * hitProbability) {
            System.out.println("Hit was dodged");
            return -1;
        }

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
        return endDamage;
    }

    /**
     * Whether the entity is destroyed / dead.
     * @return boolean whether entity is alive
     */
    public boolean hasHealthLeft() {
        return health > 0;
    }

    public boolean isInInventory(Item item) {
        for (Item i : inventory) {
            if (i.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public String healthBarString(boolean isLeftAligned){
        // define set lengths for bar, name, padding, and numbers
        final int BAR_LENGTH = 20;
        final int ALLOWED_NAME_LENGTH = 25;
        final int LEFT_PADDING = 60;
        final int NUM_WIDTH_CURR = 7;
        final int NUM_WIDTH_MAX = 7;

        double ratio = health / maxHealth;
        int filledBars = (int) (ratio * BAR_LENGTH);
        int emptyBars = BAR_LENGTH - filledBars;
        String bar = "█".repeat(filledBars) + "░".repeat(emptyBars);

        String name = getName();

        if(name.length() > ALLOWED_NAME_LENGTH) name = name.substring(0, ALLOWED_NAME_LENGTH - 3) + "...";

        String format = "%" + NUM_WIDTH_CURR + ".2f/%" + NUM_WIDTH_MAX + ".2f";


        if(isLeftAligned){
            format = format + "%-" + ALLOWED_NAME_LENGTH + "s";
            return "[" + bar + "] " + String.format(format, health, maxHealth, " " + name);
        }
        else{
            format = "%" + LEFT_PADDING + "s" + "%" + ALLOWED_NAME_LENGTH + "s" + format;
            return String.format(format, "", name + "\t", health, maxHealth) + " [" + bar + "]";
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public ArrayList<DamageModificator> getDamageModificators() {
        return damageModificators;
    }

    public void setDamageModificators(ArrayList<DamageModificator> damageModificators) {
        this.damageModificators = damageModificators;
    }

    public Double getEvasionChance() {
        return evasionChance;
    }

    public void setEvasionChance(Double evasionChance) {
        this.evasionChance = evasionChance;
    }
    

    public void dropItems(Area area){
        for(Item item : inventory){
            area.addItem(item);
        }
    }

    @Override
    public String toString(){
        StringBuilder entityDescription    = new StringBuilder("==========================================================\n"
                + healthBarString(true) + "\n");

        if (!inventory.isEmpty()) {
            entityDescription.append("> Items in inventory:\n");
            for(Item item : inventory){
                entityDescription.append("\t").append(item.toShortString()).append("\n");
            }
        }

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

        if (!effects.isEmpty()) {
            entityDescription.append("> Current Effects:\n");
            for(Effect e : effects) entityDescription.append("\t").append(e.toString()).append("\n");
        }

        entityDescription.append("==========================================================");
        return entityDescription.toString();
    }
}
