package manager;

import character.Fighter;
import character.StatMove;
import javafx.animation.AnimationTimer;


public class StrategyMove {
    private static final StrategySkin skin = new StrategySkin();
    private final int jumpSize = 20;

    public void jump(Fighter fighter) {
        skin.jump(fighter);
//        final double oldY = fighter.getSkin().getImageView().getY();
//        int gravity = 0;
//        while(oldY >= fighter.getSkin().getImageView().getY())
//        {
//            fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + gravity);
//            gravity = gravity + 1;
//            System.out.println(gravity);
//
//            if (oldY <= fighter.getSkin().getImageView().getY()) {
//                skin.idle(fighter);
//                gravity = 0;
//                fighter.getSkin().getImageView().setY(oldY);
//            }
//
//            if (gravity == jumpSize) {
//                skin.fall(fighter);
//            }
//        }
        AnimationTimer jumpTimer = new AnimationTimer() {
            final double oldY = fighter.getSkin().getImageView().getY();
            int gravity = 0;

            @Override
            public void handle(long now) {
                fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY() - jumpSize + gravity);
                gravity = gravity + 1;
                System.out.println(gravity);
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

    public void down(Fighter fighter, int deltaY) {
//        if (deltaY != 1) {
//            return;
//        }
        int jumpHeight = 5;
        //tant que le saut descend
        skin.fall(fighter);
        for (int i = jumpHeight; i >= 0; i--) {
            fighter.getSkin().getImageView().setY(fighter.getSkin().getImageView().getY()+i);;
        }
    }
    public void moveLeft(Fighter fighter, int deltaX) throws Exception{
        flipVertical(fighter,"left");
        if(fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX()+deltaX);
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    public void moveRight(Fighter fighter, int deltaX) throws Exception {
        flipVertical(fighter,"right");
        if(fighter.getStatMove() != StatMove.RUN) {
            skin.run(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX()+deltaX);
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    public void noMove(Fighter fighter) {
        if(fighter.getStatMove() != StatMove.IDLE) {
            skin.idle(fighter);
        }
        fighter.getSkin().getImageView().setX(fighter.getSkin().getImageView().getX());
    }

    private void flipVertical(Fighter fighter,String orientation) throws Exception {
        if("right" == orientation)
        {
            skin.mirror(fighter,1);
        }
        else if("left" == orientation)
        {
            skin.mirror(fighter,-1);
        }
        else
        {
            throw new Exception("Orientation character: "+orientation+" not available.");
        }
        fighter.getSkin().setOrientation(orientation);
    }
}
