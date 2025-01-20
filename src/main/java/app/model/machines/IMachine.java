package app.model.machines;

import app.model.drinks.Drink;

public interface IMachine {
    void pay(int amount);
    Drink chooseDrink(int id);
    Drink prepare(Drink drink);
}
