package manager;

import character.Fighter;

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
        //fighter.setCurrentHP(fighter.getCurrentHP()-1);
    }

    private boolean isDead(Fighter fighter)
    {
//        if(fighter.getCurrentHP()==0)
//        {
//            return true;
//        }
       return false;
    }
}
