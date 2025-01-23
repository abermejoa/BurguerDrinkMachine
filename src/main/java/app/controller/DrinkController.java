package app.controller;

import app.model.drinks.Drink;

import java.io.IOException;
import java.util.Map;

public abstract class DrinkController {
    public static Map<Integer, Drink> getDrinks(String machineName) throws IOException {
        return UtilFile.getInstance().getDrinks(machineName);
    }
    private DrinkController(){
        throw new IllegalStateException("Utility class");
    }
}
