package com.company;

import command.GamePadCommand;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue", Locale.ENGLISH);
        System.out.println(bundle.getString("test"));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/chooseCharacter.fxml"));
        Parent root = loader.load();

        stage.setTitle("StarFight"); // text brute
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}