package game.module.battle.battle;

import game.base.util.Tuple2;
import game.module.battle.Battle;
import game.module.battle.Hero;
import game.module.battle.Round;
import game.module.battle.Side;
import game.module.battle.record.BattleRecord;

import java.util.Map;

/**
 * 半手动战斗
 *
 * @author Yunzhe.Jin
 * 2021/7/18 13:52
 */
public class HalfManualBattle extends Battle {


    private HalfManualSideStatus sideA = new HalfManualSideStatus();
    private HalfManualSideStatus sideB = new HalfManualSideStatus();

    private boolean pve = true;

    @Override
    public BattleRecord start() {
        beforeBattle();


        return null;
    }

    private void init() {
        if (pve) {
            sideA.order = 1;
            sideB.order = 10;
            sideB.ready = true;
        }
    }

    /**
     * 准备
     *
     * @param action
     */
    public Round ready(final HalfManualAction action) {
        Map<Integer, Hero> heroMap;
        HalfManualSideStatus status;


        if (action.side == Side.A) {
            heroMap = sideAhero;
            status = sideA;
        } else {
            heroMap = sideBhero;
            status = sideB;
        }
        int order = status.order;

        for (Tuple2<Integer, Integer> a : action.actions) {
            Hero hero = heroMap.get(a.first);
            if (hero != null) {
                hero.setSpeed(order);
                order += 2;
            }
        }

        status.ready = true;

        return checkStart();
    }

    private Round checkStart() {

        if (sideA.ready && sideB.ready) {
            //开始战斗
            fight();

            return currentRound;

        }
        return null;
    }

}
