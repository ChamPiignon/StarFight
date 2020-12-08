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

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class World {
    public ImageView map;
    public Command command;
    //public ArrayList<Player> listJoueurs;
    public Fighter ninja = new Fighter("NiNja");
    public ManagerFighter managerFighter;


    public World(String urlMap)
    {
        this.map = new ImageView(urlMap);
    }


}
