package manager;

import character.Fighter;
import character.StatMove;
import javafx.animation.AnimationTimer;


public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;
    private final double maxY = 40.0;


    public void jump(Fighter fighter, int yOrigin) {        

        if (!fighter.isFalling) {
            fighter.isJumping = true;
            skin.jump(fighter);
        }

        fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + fighter.gravity);
        fighter.gravity += 1;

        if ((fighter.isJumping && fighter.getSkin().getImageView().getY() <= maxY) || (fighter.gravity == jumpSize && fighter.isJumping)) {
            skin.fall(fighter);
            fighter.isJumping = false;
            fighter.isFalling = true;
        }

        if (fighter.isFalling && yOrigin <= fighter.getSkin().getImageView().getY()) {
            fighter.isFalling = false;
            fighter.gravity = 0;
            fighter.getSkin().getImageView().setY(yOrigin);
            skin.idle(fighter);
        }

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
        skin.mirror(fighter, -1);
        canRun(fighter);
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        if (!fighter.isJumping || !fighter.isFalling) {
            fighter.getSkin().skinAnimation.setOnFinished(event -> {
                skin.idle(fighter);
            });
        }
    }

    public void moveRight(Fighter fighter, int deltaX) {
        skin.mirror(fighter, 1);
        canRun(fighter);
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        if (!fighter.isJumping || !fighter.isFalling) {
            fighter.getSkin().skinAnimation.setOnFinished(event -> {
                skin.idle(fighter);
            });
        }
    }

    private void canRun(Fighter fighter) {
        if (fighter.getStatMove() != StatMove.RUN && (!fighter.isJumping || !fighter.isFalling)) {
            skin.run(fighter);
        }
    }

    public void noMove(Fighter fighter) {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        if (fighter.getStatMove() != StatMove.IDLE) {
            skin.idle(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX());
    }
}
