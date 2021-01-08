package manager;

import character.Fighter;
import character.StatMove;
import javafx.scene.image.ImageView;

public class StrategySkin
{
    public void jump(Fighter fighter)
    {
        setStatMove(fighter,StatMove.JUMP,-1);
    }

    public void primaryAttack(Fighter fighter)
    {
        setStatMove(fighter,StatMove.ATTACK1,1);
    }

    public void secondaryAttack(Fighter fighter)
    {
        setStatMove(fighter,StatMove.ATTACK2,1);
    }

    public void run(Fighter fighter)
    {
        setStatMove(fighter,StatMove.RUN,1);
    }

    public void fall(Fighter fighter)
    {
        setStatMove(fighter,StatMove.FALL,-1);
    }

    public void takeHit(Fighter fighter)
    {
        setStatMove(fighter,StatMove.TAKEHIT,1);
    }

    public void idle(Fighter fighter)
    {
        setStatMove(fighter,StatMove.IDLE,-1);
    }

    public void death(Fighter fighter)
    {
        setStatMove(fighter,StatMove.DEATH,1);

        updateAnimation(fighter,1,StatMove.DEATH);
        fighter.setStatMove(StatMove.DEATH);
    }

    public void setStatMove(Fighter fighter,StatMove name, int nBoucleAnimation)
    {
        updateAnimation(fighter,nBoucleAnimation,name);
        fighter.setStatMove(name);
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
