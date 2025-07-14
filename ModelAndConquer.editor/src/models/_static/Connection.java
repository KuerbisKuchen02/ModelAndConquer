package models._static;

public class Connection extends GenericElement {
    private boolean isLocked;
    private final Area areaA; // AreaFrom
    private final Area areaB; // AreaTo

    private Effect onTraverse;
    private Item unlockedWith;

    public Connection(String name, String description, Area areaA, Area areaB) {
        super(name, description);
        this.areaA = areaA;
        this.areaB = areaB;
    }

    public void tryTraverse() {
        if (isLocked) {
            System.out.println("You have to unlock this passage with: " + unlockedWith.toShortString());
        }
        else{
            if (onTraverse != null) onTraverse.apply();
        }
    }

    public void tryUnlock(Item item) {
        if (item.equals(unlockedWith)) {
            isLocked = false;
        }
        else{
            System.out.println("Wrong item, you need to use " + unlockedWith.toShortString());
        }
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

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setLocked(Item unlockedWith) {
        this.unlockedWith = unlockedWith;
        isLocked = this.unlockedWith != null;
    }

    public Effect getOnTraverse() {
        return onTraverse;
    }

    public void setOnTraverse(Effect onTraverse) {
        this.onTraverse = onTraverse;
    }

    public Item getUnlockedWith() {
        return unlockedWith;
    }

    public void setUnlockedWith(Item unlockedWith) {
        this.unlockedWith = unlockedWith;
    }
}
