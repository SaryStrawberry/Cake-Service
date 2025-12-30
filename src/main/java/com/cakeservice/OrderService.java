package com.cakeservice;

public class OrderService {
    public static String parseUserCommand(String userInput) {
        //this method validates the user command input
        return "";
    }

    public static String parseCakeName(String nameInput) {
        //this method validates the recipe name and returns a string
    }


    public static String parseBatter(String batterInput) {
        //this method validates the batter chosen by the user, ensuring it is included
        //in the batter enum
        return "";
    }


    public static String parseFrosting(String frostingInput) {
        //this method validates the frosting and returns a string
    }

    public static String parseTopping(String toppingInput) {
        //this method validates the topping and returns a string
    }

    public static int parsePreparationTime(String preparationTime) {
        //this method validates the preparation time, converting
        // it to an int and returning it
    }

    public static String parseOrderConfirmation(String confirmationInput) {
        //this method validates the user confirmation of the order
    }

    public static double calculateFinalPrice(Cake cake, String deliveryLocation) {
        //this method adds taxes and delivery cost depending on if the cake is being
        // delivered to QC or ON, calculates and returns final price
    }
}
