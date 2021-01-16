package world;

import javafx.scene.image.Image;
import manager.ManagerFighter;

public abstract class World {
    private final Image map;
    private ManagerFighter managerFighter;


    public World(String urlMap)
    {
        map = new Image(urlMap);
        managerFighter = new ManagerFighter();
    }

    public ManagerFighter getManagerFighter() {
        return managerFighter;
    }
    public Image getMap() {
        return map;
    }
}
