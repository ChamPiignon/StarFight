package world;

import character.Fighter;
import character.Player;
import command.Command;
import command.Input;
import command.KeyboardCommand;
import controllers.GamePage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.ManagerFighter;
import manager.StrategySkin;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class World {
    private final Image map;
    public Fighter ninja = new Fighter("Ninja");

    private final String name= "test";
    public List<Player> listPlayers = new ArrayList<>();
    private final Input input = new Input();
    public Player player= new Player(ninja,name,0,new KeyboardCommand(input));

    private ManagerFighter managerFighter;
    public StrategySkin sS;


    public World(String urlMap)
    {
        listPlayers.add(player);
        this.map = new Image(urlMap);
//        ninja.getSkin().skinAnimation.play();
        player.getHisFighter().getSkin().skinAnimation.play();
    }

    public Image getMap() {
        return map;
    }

    public void update(){
        listPlayers.forEach(listPlayers -> player.update());
    }
}
