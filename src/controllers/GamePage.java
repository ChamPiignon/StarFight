package controllers;

import character.Player;
import character.Skin;
import character.StatMove;
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
    private static final int POS_X_PLAYER_1 = 0;
    private static final int POS_Y_PLAYER_1 = 485;
    private static final int POS_X_PLAYER_2 = 780;
    private static final int POS_Y_PLAYER_2 = 485;
    private static final int SPEED_INCREMENTATTION_POSITION_X = 6;
    private static final int SPEED_INCREMENTATTION_POSITION_Y = 4;
    private static final int SIZE_FIGHTER = 450;
    private final Stage stage;
    private World world;
    private Input input;

    public GamePage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() throws Exception {
        world = new World("images/background.gif");
        background.setImage(world.getMap());

        root.getChildren().addAll(world.player1.getHisFighter().getSkin(), world.player2.getHisFighter().getSkin());
        scale(world.player1.getHisFighter().getSkin(), SIZE_FIGHTER);
        scale(world.player2.getHisFighter().getSkin(), SIZE_FIGHTER);
        initializePositionFight(world.player1, world.player2);
        AnimationTimer gameThread = new AnimationTimer() {

            @Override
            public void handle(long gameTimer) {
                stage.getScene().setOnKeyPressed(Input::keyPressed);
                //moving player / attack player
                updatePlayerPosition(world.player1);
                updatePlayerPosition(world.player2);
                //collision player

                //heath actualisation
                stage.getScene().setOnKeyReleased(Input::keyReleased);
            }
        };

        gameThread.start();

    }

    private void scale(Skin skin, int taille)
    {
        skin.getImageView().setFitHeight(taille);
        skin.getImageView().setFitWidth(taille);
    }

    private void updatePlayerPosition(Player player) {
        int deltaX = 0;
        if (player.getHisFighter().getStatMove() == StatMove.IDLE || player.getHisFighter().getStatMove() == StatMove.RUN) {
            if (player.getControl().isRequestingJump()) {
                System.out.println("jump");
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.jump(player.getHisFighter());
            }

            if (player.getControl().isRequestingLeft()) {
                System.out.println("left");
                deltaX -= SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveLeft(player.getHisFighter(), deltaX);
            }

            if (player.getControl().isRequestingRight()) {
                System.out.println("right");
                deltaX += SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveRight(player.getHisFighter(), deltaX);
            }

            if (player.getControl().isRequestingPrimAtk()) {
                System.out.println("primAtk");
                world.getManagerFighter().fight.secondaryAttack(player.getHisFighter());//donner collision
            }

            if (player.getControl().isRequestingSndAtk()) {
                System.out.println("sndAtk");
                world.getManagerFighter().fight.primaryAttack(player.getHisFighter());//donner collision
            }

        }
//        System.out.println("noMove");
//        world.getManagerFighter().move.noMove(player.getHisFighter());
    }

    private void initializePositionFight(Player player1, Player player2)
    {
        player1.getHisFighter().getSkin().getImageView().setX(POS_X_PLAYER_1);
        player1.getHisFighter().getSkin().getImageView().setY(POS_Y_PLAYER_1);
        player2.getHisFighter().getSkin().getImageView().setX(POS_X_PLAYER_2);
        player2.getHisFighter().getSkin().getImageView().setY(POS_Y_PLAYER_2);
    }

}
