package manager;

import character.Fighter;
import character.Player;
import character.StatMove;
import javafx.animation.AnimationTimer;
import javafx.scene.transform.Translate;


public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;
    private final double maxY = 40.0;
    int jumpStrength = 100;


    public void jump(Player player, int yOrigin) {
        Fighter fighter = player.getHisFighter();

        if (!player.isFalling) {
            player.isJumping = true;
            skin.jump(fighter);
        }

        fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + player.gravity);
        player.gravity += 1;

        if ((player.isJumping && fighter.getSkin().getImageView().getY() <= maxY) || (player.gravity == jumpSize && player.isJumping)) {
            skin.fall(fighter);
            player.isJumping = false;
            player.isFalling = true;
        }

        if (player.isFalling && yOrigin <= fighter.getSkin().getImageView().getY()) {
            player.isFalling = false;
            player.gravity = 0;
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

    public void moveLeft(Player player, int deltaX) {
        Fighter fighter = player.getHisFighter();
        skin.mirror(fighter, -1);
        canRun(player);
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        if (!player.isJumping || !player.isFalling) {
            fighter.getSkin().skinAnimation.setOnFinished(event -> {
                skin.idle(fighter);
            });
        }
    }

    public void moveRight(Player player, int deltaX) {
        Fighter fighter = player.getHisFighter();
        skin.mirror(fighter, 1);
        canRun(player);
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX() + deltaX);
        if (!player.isJumping || !player.isFalling) {
            fighter.getSkin().skinAnimation.setOnFinished(event -> {
                skin.idle(fighter);
            });
        }
    }

    private void canRun(Player player) {
        if (player.getHisFighter().getStatMove() != StatMove.RUN && (!player.isJumping || !player.isFalling)) {
            skin.run(player.getHisFighter());
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
