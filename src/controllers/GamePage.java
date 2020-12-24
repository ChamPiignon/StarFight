package controllers;

import character.Player;
import character.Skin;
import character.StatMove;
import command.Input;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import world.World;

import java.io.IOException;

public class GamePage {
    @FXML
    AnchorPane root;
    @FXML
    ImageView background;

    @FXML
    VBox h1,h2;

    private static final int STAGE_MAX_WIDHT = 960;
    private static final int STAGE_MAX_HEIGHT = 640;
    private static final int LAYOUT_X_HP_BAR_1 = 40;
    private static final int LAYOUT_X_HP_BAR_2 = 640;
    private static final int POS_X_PLAYER_1 = -168;
    private static final int POS_Y_PLAYER_1 = 300;
    private static final int POS_X_PLAYER_2 = 648;
    private static final int POS_Y_PLAYER_2 = 300;
    private static final int SPEED_INCREMENTATTION_POSITION_X = 6;
    private static final int SIZE_FIGHTER = 450;
    private final double maxY = 275.0;
    private final Stage stage;
    private World world;

    public GamePage(Stage stage, String player1Name, String player1Character, String player2Name, String player2Character) throws Exception {
        this.stage = stage;
        world = new World("images/background.gif",player1Name, player1Character, player2Name, player2Character);
    }

    @FXML
    public void initialize(){
        initializeStage();
        initializeGame();
        AnimationTimer gameThread = new AnimationTimer() {
            @Override
            public void handle(long gameTimer) {
                stage.getScene().setOnKeyPressed(Input::keyPressed);
                stage.getScene().setOnKeyReleased(Input::keyReleased);
                //moving player / attack player
                try {
                    updatePlayerPosition(world.player1);
                    updatePlayerPosition(world.player2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //collision player
                //heath actualisation
                if(world.player1.getHisFighter().getCurrentHP().get()!=0)
                    world.player1.getHisFighter().getCurrentHP().set(world.player1.getHisFighter().getCurrentHP().get()-1);
            }
        };

        gameThread.start();

    }

    private void scale(Skin skin, int taille) {
        skin.getImageView().setFitHeight(taille);
        skin.getImageView().setFitWidth(taille);
    }

    private void updatePlayerPosition(Player player) throws Exception {
        int deltaX = 0;

        if (player.getControl().isRequestingDown()) {
            world.getManagerFighter().move.moveDown(player.getHisFighter(), POS_Y_PLAYER_1);
        }

        if (player.getHisFighter().getStatMove() == StatMove.IDLE || player.getHisFighter().getStatMove() == StatMove.RUN || player.isFalling || player.isJumping) {

            if ((player.isJumping || player.isFalling ) || player.getControl().isRequestingJump() && !player.getControl().isRequestingPrimAtk() && !player.getControl().isRequestingSndAtk()) {
                System.out.println("jump");
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.jump(player, POS_Y_PLAYER_1);
            }

            if (player.getControl().isRequestingLeft()) {
                System.out.println("left");
                deltaX -= SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveLeft(player, deltaX);
            }

            if (player.getControl().isRequestingRight()) {
                System.out.println("right");
                deltaX += SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player.getHisFighter().getSkin().getImageView().getX() + " " + player.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveRight(player, deltaX);
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
    }

//    private Parent initialiseHealthBar(HealthBarController barHpPlayer) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/view/healthBar.fxml"));
//        loader.setController(barHpPlayer);
//        Parent Health= loader.load();
//        return Health;
//    }
    private void initializeStage()
    {
        stage.setWidth(STAGE_MAX_WIDHT);
        stage.setHeight(STAGE_MAX_HEIGHT);
        stage.setResizable(false);
    }

    private void initializePositionFight(Player player1, Player player2) {
        player1.getHisFighter().getSkin().getImageView().setX(POS_X_PLAYER_1);
        player1.getHisFighter().getSkin().getImageView().setY(POS_Y_PLAYER_1);
        player2.getHisFighter().getSkin().getImageView().setX(POS_X_PLAYER_2);
        player2.getHisFighter().getSkin().getImageView().setY(POS_Y_PLAYER_2);
    }

    private void initializeHealthBar(HealthBarController barHpPlayer1,HealthBarController barHpPlayer2) {
        barHpPlayer1.layoutXProperty().set(LAYOUT_X_HP_BAR_1);
        barHpPlayer2.layoutXProperty().set(LAYOUT_X_HP_BAR_2);
    }

    private void initializeGame(){
        background.setImage(world.getMap());
        root.getChildren().addAll(world.player2.getHisFighter().getSkin(), world.player1.getHisFighter().getSkin(),world.barHpPlayer1,world.barHpPlayer2);
        scale(world.player1.getHisFighter().getSkin(), SIZE_FIGHTER);
        scale(world.player2.getHisFighter().getSkin(), SIZE_FIGHTER);
        initializePositionFight(world.player1, world.player2);
        initializeHealthBar(world.barHpPlayer1, world.barHpPlayer2);
    }
}
