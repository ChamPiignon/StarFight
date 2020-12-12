package character;

import command.Control;

public class Player
{
    private Fighter hisFighter;
    private String name;
    private int score;
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

    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(control.isRequestingUp()) {
            System.out.println("up");
            deltaY--;
        }

        if(control.isRequestingDown()) {
            System.out.println("down");
            deltaY++;
        }

        if (control.isRequestingLeft()) {
            System.out.println("left");
            deltaX--;
        }

        if (control.isRequestingRight()) {
            System.out.println("right");
            deltaX++;
        }

        if (control.isRequestingPrimAtk()) {
            System.out.println("primAtk");
        }

        hisFighter.getSkin().setPosition(new Position(hisFighter.getSkin().getPosition().getX() + deltaX, hisFighter.getSkin().getPosition().getY() + deltaY));
    }
}
