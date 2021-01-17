package controllers;

import character.Fighter;
import character.Player;
import character.Skin;
import character.StatMove;
import command.Input;
import command.KeyboardCommand;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import world.OneVersusOne;

import java.util.ResourceBundle;

/**
 * The type Game page.
 */
public class GamePage {
    /**
     * The Root.
     */
    @FXML
    AnchorPane root;
    /**
     * The Background.
     */
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
    private static final int WIDHT_HITBOX = 50;
    private static final int WIDHT_HITBOX_ATCK1 = 200;
    private static final int WIDHT_HITBOX_ATCK2 = 220;
    private static final int HEIGHT_HITBOX = 100;
    private static final int OFF_SET_HITBOX = 200;
    private static final int SPEED_INCREMENTATTION_POSITION_X = 6;
    private static final int SIZE_FIGHTER = 450;
    private static final double LIMIT_LEFT = -190;
    private static final double LIMIT_RIGHT = 685;
    private static final long TIME_THREAD = 14_000_000;
    private ResourceBundle bundle;
    private CheckerLimit checkerLimit;
    private final Stage stage;
    private OneVersusOne oneVersusOne;

    /**
     * Instantiates a new Game page.
     *
     * @param stage       the stage
     * @param player1Name the player 1 name
     * @param fighter1    the fighter 1
     * @param player2Name the player 2 name
     * @param fighter2    the fighter 2
     * @param p1Command   the p 1 command
     * @param p2Command   the p 2 command
     * @param bundle      the bundle
     * @throws Exception the exception
     */
    public GamePage(Stage stage, String player1Name, Fighter fighter1, String player2Name, Fighter fighter2,KeyboardCommand p1Command, KeyboardCommand p2Command,ResourceBundle bundle) throws Exception {
        this.stage = stage;
        oneVersusOne = new OneVersusOne("images/background.gif",player1Name, fighter1, player2Name, fighter2, p1Command, p2Command);
        checkerLimit = new CheckerLimit(LIMIT_LEFT,LIMIT_RIGHT);
        this.bundle=bundle;

    }

    /**
     * Initialize.
     */
    @FXML
    public void initialize(){
        initializeStage();
        initializeGame();
        AnimationTimer gameThread = new AnimationTimer() {
            private long now;
            @Override
            public void handle(long time) {

                if (TIME_THREAD < time - now) {
                    win(oneVersusOne.player1, oneVersusOne.player2,this);
                    stage.getScene().setOnKeyPressed(Input::keyPressed);
                    stage.getScene().setOnKeyReleased(Input::keyReleased);
                    updatePlayerPosition(oneVersusOne.player1, oneVersusOne.player2);
                    updatePlayerPosition(oneVersusOne.player2, oneVersusOne.player1);
                    now = time;
                }
            }
        };
        gameThread.start();

    }

    /**
     * scale player
     *
     * @param skin
     * @param taille
     */
    private void scale(Skin skin, int taille) {
        skin.getImageView().setFitHeight(taille);
        skin.getImageView().setFitWidth(taille);
    }

    /**
     * is Dead or not ?
     *
     * @param player
     * @return
     */
    private boolean isDead(Player player) {
        if(player.getHisFighter().getStatMove() == StatMove.DEATH) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param player1
     * @param player2
     * @param thread
     * @return
     */
    private boolean win(Player player1,Player player2,AnimationTimer thread) {
        if(isDead(player1)) {
            msgWin(player2,thread);
            return true;
        }
        else if (isDead(player2)) {
            msgWin(player1,thread);
            return true;
        }
        return false;
    }

    /**
     * Alert message for the winner Player
     *
     * @param player
     * @param thread
     */
    private void msgWin(Player player,AnimationTimer thread)
    {
        thread.stop();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(bundle.getString("msgWinTitle"));
        alert.setContentText(bundle.getString("msgWinText")+player.getName());
        alert.setHeaderText(null);
        alert.setOnHidden(evt -> stage.close());
        alert.show();
    }

    /**
     *
     * @param player1
     * @param player2
     */
    private void updatePlayerPosition(Player player1,Player player2){
        int deltaX = 0;

        if ( player1.getHisFighter().getStatMove() != StatMove.DEATH || player1.getHisFighter().getStatMove() == StatMove.IDLE || player1.getHisFighter().getStatMove() == StatMove.RUN || player1.getHisFighter().isFalling || player1.getHisFighter().isJumping) {

            if ((player1.getHisFighter().isJumping || player1.getHisFighter().isFalling ) || player1.getControl().isRequestingJump() && !player1.getControl().isRequestingPrimAtk() && !player1.getControl().isRequestingSndAtk()) {
                System.out.println("jump");
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                oneVersusOne.getManagerFighter().move.jump(player1.getHisFighter(), POS_Y_PLAYER_1);
            }

            if (player1.getControl().isRequestingLeft() && !checkerLimit.isLeftLimit(player1.getHisFighter().getSkin().getImageView().getX())) {
                System.out.println("left");
                deltaX -= SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                oneVersusOne.getManagerFighter().move.moveLeft(player1.getHisFighter(), deltaX);
            }

            if (player1.getControl().isRequestingRight() && !checkerLimit.isRightLimit(player1.getHisFighter().getSkin().getImageView().getX())) {
                System.out.println("right");
                deltaX += SPEED_INCREMENTATTION_POSITION_X;
                System.out.println(player1.getHisFighter().getSkin().getImageView().getX() + " " + player1.getHisFighter().getSkin().getImageView().getY());
                oneVersusOne.getManagerFighter().move.moveRight(player1.getHisFighter(), deltaX);
            }

            if (player1.getControl().isRequestingPrimAtk()) {
                System.out.println("primAtk");
                player1.getHisFighter().getHitbox().setWidth(WIDHT_HITBOX_ATCK1);
                oneVersusOne.getManagerFighter().fight.secondaryAttack(player1.getHisFighter(),player2.getHisFighter());
                player1.getHisFighter().getHitbox().setWidth(WIDHT_HITBOX);

            }

            if (player1.getControl().isRequestingSndAtk()) {
                System.out.println("sndAtk");
                player1.getHisFighter().getHitbox().setWidth(WIDHT_HITBOX_ATCK2);
                oneVersusOne.getManagerFighter().fight.primaryAttack(player1.getHisFighter(),player2.getHisFighter());
                player1.getHisFighter().getHitbox().setWidth(WIDHT_HITBOX);

            }

        }
    }

    /**
     * initialize the stage
     */
    private void initializeStage()
    {
        stage.setWidth(STAGE_MAX_WIDHT);
        stage.setHeight(STAGE_MAX_HEIGHT);
        stage.setResizable(false);
    }

    /**
     * Initilize position
     *
     * @param player
     * @param x
     * @param y
     */
    private void initializePositionFight(Player player, int x, int y) {
        player.getHisFighter().getSkin().getImageView().setX(x);
        player.getHisFighter().getSkin().getImageView().setY(y);
    }

    /**
     *
     * @param player
     */
    private void initializeHitBox(Player player)
    {
        Rectangle hitBox = new Rectangle();
        hitBox.xProperty().bind(player.getHisFighter().getSkin().getImageView().xProperty().add(OFF_SET_HITBOX));
        hitBox.yProperty().bind(player.getHisFighter().getSkin().getImageView().yProperty().add(OFF_SET_HITBOX));
        hitBox.setWidth(WIDHT_HITBOX);
        hitBox.setHeight(HEIGHT_HITBOX);
        hitBox.setFill(Color.TRANSPARENT);
        hitBox.setStroke(Color.RED);
        player.getHisFighter().setHitbox(hitBox);
    }

    /**
     * initialize healthbar
     *
     * @param barHpPlayer
     * @param x
     */
    private void initializeHealthBar(HealthBarController barHpPlayer,int x) {
        barHpPlayer.layoutXProperty().set(x);
    }

    /**
     * initilize the game
     *
     */
    private void initializeGame(){
        background.setImage(oneVersusOne.getMap());
        scale(oneVersusOne.player1.getHisFighter().getSkin(), SIZE_FIGHTER);
        scale(oneVersusOne.player2.getHisFighter().getSkin(), SIZE_FIGHTER);
        initializeHitBox(oneVersusOne.player1);
        initializeHitBox(oneVersusOne.player2);
        initializePositionFight(oneVersusOne.player1, POS_X_PLAYER_1,POS_Y_PLAYER_1);
        initializePositionFight(oneVersusOne.player2, POS_X_PLAYER_2,POS_Y_PLAYER_2);
        initializeHealthBar(oneVersusOne.barHpPlayer1, LAYOUT_X_HP_BAR_1);
        initializeHealthBar(oneVersusOne.barHpPlayer2, LAYOUT_X_HP_BAR_2);
        root.getChildren().addAll(oneVersusOne.player2.getHisFighter().getSkin(), oneVersusOne.player1.getHisFighter().getSkin(), oneVersusOne.barHpPlayer1, oneVersusOne.barHpPlayer2);
    }
}
