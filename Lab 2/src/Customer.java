package src;

public class Customer {
    public static int customerCount;
    private int id;
    private String name;
    private boolean isRobber = false;
    private int visitedPharmacyId;

    public Customer(String name, int pharmacyId) {
        customerCount += 1;
        this.id = generateCustomerId();
        this.name = name;
        this.visitedPharmacyId = pharmacyId;
        customerCount += 1;
    }

    public Customer(String name, int pharmacyId, boolean isRobber) {
        this.id = generateCustomerId();
        this.name = name;
        this.visitedPharmacyId = pharmacyId;
        this.isRobber = isRobber;
        customerCount += 1;
    }

    private int generateCustomerId() {
        return (int) ((Math.random() * (99999 - 10000)) + 10000);
    }

    public void createOrder(int productId, int amount) {
        System.out.println(
                "Customer with id " + this.id + " ordered " + amount + " product/products with id " + productId);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getVisitedPharmacyId() {
        return visitedPharmacyId;
    }

    public boolean isRobber() {
        return this.isRobber;
    }

}
