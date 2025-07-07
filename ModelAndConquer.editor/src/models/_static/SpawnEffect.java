package models._static;

import java.util.List;

public class SpawnEffect extends Effect {
    private final List<Monster> monster;
    private final Area area;

    public SpawnEffect(String name, String description, List<Monster> monster, Area area) {
        super(name, description);

        this.monster = monster;
        this.area = area;
    }

    @Override
    public void apply() {
        // TODO
    }

    public List<Monster> getMonster() {
        return monster;
    }

    public Area getArea() {
        return area;
    }
}
