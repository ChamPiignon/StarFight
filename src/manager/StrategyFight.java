package manager;

import character.Fighter;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class StrategyFight {
    private StrategySkin skin = new StrategySkin();



    public void primaryAttack(Fighter fighter)
    {
        skin.primaryAttack(fighter);
        //PROBLEM CONCEPTION COLLIDE
        /*ArrayList<Fighter> ListFighterCollide = isCollideWithFighter(fighter);
        if(ListFighterCollide.size()!=0)
        {
            for( Fighter fighterHit : ListFighterCollide)
            {
                receiveAttack(fighterHit);
            }
        }*/

        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    public void secondaryAttack(Fighter fighter)
    {
        skin.secondaryAttack(fighter);
        //PROBLEM CONCEPTION COLLIDE
        /*ArrayList<Fighter> ListFighterCollide = isCollideWithFighter(fighter);
        if(ListFighterCollide.size()!=0)
        {
            for( Fighter fighterHit : ListFighterCollide)
            {
                receiveAttack(fighterHit);
            }
        }*/
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    private void receiveAttack(Fighter fighter)
    {
        receiveDamage(fighter);
        if(!isDead(fighter))
        {
            skin.takeHit(fighter);
        }
        else
        {
            skin.death(fighter);
        }
        fighter.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(fighter);
        });
    }

    private void receiveDamage(Fighter fighter)
    {
        fighter.setHP(fighter.getHP()-1);
    }

    private boolean isDead(Fighter fighter)
    {
        if(fighter.getHP()==0)
        {
            return true;
        }
        return false;
    }
}
