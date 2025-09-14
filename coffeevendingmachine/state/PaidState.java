package coffeevendingmachine.state;

import coffeevendingmachine.CoffeeVendingMachine;
import coffeevendingmachine.Inventory;
import coffeevendingmachine.decorator.Coffee;

public class PaidState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        System.out.println("Coffee already selected: " + coffee.getCoffeeType());
    }

    @Override
    public void insertMoney(CoffeeVendingMachine machine, int amount) {
        System.out.println("Sufficient money already inserted. You can dispense your coffee.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        Inventory inventory = Inventory.getInstance();
        Coffee coffee = machine.getSelectedCoffee();

        if(!inventory.hasIngredients(coffee.getRecipe())) {
            System.out.println("Insufficient ingredients for " + coffee.getCoffeeType() + ". Transaction cancelled. Returning inserted money: $" + machine.getMoneyInserted());
            machine.setState(new OutOfIngredientState());
            machine.getState().cancel(machine);
            return;
        }

        inventory.deductIngredients(coffee.getRecipe());

        coffee.prepare();

        int change = machine.getMoneyInserted() - coffee.getPrice();

        if(change > 0) {
            System.out.println("Please collect your change: $" + change);
        }

        machine.reset();
        machine.setState(new ReadyState());
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        new SelectingState().cancel(machine);
    }
}