package src;

public class SupplementDelivery {
    public static int NumberOfCars = 0;
    public static int NumberOfDeliveries = 0;

    private int carId;
    private int destinationPharmacyId;
    private int productId;
    private int productAmount;

    public SupplementDelivery() {
        this.carId = generateCarId();
        NumberOfCars += 1;
    }

    private int generateCarId() {
        return (int) ((Math.random() * (9999 - 1000)) + 1000);
    }

    public void deliverProduct(

            int destinationPharmacyId,
            int productId,
            int productAmount) {
        this.destinationPharmacyId = destinationPharmacyId;
        this.productAmount = productAmount;
        this.productId = productId;
        NumberOfDeliveries += 1;
        System.out.println("Car with id " + this.carId + " delivered an amount of " + this.productAmount
                + " products with id " + this.productId + " to the pharmacy with id " + this.destinationPharmacyId);
    }

    public static void printStats() {
        System.out.println("Total number of cars: " + NumberOfCars);
        System.out.println("Total number of deliveries: " + NumberOfDeliveries);
    }

    public int getCarId() {
        return this.carId;
    }
}
