package models._static;

import models.generated.EDamageType;

import java.util.ArrayList;

public class Monster extends Entity implements IHealable, INonPlayerEntity {
    private final double damage;
    private final double accuracy;
    private EDamageType damageType;
    private Effect onSpawn;
    private Effect onHit;
    private Effect onDamage;
    private Effect onKill;

    public Monster(String name,
                   String description,
                   double maxHealth,
                   ArrayList<DamageModificator> damageModificators,
                   ArrayList<Item> inventory,
                   double damage,
                   double evasionChance,
                   double accuracy) {
        super(name, description, maxHealth, damageModificators, inventory, evasionChance);

        this.damage = damage;
        this.accuracy = accuracy;
    }

    public void heal(double amount){
        this.health += amount;
        if(this.health > this.maxHealth) this.health = this.maxHealth;
    }


    public EDamageType getDamageType() {
        return damageType;
    }

    @SuppressWarnings("unused")
    public void setDamageType(EDamageType damageType) {
        this.damageType = damageType;
    }

    public double getDamage() {
        return damage;
    }

    public Effect getOnSpawn() {
        return onSpawn;
    }

    @SuppressWarnings("unused")
    public void setOnSpawn(Effect onSpawn) {
        this.onSpawn = onSpawn;
    }

    public Effect getOnHit() {
        return onHit;
    }

    @SuppressWarnings("unused")
    public void setOnHit(Effect onHit) {
        this.onHit = onHit;
    }

    public Effect getOnDamage() {
        return onDamage;
    }

    @SuppressWarnings("unused")
    public void setOnDamage(Effect onDamage) {
        this.onDamage = onDamage;
    }

    public Effect getOnKill() {
        return onKill;
    }

    @SuppressWarnings("unused")
    public void setOnKill(Effect onKill) {
        this.onKill = onKill;
    }

    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
