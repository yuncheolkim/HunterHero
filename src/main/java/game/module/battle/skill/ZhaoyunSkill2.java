package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 有20%概率攻击2次
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class ZhaoyunSkill2 extends Skill {

    public ZhaoyunSkill2() {
        id = 7;
        actionPoint.put(ActionPoint.回合开始前, 1);
    }

    @Override
    protected void process(Record record, ActionPoint actionPoint, Hero hero) {
        
    }
}
