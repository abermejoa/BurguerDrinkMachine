package app.model.machines;

import app.model.drinks.Drink;

public class Machine implements IMachine {
    private Drink drink;

    public Machine(){
        System.out.println("Se ha iniciado la máquina");
    }

    @Override
    public void pay(int amount) {

    }

    @Override
    public Drink chooseDrink(int id) {
        return null;
    }

    @Override
    public Drink prepare(Drink drink) {
        return null;
    }
}
