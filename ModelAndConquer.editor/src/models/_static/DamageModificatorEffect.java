package models._static;

public class DamageModificatorEffect extends Effect {
    private final DamageModificator damageModificator;
    private final boolean onSelf;
    private Entity target;

    public DamageModificatorEffect(String name, String description, DamageModificator damageModificator, boolean onSelf) {
        super(name, description);

        this.damageModificator = damageModificator;
        this.onSelf = onSelf;
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
        // TODO
    }
}
