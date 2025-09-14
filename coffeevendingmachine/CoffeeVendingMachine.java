package coffeevendingmachine;
import coffeevendingmachine.decorator.CaramelSyrupDecorator;
import coffeevendingmachine.decorator.Coffee;
import coffeevendingmachine.decorator.ExtraSugarDecorator;
import coffeevendingmachine.enums.CoffeeType;
import coffeevendingmachine.enums.ToppingType;
import coffeevendingmachine.factory.CoffeeFactory;
import coffeevendingmachine.state.ReadyState;
import coffeevendingmachine.state.VendingMachineState;
import java.util.List;



public class CoffeeVendingMachine {
    private VendingMachineState state;
    private static final CoffeeVendingMachine INSTANCE = new CoffeeVendingMachine();
    private Coffee selectedCoffee;
    private int moneyInserted;

    private CoffeeVendingMachine() {
        this.state = new ReadyState();
        this.selectedCoffee = null;
        this.moneyInserted = 0;
    }

    public void insertMoney(int amount) {
        state.insertMoney(this, amount);
    }

    public void dispenseCoffee() {
        state.dispenseCoffee(this);
    }

    public VendingMachineState getState() {
        return state;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void reset() {
        this.selectedCoffee = null;
        this.moneyInserted = 0;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public void selectCoffee(CoffeeType coffeeType, List<ToppingType> toppings) {
        Coffee coffee = CoffeeFactory.createCoffee(coffeeType);

        for (ToppingType topping : toppings) {
            switch (topping) {
                case EXTRA_SUGAR -> coffee = new ExtraSugarDecorator(coffee);
                case CARAMEL_SYRUP -> coffee = new CaramelSyrupDecorator(coffee);
            }
        }

        this.state.selectCoffee(this, coffee);
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public static CoffeeVendingMachine getInstance() {
        return INSTANCE;
    }

    public void cancel() {
        state.cancel(this);
    }
}