import src.Customer;
import src.Doctor;
import src.DrugManufacturer;
import src.FinancialDepartment;
import src.Order;
import src.Pharmacist;
import src.Pharmacy;
import src.Product;
import src.Security;
import src.SupplementDelivery;
import src.Return;

public class Main {
    public static void main(String[] args) {
        var Customer1 = new Customer("Ion", 54436);
        Customer1.createOrder(87960, 5);
        System.out.println("Number of customers: " + Customer.customerCount);

        var Doctor1 = new Doctor("Vasile");
        Doctor1.prescribeDrug(92490, 78942);

        var Pharma = new DrugManufacturer("Pharma");
        Pharma.addProduct(56787);
        Pharma.addProduct(67879);
        System.out.println("The list of all products of the " + Pharma.getName() + " company: " + Pharma.getProducts());

        FinancialDepartment.addStats((float) 20000, (float) 5300, 20);
        FinancialDepartment.addStats((float) 2050, (float) 570, 5);
        FinancialDepartment.printReport();

        var Order1 = new Order();
        Order1.addProducts(67556, (float) 45.5, (float) 26, 3);
        Order1.addProducts(90429, (float) 10.5, (float) 2.5, 10);
        Order1.orderStats();
        Order.printStats();

        var Pharmacist1 = new Pharmacist(76855);
        Pharmacist1.sellDrugs(76859, 87905, 80, true);

        var Pharmacy1 = new Pharmacy();
        System.out.println("Number of pharmacies: " + Pharmacy.NumberOfPharmacies);
        Pharmacy1.addEmployee(65744);
        Pharmacy1.addEmployee(73484);
        Pharmacy1.printEmployeesList();

        var Acetominophen = new Product("Random Manufacturer", 56788, (float) 20, (float) (11.5), 20);
        var Acyclovir = new Product("Random Manufacturer 2", 45647, (float) 16, (float) (9.50), 15, true);
        Acetominophen.sell(10);
        Acyclovir.sell(25);
        Acyclovir.sell(25);

        var Return1 = new Return();
        Return1.returnProducts(67556, (float) 45.5, (float) 26, 3);
        Return1.returnProducts(90429, (float) 10.5, (float) 2.5, 10);
        Return1.orderStats();
        Return.printStats();

        var SecurityCar1 = new Security();
        SecurityCar1.arrestRobber(78943);
        SecurityCar1.arrestRobber(54637);
        Security.printStats();

        var SupplyCar1 = new SupplementDelivery();
        SupplyCar1.deliverProduct(75438, 45613, 10);
        SupplementDelivery.printStats();

    }
}