package models._static;

import models.generated.EDamageType;

import java.util.ArrayList;

public class Monster extends Entity implements IHealable, INonPlayerEntity {
    private EDamageType damageType;
    private Effect onSpawn;
    private Effect onHit;
    private Effect onDamage;
    private Effect onKill;

    // Getter
    public EDamageType getDamageType() {
        return this.damageType;
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

    public Monster(String name, String description, double maxHealth, ArrayList<Item> inventory,
                   ArrayList<Effect> effects, ArrayList<DamageModificator> damageModificators,EDamageType damageType,
                   Effect onSpawn, Effect onHit, Effect onDamage, Effect onKill) {
        super(name, description, maxHealth, inventory, effects, damageModificators);

        this.damageType = damageType;
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
