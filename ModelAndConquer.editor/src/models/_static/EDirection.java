package models._static;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3),
    UP(4),
    DOWN(5);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String getValueString(int value) {
        return switch (value) {
            case 0 -> "North";
            case 1 -> "East";
            case 2 -> "South";
            case 3 -> "West";
            case 4 -> "Up";
            case 5 -> "Down";
            default -> "Not a valid direction";
        };
    }
}
