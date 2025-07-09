package models._static;

import models.generated.EDamageType;

public class DamageModificator extends GenericElement {
    private final EDamageType damageType;
    private double multiplicator;

    public DamageModificator(String name, String description, EDamageType damageType, double multiplicator) {
        super(name, description);

        this.damageType = damageType;
        this.multiplicator = multiplicator;
    }

    private void setMultiplicator(double multiplicator) {
        if(multiplicator != 1.0 && multiplicator > 0){
            this.multiplicator = multiplicator;
        }
    }

    public EDamageType getDamageType() { return this.damageType; }
    public double getMultiplicator() { return this.multiplicator; }
}
