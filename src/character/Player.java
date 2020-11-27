package character;

public class Player
{
    private Fighter hisFighter;
    private String name;
    private int score;

    public Player(Fighter hisFighter, String name, int score)
    {
        this.hisFighter = hisFighter;
        this.name = name;
        this.score = score;
    }

    public Fighter getHisFighter()
    {
        return hisFighter;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public void setHisFighter(Fighter hisFighter)
    {
        this.hisFighter = hisFighter;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
