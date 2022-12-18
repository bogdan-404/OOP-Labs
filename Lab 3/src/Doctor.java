package src;

public class Doctor extends Person {

    public Doctor(String name) {
        super(name);
    }

    public void prescribeDrug(int drugId, int customerId) {
        System.out.println("The doctor with id " + this.id + " prescribed the drug with id + " + drugId
                + " to the customer with id " + customerId);
    }

}
