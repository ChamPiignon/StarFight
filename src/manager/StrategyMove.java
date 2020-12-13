package manager;

import character.Fighter;
import character.Position;
import javafx.util.Duration;


public class StrategyMove {
    private final Duration TIMER_JUMP=Duration.millis(10000);
    private static StrategySkin skin =new StrategySkin();

    public void jump(Fighter fighter, int deltaY) {
//        if (deltaY != 1) {
//            return;
//        }
        int jumpHeight = 5;
        //tant que le saut monte
        skin.jump(fighter);
        for (int i = 0; i <= jumpHeight; i++)
            fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY()-i);;

        //tant que le saut descend
        skin.fall(fighter);
        for (int i = jumpHeight; i >= 0; i--) {
            fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY()+i);;
        }
    }

    public void moveLeft(Fighter fighter, int deltaX) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        if(fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX()+deltaX);
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    public void moveRight(Fighter fighter, int deltaX) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        if(fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX()+deltaX);
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    public void noMove(Fighter fighter) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        if(fighter.getStatMove() != StatMove.IDLE) {
            skin.idle(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX());
    }
}
