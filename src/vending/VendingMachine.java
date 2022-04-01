// Name:
// Email ID:

//##############################################################

package vending;

import vending.model.Stock;
import labtest.vending.money.*;
import vending.exception.*;
import java.util.*;

public class VendingMachine {
    private ArrayList<Stock> inventory = new ArrayList<Stock>();
    private int customerCash = 0;
    private CoinBox box = new CoinBox();

    private static final Logger logger = LogManager.getLogger("labtest");

    public VendingMachine() {
        logger.debug("Creating an instance of Vending machine");
    }

    public void topUpProduct(Product product, int quantity) {
        inventory.add(new Stock(product, quantity));
    }

    public void topUpCash(int value, int quantity) {
        box.addCoin(value, quantity);
    }

    public void insertCoin(int value) {
        customerCash += value;
        System.out.println("numCash = " + customerCash);
        box.addCoin(value, 1);

    }

    /**
     * TODO:
     * Create public method dispense(String name)
     * 1. If the name is not a valid product name, throws a IllegalArgumentException
     * with message
     * "Invalid name"
     * 2. If there is no stock, throws a
     * labtest.vending.exception.OutOfStockException with message "No Stock"
     * 3. If customerCash is insufficient to purchase the product, throws a
     * InsufficientMoneyException
     * 4. If there is a matching product, and the customer has sufficient cash,
     * decrement the product stock quantity by 1, and deduct the product's price
     * from customerCash
     */
    public Product dispense(String name) throws OutOfStockException, InsufficientMoneyException {

        boolean found = false;
        for (Stock stock : inventory) {
            Product product = stock.getProduct();
            if (product.getName().equals(name)) {
                found = true;

                if (product.getPrice() <= customerCash) {
                    if (stock.decrement()) {

                        customerCash -= product.getPrice();
                        return stock.getProduct();
                    } else {
                        throw new OutOfStockException("No labtest.vending.model.Stock", product);
                    }

                } else {
                    throw new InsufficientMoneyException();
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Product " + name + " is not available");
        }
        return null;
    }

    public ArrayList<Coin> returnChange() {
        ArrayList<Coin> coins = box.returnChange(customerCash);
        customerCash = 0;
        return coins;

    }

}
