package controller;

import java.util.Random;
import model.*;
import view.*;

public class Controller {
    private ConfigurationMenuView ConfigurationView;
    private StatsView ResultPageView;

    public Controller() {
    }

    public void runConfiguration(ConfigurationMenuView ConfigurationView) {
        this.ConfigurationView = ConfigurationView;
        while (ConfigurationView.getRunning()) {
            System.out.println(" ");
        }
        Config.NumberOfPharmacies = this.ConfigurationView.getPharmacies();
        Config.Runtime = this.ConfigurationView.getRuntime();
        Config.NumberOfProducts = this.ConfigurationView.getProducts();
        Config.RobberProbability = this.ConfigurationView.getProbability();
    }

    public void runSimulation() {
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
            price = rand.nextFloat(450);
            productionCost = price * rand.nextFloat(1);
            if (rand.nextInt(100) > 70) {
                needsPrescribtion = true;
            } else {
                needsPrescribtion = false;
            }
            products[i] = new Product(price, productionCost, rand.nextInt(20, 80),
                    needsPrescribtion);
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
                        System.out.println("All the customers ran from the pharmacy during the robbery");
                        currentCustomersPerMinute = 0;
                        pharmacies[i].isRobbed();
                    } else {
                        addsProducts = true;
                        while (addsProducts == true) {
                            if (rand.nextInt(100) > 65) {
                                addsProducts = true;
                            } else {
                                addsProducts = false;
                            }
                            pharmacies[i].addProductToOrder(products[rand.nextInt(products.length)],
                                    rand.nextInt(1, 25));
                        }
                        pharmacies[i].finishOrder();
                        try {
                            Thread.sleep(50);
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
            if (minute % 60 == 0 && minute > 0) {
                System.out.println(
                        "One hour has passed since the start.\nThe stock for all items will be supplied and \nthe money from the cash register will be taken");
                for (int i = 0; i < products.length; i++) {
                    for (int j = 0; j < pharmacies.length; j++) {
                        pharmacies[j].supplyStock(products[i]);
                    }
                }
                for (int i = 0; i < pharmacies.length; i++) {
                    pharmacies[i].resetCashRegister();
                }
            }
            minute += 10;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (int i = 0; i < pharmacies.length; i++) {
            pharmacies[i].resetCashRegister();
        }
    }

    public void runStats(StatsView ResultPageView) {
        this.ResultPageView = ResultPageView;
        this.ResultPageView.updateStats(Config.Runtime, Customer.objectsCount, Pharmacy.totalSales,
                Pharmacy.totalProfit, Pharmacy.totalRobbedMoney, Pharmacy.totalSales / Customer.objectsCount);
    }
}
