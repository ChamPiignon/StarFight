package controllers;

import character.Fighter;
import character.SkinAnimation;
import com.sun.javafx.css.StyleCache;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.ManagerFighter;
import manager.StrategySkin;
import world.World;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

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
//        root.getChildren().addAll(world.ninja.getSkin());
        root.getChildren().addAll(world.player.getHisFighter().getSkin());

        AnimationTimer gameThread = new AnimationTimer() {

            @Override
            public void handle(long Gametimer) {
                //moving player
                // c'est ici pour update les mouvement ???
                world.update();

                //attack player

                //collision player

                //heath actualisation
            }
        };

        gameThread.start();

    }

    @FXML
    public void handleKeyPressed(KeyEvent key) {
        switch (key.getCode()) {
            case Z:
                world.sS.jump(world.ninja);
                System.out.println("jump");
                break;
            case D:
                world.sS.run(world.ninja);
                System.out.println("Run");
                break;
        }


    }
}
