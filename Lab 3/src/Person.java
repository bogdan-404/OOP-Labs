package src;

public class Person extends Root {
    protected String name;

    public Person(String name) {
        this.name = name;
        this.id = generateId();
    }

    public static void print() {
        System.out.println("A");
    }

    public String getName() {
        return this.name;
    }
}
