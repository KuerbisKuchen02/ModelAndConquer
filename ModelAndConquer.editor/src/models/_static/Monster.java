package models._static;

import models.generated.DamageType;

import java.util.ArrayList;

public class Monster extends Entity implements Healable, NonPlayEntity{
    private DamageType damageType;
    private Item[] dropItems;
    private Effect onSpawn;
    private Effect onHit;
    private Effect onDamage;
    private Effect onKill;

    // Getter
    public DamageType getDamageType() {
        return this.damageType;
    }

    public Item[] getDropItems() {
        return this.dropItems;
    }

    public Effect getOnSpawn() {
        return this.onSpawn;
    }

    public Effect getOnHit() {
        return this.onHit;
    }

    public Effect getOnDamage() {
        return this.onDamage;
    }

    public Effect getOnKill() {
        return this.onKill;
    }

    public Monster(String name, String description, double health, double maxHealth, ArrayList<Item> inventory,
                   Effect[] Effects, ArrayList<DamageModificator> damageModificators, Item[] dropItems,
                   DamageType damageType, Effect onSpawn, Effect onHit, Effect onDamage, Effect onKill) {
        super(name, description, health, maxHealth, inventory, Effects, damageModificators);

        this.damageType = damageType;
        this.dropItems = dropItems;
        this.onSpawn = onSpawn;
        this.onHit = onHit;
        this.onDamage = onDamage;
        this.onKill = onKill;
    }

    public void heal(double amount){
        this.health += amount;
        if(this.health > this.maxHealth) this.health = this.maxHealth;
    }

}
