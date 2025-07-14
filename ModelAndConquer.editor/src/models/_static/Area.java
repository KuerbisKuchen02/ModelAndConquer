package models._static;

import java.util.ArrayList;

public class Area extends GenericElement {
    private ArrayList<INonPlayerEntity> entities;
    private ArrayList<Item> items;
    private final Connection[] connections;
    private Effect onEnter;

    private boolean visited;

    public Area(String name,
                String description,
                ArrayList<INonPlayerEntity> entities,
                ArrayList<Item> items) {
        super(name, description);

        this.entities = entities == null ? new ArrayList<>() : entities;
        this.items = items == null ? new ArrayList<>() : items;
        this.connections = new Connection[6];
        this.visited = false;
    }

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

    public Connection[] getConnections() {
        return connections;
    }

    public void setConnection(Connection connection, EDirection direction) { this.connections[direction.getValue()] = connection; }

    public ArrayList<INonPlayerEntity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<INonPlayerEntity> entities) {
        this.entities = entities;
    }

    public void addEntity(INonPlayerEntity entity){
        this.entities.add(entity);
    }

    public void removeEntity(INonPlayerEntity entity) { this.entities.remove(entity); }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
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

    public Effect getOnEnter() {
        return onEnter;
    }

    public void setOnEnter(Effect onEnter) {
        this.onEnter = onEnter;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return String with short description of adjacent Areas
     */
    public String presentAdjacentAreas(){
        StringBuilder adjacentAreas = new StringBuilder();
        for (int i = 0; i < connections.length; i++) {
            if(connections[i] == null) continue;

            Area area = connections[i].getAreaA() != this ? connections[i].getAreaA() : connections[i].getAreaB();
            adjacentAreas.append("\t")
                    .append(EDirection.getValueString(i))
                    .append(" - ");
            if(area.isVisited()) {
                adjacentAreas.append(area.shortToString());
            }
            else{
                adjacentAreas.append("unknown area");
            }
            adjacentAreas.append("\n");

        }
        return adjacentAreas.toString();
    }

    /**
     * @return Returns String containing descriptions of all items
     */
    public String presentItems(){
        StringBuilder itemsString = new StringBuilder();
        for (Item item : items){
            itemsString.append("\t").append(item.toShortString()).append("\n");
        }
        return itemsString.toString();
    }

    /**
     * @return Returns String containing descriptions of all monsters
     */
    public String presentMonsters() {
        StringBuilder monsterList = new StringBuilder();
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof Monster) {
                Monster monster = (Monster) entity;
                monsterList.append(monster).append("\n");
            }
        }
        return monsterList.toString();
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
            String roomSpecification    = "==========================================================\n"
                    + "> This Area is: " + getName() + "\n";

            if (!entities.isEmpty()) {
                roomSpecification       += "> There are Monsters in the Area:\n" + presentMonsters();
            }

            if (!items.isEmpty()) {
                roomSpecification       += "> There are items in the Area:\n" + presentItems();
            }

            roomSpecification += "> Adjacent Areas: \n" + presentAdjacentAreas();
            roomSpecification += "==========================================================";
            return roomSpecification;
        } else {
            return "You have not visited this Area.";
        }
    }
}
