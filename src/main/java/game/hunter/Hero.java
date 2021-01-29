package game.hunter;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import game.hunter.action.ActionPoint;
import game.hunter.buff.Buff;
import game.hunter.damage.DamageInfo;
import game.hunter.damage.DamageSourceType;
import game.hunter.record.*;
import game.hunter.status.HealthChangeInfo;
import game.hunter.status.HeroStatusChangeListener;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:23
 */
public class Hero {

    /**
     * 英雄id
     */
    protected int id;

    /**
     * 所在位置
     */
    protected Pos pos;

    /**
     * 血量
     */
    protected int hp;

    /**
     * 最初属性英雄数据
     */
    protected HeroData originData;

    /**
     * 中间状态
     */
    protected HeroData processData = new HeroData();

    /**
     * 最终属性数据
     */
    protected HeroData finalData;

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
    protected Map<ActionPoint, HeroActionPointHandler> actionMap = new HashMap<>();

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
     * 能否行动
     */
    protected boolean canActive = true;

    /**
     * 当前目标
     */
    private Hero currentTarget;

    public void init() {
        finalData = new HeroData();
        finalData.merge(originData);
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
        HeroActionPointHandler pointHandler = actionMap.get(actionPoint);
        if (pointHandler != null) {
            Logs.trace("action", this, actionPoint);
            pointHandler.handle(this);
        }
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
            return battle.oppositeHeroes(side).stream().filter(Hero::isAlive).collect(Collectors.toList());
        }

        return list;
    }

    /**
     * 出手
     */
    public void attack() {

        List<Hero> targetList = findTarget();

        for (Hero target : targetList) {

            this.currentTarget = target;
            DamageInfo damageInfo = new DamageInfo();
            damageInfo.setType(DamageSourceType.ATTACK);
            this.battle.setDamageInfo(damageInfo);
            damageInfo.setOrigin(this);
            damageInfo.setCurrent(this);
            damageInfo.setTarget(target);

            // action
            processAction(ActionPoint.出手前);
            // skill
            processSkill(ActionPoint.出手前);
            // buff
            processBuff(ActionPoint.出手前);

            mergeToFinal();

            if (this.canActive) {

                processAction(ActionPoint.出手);
                // skill 主动技能
                boolean skillFire = processSkill(ActionPoint.出手);

                calcAttack();
                calcSourceDamage(damageInfo);
                // 计算伤害
                Logs.trace("attack:", this.getSimple(), "--->", target.getSimple(), damageInfo);

                if (!skillFire) {// 普通攻击
                    attackRecord();

                    // 受到伤害
                    damage(target, damageInfo);
                }

                // action
                processAction(ActionPoint.出手后);
                // skill
                processSkill(ActionPoint.出手后);
                // buff
                processBuff(ActionPoint.出手后);
            } else {
                Logs.trace("无法行动", this);
            }

            // 清理中间数据
            this.resetData();
            target.resetData();

        }
    }

    /**
     * 对一个敌人造成伤害
     * 伤害可能来自技能，buff
     *
     * @param target 目标
     */
    public void damage(Hero target, DamageInfo info) {
        target.attacked(info);
    }

    public void calcAttack() {
        battle.calcAttack(this);

    }

    private void attackRecord() {
        AttackRecord attackRecord = new AttackRecord();
        DamageInfo damageInfo = battle.getDamageInfo();
        attackRecord.source = damageInfo.getOrigin().getSimple();
        attackRecord.target = damageInfo.getTarget().getSimple();
        battle.addRecord(attackRecord);
    }

    public void resetData() {
        processData = new HeroData();
        canActive = true;
        // 血量不重置
        finalData = new HeroData();
        finalData.merge(originData);
    }

    /**
     * 执行buff
     */
    public void processBuff(ActionPoint actionPoint) {
        Collection<Buff> buffs = buffMap.get(actionPoint);
        if (buffs != null) {
            for (Buff buff : buffs) {
                buff.process(this);
            }
        }

        //检查回合
        Collection<Map.Entry<ActionPoint, Buff>> values = buffMap.entries();
        List<Map.Entry<ActionPoint, Buff>> removeValue = new ArrayList<>();
        for (Map.Entry<ActionPoint, Buff> entry : values) {
            if (entry.getValue().reducePoint() == actionPoint) {
                if (entry.getValue().reduceRound() == 0) {
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
        RemoveBuffRecord record = new RemoveBuffRecord();
        record.actionPoint = actionPoint;
        record.hero = getSimple();
        record.id = buff.getId();
        battle.addRecord(record);

        buffMap.remove(actionPoint, buff);
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
                UseSkillRecord record = skill.process(this);
                battle.addRecord(record);
                // 冷却
                skill.fireCoolDown();
                record.cd = skill.cd;
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
        Logs.trace("attacked:", this);

        // 计算buff
        processBuff(ActionPoint.受到伤害之前);

        battle.calcAttackedProcess(this);

        calcFinalDamage(info);
        // 减血
        reduceHp(info.getAttackedDamage());

        processBuff(ActionPoint.受到伤害之后);
    }

    /**
     * 计算最终伤害
     *
     * @param info
     */
    public void calcSourceDamage(DamageInfo info) {

        // 最终伤害合并计算
        HeroData finalData = info.getCurrent().getFinalData();
        int damage = finalData.getDamage() + finalData.getCriticalDamage();
        damage += processData.getDamage() + processData.getCriticalDamage();
        info.setSourceDamage(damage);
    }

    /**
     * 计算最终伤害
     *
     * @param info
     */
    public void calcFinalDamage(DamageInfo info) {
        info.setAttackedDamage(info.getSourceDamage());
    }


    /**
     * 最终减少的血量，所有减血操作都要通过这个方法，不能直接修改属性
     *
     * @param num
     */
    public void reduceHp(int num) {
        HealthChangeInfo info = new HealthChangeInfo();
        info.setTarget(this);
        info.setOldValue(hp);

        hp -= num;
        info.setNewValue(hp);

        addHpChangeRecord(num * -1);
        Logs.trace("reduceHp", info);
        if (info.getNewValue() <= 0) {
            deadInfo = info;
            processAction(ActionPoint.死之前);
        }

        for (HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }

        if (isDead()) {
            processAction(ActionPoint.死之后);
        }

    }

    public void addSkill(Skill s) {
        skillMap.put(s.actionPoint, s);
    }

    /**
     * 添加buff
     *
     * @param addBuff
     */
    public void addBuff(Buff addBuff) {


        ActionPoint actionPoint = addBuff.getActionPoint();

        Logs.trace("添加buff", this, actionPoint.name(), addBuff.name());

        Collection<Buff> buffs = getBuffMap().get(actionPoint);

        Optional<Buff> first = buffs.stream().filter(buff -> buff.getId() == addBuff.getId()).findFirst();
        Buff added = null;
        if (first.isPresent()) {
            switch (first.get().calcBuffMergeType(addBuff)) {
                case MERGE: {
                    Buff buff = first.get();
                    if (buff.canMerge(addBuff)) {
                        buff.mergeBuff(addBuff);
                        Logs.trace("Buff存在合并");
                    }
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
            processAll(ActionPoint.增加buff后);
        }

        addBuffRecord(added);
    }

    private void addBuffRecord(Buff buff) {
        if (buff == null) {
            return;
        }
        BuffData data = buff.buffData();
        AddBuffRecord addBuffRecord = new AddBuffRecord();
        addBuffRecord.buffData = data;
        addBuffRecord.hero = getSimple();

        battle.addRecord(addBuffRecord);
    }

    public HeroRecordSimple getSimple() {
        HeroRecordSimple simple = new HeroRecordSimple();
        simple.id = id;
        simple.pos = pos;
        simple.hp = hp;
        return simple;
    }

    /**
     * 增加血量
     *
     * @param num
     */
    public void addHp(int num) {
        HealthChangeInfo info = new HealthChangeInfo();
        info.setTarget(this);
        info.setOldValue(hp);
        hp += num;
        info.setNewValue(hp);
        if (hp > finalData.getMaxHp()) {
            hp = finalData.getMaxHp();
        }
        addHpChangeRecord(hp - info.getOldValue());

        for (HeroStatusChangeListener statusChangeListener : statusChangeListeners) {
            statusChangeListener.changHp(info);
        }
    }

    /**
     * 战斗记录
     *
     * @param hp
     */
    private void addHpChangeRecord(int hp) {
        HealthChangeRecord record = new HealthChangeRecord();
        record.hero = getSimple();
        record.value = hp;

        battle.addRecord(record);
    }

    /**
     * 根据中间状态计算最终属性值
     */
    public void mergeToFinal() {
        finalData.merge(processData);
    }

    public HeroRecordData record() {
        HeroRecordData d = new HeroRecordData();
        d.simple = getSimple();
        d.hp = hp;
        d.originData = originData;
        d.processData = new HeroData().merge(processData);
        return d;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public boolean isAlive() {
        return !isDead();
    }

    public HeroData getOriginData() {
        return originData;
    }

    public void setOriginData(HeroData originData) {
        this.originData = originData;
    }

    public HeroData getFinalData() {
        return finalData;
    }

    public void setFinalData(HeroData finalData) {
        this.finalData = finalData;
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

    public HeroData getProcessData() {
        return processData;
    }

    public void setProcessData(HeroData processData) {
        this.processData = processData;
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

    public boolean isCanActive() {
        return canActive;
    }

    public void setCanActive(boolean canActive) {
        this.canActive = canActive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public Hero getCurrentTarget() {
        return currentTarget;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hp", hp)
                .add("id", id)
                .add("pos", pos)
                .add("originData", originData)
                .add("processData", processData)
                .add("finalData", finalData)
                .add("side", side)
                .add("canActive", canActive)
                .toString();
    }
}
