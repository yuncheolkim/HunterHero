package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;
import game.module.battle.battle.HalfManualBattle;

import java.util.List;
import java.util.Map;

/**
 * 手动指定目标
 *
 * @author Yunzhe.Jin
 * 2021/7/18 20:31
 */
public class ManualTargetStrategy implements FindTargetStrategy {

    public static FindTargetStrategy I = new ManualTargetStrategy();

    @Override
    public boolean find(Hero search, List<Hero> found) {

        HalfManualBattle battle = (HalfManualBattle) search.getBattle();

        Integer targetPos = battle.targetPos(search.getPos().getIndex());

        if (targetPos == null) {
            return false;
        }

        Map<Integer, Hero> integerHeroMap = battle.mySideHeroes(search.getSide());

        Hero target = integerHeroMap.get(targetPos);
        if (target == null) {
            return false;
        }

        found.add(target);

        return true;
    }
}
