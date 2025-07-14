package models._static;

import models.generated.Game;

import java.util.Random;

public class DamageModificatorEffect extends Effect {
    private final DamageModificator damageModificator;
    private final int duration;
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
    public void apply() {
        Random rand = new Random();

        if (getProbability() > rand.nextDouble()) {
            getTarget().getDamageModificators().add(damageModificator);
        }
    }
}
