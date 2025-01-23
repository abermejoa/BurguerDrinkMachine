package app.controller;

import app.model.drinks.Drink;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IUtilFile {

    Map<Integer, Drink> getDrinks(String name) throws IOException;

    void addDrink(List<Drink> drinks) throws IOException;
    int countDrinks() throws IOException;
    List<Drink> recolectSalesDrinksData() throws IOException;

}
