package world;

import character.Fighter;
import character.Player;
import command.Input;
import command.KeyboardCommand;
import javafx.scene.image.Image;
import manager.ManagerFighter;

import java.util.ArrayList;
import java.util.List;


public class World {
    private final Image map;
    public Fighter ninja = new Fighter("Ninja");

    private final String name = "test";
    public List<Player> listPlayers = new ArrayList<>();
    public Player player;

    private ManagerFighter managerFighter;


    public World(String urlMap, Input input) {
        this.player = new Player(ninja, name, 0, new KeyboardCommand(input));
        listPlayers.add(this.player);
        this.map = new Image(urlMap);
        this.player.getHisFighter().getSkin().skinAnimation.play();
    }

    public Image getMap() {
        return map;
    }

    public void update() {
        listPlayers.forEach(listPlayers -> player.update());
    }
}
