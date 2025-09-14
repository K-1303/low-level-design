package coffeevendingmachine.templatemethod;

import coffeevendingmachine.decorator.Coffee;
import coffeevendingmachine.enums.Ingredient;
import java.util.Map;

public class Latte extends Coffee {
    public Latte() {
        this.coffeeType = "Latte";
    }

    @Override
    public int getPrice() { 
        return 220;
    }

    @Override
    public void addCondiments() {
        System.out.println("- Adding steamed milk.");
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER, 30, Ingredient.MILK, 150);
    }
}