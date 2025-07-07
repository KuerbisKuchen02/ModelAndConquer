package models._static;

public class HealthEffect extends Effect {
    private final int duration;
    private final double amount;
    private final IHealable target;

    public HealthEffect(String name, String description, int duration, double amount, IHealable target) {
        super(name, description);

        this.duration = duration;
        this.amount = amount;
        this.target = target;
    }

    public int getDuration() {
        return duration;
    }
    public double getAmount() {
        return amount;
    }

    public IHealable getTarget() {
        return target;
    }

    @Override
    public void apply() {
        // TODO
    }
}
