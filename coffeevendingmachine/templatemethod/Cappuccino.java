package coffeevendingmachine.templatemethod;

import coffeevendingmachine.decorator.Coffee;
import coffeevendingmachine.enums.Ingredient;
import java.util.Map;

public class Cappuccino extends Coffee {
    public Cappuccino() {
        this.coffeeType = "Cappuccino";
    }

    @Override
    public int getPrice() { 
        return 250;
    }

    @Override
    public void addCondiments() {
        System.out.println("- Adding steamed milk and foam.");
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.MILK, 100, Ingredient.WATER, 30);
    }
}