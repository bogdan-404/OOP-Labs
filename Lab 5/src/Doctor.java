package src;

public class Doctor extends Root {

    public Doctor() {
        this.id = generateId();
    }

    public void prescribeDrug(PatientInterface patient, ProductInterface product) {
        patient.addPrescribtion(product.getId());
        System.out.println(" ");
        System.out.println("The doctor with id " + this.id + " prescribed the drug with id " + product.getId()
                + " to the customer with id " + patient.getId());
    }
}
