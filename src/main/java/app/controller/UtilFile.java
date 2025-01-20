package app.controller;

import app.model.drinks.Drink;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class UtilFile implements IUtilFile{

    File fichero;
    //AHORA HAGO EL SINGLETON

    private static UtilFile instance;

    private UtilFile(){
        System.out.println("Recogiendo datos");
    }

    public static UtilFile getInstance(){
        if (instance==null){
            instance = new UtilFile();
        }
        return instance;
    }



    @Override
    public Map<Integer, Drink> getDrinks(String name) throws IOException,NumberFormatException {
        Map<Integer,Drink> drinks = new HashMap<>();
        int contador = 0;
        for (String line : Files.readAllLines(Path.of(rutaBuilder(name)))) {
            String[] campos = line.split(";");
            //CAMPO 0 -> NOMBRE
            //CAMPO 1 -> PRECIO
            //CAMPO 2 -> DESCRIPCIÓN
            drinks.put(contador++,new Drink(campos[0],campos[1],precioToFloat(campos[2])));
        }
        return drinks;
    }

    @Override
    public void addDrink(List<Drink> drinks) {

    }

    @Override
    public int countDrinks() {
        return 0;
    }

    private String rutaBuilder(String name){
        return "database/"+name+".txt";
    }

    private float precioToFloat(String precio)throws NumberFormatException{
        return Float.parseFloat(precio);
    }
}

class Demo{
    public static void main(String[] args) throws IOException {
        Map<Integer, Drink> drinksMap = UtilFile.getInstance().getDrinks("ColdDrinks");
    }
}
