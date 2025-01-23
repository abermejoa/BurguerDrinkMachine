package app;

import app.view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public void initApp(){
        boolean exit = false;
        int option;
        Scanner sc = new Scanner(System.in);

        while (!exit) {
            Menu.showMenu(sc);
        }

    }
}
