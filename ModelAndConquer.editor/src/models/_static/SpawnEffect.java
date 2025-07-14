package models._static;

import java.util.List;

public class SpawnEffect extends Effect {
    private final List<INonPlayerEntity> nonPlayerEntities;
    private Area area;

    public SpawnEffect(String name,
                       String description,
                       double probability,
                       List<INonPlayerEntity> entities) {
        super(name, description, probability);

        this.nonPlayerEntities = entities != null ? entities : List.of();
    }

    @Override
    public void apply() {
        for (INonPlayerEntity entity : nonPlayerEntities) {
            area.addEntity(entity);
        }
    }

    public List<INonPlayerEntity> getNonPlayerEntities() {
        return nonPlayerEntities;
    }

    public Area getArea() {
        return area;
    }

    @SuppressWarnings("unused")
    public void setArea(Area area) {
        this.area = area;
    }
}
