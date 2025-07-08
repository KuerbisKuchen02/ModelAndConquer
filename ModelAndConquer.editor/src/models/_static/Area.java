package models._static;

import java.util.ArrayList;

public class Area extends GenericElement {
    private Connection[] connections = new Connection[6];
    private ArrayList<INonPlayerEntity> entities;
    private ArrayList<Item> items;
    private Effect onEnter;
    private String asciiArt;
    private boolean visited = false;


    public Area(String name, String description, ArrayList<INonPlayerEntity> entities, ArrayList<Item> items, Effect onEnter) {
        super(name, description);
        setEntities((entities != null) ? entities : new ArrayList<>());
        setItems((items != null) ? items : new ArrayList<>());
        setOnEnter(onEnter);
    }

    public Connection[] getConnections() {
        return connections;
    }

    public void setConnections(Connection[] connections) { this.connections = connections; }

    public void setEntities(ArrayList<INonPlayerEntity> entities) {
        this.entities = entities;
    }

    public void removeEntity(INonPlayerEntity entity) { this.entities.remove(entity); }

    public void addEntity(INonPlayerEntity entity){
        this.entities.add(entity);
    }

    /**
     * @return Returns String containing descriptions of all monsters
     */
    public String presentMonsters() {
        StringBuilder monsterList = new StringBuilder();
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof Monster) {
                Monster monster = (Monster) entity;
                monsterList.append(monster.toString()).append("\n");
            }
        }
        return monsterList.toString();
    }

    public ArrayList<INonPlayerEntity> getEntities() { return entities; }

    public ArrayList<Monster> getMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof Monster) {
                    monsters.add((Monster) entity);
            }
        }

        return monsters;
    }

    public ArrayList<DestroyableObject> getDestroyableObjects() {
        ArrayList<DestroyableObject> destroyableObjects = new ArrayList<>();
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof DestroyableObject) {
                destroyableObjects.add((DestroyableObject) entity);
            }
        }

        return destroyableObjects;
    }

    public void setItems(ArrayList<Item> items) { this.items = items; }

    /**
     * @return Returns String containing descriptions of all items
     */
    public String presentItems(){
        StringBuilder itemsString = new StringBuilder();
        for (Item item : items){
            itemsString.append(item.toShortString()).append("\n");
        }
        return itemsString.toString();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    /**
     * @param itemName String name of item
     * @return Returns either requested item or null if item does not exist.
     */
    public Item removeItem(String itemName) {
        for (Item item : items){
            if (item.getName().equals(itemName)){
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public void visitArea(){ this.visited = true; }

    public ArrayList<Item> getItems() { return items; }

    public void setOnEnter(Effect onEnter) { this.onEnter = onEnter; }

    public Effect getOnEnter() { return onEnter; }

    public void setAsciiArt(String asciiArt) { this.asciiArt = asciiArt; }

    public String getAsciiArt() { return asciiArt; }

    /**
     * @return String with short description of adjacent Areas
     */
    public String presentAdjacentAreas(){
        StringBuilder adjacentAreas = new StringBuilder();
        for (int i = 0; i<connections.length; i++) {
            if(connections[i] == null) continue;

            for (Area area : connections[i].getAreas()) {
                if (area != this) {
                    adjacentAreas.append(EDirection.getValueString(i)).append(area.shortToString()).append("\n");
                    break;
                }
            }
        }
        return adjacentAreas.toString();
    }

    /**
     * @return String with short description of area
     */
    public String shortToString(){
        if (visited) {
            String roomSpec = "";

            if (!entities.isEmpty()) {
                roomSpec += "There are monsters in the area." + "\n";
            }

            if (!items.isEmpty()){
                roomSpec += "There are items in the area." + "\n";
            }

            return super.toString() + roomSpec;
        } else {
            return "There is an unknown area.";
        }
    }

    @Override
    public String toString(){
        if (visited) {
            String roomSpecification = "";

            if (!entities.isEmpty()) {
                roomSpecification += presentMonsters();
            }

            if (!items.isEmpty()) {
                roomSpecification += presentItems();
            }

            roomSpecification += "Adjacent Areas: \n" + presentAdjacentAreas();

            return super.toString() + "\n"  + roomSpecification;
        } else {
            return "There is an unknown area.";
        }
    }
}
