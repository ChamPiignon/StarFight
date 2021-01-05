package manager;

import character.Fighter;


public class CollideFighterManager
{
    public static boolean CollideWithFighter(Fighter fighter1,Fighter fighter2)
    {
           if(fighter1.getSkin().getImageView().intersects(fighter2.getSkin().getBoundsInLocal()))
            {
                return true;
            }
            return false;
    }
}
