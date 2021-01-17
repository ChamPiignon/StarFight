package manager;

import character.Fighter;
import character.StatMove;


/**
 * The type Strategy move.
 */
public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;
    private final double maxY = 40.0;

    /**
     * Jump.
     *
     * @param fighter the fighter
     * @param yOrigin the y origin
     */
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

    /**
     * Move left.
     *
     * @param fighter the fighter
     * @param deltaX  the delta x
     */
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

    /**
     * Move right.
     *
     * @param fighter the fighter
     * @param deltaX  the delta x
     */
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

    /**
     *
     * @param fighter
     */
    private void canRun(Fighter fighter) {
        if (fighter.getStatMove() != StatMove.RUN && (!fighter.isJumping && !fighter.isFalling)) {
            skin.run(fighter);
        }
    }

    /**
     * No move.
     *
     * @param fighter the fighter
     */
    public void noMove(Fighter fighter) {
        if (fighter.getStatMove() != StatMove.IDLE) {
            skin.idle(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX());
    }
}
