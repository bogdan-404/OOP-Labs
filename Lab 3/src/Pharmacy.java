package src;

import java.util.ArrayList;

public final class Pharmacy extends BusinessEntity {

    public Pharmacy(String PharmacyName) {
        super(PharmacyName);
    }

    @Override
    public void printStats() {
        System.out.println("Number of all employees: " + countIds);
        System.out.println("List of id of all employees: " + ids);
    }

}
