package game.module.battle.find;

import game.module.battle.Battle;
import game.module.battle.FindTargetStrategy;
import game.module.battle.Formation;
import game.module.battle.Hero;

import java.util.List;
import java.util.Map;

/**
 * 多个攻击目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:41
 */
public class MultipleBackTargetStrategy implements FindTargetStrategy {

    private int count;
    private int add;

    public MultipleBackTargetStrategy(int count) {
        this.count = count;
    }

    @Override
    public boolean find(Hero search, List<Hero> found) {
        final int allCount = count + add;
        if (found.size() < allCount) {
            int find = allCount - found.size();

            Battle battle = search.getBattle();
            Formation formation = battle.getFormation();
            List<Integer> posList = formation.back(search.getPos());

            Map<Integer, Hero> enemyMap = battle.oppositeHeroes(search.getSide());
            for (Integer pos : posList) {
                Hero hero = enemyMap.get(pos);
                if (hero != null && hero.isAlive()) {
                    found.add(hero);
                    find--;
                }
                if (find == 0) {
                    break;
                }
            }

            return find != 0;
        }

        return false;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAdd(int add) {
        this.add = add;
    }
}

