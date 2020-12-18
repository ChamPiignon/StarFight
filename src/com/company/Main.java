package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {

    public ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/launchPage.fxml"));
            Parent root = loader.load();
            stage.setTitle(bundle.getString("GameTitle"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.getIcons().add(new Image("images/tux.png"));
            stage.show();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}