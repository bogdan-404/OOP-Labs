package src;

public class Pharmacist {
    private int id;
    private int pharmacyId;
    private float totalSales;

    public Pharmacist(int pharmacyId) {
        this.id = generatePharmacistId();
        this.pharmacyId = pharmacyId;
    }

    private int generatePharmacistId() {
        return (int) ((Math.random() * (99999 - 10000)) + 10000);
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

    public int getId() {
        return this.id;
    }

    public float getTotalSales() {
        return this.totalSales;
    }

}
