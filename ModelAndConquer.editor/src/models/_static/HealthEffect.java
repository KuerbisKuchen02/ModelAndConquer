package models._static;

public class HealthEffect extends GenericElement implements Effect {
    private final int duration;
    private final double amount;

    public HealthEffect(String name, String description, int duration, double amount) {
        super(name, description);

        this.duration = duration;
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }
    public double getAmount() {
        return amount;
    }
}
