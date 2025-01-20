package app.model.machines;

import app.model.drinks.Drink;

public class ColdDrinkFactory implements IMachineFactory {
    @Override
    public Drink prepare(Drink drink) {
        return null;
    }
}
