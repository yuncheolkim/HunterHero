package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 每次被攻击增加10%暴击 如果暴击敌人,则清除效果
 * <p>
 * 0: 增加暴击比例
 * 1: 暴击固定回合数 - T
 * 2: 减少最大生命 - T
 * 3: 提高暴击 - T
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class MachaoSkill1 extends Skill {

    /**
     * 当前累计暴击
     */
    private int critical;

    private int round;


    public MachaoSkill1() {
        super(15);
        actionPoint.put(ActionPoint.暴击之后, 1);
        actionPoint.put(ActionPoint.受到伤害之后, 1);
        actionPoint.put(ActionPoint.出手前, 1);
        actionPoint.put(ActionPoint.开场, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 出手前:
                final int datum = data[1];
                if (datum > 0) {
                    if (++round == datum) {
                        round = 0;
                        hero.fightingData.mustCritical = true;
                    }
                } else if (critical > 0) {
                    hero.fightingData.setCritical(CalcUtil.final100(hero.fightingData.getCritical(), critical));
                }
                break;
            case 暴击之后:
                critical = 0;
                break;
            case 受到伤害之后:
                critical += data[0];
                break;
            case 开场:
                hero.origin.maxHp -= CalcUtil.change100(hero.origin.maxHp, data[2]);
                hero.origin.critical = CalcUtil.final100(hero.origin.critical, data[3]);
                hero.property.maxHp = hero.origin.maxHp;
                hero.property.critical = hero.origin.critical;
                break;
        }
    }

    public void talent1(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
        data[3] = ConfigManager.talentDataBox.findById(id).i2;
    }
}
