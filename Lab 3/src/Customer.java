package src;

public final class Customer extends Person {
    private boolean isRobber = false;
    private int visitedPharmacyId;

    public Customer(String name, int pharmacyId) {
        super(name);
        this.id = generateId();
        this.visitedPharmacyId = pharmacyId;
        objectsCount += 1;
    }

    public Customer(String name, int pharmacyId, boolean isRobber) {
        super(name);
        this.id = generateId();
        this.visitedPharmacyId = pharmacyId;
        this.isRobber = isRobber;
        objectsCount += 1;
    }

    public void createOrder(int productId, int amount) {
        System.out.println(
                "Customer with id " + this.id + " ordered " + amount + " product/products with id " + productId);
    }

    public int getVisitedPharmacyId() {
        return visitedPharmacyId;
    }

    public boolean isRobber() {
        return this.isRobber;
    }

}
