package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;

import java.util.List;

/**
 * 多个攻击目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:41
 */
public class MultipleTargetStrategy implements FindTargetStrategy {

    private int count;

    public MultipleTargetStrategy(int count) {
        this.count = count;
    }

    @Override
    public boolean find(Hero search, List<Hero> found) {
        if (found.size() < count) {
            int find = count - found.size();
            List<Hero> heroes = search.getBattle().oppositeAliveHeroes(search.getSide());
            found.addAll(heroes.subList(0, Math.min(find, heroes.size())));
        }

        return false;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
