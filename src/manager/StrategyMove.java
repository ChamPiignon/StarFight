package manager;

import character.Fighter;

public class StrategyMove {
    StrategySkin skin;
    public void jump(Fighter fighter)
    {
        //tant que le saut monte
        skin.jump(fighter);
        //fighter.setYPosition();

        //tant que le saut descend
        skin.fall(fighter);
        //fighter.setYPosition();

        //quand il touche le sol
        skin.idle(fighter);
    }

    public void moveLeft(Fighter fighter)
    {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        //fighter.setXPosition();
    }

    public void moveRight(Fighter fighter)
    {
        //skin.mirror(fighter) retourne le skin sur l'axe y
        skin.run(fighter);
        //fighter.setXPosition();
    }
}
