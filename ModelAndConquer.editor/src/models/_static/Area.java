package models._static;

import java.util.ArrayList;
import java.util.List;

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

    public boolean hasMonsters() {
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof Monster) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDestroyableObjects() {
        for (INonPlayerEntity entity : entities) {
            if (entity instanceof DestroyableObject) {
                return true;
            }
        }
        return false;
    }

    // TODO: Handle destroyable objects, list them inside toString and toShortString
    //       Maybe we need also methods to get all monsters separately??
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

    @SuppressWarnings("unused")
    public void setConnection(Connection connection, EDirection direction) { this.connections[direction.getValue()] = connection; }

    public ArrayList<INonPlayerEntity> getEntities() {
        return entities;
    }

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public Effect getOnEnter() {
        return onEnter;
    }

    @SuppressWarnings("unused")
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
        for (Monster monster : getMonsters()) {
            monsterList.append(monster).append("\n");
        }
        return monsterList.toString();
    }

    public String presentDestroyableObjects() {
        StringBuilder destroyableObjectsList = new StringBuilder();
        for (DestroyableObject destroyableObject : getDestroyableObjects()) {
            destroyableObjectsList.append(destroyableObject).append("\n");
        }
        return destroyableObjectsList.toString();
    }

    private String asciiArtString(){
        String dynamicLine = String.format("%s%5s%s%5s%s%5s", " | Items |  x ", items.size(),
                "   ⠙⠛⢻⣷⣾⡟⠛⠋  x ", getMonsters().size(), "    |\\         \\  x ",
                getDestroyableObjects().size()) + "\n";

        return  "    :~:               ⠀⢀⣠⣤⣤⣄⡀⠀              __________\n" +
                "    | |               ⣴⣿⣿⣿⣿⣿⣿⣦             /\\____;;___\\\n" +
                "   .' `.              ⣿⣿⣿⣿⣿⣿⣿⣿            | /         /\n" +
                " .'     `.            ⣇⠈⠉⡿⢿⠉⠁⣸            `._________.\n" +
                dynamicLine +
                "  `.._..'              ⠀ ⡏⠉⢹⠀               | |---------|\n" +
                "                                             \\ | Objects |\n" +
                "                                              \\|_________|\n";
    }


    /**
     * @return String with short description of area
     */
    public String shortToString(){
        if (visited) {
            String roomSpec = "\n";

            if (!getMonsters().isEmpty()) {
                roomSpec += "\tThere are monsters in the area." + "\n";
            }

            if (!getDestroyableObjects().isEmpty()) {
                roomSpec += "\tThere are destroyable objects in the area." + "\n";
            }

            if (!items.isEmpty()){
                roomSpec += "\tThere are items in the area." + "\n";
            }

            roomSpec += asciiArtString();

            return super.toString() + roomSpec;
        } else {
            return "There is an unknown area.";
        }
    }

    @Override
    public String toString(){
        if (visited) {
            String roomSpecification = "==========================================================\n"
                    + "> You are in " + getName() + "\n";

            if (hasMonsters()) {
                roomSpecification += "> There are Monsters in the Area:\n" + presentMonsters();
            }

            if (hasDestroyableObjects()) {
                roomSpecification += "> There are destroyable objects in the Area:\n" + presentDestroyableObjects();
            }

            if (!items.isEmpty()) {
                roomSpecification += "> There are items in the Area:\n" + presentItems();
            }

            roomSpecification += "> Adjacent Areas: \n" + presentAdjacentAreas();
            roomSpecification += "==========================================================";
            return roomSpecification;
        } else {
            return "You have not visited this Area.";
        }
    }
}
