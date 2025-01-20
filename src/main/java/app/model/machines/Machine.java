package app.model.machines;

import app.model.drinks.Drink;

public class Machine implements IMachine {
    private static final Machine INSTANCE = new Machine();
    private Drink drink;

    private Machine(){
        System.out.println("Se ha iniciado la máquina");
    }

    private static class Impl{
        private static final Machine INSTANCE = new Machine();
    }

    public static Machine getInstance() {
        return INSTANCE;
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
