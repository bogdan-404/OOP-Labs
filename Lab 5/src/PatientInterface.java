package src;

public interface PatientInterface extends IDIdentifiable {
    void addPrescribtion(int drugId);

    boolean hasPrescribtion(int id);

    boolean isRobber();
}
