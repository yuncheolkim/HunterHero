package game.module.battle.battle;

import game.module.battle.Battle;
import game.module.battle.Hero;
import game.module.battle.Side;
import game.module.battle.record.BattleRecord;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 手动指定目标后进行战斗
 * 全手动战斗
 * <p>
 * pve:
 * sideA 玩家
 * sideB 电脑
 *
 * @author Yunzhe.Jin
 * 2021/7/18 13:53
 */
public class ManualBattle extends Battle {

    /**
     * 当前回合方
     */
    private Side roundSide = Side.A;

    private Map<Integer, ManualHero> mSideA = new HashMap<>();
    private Map<Integer, ManualHero> mSideB = new HashMap<>();

    @Override
    protected void inBattle() {
    }

    /**
     * 只进行电脑的排序
     *
     * @return
     */
    @Override
    protected List<Hero> decideOrder() {
        final List<Hero> order = new ArrayList<>();
        order.addAll(sideBhero.values().stream().filter(hero -> !hero.isDead()).collect(Collectors.toList()));
        order.sort(Comparator.comparingInt(Hero::getSpeed));
        return order;
    }

    @Override
    protected void beforeBattle() {
        for (final Map.Entry<Integer, Hero> entry : getSideAhero().entrySet()) {
            mSideA.put(entry.getKey(), new ManualHero(entry.getValue()));
        }
        for (final Map.Entry<Integer, Hero> entry : getSideBhero().entrySet()) {
            mSideB.put(entry.getKey(), new ManualHero(entry.getValue()));
        }
        super.beforeBattle();
    }

    @Override
    public BattleRecord start() {
        beforeBattle();


        return null;
    }

    /**
     * 结束本回合
     */
    public void endRound() {
        roundSide = roundSide.opposite();
    }

    public void Action(final ManualAction action) {

    }

}

