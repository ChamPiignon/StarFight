package manager;

import character.Fighter;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static javafx.util.Duration.millis;

public class StrategySkin
{
    public void jump(Fighter fighter)
    {
        updateAnimation(fighter,-1,"Jump");
    }

    public void primaryAttack(Fighter fighter)
    {
        updateAnimation(fighter,1,"Attack1");
    }

    public void secondaryAttack(Fighter fighter)
    {
        updateAnimation(fighter,1,"Attack2");
    }

    public void run(Fighter fighter)
    {
        updateAnimation(fighter,1,"Run");
    }

    public void fall(Fighter fighter)
    {
        updateAnimation(fighter,-1,"Fall");
    }

    public void takeHit(Fighter fighter)
    {
        updateAnimation(fighter,-1,"Take hit");
    }

    public void idle(Fighter fighter)
    {
        updateAnimation(fighter,-1,"Idle");
    }

    public void death(Fighter fighter)
    {
        updateAnimation(fighter,1,"Death");
    }

    public ImageView getSprite(Fighter fighter){ return fighter.getSkin().getImageView(); }

    private void setSprite(Fighter fighter,ImageView sprite){fighter.getSkin().setImageView(sprite);}

    private void setSpriteName(Fighter fighter,String skinName){
        setSprite(fighter,fighter.getSkin().getSpriteName(skinName));
    }
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



}
