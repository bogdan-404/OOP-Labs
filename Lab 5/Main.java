import src.Customer;
import src.Pharmacist;
import src.Pharmacy;
import src.Product;
import src.Security;
import src.SupplementDelivery;
import src.Config;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Pharmacy[] pharmacies = new Pharmacy[Config.NumberOfPharmacies];
        Security[] securityCars = new Security[Config.NumberOfSecurityCars];
        Product[] products = new Product[Config.NumberOfProducts];
        SupplementDelivery car = new SupplementDelivery();
        Random rand = new Random();
        Customer.setRobberProbability(Config.RobberProbability);

        for (int i = 0; i < securityCars.length; i++) {
            securityCars[i] = new Security();
        }

        for (int i = 0; i < pharmacies.length; i++) {
            pharmacies[i] = new Pharmacy();
            pharmacies[i].setPharmacist(new Pharmacist());
            pharmacies[i].setSecurityCar(securityCars[i % securityCars.length]);
            pharmacies[i].setDeliveryCar(car);
        }

        double price, productionCost;
        boolean needsPrescribtion;
        for (int i = 0; i < products.length; i++) {
            price = (float) (Math.random() * 450);
            productionCost = price * (float) (Math.random());
            if ((int) (Math.random() * 100) > 70) {
                needsPrescribtion = true;
            } else {
                needsPrescribtion = false;
            }
            products[i] = new Product(price, productionCost,(int) (Math.random() * 60 + 20), needsPrescribtion);
            for (int j = 0; j < pharmacies.length; j++) {
                pharmacies[j].supplyStock(products[i]);
            }
        }

        int minute = 0;
        boolean addsProducts;
        while (minute <= Config.Runtime) {
            for (int i = 0; i < pharmacies.length; i++) {
                int currentCustomersPerMinute = pharmacies[i].generateNumberOfCustomers();
                while (currentCustomersPerMinute > 0) {
                    currentCustomersPerMinute -= 1;
                    pharmacies[i].setCurrentCustomer(new Customer());
                    if (pharmacies[i].robberInPharmacy()) {
                        currentCustomersPerMinute = 0;
                        System.out.println("All the customers ran from the pharmacy during the robbery");
                        pharmacies[i].isRobbed();
                    } else {
                        addsProducts = true;
                        while (addsProducts == true) {
                            if ((int) (Math.random() * 100) > 65) {
                                addsProducts = true;
                            } else {
                                addsProducts = false;
                            }
                            pharmacies[i].addProductToOrder(products[rand.nextInt(products.length)],
                            (int) (Math.random() * (25-1) + 1));
                                    
                        }
                        pharmacies[i].finishOrder();
                        try {
                            Thread.sleep(2500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
            System.out.println("");
            if (minute + 10 < Config.Runtime) {
                System.out.println("======================");
                System.out.println("10 minutes have passed");
                System.out.println("======================");
            }
            if (minute % Config.CashRegisterRefreshCooldown == 0 && minute > 0) {
                System.out.println("________________________________________________________");
                System.out.println(Config.CashRegisterRefreshCooldown + 
                        " minutes have passed since the last cash register refresh.\nNow the money from all the cash registers will be taken");

                for (int i = 0; i < pharmacies.length; i++) {
                    pharmacies[i].resetCashRegister();
                }
            }
            if (minute % Config.StockSupplyCooldown == 0 && minute > 0) {
                System.out.println("________________________________________________________");
                System.out.println(Config.StockSupplyCooldown
                       + " minutes have passed since last delivery\nThe stock for all items will be supplied");
                for (int i = 0; i < products.length; i++) {
                    for (int j = 0; j < pharmacies.length; j++) {
                        pharmacies[j].supplyStock(products[i]);
                    }
                }
            }
            minute += 10;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (int i = 0; i < pharmacies.length; i++) {
            pharmacies[i].resetCashRegister();
        }

        System.out.println("+==================+");
        System.out.println("|Simulation Results|");
        System.out.println("+==================+");
        System.out.println("Time in virtual minutes have passed: " + (minute - 10));
        System.out.println("Total number of customers: " + Customer.objectsCount);
        System.out.println("Total sales: " + Pharmacy.totalSales + " lei");
        System.out.println("Total profit: " + Pharmacy.totalProfit + " lei");
        System.out.println("Total money robbed from pharmacies: " +
                Pharmacy.totalRobbedMoney + " lei");
        System.out.println("Average chekout: " + Pharmacy.totalSales /
                Customer.objectsCount + " lei");
    }
}