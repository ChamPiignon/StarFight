package character;

import command.Control;

public class Player
{
    private Fighter hisFighter;
    private String name;
    private int score;
    public boolean isJumping = false;
    public boolean isFalling = false;
    private final Control control;


    public Player(Fighter hisFighter, String name, int score, Control control)
    {
        this.hisFighter = hisFighter;
        this.name = name;
        this.score = score;
        this.control = control;
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

    public Control getControl() {
        return control;
    }
}
