package game.module.battle.find;

import game.module.battle.Battle;
import game.module.battle.FindTargetStrategy;
import game.module.battle.Formation;
import game.module.battle.Hero;

import java.util.List;
import java.util.Map;

/**
 * 攻击前排一个目标
 *
 * @author Yunzhe.Jin
 * 2021/6/20 14:35
 */
public class FrontTargetStrategy implements FindTargetStrategy {
    @Override
    public boolean find(Hero search, List<Hero> found) {
        if (found.size() >= 1) {
            return false;
        }

        Battle battle = search.getBattle();
        Formation formation = battle.getFormation();
        List<Integer> posList = formation.front(search.getPos());

        Map<Integer, Hero> enemyMap = battle.oppositeHeroes(search.getSide());
        Hero h = null;
        for (Integer pos : posList) {
            Hero hero = enemyMap.get(pos);
            if (hero != null && hero.isAlive()) {
                h = hero;
                break;
            }
        }

        if (h == null) {
            return true;
        }

        found.add(h);
        return false;
    }
}
