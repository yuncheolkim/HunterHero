package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;

import java.util.List;

/**
 * 攻击前排
 *
 * @author Yunzhe.Jin
 * 2021/6/20 14:35
 */
public class FrontTargetStrategy implements FindTargetStrategy {
    @Override
    public boolean find(Hero search, List<Hero> found) {

        return true;
    }
}
