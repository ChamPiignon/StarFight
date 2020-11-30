package character;

import java.awt.Rectangle;

public abstract class Character
{

    private int hP;
    private String name;

    public Character(int hP, String name)
    {
        this.hP = hP;
        this.name = name;
    }



    public int getHP()
    {
        return hP;
    }
    public String getName()
    {
        return name;
    }
    public void setHP(int hP)
    {
        this.hP = hP;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}
