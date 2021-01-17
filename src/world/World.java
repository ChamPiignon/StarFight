package world;

import javafx.scene.image.Image;
import manager.ManagerFighter;

/**
 * The type World.
 */
public abstract class World {
    private final Image map;
    private ManagerFighter managerFighter;


    /**
     * Instantiates a new World.
     *
     * @param urlMap the url map
     */
    public World(String urlMap)
    {
        map = new Image(urlMap);
        managerFighter = new ManagerFighter();
    }

    /**
     * Gets manager fighter.
     *
     * @return the manager fighter
     */
    public ManagerFighter getManagerFighter() {
        return managerFighter;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public Image getMap() {
        return map;
    }
}
