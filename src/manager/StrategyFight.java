package manager;

import character.Fighter;

public class StrategyFight {
    private StrategySkin skin = new StrategySkin();
    private final static int DAMAGE = 10;



    public void primaryAttack(Fighter attacker, Fighter defender)
    {
        skin.primaryAttack(attacker);
        //PROBLEM CONCEPTION COLLIDE
        if(attacker.getSkin().intersects(defender.getSkin().getLayoutBounds()))
        {
            receiveAttack(defender);
        }
        attacker.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(attacker);
        });
    }

    public void secondaryAttack(Fighter attacker, Fighter defender)
    {
        skin.secondaryAttack(attacker);
        //PROBLEM CONCEPTION COLLIDE
        if(attacker.getSkin().intersects(defender.getSkin().getLayoutBounds()))
        {
                receiveAttack(defender);
        }
        attacker.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(attacker);
        });
    }

    private void receiveAttack(Fighter fighter)
    {
        receiveDamage(fighter);
        if(!isDead(fighter))
        {
            skin.takeHit(fighter);
            fighter.getSkin().skinAnimation.setOnFinished( event -> {
                skin.idle(fighter);
            });
        }
        else
        {
            skin.death(fighter);
        }

    }

    private void receiveDamage(Fighter fighter)
    {
        fighter.getCurrentHP().set(fighter.getCurrentHP().get()-DAMAGE);
        if(fighter.getCurrentHP().get()<=0) {
            fighter.getCurrentHP().set(0);
        }
    }

    private boolean isDead(Fighter fighter)
    {
        if(fighter.getCurrentHP().get()<=0)
        {

            return true;
        }
       return false;
    }
}
