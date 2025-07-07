package models._static;

public abstract class Effect extends GenericElement {
    public Effect(String name, String description) {
        super(name, description);
    }

    abstract void apply(

    );
}
