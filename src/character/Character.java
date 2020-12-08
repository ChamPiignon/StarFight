package character;

public abstract class Character
{

    private int hP;
    private String name;

    public Character(int hP, String name)
    {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
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
