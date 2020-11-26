package manager;

import character.Fighter;
import java.util.ArrayList;

public class StrategyFight {
    private StrategySkin skin;



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
