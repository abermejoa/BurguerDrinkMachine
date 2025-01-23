package app.controller;

import app.model.machines.IMachineFactory;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class MachineController {

    public static Map<Integer, String> getMachines() {

        Map<Integer, String> machines = new HashMap<>();
        Set<Class<? extends IMachineFactory>> classes = new Reflections("app.model.machines").getSubTypesOf(IMachineFactory.class);

        int i = 1;
        for (Class<? extends IMachineFactory> clas : classes) {
            String name = clas.getSimpleName()
                    .replace("class app.model.machines.", "")
                    .replace("DrinkFactory", "");
            if (name.equals("Cold")) {
                name += " drinks";
            }
            machines.put(i, name);

            i++;
        }

        return machines;
    }

}