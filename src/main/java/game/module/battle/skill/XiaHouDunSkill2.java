package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 获得失去血量的{0}%防御
 * <p>
 * 0:百分比
 *
 * @author Yunzhe.Jin
 * 2021/7/3 12:53
 */
public class XiaHouDunSkill2 extends Skill {
    public XiaHouDunSkill2() {
        super(26);
        actionPoint.put(ActionPoint.被攻击之前, 1);

    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 被攻击之前:
                float rate = hero.hpLoseRate();
                rate = CalcUtil.change100(rate, data[0]);
                hero.fightingData.def += CalcUtil.change100(hero.fightingData.def, rate);
                break;
        }
    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
