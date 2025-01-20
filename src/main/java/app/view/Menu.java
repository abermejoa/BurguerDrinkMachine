package app.view;

import app.controller.DrinkController;
import app.controller.MachineController;

import java.io.IOException;

public class Menu {

    public static void getMachines() {
        MachineController.getMachines()
                .forEach((number, machine) ->
                        System.out.println(number + ": " + machine)
                );
    }

    public static void getDrinks(int machineId) throws IOException {
        String drinkName = MachineController.getMachines().get(machineId) + "Drinks";
        DrinkController.getDrinks(drinkName)
                .forEach((k, v) ->
                        System.out.println(k + ": " + v)
                );
    }

}
