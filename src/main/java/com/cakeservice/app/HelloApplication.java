package com.cakeservice.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Defining nodes that do the following:
        // 1. Display all existing recipes and orders
        // 2. Search for and display a recipe or order based on a specific attribute
        // 3. Create a new order either from an existing recipe or custom
        Label title = new Label("Welcome to Sara's Cake Bakery!");

        //1
        Button cakeDisplayBtn = new Button("Display all cakes");
        Button orderDisplayBtn = new Button("Display all orders");

        //2
        Label findCakeLabel = new Label("Find cakes by:");
        ComboBox<String> cakeSearchOptions = new ComboBox<>();
        cakeSearchOptions.getItems().addAll("Name", "Batter", "Frosting", "Topping", "Preparation time", "Cost");
        TextField findCakeField = new TextField("Enter a ---");
        Button cakeSearchBtn = new Button("Enter");

        Label findOrderLabel = new Label("Find order by:");
        ComboBox<String> orderSearchOptions = new ComboBox<>();
        orderSearchOptions.getItems().addAll("Order ID", "Name", "Order Creation Date", "Delivery Date", "Delivery location", "Cost");
        TextField findOrderField = new TextField("Enter a ---");
        Button orderSearchBtn = new Button("Enter");

        Label orderLabel = new Label("Create new order:");
        ComboBox<String> orderCreationComboBox = new ComboBox<>();
        orderCreationComboBox.getItems().addAll("Order from recipe", "Custom order");

        Label displayLabel = new Label("");

        //3
        Label orderFromRecipeLabel = new Label("Create an order from a recipe");
        Label recipeNameLabel = new Label("Recipe name:");
        TextField recipeNameField = new TextField();
        Label deliveryDateLabel = new Label("Delivery date:");
        TextField deliveryDateField = new TextField();
        Label deliveryLocationLabel = new Label("Delivery location:");
        TextField deliveryLocationField = new TextField();
        Button orderEnterBtn = new Button("Enter");

        Label orderCustomLabel = new Label("Create a custom order");
        Label customNameLabel = new Label("Custom name:");
        TextField customNameField = new TextField();
        Label batterLabel = new Label("Batter:");
        TextField batterField = new TextField();
        Label frostingLabel = new Label("Frosting:");
        TextField frostingField = new TextField();
        Label toppingLabel = new Label("Topping:");
        TextField toppingField = new TextField();
        Label deliveryDateLabelForCustom = new Label("Delivery date:");
        TextField deliveryDateFieldForCustom = new TextField();
        Label deliveryLocationLabelForCustom = new Label("Delivery location:");
        TextField deliveryLocationFieldForCustom = new TextField();
        Button customOrderEnterBtn = new Button("Enter:");
        CheckBox createRecipeCheckBox = new CheckBox("Create new Recipe");


        //Organizing all nodes into VBoxes

        VBox displayBox = new VBox(12,
                cakeDisplayBtn,
                orderDisplayBtn
        );

        VBox cakeSearchBox = new VBox(12,
                findCakeLabel,
                cakeSearchOptions,
                findCakeField,
                cakeSearchBtn
        );

        VBox orderSearchBox = new VBox(12,
                findOrderLabel,
                orderSearchOptions,
                findOrderField,
                orderSearchBtn
        );

        VBox orderFromRecipeBox = new VBox(12,
                orderFromRecipeLabel,
                recipeNameLabel,
                recipeNameField,
                deliveryDateLabel,
                deliveryDateField,
                deliveryLocationLabel,
                deliveryLocationField,
                orderEnterBtn
        );

        VBox orderCustomBox = new VBox(12,
                orderCustomLabel,
                customNameLabel,
                customNameField,
                batterLabel,
                batterField,
                frostingLabel,
                frostingField,
                toppingLabel,
                toppingField,
                deliveryDateLabelForCustom,
                deliveryDateFieldForCustom,
                deliveryLocationLabelForCustom,
                deliveryLocationFieldForCustom,
                createRecipeCheckBox,
                customOrderEnterBtn
        );

        VBox createOrderBox = new VBox(12,
                orderLabel,
                orderCreationComboBox,
                orderFromRecipeBox,
                orderCustomBox
        );

//        VBox root = new VBox(12);
//        root.setPadding(new Insets(16));
//        root.getChildren().addAll(
//                displayBox,
//                cakeSearchBox,
//                orderSearchBox,
//                displayLabel,
//                createOrderBox
//        );

        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        } catch(Exception e) {
            e.printStackTrace();
        }




        //Setting up the scene and stage

        Scene scene = new Scene(root,1500, 1200);
        stage.setTitle("Cake Bakery");
        stage.setScene(scene);
        stage.show();


    }
}
