package character;

import command.Control;

/**
 * The type Player.
 */
public class Player
{
    private Fighter hisFighter;
    private String name;
    private int score;
    private final Control control;


    /**
     * Instantiates a new Player.
     *
     * @param hisFighter the his fighter
     * @param name       the name
     * @param score      the score
     * @param control    the control
     */
    public Player(Fighter hisFighter, String name, int score, Control control)
    {
        this.hisFighter = hisFighter;
        this.name = name;
        this.score = score;
        this.control = control;
    }

    /**
     * Gets his fighter.
     *
     * @return the his fighter
     */
    public Fighter getHisFighter()
    {
        return hisFighter;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Sets his fighter.
     *
     * @param hisFighter the his fighter
     */
    public void setHisFighter(Fighter hisFighter)
    {
        this.hisFighter = hisFighter;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * Gets control.
     *
     * @return the control
     */
    public Control getControl() {
        return control;
    }
}
