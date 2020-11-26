package character;

import java.awt.Rectangle;

public abstract class Character
{
    private int xPosition;
    private int yPosition;
    private int hP;
    private String name;
    private Rectangle hitbox;

    public Character(int xPosition, int yPosition, int hP, String name, Rectangle hitbox)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.hP = hP;
        this.name = name;
        this.hitbox = hitbox;
    }

    public int getXPosition()
    {
        return xPosition;
    }

    public int getYPosition()
    {
        return yPosition;
    }

    public int getHP()
    {
        return hP;
    }

    public String getName()
    {
        return name;
    }

    public Rectangle getHitbox()
    {
        return hitbox;
    }

    public void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }

    public void setHP(int hP)
    {
        this.hP = hP;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHitbox(Rectangle hitbox)
    {
        this.hitbox = hitbox;
    }
}
