package world;

import character.Fighter;
import character.Player;
import command.KeyboardCommand;
import controllers.HealthBarController;
import javafx.scene.image.Image;
import manager.ManagerFighter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class OneVersusOne extends World{
    public List<Player> listPlayers = new ArrayList<>();
    public Player player1, player2;
    public HealthBarController barHpPlayer1;
    public HealthBarController barHpPlayer2;

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
