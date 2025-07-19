package models._static;

import java.util.Random;

public class DamageModificatorEffect extends Effect {
    private final DamageModificator damageModificator;
    private int duration;
    private final boolean onSelf;
    private Entity target;

    public DamageModificatorEffect(String name, 
    							   String description, 
    							   double probability, 
    							   DamageModificator damageModificator, 
    							   boolean onSelf, 
    							   int duration) {
        super(name, description, probability);

        this.damageModificator = damageModificator;
        this.onSelf = onSelf;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public DamageModificator getDamageModificator() {
        return damageModificator;
    }

    public boolean isOnSelf() {
        return onSelf;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public Entity getTarget() {
        return this.target;
    }

    @Override
    public String apply() {
        Random rand = new Random();

        if (getProbability() > rand.nextDouble()) {
            if (getTarget().getDamageModificators().contains(damageModificator)) {
                getTarget().getDamageModificators().add(damageModificator);
            }
        }

        this.duration--;
        
        return "Got " + (damageModificator.getMultiplicator() > 1 ? "resistance" : "weakness") + "for " + damageModificator.getDamageType() + " by " + this.getName();
    }

    @Override
    public String toString(){
        String ret = super.toString();
        ret += "\n" + damageModificator + " for " + duration + " turns.";
        return ret;
    }
}
