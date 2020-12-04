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
import world.World;
import net.java.games.input.Controller;

import javax.swing.*;
import javax.imageio.IIOException;
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
    public void start(Stage stage) throws Exception {

        try {
            ManagerFighter mF= new ManagerFighter();
            Fighter ninja = new Fighter("Ninja");

            stage.setTitle("Test Sprite");

            World world = new World("images/background.gif");
            Pane root = FXMLLoader.load(getClass().getResource("/view/gamePage.fxml"));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

/*        GamePadCommand gamepad = new GamePadCommand();
        gamepad.gamePadInit();*/

    }


}