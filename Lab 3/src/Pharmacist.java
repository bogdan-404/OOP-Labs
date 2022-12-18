package src;

public final class Pharmacist extends Person {
    private int pharmacyId;
    private float totalSales;

    public Pharmacist(String name, int pharmacyId) {
        super(name);
        this.id = generateId();
        this.pharmacyId = pharmacyId;
    }

    public static void print() {
        System.out.println("B");
    }

    public void sellDrugs(int productId, int customerId, float totalPrice, boolean prescribtionNeeded) {
        if (prescribtionNeeded == true)
            System.out.println("Prescribtion checked");
        System.out.println("Pharmacist sold product with id " + productId + " to the customer with id " + customerId);
        this.totalSales += totalPrice;
    }

    public void setPharmacyId(int id) {
        this.id = pharmacyId;
    }

    public int getPharmacyId() {
        return this.pharmacyId;
    }

    public float getTotalSales() {
        return this.totalSales;
    }

}
