package models._static;

import models.generated.DamageType;

public class DamageModificator extends GenericElement {
    private final DamageType damageType;
    private double multiplicator;

    public DamageModificator(String name, String description,  DamageType damageType, double multiplicator) {
        super(name, description);

        this.damageType = damageType;
        this.multiplicator = multiplicator;
    }

    private void setMultiplicator(double multiplicator) {
        if(multiplicator != 1.0){
            this.multiplicator = multiplicator;
        }
    }

    public DamageType getDamageType() { return this.damageType; }
    public double getMultiplicator() { return this.multiplicator; }
}
