
import src.Customer;
import src.Doctor;
import src.Order;
import src.Pharmacist;
import src.Pharmacy;
import src.Product;
import src.Security;
import src.SupplementDelivery;

public class Main {
    public static void main(String[] args) {
        // Scenario 1: Customer orders products which do not need prescribtion
        System.out.println(" ");
        System.out.println("===================================================================");
        System.out.println("Scenario 1: Customer orders products which do not need prescribtion");
        System.out.println("Variations:");
        System.out.println("- The product is in stock");
        System.out.println("- One of the products is less in stock than customer needs");
        System.out.println("- The product is out of stock");
        System.out.println("==================================================================");
        var Pharmacy1 = new Pharmacy();
        var Pharmacist1 = new Pharmacist();
        Pharmacy1.setPharmacist(Pharmacist1);
        var DeliveryCar1 = new SupplementDelivery();
        Pharmacy1.setDeliveryCar(DeliveryCar1);
        var Product1 = new Product(10, 4.5, 20);
        var Product2 = new Product(12, 7, 12);
        var Product3 = new Product(12, 9.7, 5);
        Pharmacy1.supplyStock(Product1);
        Pharmacy1.supplyStock(Product2);
        var Customer1 = new Customer();
        Customer1.comeToPharmacy(Pharmacy1, new Order());
        Customer1.addProductToOrder(Product1, 3);
        Customer1.addProductToOrder(Product2, 35);
        Customer1.addProductToOrder(Product3, 5);
        Customer1.finishOrder();

        // Scenario 2: Customer orders a products which need prescribtion
        System.out.println(" ");
        System.out.println("============================================================");
        System.out.println("Scenario 2: Customer orders products which need prescribtion");
        System.out.println("Variations:");
        System.out.println("- Client has the needed prescribtion");
        System.out.println("- Client doesn't have the needed prescribtion");
        System.out.println("============================================================");
        var Pharmacy2 = new Pharmacy();
        var Pharmacist2 = new Pharmacist();
        Pharmacy2.setPharmacist(Pharmacist1);
        var DeliveryCar2 = new SupplementDelivery();
        Pharmacy2.setDeliveryCar(DeliveryCar2);
        var Product4 = new Product(10, 4.5, 20, true);
        var Product5 = new Product(12, 9.7, 5, true);
        Pharmacy2.supplyStock(Product4);
        Pharmacy2.supplyStock(Product5);
        var Customer2 = new Customer();
        var Doctor2 = new Doctor();
        Doctor2.prescribeDrug(Customer2, Product4);
        Customer2.comeToPharmacy(Pharmacy2, new Order());
        Customer2.addProductToOrder(Product4, 2);
        Customer2.addProductToOrder(Product5, 2);
        Customer2.finishOrder();

        // Scenario 3: Customer tries to rob the pharmacy:
        System.out.println(" ");
        System.out.println("============================================================");
        System.out.println("Scenario 3: Customer tries to rob the pharmacy");
        System.out.println("Variations:");
        System.out.println("- Client is arrested (with probability of 80%)");
        System.out.println("- Client is not arrested");
        System.out.println("============================================================");
        var Pharmacy3 = new Pharmacy();
        var Pharmacist3 = new Pharmacist();
        Pharmacy3.setPharmacist(Pharmacist3);
        var DeliveryCar3 = new SupplementDelivery();
        Pharmacy3.setDeliveryCar(DeliveryCar3);
        var SecurityCar3 = new Security();
        Pharmacy3.setSecurityCar(SecurityCar3);
        var Customer3 = new Customer();
        Customer3.comeToPharmacy(Pharmacy3, new Order());
        Customer3.robPharmacy();

    }
}