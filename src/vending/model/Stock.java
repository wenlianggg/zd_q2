// Name:
// Email ID:

//##############################################################
package vending.model;

public class Stock {
    private Product product;
    private int quantity;

    public Stock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public boolean decrement() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }
}
