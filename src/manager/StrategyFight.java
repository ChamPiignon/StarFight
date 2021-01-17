package manager;

import character.Fighter;

/**
 * The type Strategy fight.
 */
public class StrategyFight {
    private StrategySkin skin = new StrategySkin();
    private final static int DAMAGE = 10;


    /**
     * Primary attack.
     *
     * @param attacker the attacker
     * @param defender the defender
     */
    public void primaryAttack(Fighter attacker, Fighter defender)
    {
        skin.primaryAttack(attacker);
        collision(attacker,defender);
    }

    /**
     * Secondary attack.
     *
     * @param attacker the attacker
     * @param defender the defender
     */
    public void secondaryAttack(Fighter attacker, Fighter defender)
    {
        skin.secondaryAttack(attacker);
        collision(attacker,defender);
    }

    /**
     *
     * @param attacker
     * @param defender
     */
    private void collision(Fighter attacker, Fighter defender)
    {
        if(attacker.getHitbox().intersects(defender.getHitbox().getLayoutBounds()))
        {
            receiveAttack(defender);
        }
        attacker.getSkin().skinAnimation.setOnFinished( event -> {
            skin.idle(attacker);
        });
    }

    /**
     *
     * @param fighter
     */
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

    /**
     *
     * @param fighter
     */
    private void receiveDamage(Fighter fighter)
    {
        fighter.getCurrentHP().set(fighter.getCurrentHP().get()-DAMAGE);
        if(fighter.getCurrentHP().get()<=0) {
            fighter.getCurrentHP().set(0);
        }
    }

    /**
     *
     * @param fighter
     * @return boolean
     */
    private boolean isDead(Fighter fighter)
    {
        if(fighter.getCurrentHP().get()<=0)
        {
            return true;
        }
       return false;
    }
}
