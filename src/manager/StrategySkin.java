package manager;

import character.Fighter;
import character.StatMove;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static javafx.util.Duration.millis;

public class StrategySkin
{
    public void jump(Fighter fighter)
    {
        updateAnimation(fighter,-1, StatMove.JUMP);
        fighter.setStatMove(StatMove.JUMP);
    }

    public void primaryAttack(Fighter fighter)
    {
        updateAnimation(fighter,1,StatMove.ATTACK1);
        fighter.setStatMove(StatMove.ATTACK1);
    }

    public void secondaryAttack(Fighter fighter)
    {
        updateAnimation(fighter,1,StatMove.ATTACK2);
        fighter.setStatMove(StatMove.ATTACK2);
    }

    public void run(Fighter fighter)
    {
        updateAnimation(fighter,1,StatMove.RUN);
        fighter.setStatMove(StatMove.RUN);
    }

    public void fall(Fighter fighter)
    {
        updateAnimation(fighter,-1,StatMove.FALL);
        fighter.setStatMove(StatMove.FALL);
    }

    public void takeHit(Fighter fighter)
    {
        updateAnimation(fighter,1,StatMove.TAKEHIT);
        fighter.setStatMove(StatMove.TAKEHIT);
    }

    public void idle(Fighter fighter)
    {
        updateAnimation(fighter,-1,StatMove.IDLE);
        fighter.setStatMove(StatMove.IDLE);
    }

    public void death(Fighter fighter)
    {
        updateAnimation(fighter,1,StatMove.DEATH);
        fighter.setStatMove(StatMove.DEATH);
    }

    public void mirror(Fighter fighter,int xOrientation)
    {
        fighter.getSkin().getImageView().setScaleX(xOrientation);
    }

    public ImageView getSprite(Fighter fighter){ return fighter.getSkin().getImageView(); }

    private void setSprite(Fighter fighter,ImageView sprite){
        fighter.getSkin().getImageView().setImage(sprite.getImage());
    }

    private void setSpriteName(Fighter fighter,StatMove skinName) {
        setSprite(fighter, fighter.getSkin().getSpriteName(skinName));
    }
    private void updateAnimation(Fighter fighter,int n,StatMove spriteName)
    {
        setSpriteName(fighter,spriteName);
        fighter.getSkin().refreshAnimation();
        if(n == -1) {
            fighter.getSkin().skinAnimation.setIndefiniteCycle();
        }
        else {
            fighter.getSkin().skinAnimation.setNCycle(n);
        }
        fighter.getSkin().skinAnimation.play();
    }



/*
        private void updateAnimation(Fighter fighter,int n,String spriteName)
    {
        setSpriteName(fighter,spriteName);
        fighter.getSkin().refreshAnimation();
        if(n == -1) {
            fighter.getSkin().skinAnimation.setIndefiniteCycle();
        }
        else {
            fighter.getSkin().skinAnimation.setNCycle(n);
        }
        fighter.getSkin().skinAnimation.play();
    }
 */

}
