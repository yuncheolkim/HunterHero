package game.module.battle;

import com.google.common.base.MoreObjects;
import game.base.Logs;
import game.config.data.SkillConfigData;
import game.manager.ConfigManager;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.HeroRecordSimple;
import game.module.battle.record.Record;
import game.proto.data.RecordType;

import java.util.*;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 14:27
 */
public abstract class Skill {
    protected int id;

    /**
     * 技能配置
     */
    protected SkillConfigData config;

    /**
     * 冷却时间
     */
    protected CoolDown cd;

    /**
     * 减少冷却时间时机
     */
    protected List<ActionPoint> reduceCoolDownPoint = new ArrayList<>(2);

    /**
     * 触发时机
     */
    public Map<ActionPoint, Integer> actionPoint = new HashMap<>(4);

    /**
     * 配置数据
     */
    protected int[] data;

    /**
     * 是否需要记录数据
     */
    protected boolean needRecord;

    public Skill(final int id) {
        this.id = id;
        config = ConfigManager.skillDataBox.findById(id);

        if (config.data != null) {
            this.data = Arrays.copyOf(config.data, config.data.length);
        }
        cd = config.getCd();
        if (cd.getCd() > 0) {
            reduceCoolDownPoint.add(ActionPoint.回合开始前);
        }
    }

    public Record process(final ActionPoint actionPoint, final Hero hero) {

        Record record = null;
        if (needRecord) {
            record = new Record(RecordType.SKILL_USE);
            final HeroRecordSimple simple = hero.getSimple();
            record.heroId = simple.id;
            record.pos = simple.pos.getIndex();
            record.id = id;
            record.actionPoint = actionPoint;
        }

        process(record, actionPoint, hero);

        return record;
    }

    protected abstract void process(final Record record, final ActionPoint actionPoint, final Hero hero);

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

    public void addCdPoint(final ActionPoint point) {
        reduceCoolDownPoint.add(point);
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
        return config.priority;
    }

    public CoolDown getCd() {
        return cd;
    }

    public void setCd(final CoolDown cd) {
        this.cd = cd;
    }

    public String getName() {
        return ConfigManager.skillDataBox.findById(id).name;
    }

    public SkillType getSkillType() {
        return config.skillType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("priority", config.priority)
                .add("cd", cd)
                .add("actionPoint", actionPoint)
                .add("reduceCoolDownPoint", reduceCoolDownPoint)
                .add("name", getName())
                .toString();
    }

}
