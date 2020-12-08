package controllers;

import character.Fighter;
import character.SkinAnimation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.ManagerFighter;
import manager.StrategySkin;
import world.World;

public class GamePage
{
    private static final int MAX_WIDHT=960;
    private static final int MAX_Height=640;
    private final World world = new World("/images/background.gif");

    @FXML
    AnchorPane root;
    @FXML
    ImageView background;

    @FXML
    public void initialize()
    {
        background.setImage(world.getMap());
        root.getChildren().addAll(world.ninja.getSkin());

        AnimationTimer gamethread = new AnimationTimer() {

            @Override
            public void handle(long timeGame) {
                System.out.println(timeGame);
                //moving player

                //attack player

                //collision player

                //heath actualisation

            }
        };

        gamethread.start();

    }


}
