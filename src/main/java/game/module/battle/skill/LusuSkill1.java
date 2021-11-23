package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.find.MultipleBackTargetStrategy;
import game.module.battle.find.MultipleFrontTargetStrategy;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 冰锥,攻击8目标20%伤害,对冰冻目标造成额外100%伤害
 * <p>
 * 0: 数量
 * 1: 伤害
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class LusuSkill1 extends Skill {


    public LusuSkill1() {
        super(20);
        actionPoint.put(ActionPoint.开场, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 开场:
                final int count = data[0];
                final int rate = data[1];
                hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
                hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));
                hero.origin.damage = CalcUtil.change100(hero.origin.damage, rate);
                hero.property.damage = CalcUtil.change100(hero.property.damage, rate);
                break;
        }

    }


    public void talent1(final int id) {
        data[1] = id;
    }
}
