package models._static;

public class Connection extends GenericElement {
    private boolean isLocked;
    private Area areaFrom;
    private Area areaTo;
    private EDirection direction;
    private Effect onTraverse;
    private Item unlockedWith;

    public Connection(String name, String description) {
        super(name, description);
    }

    public Connection(String name, String description, EDirection direction, Area areaFrom, Area areaTo, Effect onTraverse, Item unlockedWith) {
        super(name, description);
        this.direction = direction;
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;        
        this.onTraverse = onTraverse;
        setLocked(unlockedWith);
    }

    public Area getAreaFrom() {
        return areaFrom;
    }

    
    public Area getAreaTo() {
    	return areaTo;
    }
    
    public void setAreaFrom(Area area) {
        this.areaFrom = area;
    }

    public void setAreaTo(Area area) {
        this.areaTo = area;
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
