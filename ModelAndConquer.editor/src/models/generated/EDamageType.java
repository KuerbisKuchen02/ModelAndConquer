package models.generated;

public enum EDamageType {
    POISON(0),
    NORMAL(1);

    private final int value;

    private

    EDamageType(int value) { this.value=value; }

    @Override
    public String toString() {
        return switch (value) {
            case 0 -> "Poison";
            case 1 -> "Normal";
            default -> "Not an valid DamageType!";
        };
    }
}