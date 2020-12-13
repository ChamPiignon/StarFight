package manager;

import character.Fighter;
import character.Position;
import javafx.util.Duration;


public class StrategyMove {
    private final Duration TIMER_JUMP=Duration.millis(10000);
    private static StrategySkin skin;

    public void jump(Fighter fighter, int deltaY) {
        if (deltaY != 1) {
            return;
        }
        int jumpHeight = 50;
        //tant que le saut monte
        skin.jump(fighter);
        for (int i = 0; i <= jumpHeight; i++)
            fighter.getSkin().setPosition(new Position(fighter.getSkin().getPosition().getX(), fighter.getSkin().getPosition().getY() + i));

        //tant que le saut descend
        skin.fall(fighter);
        for (int i = jumpHeight; i >= 0; i--) {
            fighter.getSkin().setPosition(new Position(fighter.getSkin().getPosition().getX(), fighter.getSkin().getPosition().getY() - i));
        }

        //quand il touche le sol
        skin.idle(fighter);
    }

    public void moveLeft(Fighter fighter, int deltaX) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        fighter.getSkin().setPosition(new Position(fighter.getSkin().getPosition().getX() - deltaX, fighter.getSkin().getPosition().getY()));
    }

    public void moveRight(Fighter fighter, int deltaX) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        fighter.getSkin().setPosition(new Position(fighter.getSkin().getPosition().getX() + deltaX, fighter.getSkin().getPosition().getY()));
    }
}
