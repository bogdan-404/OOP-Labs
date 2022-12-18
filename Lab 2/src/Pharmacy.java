package src;
import java.util.ArrayList;


public class Pharmacy {
    public static int NumberOfPharmacies = 0;
    public static int NumberOfEmployees= 0;

    private int id;
    private ArrayList<Integer> employees = new ArrayList<Integer>();

    public Pharmacy() {
        this.id = generatePharmacyId();
        NumberOfPharmacies++;
    }

    private int generatePharmacyId() {
        return (int) ((Math.random() * (99999 - 10000)) + 10000);
    }

    public void addEmployee(int employeeId) {
        employees.add(employeeId);
        NumberOfEmployees += 1;
    }
    public void printEmployeesList() {
        System.out.println("List of id of all employees: " + employees);
    }
    public int getId() {
        return id;
    }
}
