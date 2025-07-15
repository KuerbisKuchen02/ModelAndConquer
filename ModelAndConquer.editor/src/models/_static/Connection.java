package models._static;

public class Connection extends GenericElement {
    private boolean isLocked;
    private Area areaA; // AreaFrom
    private Area areaB; // AreaTo

    private Effect onTraverse;
    private Item unlockedWith;

    public Connection(String name, String description) {
        super(name, description);
    }

    public boolean tryTraverse() {
        if (isLocked) {
            System.out.println("You have to unlock this passage with: " + unlockedWith.toShortString());
            return false;
        }
        else{
            if (onTraverse != null) onTraverse.apply();
            return true;
        }
    }

    public void tryUnlock(Item item) {
        if (item.equals(unlockedWith)) {
            System.out.println("Unlocked with " + unlockedWith.toShortString());
            isLocked = false;
        }
        else{
            System.out.println("Wrong item, you need to use " + unlockedWith.toShortString());
        }
    }

    public Area getOtherArea(Area currentArea){
        return currentArea == areaA ? currentArea : areaB;
    }

    public Area getAreaA() {
        return areaA;
    }

    public Area getAreaB() {
        return areaB;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @SuppressWarnings("unused")
    public void setAreaA(Area area) {
    	this.areaA = area;
    }

    @SuppressWarnings("unused")
    public void setAreaB(Area area) {
    	this.areaB = area;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @SuppressWarnings("unused")
    public void setLocked(Item unlockedWith) {
        this.unlockedWith = unlockedWith;
        isLocked = this.unlockedWith != null;
    }

    public Effect getOnTraverse() {
        return onTraverse;
    }

    @SuppressWarnings("unused")
    public void setOnTraverse(Effect onTraverse) {
        this.onTraverse = onTraverse;
    }

    public Item getUnlockedWith() {
        return unlockedWith;
    }
}
