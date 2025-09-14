package coffeevendingmachine.state;

import coffeevendingmachine.CoffeeVendingMachine;
import coffeevendingmachine.decorator.Coffee;

public class OutOfIngredientState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
         System.out.println("Sorry, the machine is out of ingredients.");
    }

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Sorry, the machine is out of ingredients. Cannot accept money.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Sorry, the machine is out of ingredients. Cannot dispense coffee.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Transaction cancelled. Returning inserted money: $" + machine.getMoneyInserted());
        machine.reset();
        machine.setState(new ReadyState());
    }
}