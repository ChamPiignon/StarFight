package manager;

import character.Fighter;
import character.StatMove;
import javafx.animation.AnimationTimer;


public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;
    private final double maxY = 275.0;

    public void jump(Fighter fighter, int deltaX, int yOrigin) {

        skin.jump(fighter);
        if (deltaX != 0) {
            fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        }
        AnimationTimer jumpTimer = new AnimationTimer() {
            final double oldY = fighter.getSkin().getImageView().getY();
            int gravity = 0;

            @Override
            public void handle(long now) {
                fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + gravity);
                gravity += 1;
                System.out.println(fighter.getSkin().getImageView().getX() + " " + fighter.getSkin().getImageView().getY());

                // try to reset the Y position of a fighter if Y < yOrigin - maxY
                if (fighter.getSkin().getImageView().getY() < yOrigin - maxY) {
                    fighter.getSkin().getImageView().setY(yOrigin);
                }
                if (gravity == jumpSize) {
                    skin.fall(fighter);
                }
                if (oldY <= fighter.getSkin().getImageView().getY()) {
                    skin.idle(fighter);
                    gravity = 0;
                    fighter.getSkin().getImageView().setY(oldY);
                    this.stop();
                }
            }
        };
        jumpTimer.start();
    }

    public void moveDown(Fighter fighter, int yOrigin) {
        skin.fall(fighter);
        AnimationTimer fallTimer = new AnimationTimer() {
            int gravity = 0;

            @Override
            public void handle(long now) {
                fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() + gravity);
                gravity += 1;
                System.out.println(fighter.getSkin().getImageView().getX() + " " + fighter.getSkin().getImageView().getY());

                if (yOrigin <= fighter.getSkin().getImageView().getY()) {
                    skin.idle(fighter);
                    gravity = 0;
                    fighter.getSkin().getImageView().setY(yOrigin);
                    this.stop();
                }
            }
        };
        fallTimer.start();
    }

    public void moveLeft(Fighter fighter, int deltaX) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        if (fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        fighter.getSkin().skinAnimation.setOnFinished(event -> {
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
