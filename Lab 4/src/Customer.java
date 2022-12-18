package src;

import java.util.ArrayList;

public final class Customer extends Root implements PatientInterface {

    private ArrayList<Integer> prescribtions = new ArrayList<Integer>();

    private PharmacyInterface pharmacy;
    private OrderInterface order;
    // private ProductInterface currentProduct;

    public Customer() {
        this.id = generateId();
        objectsCount += 1;
    }

    public void comeToPharmacy(PharmacyInterface pharmacy, OrderInterface order) {
        this.pharmacy = pharmacy;
        this.order = order;
        System.out.println(" ");
        System.out.println("Client with id " + this.id + " came to pharmacy with id " + pharmacy.getId());
        System.out.println("Order with id " + order.getId() + " is assigned to this client");
    }

    public void addProductToOrder(ProductInterface product, int amount) {
        System.out.println(" ");
        if (product.getPrescriptionNeeded()) {
            pharmacy.checkPrescribtion(this.hasPrescribtion(product.getId()));
            if (!this.hasPrescribtion(product.getId())) {
                return;
            }
        }
        int stock = pharmacy.checkStock(product, amount);
        if (stock == 0) {
            return;
        } else {
            this.order.addProducts(product, stock);
            this.pharmacy.removeStock(product, stock);
            this.pharmacy.addCash(this.order.getOrderRevenue());
        }
    }

    public void finishOrder() {
        System.out.println(" ");
        System.out.println("The client finalized the order");
        this.order.printOrderStats();
    }

    public void robPharmacy() {
        this.pharmacy.robCashRegister();
    }

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
    public int getId() {
        return this.id;
    }
}
