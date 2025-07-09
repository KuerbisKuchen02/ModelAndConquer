package models._static;

public class Connection extends GenericElement {
    private boolean isLocked;
    private Area[] areas = new Area[2];
    private Effect onTraverse;
    private Item unlockedWith;

    public Connection(String name, String description) {
        super(name, description);
    }

    public Connection(String name, String description, Area[] areas, Effect onTraverse, Item unlockedWith) {
        super(name, description);
        this.areas = areas;
        this.onTraverse = onTraverse;
        setLocked(unlockedWith);
    }

    public Area[] getAreas() {
        return areas;
    }

    public void setAreas(Area[] areas) {
        this.areas = areas;
    }

    public void tryTraverse() {
        if (isLocked) {
            System.out.println("You have to unlock this connection with " + unlockedWith.toShortString());
        }
        else{
            if (onTraverse != null) onTraverse.apply();
        }
    }

    public void setOnTraverse(Effect onTraverse) {this.onTraverse = onTraverse;}

    public Effect getOnTraverse() {return this.onTraverse;}

    public boolean isLocked() {return this.isLocked;}

    public void setLocked(Item unlockedWith) {
        this.unlockedWith = unlockedWith;
        isLocked = this.unlockedWith != null;
    }

    public void tryUnlock(Item item) {
        if (item.equals(unlockedWith)) {
            isLocked = false;
        }
        else{
            System.out.println("Wrong item, you need to use " + unlockedWith.toShortString());
        }
    }
}
