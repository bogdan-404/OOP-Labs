package model;

public class Product extends Root implements ProductInterface {

    private double price;
    private double productExpenses;
    private int stockSupplyQuantity;
    private boolean prescriptionNeeded = false;

    public Product(
            double price,
            double productExpenses,
            int stockSupplyQuantity) {
        this.id = generateId();
        this.price = price;
        this.productExpenses = productExpenses;
        this.stockSupplyQuantity = stockSupplyQuantity;
        objectsCount += 1;
    }

    public Product(
            double price,
            double productExpenses,
            int stockSupplyQuantity,
            boolean prescriptionNeeded) {
        this.id = generateId();
        this.price = price;
        this.productExpenses = productExpenses;
        this.stockSupplyQuantity = stockSupplyQuantity;
        this.prescriptionNeeded = prescriptionNeeded;
        objectsCount += 1;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getExpenses() {
        return this.productExpenses;
    }

    @Override
    public int getSupplyStockQuantity() {
        return this.stockSupplyQuantity;
    }

    @Override
    public boolean getPrescriptionNeeded() {
        return this.prescriptionNeeded;
    }

    public void setSupplyStockQuantity(int quantity) {
        this.stockSupplyQuantity = quantity;
    }

}
