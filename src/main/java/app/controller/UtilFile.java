package app.controller;

import app.model.drinks.Drink;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 *
 */
public class UtilFile implements IUtilFile{

    private static UtilFile instance;

    /**
     *Private constructor for the class.
     */
    private UtilFile(){
        System.out.println("Recogiendo datos");
    }

    /**
     *Return an instance of one object of the class
     * Check if there is any object created
     * @return UtilFile
     */
    public static UtilFile getInstance(){
        if (instance==null){
            instance = new UtilFile();
        }
        return instance;
    }


    /**
     * Return a map of drinks. This map contains an id, and
     * the drink object
     * @param name
     * @return Map<Integer,Drink>
     * @throws IOException
     * @throws NumberFormatException
     */
    @Override
    public Map<Integer, Drink> getDrinks(String name) throws IOException,NumberFormatException {
        Map<Integer,Drink> drinks = new HashMap<>();
        int contador = 0;
        for (String line : Files.readAllLines(Path.of(rutaBuilder(name)))) {
            String[] campos = line.split(";");
            //CAMPO 0 -> NOMBRE
            //CAMPO 1 -> PRECIO
            //CAMPO 2 -> DESCRIPCIÓN
            drinks.put(contador++,new Drink(campos[0],campos[2],precioToFloat(campos[1])));
        }
        return drinks;
    }

    /**
     *Write in a file, whose name is SoldDrinks.txt and his path is database/SoldDrinks.txt, the drinks, that have been sold.
     * Write the list of drinks that it receive by param.
     * @param drinks
     * @throws IOException
     */
    @Override
    public void addDrink(List<Drink> drinks) throws IOException {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(rutaBuilder("SoldDrinks"));
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)
        ) {
                oos.writeObject(drinks);
                System.out.println("Se han guardado los objetos");
        }
    }

    /**
     *This only count the list it receives when it calls the method whose name is recolectSalesDrinksData()
     * @return
     * @throws IOException
     */
    @Override
    public int countDrinks() throws IOException {
        return recolectSalesDrinksData().size();
    }

    /**
     *This method read the Object List<Drink> that is container in the file "SoldDrinks.txt"
     * @return List<Drink>
     * @throws IOException
     * @throws RuntimeException
     */
    @Override
    public List<Drink> recolectSalesDrinksData() throws IOException, RuntimeException {
        List<Drink> drinks;
        try(
                FileInputStream fileInputStream = new FileInputStream(rutaBuilder("SalesDrinks"));
                ObjectInputStream ois = new ObjectInputStream(fileInputStream)
        ) {
            drinks = (List<Drink>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return drinks;
    }

    /**
     *Build a simple path for the directory database/
     * @param name
     * @return String
     */
    private String rutaBuilder(String name){
        return "database/"+name+".txt";
    }

    /**
     *Only modify the price that is as String to float, because the Drink's object have a float property for the price
     * @param precio
     * @return float
     * @throws NumberFormatException
     */
    private float precioToFloat(String precio)throws NumberFormatException{
        return Float.parseFloat(precio);
    }
}
