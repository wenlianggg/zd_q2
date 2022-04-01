// Name:
// Email ID:

//##############################################################

import q2.vending.VendingMachine;

public class VendingMachineTest {
    public static void testReturnChange() {

        VendingMachine vm = new VendingMachine();

        vm.topUpCash(50, 2);
        vm.topUpCash(100, 3);

        int[] coinsInserted = {10,100};
        int original = 0;
        for (int i = 0 ; i < coinsInserted.length ; i++) {
            vm.insertCoin(coinsInserted[i]);
            original += coinsInserted[i];
        }

        ArrayList<Coin> coins = vm.returnChange();

        int sum = 0;
        for (int i = 0; i < coins.size(); i++) {
            Coin c = coins.get(i);
            sum += c.getValue();
        }
        if (sum == original) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }

    public static void main(String[] args) {
        testReturnChange();
    }
}