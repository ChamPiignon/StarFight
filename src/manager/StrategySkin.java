package manager;

import character.Fighter;
import character.StatMove;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;

public class StrategySkin
{
    /**
     *
     * @param fighter
     */
    public void jump(Fighter fighter)
    {
        setStatMove(fighter,StatMove.JUMP,-1);
    }

    /**
     *
     * @param fighter
     */
    public void primaryAttack(Fighter fighter)
    {
        setStatMove(fighter,StatMove.ATTACK1,1);
    }

    /**
     *
     * @param fighter
     */
    public void secondaryAttack(Fighter fighter)
    {
        setStatMove(fighter,StatMove.ATTACK2,1);
    }

    /**
     *
     * @param fighter
     */
    public void run(Fighter fighter)
    {
        setStatMove(fighter,StatMove.RUN,1);
    }

    /**
     *
     * @param fighter
     */
    public void fall(Fighter fighter)
    {
        setStatMove(fighter,StatMove.FALL,-1);
    }

    /**
     *
     * @param fighter
     */
    public void takeHit(Fighter fighter)
    {
        setStatMove(fighter,StatMove.TAKEHIT,1);
    }

    /**
     *
     * @param fighter
     */
    public void idle(Fighter fighter)
    {
        setStatMove(fighter,StatMove.IDLE,-1);
    }

    /**
     *
     * @param fighter
     */
    public void death(Fighter fighter)
    {
        setStatMove(fighter,StatMove.DEATH,1);

        updateAnimation(fighter,1,StatMove.DEATH);
        fighter.setStatMove(StatMove.DEATH);
    }

    /**
     *
     * @param fighter
     * @param name
     * @param nBoucleAnimation
     */
    public void setStatMove(Fighter fighter,StatMove name, int nBoucleAnimation)
    {
        updateAnimation(fighter,nBoucleAnimation,name);
        fighter.setStatMove(name);
    }

    /**
     *
     * @param fighter
     * @param xOrientation
     */
    public void mirror(Fighter fighter,int xOrientation)
    {
        fighter.getSkin().getImageView().setScaleX(xOrientation);
    }

    /**
     *
     * @param fighter
     * @return
     */
    public ImageView getSprite(Fighter fighter){ return fighter.getSkin().getImageView(); }

    /**
     *
     * @param fighter
     * @param sprite
     */
    private void setSprite(Fighter fighter,ImageView sprite){
        fighter.getSkin().getImageView().setImage(sprite.getImage());
    }

    /**
     *
     * @param fighter
     * @param skinName
     */
    private void setSpriteName(Fighter fighter,StatMove skinName) {
        setSprite(fighter, fighter.getSkin().getSpriteName(skinName));
    }

    /**
     *
     * @param fighter
     * @param n
     * @param spriteName
     */
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

}
