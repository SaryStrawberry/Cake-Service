package com.cakeservice;

import com.cakeservice.exceptions.InvalidRecipeNameException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static final String recipes = "recipes.txt";
    public static String orders = "orders.txt";

    //This method takes a String called line, splits it into an array of parts and uses them to make a Cake object.
    public static Cake getCakeFromLine(String line) {
        Cake cake = null;
        String[] parts = line.split(",");

        for (int i = 0; i < parts.length; i += 6) {
            cake = new Cake(parts[i], parts[i+1], parts[i+2], parts[i+3], Integer.parseInt(parts[i+4]),
                    Double.parseDouble(parts[i+5]));
        }
        return cake;
    }

    //This method takes a recipe name, checks the recipes file to find a match and returns a Cake object
    //or throws an InvalidRecipeNameException if no match is found.
    public static Cake getCakeByName(String name) throws IOException, InvalidRecipeNameException {
        BufferedReader recipeReader = new BufferedReader(new FileReader(recipes));
        String line;
        Cake cake = null;
        boolean flag = false;
        //This boolean flag will switch to true if a matching recipe is found, otherwise an InvalidRecipeException
        //will be thrown.

        while ((line = recipeReader.readLine()) != null) {
            if (line.startsWith(name)) {
                cake = getCakeFromLine(line);
                flag = true;
            }
        }

        if (!flag) {
            throw new InvalidRecipeNameException("Recipe could not be found");
        }
        return cake;
    }


    //This method calls the getCakeByName() method to create a Cake object, then formats it into a readable recipe.
    public static String formatRecipeByName(String name) throws IOException {
        Cake cake = getCakeByName(name);

        return String.format("%s:\n\nBatter: %s\nFrosting: %s\nTopping: %s\nPreparation Time: %d\nCost: %.2f",
                cake.getRecipeName().toUpperCase(), cake.getBatter(), cake.getFrosting(), cake.getTopping(),
                cake.getPreparationTime(), cake.getCost());
    }

    //This method reads from the recipes file, parses them and stores the recipes in an ArrayList of Cake objects
    public static List<Cake> retrieveAllRecipes() throws IOException {
        BufferedReader recipeReader = new BufferedReader(new FileReader(recipes));
        String line;
        Cake cake = null;
        List<Cake> recipes = new ArrayList<>();

        //This while loop reads each line of the recipes file, calls the getCakeFromLine() method to create a Cake
        //object at each line, and adds each one to an ArrayList of Cake objects.
        while ((line = recipeReader.readLine()) != null) {
            cake = getCakeFromLine(line);
            recipes.add(cake);
        }
        return recipes;
    }

    //This method reads each line of the orders file, creates an Order object from each line and adds each to an
    //ArrayList of Order objects.
    public static List<Order> retrieveAllOrders() throws IOException{
        BufferedReader orderReader = new BufferedReader(new FileReader(orders));
        String line;
        Order order = null;
        List<Order> orders = new ArrayList<>();

        while ((line = orderReader.readLine()) != null) {
            String[] parts = line.split(",");

            for (int i = 0; i < parts.length; i +=6) {
                Order order = new Order(formatRecipeByName(parts[i]), LocalDate.parse(parts[i+1]), LocalDate.parse(parts[i+2]), parts[i+3], parts[i+4], Double.parseDouble(parts[i+5]));
                orders.add(order);
            }
        }
        return recipes;
    }



    //This method takes a cake object, retrieves each attribute with a getter method, formats them into a new recipe
    //and returns it
    public static String formatNewRecipe(Cake cake) {
        String name = cake.getRecipeName();
        String batter = cake.getBatter();
        String frosting = cake.getFrosting();
        String topping = cake.getTopping();
        int preparationTime = cake.getPreparationTime();
        double cost = cake.getCost();
        return String.format("%s, %s, %s, %s, %d, %f", name, batter, frosting, topping, preparationTime, cost);
    }

    //This method prints a recipe made by the 'formatNewRecipe()' method into the recipe file
    public static void appendRecipe(String recipe) throws IOException{
        PrintWriter recipeWriter = new PrintWriter(new FileWriter(recipes, true));
        recipeWriter.println(recipe);
        recipeWriter.flush();
        recipeWriter.close();

    }

    //This method prints a new order to the order file
    public static void appendOrder(Order order) throws IOException{
        PrintWriter orderWriter = new PrintWriter(new FileWriter(orders, true));
        orderWriter.println(order);
        orderWriter.flush();
        orderWriter.close();
    }
}
