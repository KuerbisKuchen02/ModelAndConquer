package models._static;

import models.generated.EDamageType;

public class DamageModificator extends GenericElement {
    private double multiplicator;
    private EDamageType damageType;

    public DamageModificator(String name,
                             String description,
                             double multiplicator) {
        super(name, description);
        this.multiplicator = multiplicator;
    }

    public double getMultiplicator() {
        return multiplicator;
    }

    public EDamageType getDamageType() {
        return damageType;
    }
    
    public void setDamageType(EDamageType damageType) {
    	this.damageType = damageType;
    }

    @SuppressWarnings("unused")
    private void setMultiplicator(double multiplicator) {
        if(multiplicator != 1.0 && multiplicator > 0){
            this.multiplicator = multiplicator;
        }
    }

    @Override
    public String toString() {
        return (multiplicator > 1 ? "Strong" : "Weak") + " against " + damageType;
    }
}
