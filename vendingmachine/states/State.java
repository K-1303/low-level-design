package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.Coin;

public abstract class State {
    public VendingMachine machine;

    State(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}