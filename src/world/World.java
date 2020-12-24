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
    public Fighter ninja = new Fighter("Ninja");
    public Fighter samourai = new Fighter("samourai");
    public List<Player> listPlayers = new ArrayList<>();
    public Player player1, player2;
    public HealthBarController barHpPlayer1;
    public HealthBarController barHpPlayer2;

    public World(String urlMap) throws Exception {
        this.player1 = new Player(ninja, "Florent", 0, new KeyboardCommand(1));
        this.player2 = new Player(samourai, "Raphael", 0, new KeyboardCommand(2));
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
