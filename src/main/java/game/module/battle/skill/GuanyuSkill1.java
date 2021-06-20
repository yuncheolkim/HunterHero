package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.OneAttackBuff;
import game.module.battle.buff.data.OneAttackBuffData;
import game.module.battle.record.Record;

/**
 * 关羽技能1
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill1 extends Skill {
    private OneAttackBuffData data;

    public GuanyuSkill1() {
        id = 200002;
        name = "GuanyuSkill1";
        actionPoint.put(ActionPoint.出手后, 1);
        priority = 1;

    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);
        OneAttackBuffData d = new OneAttackBuffData();
        d.setStack(data.getStack());
        d.setCurrent(data.getCurrent());
        hero.addBuff(new OneAttackBuff(hero.damageInfo.target, d));
        return record;
    }

    public void setData(OneAttackBuffData data) {
        this.data = data;
    }
}
