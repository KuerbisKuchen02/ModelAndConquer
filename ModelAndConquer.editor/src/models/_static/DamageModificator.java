package models._static;

import models.generated.EDamageType;

public class DamageModificator extends GenericElement {
    private double multiplicator;
    private final EDamageType damageType;

    public DamageModificator(String name,
                             String description,
                             EDamageType damageType,
                             double multiplicator) {
        super(name, description);
        this.damageType = damageType;
        this.multiplicator = multiplicator;
    }

    public double getMultiplicator() {
        return multiplicator;
    }

    public EDamageType getDamageType() {
        return damageType;
    }

    @SuppressWarnings("unused")
    private void setMultiplicator(double multiplicator) {
        if(multiplicator != 1.0 && multiplicator > 0){
            this.multiplicator = multiplicator;
        }
    }
}
