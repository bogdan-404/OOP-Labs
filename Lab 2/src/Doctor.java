package src;

public class Doctor {

    private int id;
    private String name;

    public Doctor(String name) {
        this.id = generateDoctorId();
        this.name = name;
    }

    private int generateDoctorId() {
        return (int) ((Math.random() * (99999 - 10000)) + 10000);
    }

    public void prescribeDrug(int drugId, int customerId) {
        System.out.println("The doctor with id " + this.id + " prescribed the drug with id + " + drugId
                + " to the customer with id " + customerId);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}
