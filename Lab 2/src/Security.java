package src;

public class Security {
    public static int NumberOfCars = 0;
    public static int NumberOfArrests = 0;
    private int carId;

    public Security() {
        NumberOfCars += 1;
        this.carId = generateCarId();
    }

    private int generateCarId() {
        return (int) ((Math.random() * (9999 - 1000)) + 1000);
    }

    public void arrestRobber(int customerId) {
        System.out.println("Security with car id " + this.carId + " arrested the customer with id " + customerId);
        NumberOfArrests += 1;
    }

    public static void printStats() {
        System.out.println("Total number of cars: " + NumberOfCars);
        System.out.println("Total number of arrests: " + NumberOfArrests);
    }

    public int getCarId() {
        return this.carId;
    }

}
