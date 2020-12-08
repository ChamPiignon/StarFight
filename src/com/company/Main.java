package com.company;

import character.Fighter;
import command.GamePadCommand;
import controllers.GamePage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.ManagerFighter;
import world.World;

import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");
        launch(args);
    }

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/gamePage.fxml"));
            Parent root = loader.load();
            stage.setTitle("StarFight"); // text brute
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }


}