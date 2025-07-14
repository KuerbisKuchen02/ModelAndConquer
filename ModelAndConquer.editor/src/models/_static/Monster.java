package models._static;

import models.generated.EDamageType;

import java.util.ArrayList;

public class Monster extends Entity implements IHealable, INonPlayerEntity {
    private EDamageType damageType;
    private double damage;
    private double accuracy;
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

    public void setDamageType(EDamageType damageType) {
        this.damageType = damageType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Effect getOnSpawn() {
        return onSpawn;
    }

    public void setOnSpawn(Effect onSpawn) {
        this.onSpawn = onSpawn;
    }

    public Effect getOnHit() {
        return onHit;
    }

    public void setOnHit(Effect onHit) {
        this.onHit = onHit;
    }

    public Effect getOnDamage() {
        return onDamage;
    }

    public void setOnDamage(Effect onDamage) {
        this.onDamage = onDamage;
    }

    public Effect getOnKill() {
        return onKill;
    }

    public void setOnKill(Effect onKill) {
        this.onKill = onKill;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
