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
 * 0:增加暴击比例
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class MachaoSkill1 extends Skill {

    /**
     * 当前累计暴击
     */
    private int critical;


    public MachaoSkill1() {
        super(15);
        actionPoint.put(ActionPoint.暴击之后, 1);
        actionPoint.put(ActionPoint.受到伤害之后, 1);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    protected void process(Record record, ActionPoint actionPoint, Hero hero) {

        switch (actionPoint) {
            case 暴击之后:
                critical = 0;
                break;
            case 受到伤害之后:
                critical += data[0];
                break;
            case 出手前:
                if (critical > 0) {
                    hero.fightingData.setCritical(CalcUtil.final100(hero.fightingData.getCritical(), critical));
                }
                break;
        }
    }

    public void talent1(int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
