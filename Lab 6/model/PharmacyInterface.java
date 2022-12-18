package model;

public interface PharmacyInterface extends PrescribtionChecker {
    int checkStock(ProductInterface product, int amount);

    void removeStock(ProductInterface product, int amount);

    public void addCash(double profit);

    public void robCashRegister();

}
