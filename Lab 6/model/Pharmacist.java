package model;

public final class Pharmacist extends Root implements PrescribtionChecker {

    public Pharmacist() {
        this.id = generateId();
    }

    @Override
    public void checkPrescribtion(boolean prescribtionPresent) {
        System.out.println("Pharmacist with id " + this.id + " checks if the client with has a prescribtion");
        if (prescribtionPresent) {
            System.out.println(
                    "Client has the prescribtion, so pharmacist with id " + this.id + " can sell him the product");
        } else {
            System.out.println(
                    "Client doesn't have the prescribtion, so pharmacist with id " + this.id
                            + " can not sell him the product");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }
}
