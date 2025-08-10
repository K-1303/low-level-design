package vendingmachine.states;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class DispensingState extends State {
    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently Dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently Dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        // already triggered by HasMoneyState
    }

    @Override
    public void refund() {
        System.out.println("Cannot refund while dispensing. Please wait.");
    }
}