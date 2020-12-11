package world;

import character.Fighter;
import character.Player;
import command.Command;
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

public class World {
    private final Image map;
    public Fighter ninja = new Fighter("Ninja");
    private ManagerFighter managerFighter;
    public StrategySkin sS;


    public World(String urlMap)
    {
        this.map = new Image(urlMap);
        ninja.getSkin().skinAnimation.play();
    }

    public Image getMap() {
        return map;
    }
}
