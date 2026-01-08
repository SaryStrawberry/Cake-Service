package com.cakeservice.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//This class has the stage as its one attribute.
public class SceneManager {
    private static Stage stage;

    //This method stores a reference to the primaryStage to be used later by switchScene() to change to a different
    //page of the application
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    //This method creates a root node by loading a fxml file from resources with SceneManager's class loader. It then
    //creates and sets a new Scene using that root.
    public static void switchScene(String fxmlFile, String pageName) {
        try {
            Parent root = FXMLLoader.load(
                    SceneManager.class.getResource(fxmlFile)
            );
            stage.setTitle(pageName);
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
