package models._static;

import java.util.List;

public class SpawnEffect extends Effect {
    private final List<INonPlayerEntity> nonPlayerEntities;
    private final Area area;

    public SpawnEffect(String name, String description, List<INonPlayerEntity> entities, Area area) {
        super(name, description);

        this.nonPlayerEntities = entities;
        this.area = area;
    }

    @Override
    public void apply() {
        for (INonPlayerEntity entity : nonPlayerEntities) {
            area.addEntity(entity);
        }
    }

    public List<INonPlayerEntity> getEntities() {
        return nonPlayerEntities;
    }

    public Area getArea() {
        return area;
    }
}
