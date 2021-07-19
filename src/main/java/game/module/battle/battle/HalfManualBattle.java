package game.module.battle.battle;

import game.base.Logs;
import game.module.battle.Battle;
import game.module.battle.Hero;
import game.module.battle.Round;
import game.module.battle.Side;
import game.module.battle.record.BattleRecord;
import game.proto.data.FightHmHeroPos;
import game.utils.JacksonUtil;

import java.util.HashMap;
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

    private Map<Integer, Integer> targetMap = new HashMap<>(8);

    @Override
    public BattleRecord start() {

        init();
        beforeBattle();
        Logs.trace(JacksonUtil.toStr(battleRecord));
        return battleRecord;
    }

    private void init() {
        if (pve) {
            sideA.order = 1;
            sideB.order = 10;
            sideB.ready = true;
        }
    }

    public void setSideAPid(long pid) {
        sideA.pid = pid;
    }

    /**
     * 准备
     *
     * @param action
     */
    public Round ready(final HalfManualAction action) {
        Map<Integer, Hero> heroMap;
        HalfManualSideStatus status;


        if (action.pid == sideA.pid) {
            heroMap = sideAhero;
            status = sideA;
        } else {
            heroMap = sideBhero;
            status = sideB;
        }
        int order = status.order;

        for (FightHmHeroPos a : action.actions) {
            Integer from = a.getFromPos();
            Integer to = a.getFromPos();
            targetMap.put(from, to);

            Hero hero = heroMap.get(from);
            if (hero != null) {
                hero.setSpeed(a.getOrder() * 2 - order);
            }
        }

        status.ready = true;

        return checkStart();
    }

    private Round checkStart() {

        if (sideA.ready && sideB.ready) {
            decideOrder();
            //开始战斗
            fight();

            cleanRoundStatus();
            return currentRound;

        }
        return null;
    }

    /**
     * 一回合结束后清理相关状态
     */
    private void cleanRoundStatus() {
        targetMap.clear();
        if (sideA.pid != 0) {
            sideA.ready = false;
        }
        if (sideB.pid != 0) {
            sideB.ready = false;
        }
    }

    public void setPve(boolean pve) {
        this.pve = pve;
    }

    public Integer targetPos(int heroPos) {
        return targetMap.get(heroPos);
    }

    public boolean isWin(long pid) {
        Side mySide = sideA.pid == pid ? Side.A : Side.B;
        return getWinSide() == mySide;
    }
}
