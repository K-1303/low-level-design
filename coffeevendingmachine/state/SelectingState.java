package coffeevendingmachine.state;

import coffeevendingmachine.CoffeeVendingMachine;
import coffeevendingmachine.decorator.Coffee;

public class SelectingState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        System.out.println("Coffee already selected: " + coffee.getCoffeeType());
    }

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        machine.setMoneyInserted(machine.getMoneyInserted() + amount);
        System.out.println("Inserted money: $" + amount + ". Total inserted: $" + machine.getMoneyInserted());

        if (machine.getMoneyInserted() >= machine.getSelectedCoffee().getPrice()) {
            machine.setState(new PaidState());
            System.out.println("Sufficient money inserted. You can now dispense your coffee.");
        }
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Please insert sufficient money first.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Transaction cancelled. Returning inserted money: $" + machine.getMoneyInserted());
        machine.reset();
        machine.setState(new ReadyState());
    }
}