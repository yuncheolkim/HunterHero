package game.module.battle;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import game.base.Logs;
import game.module.battle.action.ActionPoint;
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

    public void init() {
        property = new HeroData().merge(origin);

    }

    public void setSpeed(int speed) {
        origin.setSpeed(speed);
    }

    public void processAll(ActionPoint actionPoint) {
        processAction(actionPoint);
        processSkill(actionPoint);
        processBuff(actionPoint);
    }

    /**
     * 执行动作
     *
     * @param actionPoint 相应的动作
     */
    public void processAction(ActionPoint actionPoint) {
        Collection<HeroActionPointHandler> pointHandler = actionMap.get(actionPoint);
        if (!pointHandler.isEmpty()) {
            Logs.trace("action", this, actionPoint);
            for (HeroActionPointHandler heroActionPointHandler : pointHandler) {
                heroActionPointHandler.handle(this);
            }
        }
    }

    public void addAction(ActionPoint actionPoint, HeroActionPointHandler h) {

        actionMap.put(actionPoint, h);

    }

    public void removeAction(ActionPoint actionPoint, HeroActionPointHandler h) {

        actionMap.remove(actionPoint, h);
    }

    /**
     * 查找目标
     */
    public List<Hero> findTarget() {

        List<Hero> list = new ArrayList<>();

        for (FindTargetStrategy targetStrategy : targetStrategies) {
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
        Record record = new Record(ACTION);
        record.heroId = id;
        record.pos = pos.getIndex();
        battle.addRecord(record);
        attack();
    }

    /**
     * 普通攻击
     */
    public void attack() {

        List<Hero> targetList = findTarget();

        for (Hero target : targetList) {
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

                calcAttack();
                processAction(ActionPoint.出手);
                // skill 主动技能
                boolean skillFire = processSkill(ActionPoint.出手);

                // 计算伤害
                Logs.trace("attack:", this.getSimple(), "--->", target.getSimple(), damageInfo);

                if (!skillFire) {// 普通攻击
                    attackRecord();

                    // 受到伤害
                    damage(damageInfo);
                }

                // action
                processAll(ActionPoint.出手后);
            } else {
                Logs.trace("无法行动", this);
            }

        }
    }

    /**
     * 对一个敌人造成伤害
     * 伤害可能来自技能，buff
     *
     * @param target 目标
     */
    public void damage(DamageInfo info) {
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
        fightingData = new HeroData().merge(property);
    }


    private void attackRecord() {
        Record attackRecord = new Record(ATTACK);
        HeroRecordSimple simple = damageInfo.source.getSimple();
        attackRecord.heroId = simple.id;
        attackRecord.pos = simple.pos.getIndex();
        attackRecord.targetList = Lists.newArrayList(damageInfo.target.getSimple().pos.getIndex());
        battle.addRecord(attackRecord);
    }

    /**
     * 执行buff
     */
    public void processBuff(ActionPoint actionPoint) {
        Collection<Buff> buffs = buffMap.get(actionPoint);
        if (buffs != null) {
            for (Buff buff : buffs) {
                buff.process(actionPoint, this);
            }
        }

        //检查回合
        Collection<Map.Entry<ActionPoint, Buff>> values = buffMap.entries();
        List<Map.Entry<ActionPoint, Buff>> removeValue = new ArrayList<>();
        for (Map.Entry<ActionPoint, Buff> entry : values) {
            if (entry.getValue().reducePoint() == actionPoint) {
                if (!entry.getValue().isActive()) {
                    removeValue.add(entry);
                }
            }
        }

        if (!removeValue.isEmpty()) {
            for (Map.Entry<ActionPoint, Buff> actionPointBuffEntry : removeValue) {
                removeBuff(actionPointBuffEntry.getKey(), actionPointBuffEntry.getValue());
            }
        }

    }

    /**
     * 移除buff
     */
    public void removeBuff(ActionPoint actionPoint, Buff buff) {
        Logs.trace("移除buff", buff);
        contextData = buff;
        Record record = new Record(RecordType.BUFF_REMOVE);
        record.actionPoint = actionPoint;
        record.heroId = id;
        record.pos = pos.getIndex();
        record.id = buff.getId();
        battle.addRecord(record);

        buffMap.remove(actionPoint, buff);
        // 重新计算增加buff的效果
        calcBuffEffect(ActionPoint.重新计算属性);
        processAll(ActionPoint.buff移除后);
        contextData = null;
    }


    /**
     * 执行技能
     */
    public boolean processSkill(ActionPoint actionPoint) {
        Collection<Skill> skills = skillMap.get(actionPoint);
        boolean fired = false;
        for (Skill skill : skills) {
            // 减少cd
            if (actionPoint == skill.reduceCoolDownPoint) {
                skill.reduceCoolDown(1);
            }

            if (skill.isReady() && skill.canProcess(this)) {
                Logs.trace("使用技能", this);

                // 使用技能
                Record record = skill.process(actionPoint, this);
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
    public void attacked(DamageInfo info) {
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
            Record record = new Record(RecordType.AVOID);
            record.heroId = id;
            record.pos = pos.getIndex();
            battle.addRecord(record);
            processAll(ActionPoint.闪避之后);
        } else {
            // 计算buff
            processAll(ActionPoint.受到伤害之前);
            info.attackedDamage = (info.allSourceDamage());
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
    public void reduceHp(DamageInfo i) {
        Hero target = i.target;
        int num = i.attackedDamage;
        HealthChangeInfo info = new HealthChangeInfo();
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

        for (HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }

        if (isDead()) {
            processAll(ActionPoint.死之后);
        }

    }

    public void addSkill(Skill s) {
        for (ActionPoint actionPoint : s.actionPoint.keySet()) {
            skillMap.put(actionPoint, s);
        }
    }

    /**
     * 添加buff
     *
     * @param addBuff
     */
    public void addBuff(Buff addBuff) {


        Set<ActionPoint> values = addBuff.effectPoint.keySet();

        Buff added = null;
        for (ActionPoint actionPoint : values) {
            Logs.trace("添加buff", this, actionPoint.name(), addBuff.name());

            Collection<Buff> buffs = getBuffMap().get(actionPoint);

            Optional<Buff> first = buffs.stream().filter(buff -> buff.getId() == addBuff.getId()).findFirst();
            if (first.isPresent()) {
                switch (first.get().calcBuffMergeType(addBuff)) {
                    case MERGE: {
                        Buff buff = first.get();
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
        processAll(ActionPoint.增加buff后);
        calcBuffEffect(ActionPoint.重新计算属性);
        addBuffRecord(added);
    }

    /**
     * 重新计算buff效果
     */
    public void calcBuffEffect(ActionPoint point) {
        property = new HeroData().merge(origin);
        processAll(point);
    }

    private void addBuffRecord(Buff buff) {
        if (buff == null) {
            return;
        }
        BuffData data = buff.buffData();
        Record addBuffRecord = new Record(RecordType.BUFF_ADD);
        addBuffRecord.buffData = data;
        addBuffRecord.heroId = id;
        addBuffRecord.pos = pos.getIndex();

        battle.addRecord(addBuffRecord);
    }

    public HeroRecordSimple getSimple() {
        HeroRecordSimple simple = new HeroRecordSimple();
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
    public void addHp(int num) {
        HealthChangeInfo info = new HealthChangeInfo();
        info.setTarget(this);
        info.setOldValue(heroStats.hp);
        heroStats.hp += num;
        if (heroStats.hp > property.getMaxHp()) {
            heroStats.hp = property.getMaxHp();
        }
        info.setNewValue(heroStats.hp);

        addHpRecord(info.getNewValue() - info.getOldValue());

        for (HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }
    }

    private void addHpRecord(int add) {
        Record record = new Record(RecordType.HEALTH_CHANGE);
        record.heroId = id;
        record.pos = pos.getIndex();
        record.value = add;
        record.damageType = DamageType.DAMAGE_NONE;
        battle.addRecord(record);
    }

    /**
     * 战斗记录
     *
     * @param info
     */
    private void addDamageRecord(DamageInfo info) {
        Record record = new Record(RecordType.HEALTH_CHANGE);
        HeroRecordSimple simple = info.target.getSimple();
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
        HeroRecordData d = new HeroRecordData();
        d.simple = getSimple();
        d.property = property;
        return d;
    }

    public Optional<Buff> findBuff(int id) {
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

    public void addTargetStrategy(FindTargetStrategy s) {
        targetStrategies.add(s);

    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTalentInfo(int talentInfo) {
        this.talentInfo = talentInfo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("property", property)
                .add("id", id)
                .add("pos", pos)
                .add("side", side)
                .add("hp", heroStats.hp)
                .toString();
    }

}
