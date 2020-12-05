package controllers;

import character.Fighter;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.ManagerFighter;
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

        Image img = new Image("/images/background.gif");
        background.setImage(img);
        root.getChildren().add(world.ninja.getSkin().imageView);
    }
    /*
    private static Scene scene;
    private Stage stage;

    @FXML
    private Pane root;

    ManagerFighter managerFighter = new ManagerFighter();
    Fighter fighter1;


    @FXML
    private void initialize()
    {
        scene = new Scene(root,MAX_WIDHT,MAX_Height);
        root.getChildren().addAll(fighter1.getSkin().imageView);
        stage.setScene(scene);
        stage.show();
    }
*/

}
