package models._static;

public class DamageModificatorEffect extends Effect {
    private final DamageModificatorEffect damageModificator;

    public DamageModificatorEffect(String name, String description, DamageModificatorEffect damageModificator) {
        super(name, description);

        this.damageModificator = damageModificator;
    }

    public DamageModificatorEffect getDamageModificator() {
        return damageModificator;
    }

    @Override
    public void apply() {
        // TODO
    }
}
