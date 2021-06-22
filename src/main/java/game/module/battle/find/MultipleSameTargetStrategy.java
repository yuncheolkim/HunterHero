package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;

import java.util.List;

/**
 * 多次攻击同一目标
 *
 * @author Yunzhe.Jin
 * 2021/6/22 22:07
 */
public class MultipleSameTargetStrategy implements FindTargetStrategy {

    FindTargetStrategy[] f = new FindTargetStrategy[2];
    private int count = 1;


    public MultipleSameTargetStrategy(int count) {
        this.count = count;
    }

    @Override
    public boolean find(Hero search, List<Hero> found) {

        boolean result = false;

        for (FindTargetStrategy findTargetStrategy : f) {
            if (findTargetStrategy.find(search, found)) {

                result = true;
                break;
            }
        }


        return result;
    }
}
