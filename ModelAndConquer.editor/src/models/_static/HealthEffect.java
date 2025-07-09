package models._static;

public class HealthEffect extends Effect {
    private int duration;
    private final double amount;
    private final boolean onSelf;
    private IHealable target;

    public HealthEffect(String name, String description, int duration, double amount, boolean onSelf, IHealable target) {
        super(name, description);

        this.duration = duration;
        this.amount = amount;
        this.onSelf = onSelf;
        this.target = target;
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
        this.target.heal(this.amount);
        this.duration--;
    }
}
