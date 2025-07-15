package models._static;

import java.util.Random;

public class HealthEffect extends Effect {
    private final double amount;
    private int duration;
    private final boolean onSelf;

    private IHealable target;

    public HealthEffect(String name,
                        String description,
                        double probability,
                        double amount,
                        int duration,
                        boolean onSelf) {
        super(name, description, probability);

        this.amount = amount;
        this.duration = duration;
        this.onSelf = onSelf;
    }

    public int getDuration() {
        return duration;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isOnSelf() {
        return onSelf;
    }

    public IHealable getTarget() {
        return target;
    }

    public void setTarget(IHealable target) {
        this.target = target;
    }

    @Override
    public void apply() {
        Random rand = new Random();
        Entity entityTarget = (Entity) getTarget();
        if (getProbability() > rand.nextDouble()) {
            if (!entityTarget.getEffects().contains(this)) {
                entityTarget.getEffects().add((this));
            }
            this.target.heal(this.amount);
        }

        this.duration--;

        if (duration == 0) {
            entityTarget.getEffects().remove(this);
        }
    }

    @Override
    public String toString(){
        String ret = super.toString();
        ret += "\n" + (amount > 0 ? "Heals" : "Damages") + " for " + amount + " hp" +
                (duration == 1 ? " once" : (" over " + duration + " turns"));
        return ret;
    }
}
