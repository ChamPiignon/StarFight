package character;

import command.Control;
import manager.ManagerFighter;

public class Player
{
    private Fighter hisFighter;
    private String name;
    private int score;
    private final Control control;
    private ManagerFighter managerFighter;

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
            deltaY++;
            managerFighter.move.jump(hisFighter, deltaY);
            deltaY--;
        }

        if (control.isRequestingLeft()) {
            deltaX--;
            managerFighter.move.moveLeft(hisFighter, deltaX);
        }

        if (control.isRequestingRight()) {
            deltaX++;
            managerFighter.move.moveRight(hisFighter, deltaX);
        }

        if (control.isRequestingPrimAtk()) {
            System.out.println("primAtk");
            managerFighter.fight.primaryAttack(hisFighter);
        }

        if (control.isRequestingSndAtk()) {
            System.out.println("sndAtk");
            managerFighter.fight.secondaryAttack(hisFighter);
        }
    }
}
