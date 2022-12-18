package model;

import java.util.HashMap;
import java.util.Random;

public final class Pharmacy extends Root {
    public static double totalSales;
    public static double totalProfit;
    public static double totalRobbedMoney;

    protected HashMap<Integer, Integer> stock = new HashMap<Integer, Integer>();
    private int productID, amount, updatedAmount;
    private int salesOfCurrentDay, profitOfCurrentDay;

    private PrescribtionChecker pharmacist;
    private IDIdentifiable deliveryCar;
    private SecurityInterface securityCar;
    private PatientInterface currentCustomer;
    private OrderInterface currentOrder;

    public Pharmacy() {
        this.id = generateId();
        objectsCount++;
    }

    public void supplyStock(ProductInterface product) {
        this.productID = product.getId();
        this.amount = product.getSupplyStockQuantity();
        if (stock.containsKey(productID)) {
            this.updatedAmount = amount + stock.get(productID);
            stock.replace(productID, updatedAmount);
        } else {
            stock.put(productID, amount);
        }
        System.out.println(" ");
        System.out.println("Car with id " + deliveryCar.getId() + " delivered the product");
        System.out.println(
                "Pharmacy with id " + this.id + " supplied an amount of " + amount + " items of id " + productID);
        System.out.println("Now the current stock quantity for this product is " + stock.get(productID));
    }

    public int checkStock(ProductInterface product, int amount) {
        productID = product.getId();
        if (!stock.containsKey(productID) || stock.get(productID) == 0) {
            System.out.println("The chosen product is out of stock");
            return 0;
        }
        if (stock.get(productID) < amount) {
            System.out.println("Stock is less than needed amount of " + amount + " items. The pharmacy will sell only "
                    + stock.get(productID)
                    + " items of this product");
            return stock.get(productID);
        }
        return amount;
    }

    public void removeStock(ProductInterface product, int amount) {
        this.productID = product.getId();
        int updatedAmount = stock.get(productID) - amount;
        stock.replace(productID, updatedAmount);
    }

    public void checkPrescribtion(boolean prescribtionPresent) {
        pharmacist.checkPrescribtion(prescribtionPresent);

    }

    public int getId() {
        return this.id;
    }

    public void setPharmacist(PrescribtionChecker currentPharmacist) {
        this.pharmacist = currentPharmacist;
    }

    public void setDeliveryCar(IDIdentifiable car) {
        this.deliveryCar = car;
    }

    public void setSecurityCar(SecurityInterface car) {
        this.securityCar = car;
    }

    public void setCurrentCustomer(PatientInterface customer) {
        this.currentCustomer = customer;
        this.currentOrder = new Order();
        System.out.println("________________________________________________________");
        System.out.println(" ");
        System.out.println("Client with id " + currentCustomer.getId() + " came to pharmacy with id " + this.id);
        System.out.println("Order with id " + this.currentOrder.getId() + " is assigned to this client");
    }

    public void addProductToOrder(ProductInterface product, int amount) {
        System.out.println(" ");
        if (product.getPrescriptionNeeded()) {
            Random rand = new Random();
            if (rand.nextInt(100) > 40) {
                this.currentCustomer.addPrescribtion(product.getId());
            }
            this.checkPrescribtion(this.currentCustomer.hasPrescribtion(product.getId()));
            if (!this.currentCustomer.hasPrescribtion(product.getId())) {
                return;
            }
        }
        int stock = this.checkStock(product, amount);
        if (stock == 0) {
            return;
        } else {
            this.currentOrder.addProducts(product, stock);
            this.removeStock(product, stock);
            System.out.println(this.currentOrder.getOrderRevenue()
                    + " lei were added to the cash register of the pharmacy with id " + this.id);
        }
    }

    public void finishOrder() {
        System.out.println(" ");
        System.out.println("The client finished the order");
        this.currentOrder.printOrderStats();
        this.salesOfCurrentDay += this.currentOrder.getOrderRevenue();
        this.profitOfCurrentDay += this.currentOrder.getOrderProfit();
    }

    public void resetCashRegister() {
        totalSales += this.salesOfCurrentDay;
        totalProfit += this.profitOfCurrentDay;
        salesOfCurrentDay = 0;
        profitOfCurrentDay = 0;
    }

    public void isRobbed() {
        System.out.println("A robber came to the pharmacy");
        if (securityCar.arrestRobber()) {
            return;
        }
        totalRobbedMoney += salesOfCurrentDay;
        this.salesOfCurrentDay = 0;
        this.profitOfCurrentDay = 0;
        return;
    }

    public boolean robberInPharmacy() {
        return this.currentCustomer.isRobber();
    }

    public int generateNumberOfCustomers() {
        int numberOfClients = (int) (Math.random() * 100);
        if (numberOfClients > 98) {
            return (int) (Math.random() * (10 - 6) + 6);
        } else if (numberOfClients > 95) {
            return 5;
        } else if (numberOfClients > 90) {
            return 4;
        } else if (numberOfClients > 85) {
            return 3;
        } else if (numberOfClients > 75) {
            return 2;
        } else if (numberOfClients > 60) {
            return 1;
        } else {
            return 0;
        }
    }
}
