package app;

import app.view.Menu;

import java.io.IOException;

public class App {

    public App() {

    }

    public void showMachines() {
        Menu.getMachines();
    }

    public void showDrinks(int machineId) throws IOException {
        Menu.getDrinks(machineId);
    }

}
