package models._static;

import java.util.ArrayList;

public class SpawnEffect extends Effect {
    private final ArrayList<INonPlayerEntity> nonPlayerEntities;
    private Area area;

    public SpawnEffect(String name,
                       String description,
                       double probability,
                       ArrayList<INonPlayerEntity> entities) {
        super(name, description, probability);

        this.nonPlayerEntities = (entities == null) ? new ArrayList<>() : entities;
    }

    @Override
    public String apply() {
    	String msg = "\n**********************************************************\n" + "Spawned:\n";
        for (INonPlayerEntity entity : nonPlayerEntities) {
        	msg += entity + " ";
            area.addEntity(entity);
        }
        
        msg += "because of " + this.getName();
        return msg;
    }

    public ArrayList<INonPlayerEntity> getNonPlayerEntities() {
        return nonPlayerEntities;
    }

    public Area getArea() {
        return area;
    }

    @SuppressWarnings("unused")
    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder(super.toString());
        ret.append("\nSpawns: ");
        for (INonPlayerEntity entity : nonPlayerEntities) {
            ret.append(((Entity)entity).getName()).append(", ");
        }
        if (!nonPlayerEntities.isEmpty()) {
            ret.setLength(ret.length() - 2); // Remove trailing comma and space
        }
        ret.append("\nIn area: ").append(area != null ? area.getName() : "None");
        return ret.toString();
    }
}
