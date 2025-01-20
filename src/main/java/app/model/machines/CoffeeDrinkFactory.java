package app.model.machines;

import app.model.drinks.Drink;

public class CoffeeDrinkFactory implements IMachineFactory {
    @Override
    public Drink prepare(Drink drink) {
        drink.prepare();
        return null;
    }
}
