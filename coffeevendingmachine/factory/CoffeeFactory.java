package coffeevendingmachine.factory;

import coffeevendingmachine.decorator.Coffee;
import coffeevendingmachine.enums.CoffeeType;
import coffeevendingmachine.templatemethod.Cappuccino;
import coffeevendingmachine.templatemethod.Espresso;
import coffeevendingmachine.templatemethod.Latte;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        return switch (type) {
            case CoffeeType.ESPRESSO -> new Espresso();
            case CoffeeType.LATTE -> new Latte();
            case CoffeeType.CAPPUCCINO -> new Cappuccino();
            default -> throw new IllegalArgumentException("Unknown coffee type: " + type);
        };
    }
}