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
     *
     */
    private UtilFile(){
        System.out.println("Recogiendo datos");
    }

    /**
     *
     * @return
     */
    public static UtilFile getInstance(){
        if (instance==null){
            instance = new UtilFile();
        }
        return instance;
    }


    /**
     *
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
     *
     * @param drinks
     * @throws IOException
     */
    @Override
    public void addDrink(List<Drink> drinks) throws IOException {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(rutaBuilder("SalesDrinks"));
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)
        ) {
                oos.writeObject(drinks);
                System.out.println("Se han guardado los objetos");

        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
    @Override
    public int countDrinks() throws IOException {
        return recolectSalesDrinksData().size();
    }

    /**
     *
     * @return
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
     *
     * @param name
     * @return
     */
    private String rutaBuilder(String name){
        return "database/"+name+".txt";
    }

    /**
     *
     * @param precio
     * @return
     * @throws NumberFormatException
     */
    private float precioToFloat(String precio)throws NumberFormatException{
        return Float.parseFloat(precio);
    }
}

class Demo{
    public static void main(String[] args) throws IOException {
        Map<Integer, Drink> drinksMap = UtilFile.getInstance().getDrinks("TeeDrinks");
        System.out.println(drinksMap);
        List<Drink> bebidas = drinksMap.values().stream().toList();
        UtilFile.getInstance().addDrink(bebidas);
        System.out.println(UtilFile.getInstance().recolectSalesDrinksData());
    }
}
