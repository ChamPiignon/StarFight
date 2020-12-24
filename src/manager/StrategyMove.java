package manager;

import character.Fighter;
import character.Player;
import character.StatMove;
import javafx.animation.AnimationTimer;


public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;
    private final double maxY = 275.0;
    int jumpStrength = 100;

    public void jump(Player player, int deltaX, int yOrigin) {
        Fighter fighter = player.getHisFighter();
        if (!player.isFalling){
            player.isJumping = true;
        }

        skin.jump(fighter);
        if (deltaX != 0) {
            fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        }
        AnimationTimer jumpTimer = new AnimationTimer() {
//            final double oldY = fighter.getSkin().getImageView().getY();
            int gravity = 0;

            @Override
            public void handle(long now) {
                System.out.println(fighter.getSkin().getImageView().getX() + " " + fighter.getSkin().getImageView().getY());

                fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + gravity);
                gravity += 1;

                if (gravity == jumpSize) {
                    skin.fall(fighter);
                    player.isJumping = false;
                    player.isFalling = true;
                }
                if (yOrigin <= fighter.getSkin().getImageView().getY()) {
                    player.isFalling = false;
                    player.isJumping = false;
                    gravity = 0;
                    fighter.getSkin().getImageView().setY(yOrigin);
                    skin.idle(fighter);
                    this.stop();
                }
            }
        };
        jumpTimer.start();

//            skin.jump(fighter);
//            fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize );
//            jumpStrength -= 1;
//            if(fighter.getSkin().getImageView().getY()>= yOrigin+jumpSize)
//            {
//                skin.fall(fighter);
//                jumpStrength=100;
//            }


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
        skin.mirror(fighter,-1);
        if (fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        fighter.getSkin().skinAnimation.setOnFinished(event -> {
            skin.idle(fighter);
        });
    }

    public void moveRight(Fighter fighter, int deltaX) {
        skin.mirror(fighter,1);
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
