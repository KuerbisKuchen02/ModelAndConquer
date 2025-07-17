package models._static;

import java.util.ArrayList;
import java.util.function.Function;

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
        String dynamicLine = String.format("%s%-5s%s%-5s%s%-5s", " | Items |  x ", items.size(),
                "   ⠙⠛⢻⣷⣾⡟⠛⠋  x ", getMonsters().size(), "    | |---------|  x ",
                getDestroyableObjects().size()) + "\n";

        return  "                                              __________\n" +
                "    :~:               ⠀⢀⣠⣤⣤⣄⡀⠀             /\\____;;___\\\n" +
                "    | |               ⣴⣿⣿⣿⣿⣿⣿⣦            | /         /\n" +
                "   .' `.              ⣿⣿⣿⣿⣿⣿⣿⣿            `._________.\n" +
                " .'     `.            ⣇⠈⠉⡿⢿⠉⠁⣸             |\\         \\\n" +
                dynamicLine +
                "  `.._..'              ⠀ ⡏⠉⢹                \\ | Objects |\n" +
                "                                             \\|__________|\n";
    }

    /**
     * Method to receive a string projecting current area and adjacent areas visually
     * @param padding left padding
     * @return map String
     */
    public String mapString(int padding){
        String visitedArea = "|+|";
        String unknownArea = "|*|";
        String ret = "";

        Function<Integer, String> getRoom = (i) -> connections[i] != null &&
                connections[i].getOtherArea(this).isVisited() ? visitedArea : unknownArea;

        int mapElementSize = visitedArea.length();

        // build map from top to bottom, first check north and up connection, then west and east, then south and down

        String currLine = String.format("%" + padding + "s", "");
        if(connections[0] != null) currLine = String.format("%" + (padding+mapElementSize+1) + "s%s", currLine,
                getRoom.apply(0));
        if(connections[4] != null) currLine = String.format("%" + (padding+2*mapElementSize+1) + "s%s", currLine,
                getRoom.apply(4));
        // only append line if
        if(connections[0] != null || connections[4] != null) ret += currLine + "\n";

        currLine = String.format("%" + padding + "s", "");
        if(connections[0] != null) currLine = String.format("%" + padding + "s%s", currLine, "     | ");
        if(connections[4] != null) currLine = String.format("%" + (padding+2*mapElementSize+1) + "s%s",
                currLine, "/   ");
        if(connections[0] != null || connections[4] != null) ret += currLine + "\n";

        currLine = String.format("%" + padding + "s", "");
        if(connections[3] != null) currLine = String.format("%" + padding + "s%s", currLine,
                getRoom.apply(3) + "-");
        // current area
        currLine = String.format("%" + (padding + mapElementSize+1) + "s%s", currLine, "|X|");
        if(connections[1] != null) currLine += "-" +
                getRoom.apply(1);
        ret += currLine + "\n";

        currLine = String.format("%" + padding + "s", "");
        if(connections[5] != null) currLine = String.format("%" + padding + "s%s", currLine, "   / ");
        if(connections[2] != null) currLine = String.format("%" + (padding+2*mapElementSize-1) + "s%s", currLine, "| ");
        if(connections[5] != null || connections[2] != null) ret += currLine + "\n";

        currLine = String.format("%" + padding + "s", "");
        if(connections[5] != null) currLine = String.format("%" + padding + "s%s", currLine, " " + getRoom.apply(5));
        if (connections[2] != null) currLine = String.format("%" + (padding+mapElementSize+1) + "s%s", currLine,
                getRoom.apply(2) + "    ");

        if(connections[5] != null || connections[2] != null) ret += currLine + "\n";
        ret += "\nLegend: |X|: current area, |+|: visited area, |*|: unknown area\n";
        return ret;
    }


    /**
     * @return String with short description of area
     */
    public String shortToString(){
        if (visited) {
            return super.toString();
        } else {
            return "There is an unknown area.";
        }
    }

    @Override
    public String toString(){
        if (visited) {
            String roomSpecification = "==========================================================\n"
                    + "> You are in " + getName() + "\n\n";

            roomSpecification += getDescription() + "\n\n";

            roomSpecification += asciiArtString();
            
            if (hasMonsters()) {
                roomSpecification += "> Monster:\n" + presentMonsters();
            }

            if (hasDestroyableObjects()) {
                roomSpecification += "> Destroyable Objects:\n" + presentDestroyableObjects();
            }

            if (!items.isEmpty()) {
                roomSpecification += "> Items:\n" + presentItems();
            }

            roomSpecification += "> Adjacent Areas: \n" + presentAdjacentAreas();
            roomSpecification += "----------------------------------------------------------";
            roomSpecification += "\nmap: \n" + mapString(4);
            roomSpecification += "==========================================================";
            return roomSpecification;
        } else {
            return "You have not visited this Area.";
        }
    }
}
