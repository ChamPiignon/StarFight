package controllers;

import character.Fighter;
import character.Player;
import character.Skin;
import character.StatMove;
import command.Input;
import command.KeyboardCommand;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import world.World;
import java.util.ResourceBundle;

public class GamePage {
    @FXML
    AnchorPane root;
    @FXML
    ImageView background;

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
    private static final double LIMIT_LEFT = -190;
    private static final double LIMIT_RIGHT = 685;
    private CheckerLimit checkerLimit;
    private final Stage stage;
    private World world;


    public GamePage(Stage stage, String player1Name, Fighter fighter1, String player2Name, Fighter fighter2, ResourceBundle bundle, KeyboardCommand p1Command, KeyboardCommand p2Command) throws Exception {
        this.stage = stage;
        world = new World("images/background.gif",player1Name, fighter1, player2Name, fighter2, bundle, p1Command, p2Command);
        checkerLimit = new CheckerLimit(LIMIT_LEFT,LIMIT_RIGHT);
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
                try {
                    updatePlayerPosition(world.player1,world.player2);
                    updatePlayerPosition(world.player2,world.player1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        gameThread.start();

    }

    /**
     *
     * @param skin
     * @param taille
     */
    private void scale(Skin skin, int taille) {
        skin.getImageView().setFitHeight(taille);
        skin.getImageView().setFitWidth(taille);
    }

    private void updatePlayerPosition(Player player1,Player player2) throws Exception {
        int deltaX = 0;

        if ( player1.getHisFighter().getStatMove() != StatMove.DEATH || player1.getHisFighter().getStatMove() == StatMove.IDLE || player1.getHisFighter().getStatMove() == StatMove.RUN || player1.getHisFighter().isFalling || player1.getHisFighter().isJumping) {

            if ((player1.getHisFighter().isJumping || player1.getHisFighter().isFalling ) || player1.getControl().isRequestingJump() && !player1.getControl().isRequestingPrimAtk() && !player1.getControl().isRequestingSndAtk()) {
                System.out.println("jump");
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.jump(player1.getHisFighter(), POS_Y_PLAYER_1);
            }

            if (player1.getControl().isRequestingLeft() && !checkerLimit.isLeftLimit(player1.getHisFighter().getSkin().getImageView().getX())) {
                System.out.println("left");
                deltaX -= SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveLeft(player1.getHisFighter(), deltaX);
            }

            if (player1.getControl().isRequestingRight() && !checkerLimit.isRightLimit(player1.getHisFighter().getSkin().getImageView().getX())) {
                System.out.println("right");
                deltaX += SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                world.getManagerFighter().move.moveRight(player1.getHisFighter(), deltaX);
            }

            if (player1.getControl().isRequestingPrimAtk()) {
                System.out.println("primAtk");
                world.getManagerFighter().fight.secondaryAttack(player1.getHisFighter(),player2.getHisFighter());
            }

            if (player1.getControl().isRequestingSndAtk()) {
                System.out.println("sndAtk");
                world.getManagerFighter().fight.primaryAttack(player1.getHisFighter(),player2.getHisFighter());
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

    private void initializePositionFight(Player player, int x, int y) {
        player.getHisFighter().getSkin().getImageView().setX(x);
        player.getHisFighter().getSkin().getImageView().setY(y);
    }

    private void initializeHealthBar(HealthBarController barHpPlayer,int x) {
        barHpPlayer.layoutXProperty().set(x);
    }

    private void initializeGame(){
        background.setImage(world.getMap());
        root.getChildren().addAll(world.player2.getHisFighter().getSkin(), world.player1.getHisFighter().getSkin(),world.barHpPlayer1,world.barHpPlayer2);
        scale(world.player1.getHisFighter().getSkin(), SIZE_FIGHTER);
        scale(world.player2.getHisFighter().getSkin(), SIZE_FIGHTER);
        initializePositionFight(world.player1, POS_X_PLAYER_1,POS_Y_PLAYER_1);
        initializePositionFight(world.player2, POS_X_PLAYER_2,POS_Y_PLAYER_2);
        initializeHealthBar(world.barHpPlayer1, LAYOUT_X_HP_BAR_1);
        initializeHealthBar(world.barHpPlayer2, LAYOUT_X_HP_BAR_2);
    }
}
