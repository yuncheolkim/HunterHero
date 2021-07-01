package game.module.battle;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import game.base.Logs;
import game.module.battle.action.ActionPoint;
import game.module.battle.action.ShieldRoundEndHandler;
import game.module.battle.buff.Buff;
import game.module.battle.damage.DamageInfo;
import game.module.battle.damage.DamageSourceType;
import game.module.battle.record.BuffData;
import game.module.battle.record.HeroRecordData;
import game.module.battle.record.HeroRecordSimple;
import game.module.battle.record.Record;
import game.module.battle.status.HealthChangeInfo;
import game.module.battle.status.HeroStatusChangeListener;
import game.proto.data.DamageType;
import game.proto.data.DisplayPoint;
import game.proto.data.RecordType;

import java.util.*;
import java.util.stream.Collectors;

import static game.proto.data.RecordType.ACTION;
import static game.proto.data.RecordType.ATTACK;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:23
 */
public class Hero {

    /**
     * 英雄id
     */
    protected int id;

    protected int talentInfo;

    /**
     * 所在位置
     */
    protected Pos pos;

    /**
     * 名称
     */
    protected String name;

    protected int level;

    /**
     * 英雄原始数据，开局后永远不变
     */
    public HeroData origin;

    /**
     * 英雄当前数据,本局持续
     */
    public HeroData property;

    /**
     * 每次出手数据,临时数据
     */
    public HeroData fightingData;

    /**
     * 英雄状态
     */
    public HeroStats heroStats = new HeroStats();

    /**
     * 技能列表
     */
    protected Multimap<ActionPoint, Skill> skillMap = ArrayListMultimap.create();

    /**
     * buff 列表
     */
    protected Multimap<ActionPoint, Buff> buffMap = ArrayListMultimap.create();

    /**
     * buff cd检查
     */
    protected Multimap<ActionPoint, Buff> buffCdMap = ArrayListMultimap.create();

    /**
     * 动作
     */
    protected Multimap<ActionPoint, HeroActionPointHandler> actionMap = ArrayListMultimap.create();

    /**
     * 当前所在战斗
     */
    protected Battle battle;

    /**
     * 哪一方
     */
    protected Side side;

    /**
     * 监听状态变化
     */
    protected List<HeroStatusChangeListener> statusChangeListeners = new ArrayList<>();

    /**
     * 死之前状态
     */
    protected HealthChangeInfo deadInfo;

    /**
     * 查找敌人策略
     */
    protected List<FindTargetStrategy> targetStrategies = new ArrayList<>();

    /**
     * 上下文数据根据情况来存储转换
     */
    protected Object contextData;

    /**
     * 当前攻击信息
     */
    public DamageInfo damageInfo;

    /**
     * 是否继续行动
     */
    private boolean continueAction;

    /**
     * 战报写入时机
     */
    private Multimap<ActionPoint, Record> delayRecord = ArrayListMultimap.create();

    /**
     * 初始化
     */
    public final void init() {
        property = origin.copy();
        // 回合结束后计算
        actionMap.put(ActionPoint.回合结束后, ShieldRoundEndHandler.INSTANCE);
        initTalent();

    }


    /**
     * 初始化天赋
     */
    protected void initTalent() {
    }

    public void setSpeed(final int speed) {
        origin.setSpeed(speed);
    }

    public void processAll(final ActionPoint actionPoint) {
        processSkill(actionPoint);
        processBuff(actionPoint);
        processAction(actionPoint);

        final Collection<Record> records = delayRecord.get(actionPoint);
        if (records != null) {
            for (final Record record : records) {
                battle.addRecord(record);
            }
            delayRecord.removeAll(actionPoint);
        }
    }

    /**
     * 执行动作
     *
     * @param actionPoint 相应的动作
     */
    public void processAction(final ActionPoint actionPoint) {
        final Collection<HeroActionPointHandler> pointHandler = actionMap.get(actionPoint);
        if (!pointHandler.isEmpty()) {
            Logs.trace("action", this, actionPoint);
            for (final HeroActionPointHandler heroActionPointHandler : pointHandler) {
                heroActionPointHandler.handle(this);
            }
        }
    }

    public void addAction(final ActionPoint actionPoint, final HeroActionPointHandler h) {
        actionMap.put(actionPoint, h);
    }

    public void removeAction(final ActionPoint actionPoint, final HeroActionPointHandler h) {
        actionMap.remove(actionPoint, h);
    }

    /**
     * 查找目标
     */
    public List<Hero> findTarget() {

        final List<Hero> list = new ArrayList<>();

        for (final FindTargetStrategy targetStrategy : targetStrategies) {
            if (!targetStrategy.find(this, list)) {
                break;
            }
        }
        if (list.isEmpty()) {
            return battle.oppositeHeroes(side).values().stream().filter(Hero::isAlive).limit(1).collect(Collectors.toList());
        }

        return list;
    }

    public void action() {
        final Record record = new Record(ACTION);
        record.heroId = id;
        record.pos = pos.getIndex();
        battle.addRecord(record);
        attack();
        // 清楚临时战报
        delayRecord.clear();
    }

    List<Hero> targetList;

    /**
     * 普通攻击
     */
    public void attack() {

        targetList = findTarget();
        processSkill(ActionPoint.选择目标后);

        for (final Hero target : targetList) {

            if (target.isDead()) {
                continue;
            }
            resetFightingData();
            damageInfo = new DamageInfo();
            damageInfo.type = (DamageSourceType.ATTACK);
            damageInfo.origin = this;
            damageInfo.source = this;
            damageInfo.target = target;
            damageInfo.sourceDamage = property.getDamage();
            target.damageInfo = damageInfo;

            processAll(ActionPoint.出手前);

            if (this.heroStats.active) {

                Logs.trace("calcAttack:", this);
                calcAttack();
                processAction(ActionPoint.出手);
                // skill 主动技能
                final boolean skillFire = processSkill(ActionPoint.出手);

                // 计算伤害
                Logs.trace("attack:", this.getSimple(), "--->", target.getSimple(), damageInfo);

                if (!skillFire) {// 普通攻击
                    attackRecord();

                    // 受到伤害
                    damage(damageInfo);
                }
            } else {
                Logs.trace("无法行动", this);
            }
            // action
            processAll(ActionPoint.出手后);

        }
    }

    /**
     * 对一个敌人造成伤害
     * 伤害可能来自技能，buff
     *
     * @param target 目标
     */
    public void damage(final DamageInfo info) {
        info.target.attacked(info);
    }

    /**
     * 计算攻击方最终伤害
     */
    public void calcAttack() {
        damageInfo.target.processBuff(ActionPoint.攻击方计算伤害前);
        battle.calcAttack(this);
        damageInfo.target.processBuff(ActionPoint.攻击方计算伤害后);
    }

    private void resetFightingData() {
        fightingData = property.copy();
    }


    private void attackRecord() {
        final Record attackRecord = new Record(ATTACK);
        final HeroRecordSimple simple = damageInfo.source.getSimple();
        attackRecord.heroId = simple.id;
        attackRecord.pos = simple.pos.getIndex();
        attackRecord.targetList = Lists.newArrayList(damageInfo.target.getSimple().pos.getIndex());
        battle.addRecord(attackRecord);
    }

    /**
     * 执行buff
     */
    public void processBuff(final ActionPoint actionPoint) {
        Collection<Buff> buffs = buffMap.get(actionPoint);
        if (actionPoint == ActionPoint.重新计算属性) {
            buffs = buffMap.values();
        }
        if (buffs != null) {
            for (final Buff buff : buffs) {
                buff.process(actionPoint, this);
            }
        }

        // Check round
        buffCdMap.get(actionPoint).forEach(buff -> buff.checkRound(actionPoint, this));
    }

    public void removeBuff(final Buff buff) {

        contextData = buff;
        for (final ActionPoint actionPoint : buff.effectPoint.keySet()) {
            buffMap.remove(actionPoint, buff);
            removeBuffRecord(actionPoint, buff);
            processAll(ActionPoint.buff移除后);
        }
        contextData = null;

        if (buff.needReCalcProperty()) {
            calcBuffEffect(ActionPoint.重新计算属性);
        }
    }

    private void removeBuffRecord(final ActionPoint actionPoint, final Buff buff) {

        final Record record = new Record(RecordType.BUFF_REMOVE);
        record.actionPoint = actionPoint;
        record.heroId = id;
        record.pos = pos.getIndex();
        record.id = buff.getId();
        battle.addRecord(record);
    }

    /**
     * 执行技能
     */
    public boolean processSkill(final ActionPoint actionPoint) {
        final Collection<Skill> skills = skillMap.get(actionPoint);
        boolean fired = false;
        for (final Skill skill : skills) {
            // 减少cd
            if (actionPoint == skill.reduceCoolDownPoint) {
                skill.reduceCoolDown(1);
            }

            if (skill.isReady() && skill.canProcess(this)) {
                Logs.trace("使用技能", this);

                // 使用技能
                final Record record = skill.process(actionPoint, this);
                if (skill.getSkillType() == SkillType.Z && record != null) {
                    battle.addRecord(record);
                }
                // 冷却
                skill.fireCoolDown();
                if (record != null) {
                    record.cd = skill.cd;
                }
                fired = true;
            }
        }

        return fired;
    }

    /**
     * 被攻击
     *
     * @param info
     */
    public void attacked(final DamageInfo info) {
        resetFightingData();
        Logs.trace("attacked:", this);
        processAll(ActionPoint.被攻击之前);
        if (info.target.id != this.id) {
            info.target.attacked(info);
            return;
        }

        // 计算受到的伤害
        battle.calcAttackedProcess(info);
        if (info.avoid) {
            processAll(ActionPoint.闪避之前);
        }
        if (info.avoid) {
            final Record record = new Record(RecordType.AVOID);
            record.heroId = id;
            record.pos = pos.getIndex();
            battle.addRecord(record);
            processAll(ActionPoint.闪避之后);
        } else {
            // 计算buff
            processAll(ActionPoint.受到伤害之前);
            info.attackedDamage = info.allSourceDamage();
            // 减血
            reduceHp(info);

            processAll(ActionPoint.受到伤害之后);
        }
    }


    /**
     * 最终减少的血量，所有减血操作都要通过这个方法，不能直接修改属性
     *
     * @param num
     */
    public void reduceHp(final DamageInfo i) {
        final Hero target = i.target;
        final int num = i.attackedDamage;

        if (num <= 0) {
            return;
        }
        final HealthChangeInfo info = new HealthChangeInfo();
        info.setTarget(this);
        info.setOldValue(target.heroStats.hp);

        target.heroStats.hp -= num;
        info.setNewValue(target.heroStats.hp);

        addDamageRecord(i);
        Logs.trace("reduceHp", info);
        if (info.getNewValue() <= 0) {
            deadInfo = info;
            processAll(ActionPoint.死之前);
        }

        for (final HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }

        if (isDead()) {
            processAll(ActionPoint.死之后);
        }

    }

    public void addSkill(final Skill s) {
        for (final ActionPoint actionPoint : s.actionPoint.keySet()) {
            skillMap.put(actionPoint, s);
        }
    }

    /**
     * 添加buff
     *
     * @param addBuff
     */
    public void addBuff(final Buff addBuff) {


        final Set<ActionPoint> values = addBuff.effectPoint.keySet();

        Buff added = null;
        for (final ActionPoint actionPoint : values) {
            Logs.trace("添加buff", this, actionPoint.name(), addBuff.name());

            final Collection<Buff> buffs = getBuffMap().get(actionPoint);

            final Optional<Buff> first = buffs.stream().filter(buff -> buff.getId() == addBuff.getId()).findFirst();
            if (first.isPresent()) {
                switch (first.get().calcBuffMergeType(addBuff)) {
                    case MERGE: {
                        final Buff buff = first.get();
                        buff.mergeBuff(addBuff);
                        Logs.trace("Buff存在合并");
                        added = buff;
                        break;
                    }
                    case REPLACE: {
                        buffMap.remove(actionPoint, first.get());
                        buffMap.put(actionPoint, addBuff);
                        Logs.trace("Buff存在替换");
                        added = addBuff;
                        break;
                    }
                }
            } else {
                added = addBuff;
                buffMap.put(actionPoint, addBuff);
            }
        }

        if (!added.isInfinite()) {
            buffCdMap.put(addBuff.reducePoint(), addBuff);
        }
        processAll(ActionPoint.增加buff后);
        if (addBuff.needReCalcProperty()) {
            calcBuffEffect(ActionPoint.重新计算属性);
        }
        addBuffRecord(added);
    }

    /**
     * 重新计算buff效果
     */
    public void calcBuffEffect(final ActionPoint point) {
        property = origin.copy();
        processBuff(point);
    }

    private void addBuffRecord(final Buff buff) {
        if (buff == null) {
            return;
        }
        final BuffData data = buff.buffData();
        final Record addBuffRecord = new Record(RecordType.BUFF_ADD);
        addBuffRecord.buffData = data;
        addBuffRecord.heroId = id;
        addBuffRecord.pos = pos.getIndex();

        battle.addRecord(addBuffRecord);
    }

    public HeroRecordSimple getSimple() {
        final HeroRecordSimple simple = new HeroRecordSimple();
        simple.id = id;
        simple.pos = pos;
        simple.hp = heroStats.hp;
        simple.angry = heroStats.angry;
        simple.name = getName();
        simple.level = level;
        return simple;
    }

    /**
     * 增加血量
     * todo
     *
     * @param num
     */
    public void addHp(final int num) {
        if (num <= 0) {
            return;
        }
        final HealthChangeInfo info = new HealthChangeInfo();
        info.setTarget(this);
        info.setOldValue(heroStats.hp);
        heroStats.hp += num;
        if (heroStats.hp > property.getMaxHp()) {
            heroStats.hp = property.getMaxHp();
        }
        info.setNewValue(heroStats.hp);

        addHpRecord(info.getNewValue() - info.getOldValue());

        for (final HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }
    }

    public boolean isFullHp() {
        return property.getMaxHp() == heroStats.hp;
    }

    private void addHpRecord(final int add) {
        final Record record = new Record(RecordType.HEALTH_CHANGE);
        record.heroId = id;
        record.pos = pos.getIndex();
        record.value = add;
        record.damageType = DamageType.DAMAGE_NONE;
        battle.addRecord(record);
    }

    public void addShield(final int round, final int v, final ActionPoint recordPoint) {
        heroStats.addShield(new ShieldInfo(round, v));
        recordShieldChange(recordPoint, v);
    }

    /**
     * 护盾变化通知
     *
     * @param recordPoint
     */
    public void recordShieldChange(final ActionPoint recordPoint, final int change) {
        final Record record = new Record(RecordType.SHIELD_CHANGE);
        record.heroId = id;
        record.pos = pos.getIndex();
        record.dp = DisplayPoint.DP_ATT_3;
        record.value = change;
        if (recordPoint != null) {
            delayRecord.put(recordPoint, record);
        } else {
            battle.addRecord(record);
        }
    }

    /**
     * 战斗记录
     *
     * @param info
     */
    private void addDamageRecord(final DamageInfo info) {
        Record record = new Record(RecordType.HEALTH_CHANGE);
        final HeroRecordSimple simple = info.target.getSimple();
        record.heroId = simple.id;
        record.pos = simple.pos.getIndex();
        record.dp = DisplayPoint.DP_DEF_1;
        record.value = info.sourceDamage * -1;
        record.damageType = DamageType.DAMAGE_NORMAL;
        battle.addRecord(record);

        // 暴击
        if (info.sourceCriticalDamage > 0) {
            record = new Record(RecordType.HEALTH_CHANGE);
            record.heroId = simple.id;
            record.dp = DisplayPoint.DP_DEF_1;
            record.pos = simple.pos.getIndex();
            record.value = info.sourceCriticalDamage * -1;
            record.damageType = DamageType.DAMAGE_CRITICAL;
            battle.addRecord(record);
        }
    }

    public HeroRecordData record() {
        final HeroRecordData d = new HeroRecordData();
        d.simple = getSimple();
        d.property = property;
        return d;
    }

    public Optional<Buff> findBuff(final int id) {
        return buffMap.values().stream().filter(buff -> buff.getId() == id).findFirst();
    }

    public boolean isDead() {
        return heroStats.hp <= 0;
    }

    public boolean isAlive() {
        return !isDead();
    }


    public boolean hasBuff(final int id) {
        return buffMap.values().stream().anyMatch(buff -> buff.getId() == id);
    }

    public Map<Integer, Hero> friends() {
        return battle.mySideHeroes(side);
    }

    public void addTargetStrategy(final FindTargetStrategy s) {
        targetStrategies.add(s);

    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(final Pos pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(final Battle battle) {
        this.battle = battle;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(final Side side) {
        this.side = side;
    }

    public Multimap<ActionPoint, Buff> getBuffMap() {
        return buffMap;
    }

    public Multimap<ActionPoint, Skill> getSkillMap() {
        return skillMap;
    }


    public int getHp() {
        return heroStats.hp;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public void setTalentInfo(final int talentInfo) {
        this.talentInfo = talentInfo;
    }

    public List<FindTargetStrategy> getTargetStrategies() {
        return targetStrategies;
    }

    public List<Hero> getTargetList() {
        return targetList;
    }

    public boolean isContinueAction() {
        return continueAction;
    }

    public void setContinueAction(final boolean continueAction) {
        this.continueAction = continueAction;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("fightingData", fightingData)
                .add("id", id)
                .add("pos", pos)
                .add("side", side)
                .add("hp", heroStats.hp)
                .toString();
    }

}
