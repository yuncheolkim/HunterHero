package game.module.battle;

import com.google.common.base.MoreObjects;
import game.base.Logs;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.HeroRecordSimple;
import game.module.battle.record.Record;
import game.proto.data.RecordType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:27
 */
public class Skill {
    protected int id;

    /**
     * 优先级
     * 数字越低优先级越高
     */
    protected int priority;

    /**
     * 冷却时间
     */
    protected CoolDown cd = BattleConstant.INFINITE;

    /**
     * 触发时机
     */
    public Map<ActionPoint, Integer> actionPoint = new HashMap<>();

    /**
     * 减少冷却时间时机
     */
    protected ActionPoint reduceCoolDownPoint = ActionPoint.回合开始前;

    /**
     * 技能名
     */
    protected String name;

    protected SkillType skillType = SkillType.B;

    public Record process(final ActionPoint actionPoint, final Hero hero) {
        final Record record = new Record(RecordType.SKILL_USE);
        final HeroRecordSimple simple = hero.getSimple();
        record.heroId = simple.id;
        record.pos = simple.pos.getIndex();
        record.id = id;
        record.actionPoint = actionPoint;

        process(record, actionPoint, hero);

        return record;
    }

    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
    }

    /**
     * 能不能使用技能
     *
     * @param hero
     * @return
     */
    public boolean canProcess(final Hero hero) {
        return true;
    }

    /**
     * 使技能冷却
     */
    public void fireCoolDown() {
        cd.cold();
    }

    /**
     * 减少cd
     *
     * @param round
     */
    public void reduceCoolDown(final int round) {
        Logs.trace("减少cd", this, round);
        cd.reduce(round);
    }

    /**
     * 重置冷却
     */
    public void resetCoolDown() {
        cd.reset();
    }

    public boolean isReady() {
        return cd.ready();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public CoolDown getCd() {
        return cd;
    }

    public void setCd(final CoolDown cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("priority", priority)
                .add("cd", cd)
                .add("actionPoint", actionPoint)
                .add("reduceCoolDownPoint", reduceCoolDownPoint)
                .add("name", name)
                .toString();
    }
}
