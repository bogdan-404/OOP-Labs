package src;

import java.util.ArrayList;

public abstract class BusinessEntity extends Root {

    protected String name;
    protected ArrayList<Integer> ids = new ArrayList<Integer>();
    protected int countIds;

    public BusinessEntity(String name) {
        this.id = generateId();
        this.name = name;
        objectsCount++;
    }

    public void addId(int id) {
        ids.add(id);
        countIds += 1;
    }

    public void printStats() {
        System.out.println("Number of items: " + countIds);
        System.out.println("List: " + ids);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList getIdsList() {
        return this.ids;
    }

}
