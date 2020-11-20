package manager;

import character.Fighter;

import java.util.List;

public class ManagerFighter {
    public List<Fighter> ListFighter;
    private StrategyMove MoveManager;
    private StrategyFight FightManager;

    public boolean addFighter(Fighter character) {
        return true;
    }

    public boolean removeFighter(int index) {
        return true;
    }
}
