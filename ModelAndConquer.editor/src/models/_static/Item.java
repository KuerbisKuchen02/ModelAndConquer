package models._static;

import models.generated.DamageType;

import java.util.Objects;

public class Item extends GenericElement {
    private final double damage;
    private final boolean isConsumable;
    private final Effect onDrop;
    private final Effect onUse;
    private final Effect onPickup;
    private final DamageType damageType;

    public Item(String name, String description, double damage,  boolean isConsumable, Effect onDrop, Effect onUse, Effect onPickup,  DamageType damageType) {
        super(name, description);

        this.damage = damage;
        this.isConsumable = isConsumable;
        this.onDrop = onDrop;
        this.onUse = onUse;
        this.onPickup = onPickup;
        this.damageType = damageType;
    }

    public double getDamage() { return this.damage; }
    public Effect getOnDrop() { return this.onDrop; }
    public Effect getOnUse() { return this.onUse; }
    public Effect getOnPickup() { return this.onPickup; }
    public DamageType getDamageType() { return this.damageType; }

    public boolean isConsumable() { return this.isConsumable; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return Double.compare(damage, item.damage) == 0 && isConsumable == item.isConsumable && Objects.equals(onDrop, item.onDrop) && Objects.equals(onUse, item.onUse) && Objects.equals(onPickup, item.onPickup) && damageType == item.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, isConsumable, onDrop, onUse, onPickup, damageType);
    }
}
