package src;

import java.util.ArrayList;

public class DrugManufacturer extends BusinessEntity {

    public DrugManufacturer(String CompanyName) {
        super(CompanyName);
    }

    @Override
    public void printStats() {
        System.out.println("Number of all products which belong to this manufacturer: " + countIds);
        System.out.println("List of id of all products of this company: " + ids);
    }

}
