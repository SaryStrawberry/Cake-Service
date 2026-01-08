package com.cakeservice.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FindController {
    @FXML
    public VBox findBox;
    public Label findLabel;
    public ComboBox<String> searchOptions;

    public VBox findCakeBox;
    public Label findCakeLabel;
    public ComboBox<String> cakeSearchOptions;
    public TextField findCakeField;
    public Button cakeSearchBtn;

    public VBox findOrderBox;
    public Label findOrderLabel;
    public ComboBox<String> orderSearchOptions;
    public TextField findOrderField;
    public Button orderSearchBtn;

    public Button returnBtn;


    //Initial state of page
    public void initialize() {
        findCakeBox.setVisible(false);
        findCakeBox.setManaged(false);
        findOrderBox.setVisible(false);
        findOrderBox.setManaged(false);
    }

    public void selectSearchOption(ActionEvent event) {
        String selected = searchOptions.getValue();

        if (selected == null) {return;}

        switch (selected) {
            case "Find a cake":
                findCakeBox.setVisible(true);
                findCakeBox.setManaged(true);
                findOrderBox.setVisible(false);
                findOrderBox.setManaged(false);
                break;
            case "Find an order":
                findCakeBox.setVisible(false);
                findCakeBox.setManaged(false);
                findOrderBox.setVisible(true);
                findOrderBox.setManaged(true);
                break;
            default:
                throw new RuntimeException();
        }

    }
}
