package world;

import character.Fighter;
import character.Player;
import command.KeyboardCommand;
import controllers.HealthBarController;

import java.util.ArrayList;
import java.util.List;


/**
 * The type One versus one.
 */
public class OneVersusOne extends World{
    /**
     * The List players.
     */
    public List<Player> listPlayers = new ArrayList<>();
    /**
     * The Player 1.
     */
    public Player player1, /**
     * The Player 2.
     */
    player2;
    /**
     * The Bar hp player 1.
     */
    public HealthBarController barHpPlayer1;
    /**
     * The Bar hp player 2.
     */
    public HealthBarController barHpPlayer2;

    /**
     * Instantiates a new One versus one mode game.
     *
     * @param urlMap      the url map
     * @param player1Name the player 1 name
     * @param fighter1    the fighter 1
     * @param player2Name the player 2 name
     * @param fighter2    the fighter 2
     * @param p1Command   the p 1 command
     * @param p2Command   the p 2 command
     * @throws Exception the exception
     */
    public OneVersusOne(String urlMap, String player1Name, Fighter fighter1, String player2Name, Fighter fighter2,KeyboardCommand p1Command, KeyboardCommand p2Command) throws Exception {
        super(urlMap);
        this.player1 = new Player(fighter1, player1Name, 0, p1Command);
        this.player2 = new Player(fighter2, player2Name, 0, p2Command);
        listPlayers.add(this.player1);
        listPlayers.add(this.player2);
        this.player1.getHisFighter().getSkin().skinAnimation.play();
        this.player2.getHisFighter().getSkin().skinAnimation.play();


        barHpPlayer1 = new HealthBarController(player1);
        barHpPlayer2 = new HealthBarController(player2);
    }
}
