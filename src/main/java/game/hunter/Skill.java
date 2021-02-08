package game.hunter;

import com.google.common.base.MoreObjects;
import game.hunter.action.ActionPoint;
import game.hunter.record.UseSkillRecord;

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
    protected CoolDown cd = Constant.INFINITE;

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

    public UseSkillRecord process(ActionPoint actionPoint, Hero hero) {
        UseSkillRecord record = new UseSkillRecord(id);
        record.hero = hero.getSimple();
        record.skillId = id;
        record.actionPoint = actionPoint;

        return record;
    }

    /**
     * 能不能使用技能
     * @param hero
     * @return
     */
    public boolean canProcess(Hero hero) {
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
     * @param round
     */
    public void reduceCoolDown(int round) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public CoolDown getCd() {
        return cd;
    }

    public void setCd(CoolDown cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
