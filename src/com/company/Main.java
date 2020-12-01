package com.company;

import character.Fighter;
import character.Skin;
import command.GamePadCommand;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import manager.ManagerFighter;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue", Locale.ENGLISH);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        try {
            ManagerFighter mF= new ManagerFighter();
            Fighter ninja = new Fighter("Ninja");
            mF.st.fall(ninja);

            stage.setTitle("Test Sprite");
            stage.setScene(new Scene(new Group(ninja.getSkin().imageView)));
            stage.show();

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}