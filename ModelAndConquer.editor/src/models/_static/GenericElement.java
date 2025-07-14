package models._static;

public abstract class GenericElement {
    private final String name;
    private final String description;

    public GenericElement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return name + (description.isEmpty() ? "" : (" - " + description));
    }
}
