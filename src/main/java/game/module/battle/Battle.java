package game.module.battle;

import game.base.Logs;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.*;
import game.module.battle.record.BattleRecord;
import game.module.battle.record.Record;
import game.utils.JacksonUtil;

import java.util.*;
import java.util.stream.Collectors;

import static game.module.battle.Constant.ID_GEN;

/**
 * 一场战斗
 *
 * @author Yunzhe.Jin
 * 2021/1/8 14:24
 */
public class Battle {
    private final long battleId;

    private final long seed;

    private Formation formation = Formation.A_3_3_B_4_4;

    private final Random random;

    private final List<Round> roundList = new ArrayList<>();

    private Round currentRound;

    private List<Hero> sideAhero = new ArrayList<>();

    private List<Hero> sideBhero = new ArrayList<>();

    /**
     * 出手顺序
     */
    private List<Hero> actionOrderList = new ArrayList<>();

    /**
     * 计算攻击伤害逻辑
     */
    private List<DamageProcess> damageProcessList = new ArrayList<>();

    /**
     * 计算受到的伤害
     */
    private List<DamagedProcess> takeDamageProcessList = new ArrayList<>();

    private Side winSide;

    /**
     * 当前执行人动作信息
     */
    private DamageInfo damageInfo;

    public Battle() {
        battleId = ID_GEN.addAndGet(1);
        seed = System.currentTimeMillis();
        random = new Random(seed);

        // 暴击
        damageProcessList.add(new CriticalDamageProcess());
        // 闪避
        takeDamageProcessList.add(new AvoidDamagedProcess());
        // 护甲
        takeDamageProcessList.add(new DefDamagedProcess());
        // 护盾
//        takeDamageProcessList.add(new ShieldDamagedProcess());
    }


    /**
     * 开始一场战斗
     *
     * @return
     */
    public BattleRecord start() {

        // 计算出售顺序
        actionOrderList = decideOrder();

        final BattleRecord battleRecord = new BattleRecord(this);

        currentRound = new Round();
        Logs.trace("开场");
        // 开场
        processHero(ActionPoint.开场);
        nextRound();
        Logs.trace("==============================================");
        int roundCount = 0;
        while (!checkWin()) {
            roundCount += 1;
            Logs.trace("回合开始：", currentRound.getRoundCount());

            processHero(ActionPoint.回合开始前);

            // 出手
            for (final Hero hero : actionOrderList) {
                if (hero.isAlive()) {
                    hero.action();
                }
            }

            processHero(ActionPoint.回合结束后);
            // debug
            for (final Hero hero : actionOrderList) {
                Logs.trace("回合结束后状态", hero);
            }
            Logs.trace("回合结束：", currentRound.getRoundCount());
            Logs.trace("==============================================");

            if (roundCount == 30) {
                // 最多30回合
                break;
            }
            //下一回合
            nextRound();
        }
        // 结算
        Logs.trace("游戏结束", "胜利：", winSide);
        battleRecord.setRoundList(roundList);
        battleRecord.setWinSide(winSide);
        Logs.C.info("end:\n{}", JacksonUtil.toStr(battleRecord));

        return battleRecord;
    }

    /**
     * 获取水平附近的英雄
     *
     * @param from
     * @return
     */
    public List<Hero> findHNear(final Hero from) {
        final List<Hero> list = new ArrayList<>();


        return list;
    }

    /**
     * 英雄执行动作
     *
     * @param actionPoint
     */
    private void processHero(final ActionPoint actionPoint) {
        final List<Hero> heroes = decideOrder();
        for (final Hero hero : heroes) {
            hero.processAll(actionPoint);
        }
    }

    /**
     * 根据速度计算出手顺序
     */
    private List<Hero> decideOrder() {
        final List<Hero> order = new ArrayList<>();
        order.addAll(sideAhero.stream().filter(hero -> !hero.isDead()).collect(Collectors.toList()));
        order.addAll(sideBhero.stream().filter(hero -> !hero.isDead()).collect(Collectors.toList()));
        order.sort(Comparator.comparingInt(o -> o.property.getSpeed()));
        return order;
    }

    private void nextRound() {
        roundList.add(currentRound);
        final int nextRound = currentRound.getRoundCount() + 1;
        currentRound = new Round();
        currentRound.setRoundCount(nextRound);

    }

    /**
     * 检查是否有一方胜利
     */
    private boolean checkWin() {
        Optional<Hero> first = sideAhero.stream().filter(Hero::isAlive).findFirst();
        if (!first.isPresent()) {
            winSide = Side.B;
            return true;
        }

        first = sideBhero.stream().filter(hero -> !hero.isDead()).findFirst();
        if (!first.isPresent()) {
            winSide = Side.A;
            return true;
        }
        return false;
    }

    /**
     * 对方英雄
     */
    public List<Hero> oppositeHeroes(final Side side) {

        if (side == Side.A) {
            return sideBhero;
        }
        return sideAhero;
    }

    public List<Hero> oppositeAliveHeroes(final Side side) {

        if (side == Side.A) {
            return sideBhero.stream().filter(Hero::isAlive).collect(Collectors.toList());
        }
        return sideAhero.stream().filter(Hero::isAlive).collect(Collectors.toList());
    }


    public List<Hero> mySideHeroes(final Side side) {

        if (side == Side.A) {
            return sideAhero;
        }
        return sideBhero;
    }

    public List<Hero> mySideAliveHeroes(final Side side) {

        if (side == Side.A) {
            return sideAhero.stream().filter(Hero::isAlive).collect(Collectors.toList());
        }
        return sideBhero.stream().filter(Hero::isAlive).collect(Collectors.toList());
    }

    public void addRecord(final Record r) {
        currentRound.addRecord(r);
    }

    /// 计算给攻击伤害
    public void addAttack(final DamageProcess process) {
        damageProcessList.add(process);
    }

    public void removeAttack(final Class<?> clazz) {
        damageProcessList.removeIf(process -> process.getClass() == clazz);
    }

    public void calcAttack(final Hero hero) {
        for (final DamageProcess damageProcess : damageProcessList) {
            damageProcess.process(hero);
        }
    }

    /// 计算受到的伤害
    public void addAttackedProcess(final DamagedProcess process) {
        takeDamageProcessList.add(process);
    }

    public void removeAttackedProcess(final Class<?> clazz) {
        takeDamageProcessList.removeIf(process -> process.getClass() == clazz);
    }

    public void calcAttackedProcess(final DamageInfo info) {
        for (final DamagedProcess damageProcess : takeDamageProcessList) {
            damageProcess.process(info);
        }
    }

    public long getBattleId() {
        return battleId;
    }

    public List<Hero> getSideAhero() {
        return sideAhero;
    }

    public void setSideAhero(final List<Hero> sideAhero) {
        this.sideAhero = sideAhero;
    }

    public List<Hero> getSideBhero() {
        return sideBhero;
    }

    public void setSideBhero(final List<Hero> sideBhero) {
        this.sideBhero = sideBhero;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(final Round currentRound) {
        this.currentRound = currentRound;
    }

    public long getSeed() {
        return seed;
    }

    public Random getRandom() {
        return random;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public Side getWinSide() {
        return winSide;
    }

    public List<DamageProcess> getDamageProcessList() {
        return damageProcessList;
    }

    public void setDamageProcessList(final List<DamageProcess> damageProcessList) {
        this.damageProcessList = damageProcessList;
    }

    public List<DamagedProcess> getTakeDamageProcessList() {
        return takeDamageProcessList;
    }

    public void setTakeDamageProcessList(final List<DamagedProcess> takeDamageProcessList) {
        this.takeDamageProcessList = takeDamageProcessList;
    }

    public DamageInfo getDamageInfo() {
        return damageInfo;
    }

    public void setDamageInfo(final DamageInfo damageInfo) {
        this.damageInfo = damageInfo;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(final Formation formation) {
        this.formation = formation;
    }
}

