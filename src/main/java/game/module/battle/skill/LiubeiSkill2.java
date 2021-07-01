package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LiubeiBuff2;
import game.module.battle.record.Record;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill2 extends Skill {

    public LiubeiSkill2() {
        super(1);
        actionPoint.put(ActionPoint.开场, 1);
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);

        hero.addBuff(new LiubeiBuff2());

        return record;
    }
}
