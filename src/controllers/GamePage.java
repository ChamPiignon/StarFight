package controllers;

import command.Input;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import world.World;

public class GamePage {
    @FXML
    AnchorPane root;
    @FXML
    ImageView background;

    private static final int MAX_WIDHT = 960;
    private static final int MAX_Height = 640;
    private final Stage stage;
    private World world;
    private Input input;

    public GamePage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        input = new Input();
        world = new World("images/background.gif", input);
        background.setImage(world.getMap());
        root.getChildren().addAll(world.player.getHisFighter().getSkin());

        AnimationTimer gameThread = new AnimationTimer() {

            @Override
            public void handle(long Gametimer) {
                stage.getScene().setOnKeyPressed(Input::keyPressed);
                stage.getScene().setOnKeyReleased(Input::keyReleased);
                //moving player
                world.update();
                //attack player

                //collision player

                //heath actualisation
            }
        };

        gameThread.start();

    }

}
