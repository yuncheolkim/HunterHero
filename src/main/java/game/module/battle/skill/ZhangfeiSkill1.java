package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.ZhangfeiBuff1;
import game.module.battle.record.Record;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class ZhangfeiSkill1 extends Skill {

    public ZhangfeiSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 200001;
        name = "ZhangfeiSkill1";
        cd = Constant.INFINITE;
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);

        hero.addBuff(new ZhangfeiBuff1());

        return record;
    }
}
