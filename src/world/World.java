package world;

import character.Fighter;
import character.Player;
import command.KeyboardCommand;
import controllers.HealthBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import manager.ManagerFighter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class World {
    private final Image map;
    private ManagerFighter managerFighter = new ManagerFighter();
    public List<Player> listPlayers = new ArrayList<>();
    public Player player1, player2;
    public HealthBarController barHpPlayer1;
    public HealthBarController barHpPlayer2;

    public World(String urlMap, String player1Name, String player1Character, String player2Name, String player2Character) throws Exception {
        this.player1 = new Player(new Fighter(player1Character), player1Name, 0, new KeyboardCommand(1));
        this.player2 = new Player(new Fighter(player2Character), player2Name, 0, new KeyboardCommand(2));
        listPlayers.add(this.player1);
        listPlayers.add(this.player2);
        this.map = new Image(urlMap);
        this.player1.getHisFighter().getSkin().skinAnimation.play();
        this.player2.getHisFighter().getSkin().skinAnimation.play();

        barHpPlayer1 = new HealthBarController(player1);
        barHpPlayer2 = new HealthBarController(player2);
    }
    public ManagerFighter getManagerFighter() {
        return managerFighter;
    }

    public Image getMap() {
        return map;
    }

}
