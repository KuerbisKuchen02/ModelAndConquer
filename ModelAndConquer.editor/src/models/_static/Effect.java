package models._static;

public abstract class Effect extends GenericElement {
    private double probability;

    public Effect(String name, String description, double probability) {
        super(name, description);

        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    @SuppressWarnings("unused")
    public void setProbability(double probability) {
        if (probability <= 1.0 && probability > 0.00){
            this.probability = probability;
        }
    }

    abstract public String apply();

    @Override
    public String toString() {
        String ret = super.toString();
        if (probability != 1.0) ret += "\nProbability: " + (probability*100) + "%";
        return ret;
    }
}
