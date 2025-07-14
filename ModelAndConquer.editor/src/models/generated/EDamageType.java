package models.generated;

public enum EDamageType {
	POISON(0),
	NORMAL(1);
	
	private final int value;
	
	EDamageType(int value) { this.value=value; }
	
	public static EDamageType getDamageTypeByName(String name) {
		switch (name) {
			case "Poison": return EDamageType.POISON;
			case "Normal": return EDamageType.NORMAL;
			default: return null;
		}
	}
	
	@Override
	public String toString() {
		return switch (value) {
			case 0 -> "Poison";
			case 1 -> "Normal";
			default -> "Not an valid DamageType!";
		};
	}
}
