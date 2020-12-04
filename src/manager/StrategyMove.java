package manager;

import character.Fighter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.util.Duration;


public class StrategyMove {
    private final Duration TIMER_JUMP=Duration.millis(10000);
    private static StrategySkin skin;

    public void jump(Fighter fighter)
    {

        //tant que le saut monte
        skin.jump(fighter);
        //fighter.setYPosition();

        //tant que le saut descend
        skin.fall(fighter);
        //fighter.setYPosition();

        //quand il touche le sol
        skin.idle(fighter);
    }

    public void moveLeft(Fighter fighter)
    {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        //fighter.setXPosition();
    }

    public void moveRight(Fighter fighter)
    {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        //fighter.setXPosition();
    }

    public void CharacterEventOnKeyPressed(Fighter fighter,KeyEvent keyEvent) {
        switch (keyEvent.getCode())
        {
            case Q:
                moveLeft(fighter);
                break;
            case D:
                moveRight(fighter);
                break;
            case Z:
                jump(fighter);
                break;
        }
    }

}
