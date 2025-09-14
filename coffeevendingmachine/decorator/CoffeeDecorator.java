package coffeevendingmachine.decorator;

import coffeevendingmachine.enums.Ingredient;
import java.util.Map;

public abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public void prepare() {
        decoratedCoffee.prepare();
    }

    @Override
    protected void addCondiments() {
        decoratedCoffee.addCondiments();
    }

    @Override
    public int getPrice() {
        return decoratedCoffee.getPrice();
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return decoratedCoffee.getRecipe();
    }

}