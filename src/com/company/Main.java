package com.company;

import character.Fighter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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