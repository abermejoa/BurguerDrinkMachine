package app.view;

import app.controller.DrinkController;
import app.controller.MachineController;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.Set;

public class Menu {

    /*
    Set<Class<? extends IHotDrinkFactory>> types =
            new Reflections("factories") // ""
                    .getSubTypesOf(IHotDrinkFactory.class);
        for (Class<? extends IHotDrinkFactory> type : types)
    {
        namedFactories.add(new Pair<>(
                type.getSimpleName().replace("Factory", ""),
                type.getDeclaredConstructor().newInstance()
        ));
    }*/
    public static void getMachine() {
        MachineController.getMachines()
                .forEach((number, machine) -> System.out.println(number + ": " + machine));
    }

    public static void getDrinks(String machineName) throws IOException {
        DrinkController.getDrinks(machineName);
    }
}

class Demo {
    public static void main(String[] args) throws IOException {
        Menu.getDrinks("CoffeController");
    }
}
