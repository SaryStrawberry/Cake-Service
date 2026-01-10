package com.cakeservice.app.controllers;

import com.cakeservice.app.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CreateController {

    public VBox createOptionsBox;
    public ComboBox<String> createOptions;

    public VBox createFromRecipeBox;
    public TextField recipeNameField;
    public TextField deliveryDateField;
    public TextField deliveryLocationField;

    public GridPane createCustomPane;
    public TextField customNameField;
    public ComboBox batterBox;
    public ComboBox frostingBox;
    public ComboBox toppingBox;
    public TextField deliveryDateFieldForCustom;
    public TextField deliveryLocationFieldForCustom;

    public Button returnBtn;
    

    public void initialize() {
        createFromRecipeBox.setVisible(false);
        createFromRecipeBox.setManaged(false);
        createCustomPane.setVisible(false);
        createCustomPane.setManaged(false);
    }

    public void selectCreateOption(ActionEvent actionEvent) {
        String selected = createOptions.getValue();

        if (selected == null) {return;}

        switch (selected) {
            case "Create an order from a recipe":
                createFromRecipeBox.setVisible(true);
                createFromRecipeBox.setManaged(true);
                createCustomPane.setVisible(false);
                createCustomPane.setManaged(false);
                break;
            case "Create a custom order":
                createFromRecipeBox.setVisible(false);
                createFromRecipeBox.setManaged(false);
                createCustomPane.setVisible(true);
                createCustomPane.setManaged(true);
                break;
            default:
                throw new RuntimeException();
        }
    }

    public void backToMainOnClick(MouseEvent mouseEvent) {
        SceneManager.switchScene("main-view.fxml", "Main");
    }
}
