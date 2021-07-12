package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 护甲穿透
 * <p>
 * 0:护甲穿透万分比
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class HuanzhongSkill2 extends Skill {

    public HuanzhongSkill2() {
        super(5);
        actionPoint.put(ActionPoint.开场, 1);
        data[0] *= 100;
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        hero.origin.setDefReduce(hero.origin.getDefReduce() + data[0]);
        hero.property.setDefReduce(hero.origin.getDefReduce());

    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

}
