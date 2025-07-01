package models._static;

public class Connection extends GenericElement {
    private boolean isLocked;
    private Area[] areas = new Area[2];
    private Effect onTraverse;
    private Item unlockedWith;

    public Connection(String name, String description) {
        super(name, description);
    }

    public Area[] getAreas() {
        return areas;
    }

    public void setAreas(Area[] areas) {
        this.areas = areas;
    }

    public void tryTraverse() {
        if(onTraverse != null) {

        }
    }
}
