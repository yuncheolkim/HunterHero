package game.module.battle;

import com.google.common.base.Stopwatch;
import game.base.Logs;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.*;
import game.module.battle.record.BattleRecord;
import game.module.battle.record.Record;
import game.utils.JacksonUtil;

import java.util.*;
import java.util.stream.Collectors;

import static game.module.battle.BattleConstant.ID_GEN;

/**
 * 一场战斗
 *
 * @author Yunzhe.Jin
 * 2021/1/8 14:24
 */
public class Battle {
    /**
     * 当前战斗id
     */
    private final long fightId;
    /**
     * 战斗
     */
    private int battleId;

    private final long seed;

    private Formation formation = Formation.A_3_3_B_4_4;

    private final Random random;

    private final List<Round> roundList = new ArrayList<>();

    protected Round currentRound;

    /**
     * key:pos
     */
    protected Map<Integer, Hero> sideAhero = new HashMap<>(8);

    /**
     * key:pos
     */
    protected Map<Integer, Hero> sideBhero = new HashMap<>(8);

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

    BattleRecord battleRecord;

    public Battle() {
        fightId = ID_GEN.addAndGet(1);
        seed = System.currentTimeMillis();
        random = new Random(seed);

        // 暴击
        damageProcessList.add(new CriticalDamageProcess());
        // 闪避
        takeDamageProcessList.add(new AvoidDamagedProcess());
        // 护甲
        takeDamageProcessList.add(new DefDamagedProcess());
        // 护盾
        takeDamageProcessList.add(new ShieldDamagedProcess());
    }


    /**
     * 开始一场战斗
     *
     * @return
     */
    public BattleRecord start() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        beforeBattle();
        inBattle();
        endBattle();
        Logs.C.info("=============> 战斗耗时:{}", stopwatch.stop());

        return battleRecord;
    }

    /**
     * 战斗中
     */
    protected void inBattle() {
        while (!fight()) {
            //下一回合
            nextRound();
        }
    }

    /**
     * 战斗
     *
     * @return 是否有胜负
     */
    protected boolean fight() {
        Logs.trace("回合开始：", currentRound.getRoundCount());

        processHero(ActionPoint.回合开始前);

        // 出手
        for (final Hero hero : actionOrderList) {
            processHero(ActionPoint.出手开始前);
            do {
                if (hero.isAlive()) {
                    hero.action();
                }
            } while (hero.isAlive() && hero.isContinueAction() && !checkWinner());
            if (checkWinner()) {
                return true;
            }
            processHero(ActionPoint.出手结束后);
        }

        processHero(ActionPoint.回合结束后);
        // debug
        for (final Hero hero : actionOrderList) {
            Logs.trace("回合结束后状态", hero);
        }
        Logs.trace("回合结束：", currentRound.getRoundCount());
        Logs.trace("==============================================");

        if (currentRound.getRoundCount() == 30) {
            if (!checkWinner()) {
                winSide = actionOrderList.get(0).getSide() == Side.A ? Side.B : Side.A;
            }
            // 最多30回合
            return true;
        }
        return checkWinner();
    }

    protected void endBattle() {
        // 结算
        Logs.trace("游戏结束", "胜利：", winSide);
        battleRecord.setRoundList(roundList);
        battleRecord.setWinSide(winSide);
        Logs.C.info("end:\n{}", JacksonUtil.toStr(battleRecord));
    }

    protected void beforeBattle() {
        // 计算出手顺序
        actionOrderList = decideOrder();

        battleRecord = new BattleRecord(this);

        currentRound = new Round();
        roundList.add(currentRound);
        Logs.trace("开场");
        // 开场
        processHero(ActionPoint.开场);

        // 记录场景
        currentRound = new Round();
        currentRound.setRoundCount(1);
        roundList.add(currentRound);
    }

    /**
     * 英雄执行动作
     *
     * @param actionPoint
     */
    protected void processHero(final ActionPoint actionPoint) {
        for (final Hero hero : actionOrderList) {
            if (hero.isAlive()) {
                hero.processAll(actionPoint);
            }
        }
    }

    /**
     * 根据速度计算出手顺序
     */
    protected List<Hero> decideOrder() {
        final List<Hero> order = new ArrayList<>();
        order.addAll(sideAhero.values().stream().filter(hero -> !hero.isDead()).collect(Collectors.toList()));
        order.addAll(sideBhero.values().stream().filter(hero -> !hero.isDead()).collect(Collectors.toList()));
        order.sort(Comparator.comparingInt(Hero::getSpeed));
        return order;
    }

    private void nextRound() {
        final int nextRound = currentRound.getRoundCount() + 1;
        currentRound = new Round();
        currentRound.setRoundCount(nextRound);
        roundList.add(currentRound);

    }

    /**
     * 检查是否有一方胜利
     */
    private boolean checkWinner() {
        Optional<Hero> first = sideAhero.values().stream().filter(Hero::isAlive).findFirst();
        if (!first.isPresent()) {
            winSide = Side.B;
            return true;
        }

        first = sideBhero.values().stream().filter(hero -> !hero.isDead()).findFirst();
        if (!first.isPresent()) {
            winSide = Side.A;
            return true;
        }
        return false;
    }

    public boolean hasWinner() {
        return winSide != null;
    }


    /**
     * 对方英雄
     *
     * @return
     */
    public Map<Integer, Hero> oppositeHeroes(final Side side) {

        if (side == Side.A) {
            return sideBhero;
        }
        return sideAhero;
    }

    public List<Hero> oppositeAliveHeroes(final Side side) {

        if (side == Side.A) {
            return sideBhero.values().stream().filter(Hero::isAlive).collect(Collectors.toList());
        }
        return sideAhero.values().stream().filter(Hero::isAlive).collect(Collectors.toList());
    }


    public Map<Integer, Hero> mySideHeroes(final Side side) {

        if (side == Side.A) {
            return sideAhero;
        }
        return sideBhero;
    }


    public void addRecord(final Record r) {
        currentRound.addRecord(r);
    }


    public void addHero(final Hero hero) {
        final Map<Integer, Hero> map;

        if (hero.side == Side.A) {
            map = sideAhero;
        } else {
            map = sideBhero;
        }
        map.put(hero.getPos().getIndex(), hero);
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

    public Map<Integer, Hero> getSideAhero() {
        return sideAhero;
    }

    public Map<Integer, Hero> getSideBhero() {
        return sideBhero;
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

    public int getBattleId() {
        return battleId;
    }

    public void setBattleId(final int battleId) {
        this.battleId = battleId;
    }

    public long getFightId() {
        return fightId;
    }
}

