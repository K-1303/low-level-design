package coffeevendingmachine.state;

import coffeevendingmachine.CoffeeVendingMachine;
import coffeevendingmachine.decorator.Coffee;

public class ReadyState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        machine.setSelectedCoffee(coffee);
        System.out.println("Selected coffee: " + coffee.getCoffeeType());
        machine.setState(new SelectingState());
    }

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Please select a coffee and insert money first.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("No transaction to cancel.");
    }
}