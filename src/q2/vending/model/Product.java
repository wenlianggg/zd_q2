// Name:
// Email ID:

//##############################################################

package q2.vending.model;

public abstract class Product {
    private String name;
    private int price;

    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
