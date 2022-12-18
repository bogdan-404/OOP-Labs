package src;

import java.util.ArrayList;

public final class Customer extends Root implements PatientInterface {

    private static int RobberProbability = 1;

    private ArrayList<Integer> prescribtions = new ArrayList<Integer>();
    private boolean isRobber = false;

    public Customer() {
        this.id = generateId();
        objectsCount += 1;
        if ((int) (Math.random() * 100) > (99 - RobberProbability)) {
            this.isRobber = true;
        }
    }

    @Override
    public boolean hasPrescribtion(int id) {
        if (prescribtions.contains(id)) {
            return true;
        }
        return false;
    }

    @Override
    public void addPrescribtion(int drugId) {
        prescribtions.add(drugId);
    }

    @Override
    public boolean isRobber() {
        return this.isRobber;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static void setRobberProbability(int probability) {
        RobberProbability = probability;
    }

}
