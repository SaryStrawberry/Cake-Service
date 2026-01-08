package com.cakeservice.app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override

    //This method opens the first page of the application, then the SceneManager class takes over and goes through the
    //JavaFX event loop
    public void start(Stage primaryStage) throws IOException {

        SceneManager.setStage(primaryStage);
        SceneManager.switchScene("main-view.fxml", "Main");
        primaryStage.show();

    //It calls the setStage() method to store the primaryStage in the SceneManager class.
    //It calls the switchScene() method which loads the main fxml file and sets it as the root.
    //It opens the application from that scene.
    }
}
