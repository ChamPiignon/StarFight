package character;

import java.awt.Rectangle;

public class Fighter extends Character
{
    private Skin skin;

    public Fighter(int xPosition, int yPosition, int hP, String name, Rectangle hitbox, Skin skin) {
        super(xPosition, yPosition, hP, name, hitbox);
        this.skin = skin;
    }
}
