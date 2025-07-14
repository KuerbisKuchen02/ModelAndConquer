package models._static;

import models.generated.EDamageType;

import java.util.Objects;

public class Item extends GenericElement {
    private final double damage;
    private final boolean isConsumable;
    private final double accuracy;
    private EDamageType damageType;
    private Effect onDrop;
    private Effect onPickup;
    private Effect onUse;

    public Item(String name,
                String description,
                double damage,
                boolean isConsumable,
                double accuracy) {
        super(name, description);

        this.damage = damage;
        this.isConsumable = isConsumable;
        this.accuracy = accuracy;
    }

    public double getDamage() {
        return damage;
    }

    public EDamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(EDamageType damageType) {
        this.damageType = damageType;
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    public Effect getOnDrop() {
        return onDrop;
    }

    @SuppressWarnings("unused")
    public void setOnDrop(Effect onDrop) {
        this.onDrop = onDrop;
    }

    public Effect getOnPickup() {
        return onPickup;
    }

    @SuppressWarnings("unused")
    public void setOnPickup(Effect onPickup) {
        this.onPickup = onPickup;
    }

    public Effect getOnUse() {
        return onUse;
    }

    @SuppressWarnings("unused")
    public void setOnUse(Effect onUse) {
        this.onUse = onUse;
    }

    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return Double.compare(damage, item.damage) == 0
                && isConsumable == item.isConsumable
                && Objects.equals(onDrop, item.onDrop)
                && Objects.equals(onUse, item.onUse)
                && Objects.equals(onPickup, item.onPickup)
                && damageType == item.damageType;
    }

    @Override
    public String toString() {
        return "==========================================================\n"
                + "> " + super.toString() + "\n"
                + (isConsumable ? "> This item is consumable\n" : "")
                + "> Damage: " + damage + "\n"
                + (damageType != null ? ("> Damage type: " + damageType + "\n") : "")
                + "==========================================================";
    }

    public String toShortString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, isConsumable, onDrop, onUse, onPickup, damageType);
    }
}
