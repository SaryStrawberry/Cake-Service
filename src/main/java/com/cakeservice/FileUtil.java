package com.cakeservice;

import com.cakeservice.exceptions.InvalidRecipeNameException;

import java.io.*;
import java.util.Scanner;

public class FileUtil {
    public static final String recipes = "recipes.txt";
    public static String orders = "orders.txt";

    //This method reads from the recipes file, then parses, formats and prints each line to the screen
    public static void printAllRecipes() throws IOException {
        BufferedReader recipeReader = new BufferedReader(new FileReader(recipes));
        String line;

    }

    //This method does the same as 'printAllRecipes()', except for the orders file
    public static void printAllOrders() {

    }

    //This method searches the recipe file for one that matches the given name, then formats it into a readable recipe,
    //or throws an exception if no match is found
    public static String formatRecipeByName(String name) throws IOException, InvalidRecipeNameException {
        BufferedReader recipeReader = new BufferedReader(new FileReader(recipes));
        String line;
        String recipeName;
        String batter;
        String frosting;
        String topping;
        int preparationTime;
        double cost;
        boolean flag = false;
        //The flag above will only switch to true if a match is found in the file, otherwise the method will throw an
        //InvalidRecipeNameException

        while ((line = recipeReader.readLine()) != null) {
            if (line.startsWith(name)) {
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                recipeName = lineScanner.next();
                batter = lineScanner.next();
                frosting = lineScanner.next();
                topping = lineScanner.next();
                preparationTime = lineScanner.nextInt();
                lineScanner.nextLine();
                cost = lineScanner.nextDouble();
                flag = true;
            }
        }

        if (!flag) {
            throw new InvalidRecipeNameException("Recipe could not be found");
        }

        return String.format("%s:\n", recipeName.toUpperCase(), )
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
