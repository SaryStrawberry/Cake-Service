package com.cakeservice.app.controllers;

import com.cakeservice.app.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {
    public Button cakeDisplayBtn;
    public Button orderDisplayBtn;
    public Label displayLabel;
    public Button findBtn;
    public Button createBtn;
    public Button returnBtn;

    public void goToFindPageOnClick(MouseEvent mouseEvent) {
        SceneManager.switchScene("find-view.fxml", "Find cake or order");
    }
}
