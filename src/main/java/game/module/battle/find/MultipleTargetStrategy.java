package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/22 22:03
 */
public class MultipleTargetStrategy implements FindTargetStrategy {


    FindTargetStrategy[] f = new FindTargetStrategy[2];

    public MultipleTargetStrategy(int count, boolean front) {

        if (front) {
            f[0] = new MultipleFrontTargetStrategy(count);
            f[1] = new MultipleBackTargetStrategy(count);
        } else {
            f[1] = new MultipleFrontTargetStrategy(count);
            f[0] = new MultipleBackTargetStrategy(count);

        }
    }

    @Override
    public boolean find(Hero search, List<Hero> found) {

        for (FindTargetStrategy findTargetStrategy : f) {
            if (!findTargetStrategy.find(search, found)) {
                return false;
            }
        }
        return true;
    }
}
