package app.view;

import app.controller.DrinkController;
import app.controller.MachineController;
import app.model.drinks.Drink;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public abstract class Menu {
    public static void showMenu(Scanner sc){
        System.out.println("Selecciona una maquina: ");
        getMachines();
        Map<Integer, Drink> drinks = getDrinks(sc.nextInt());
        System.out.println(System.lineSeparator() + "Selecciona una bebida: ");
        Drink drink = drinks.get(sc.nextInt());

        System.out.println(drink.prepare());

    }

    private static void getMachines() {
        MachineController.getMachines()
                .forEach((number, machine) ->
                        System.out.println(number + ": " + machine)
                );
    }

    public static Map<Integer, Drink> getDrinks(int machineId) {
        String drinkName = MachineController.getMachines().get(machineId).replace(" drinks", "") + "Drinks";
        try {
            Map<Integer, Drink> drinks = DrinkController.getDrinks(drinkName);
            drinks.forEach((k, v) ->
                            System.out.println(k + ": " + v)
                    );
            return drinks;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
