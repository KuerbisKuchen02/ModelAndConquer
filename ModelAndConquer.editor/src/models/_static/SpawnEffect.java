package models._static;

public class SpawnEffect extends GenericElement implements Effect {
    private final Monster monster;
    private final Area area;

    public SpawnEffect(String name, String description, Monster monster, Area area) {
        super(name, description);

        this.monster = monster;
        this.area = area;
    }

    public Monster getMonster() {
        return monster;
    }

    public Area getArea() {
        return area;
    }
}
