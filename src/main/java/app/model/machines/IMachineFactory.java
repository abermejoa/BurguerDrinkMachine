package app.model.machines;

import app.model.drinks.Drink;

public interface IMachineFactory {
    Drink prepare(Drink drink);
}
