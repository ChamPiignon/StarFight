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


public class World {
    private final Image map;
    private ManagerFighter managerFighter = new ManagerFighter();
    private ResourceBundle bundle;
    public List<Player> listPlayers = new ArrayList<>();
    public Player player1, player2;
    public HealthBarController barHpPlayer1;
    public HealthBarController barHpPlayer2;

    /**
     *
     * @param urlMap
     * @param player1Name
     * @param player1Character
     * @param player2Name
     * @param player2Character
     * @param bundle
     * @throws Exception
     */
    public World(String urlMap, String player1Name, String player1Character, String player2Name, String player2Character, ResourceBundle bundle, KeyboardCommand p1Command, KeyboardCommand p2Command) throws Exception {
        this.player1 = new Player(new Fighter(player1Character), player1Name, 0, p1Command);
        this.player2 = new Player(new Fighter(player2Character), player2Name, 0, p2Command);
        listPlayers.add(this.player1);
        listPlayers.add(this.player2);
        this.map = new Image(urlMap);
        this.player1.getHisFighter().getSkin().skinAnimation.play();
        this.player2.getHisFighter().getSkin().skinAnimation.play();

        this.bundle = bundle;

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
