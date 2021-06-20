package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.find.MultipleBackTargetStrategy;
import game.module.battle.find.MultipleFrontTargetStrategy;
import game.module.battle.record.Record;

/**
 * 多重箭,可以同时打多个目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class HuanzhongSkill1 extends Skill {

    /**
     * 攻击目标数量
     */
    private int count = 2;

    public HuanzhongSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 10;
        name = "多重箭";
        cd = Constant.INFINITE;
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
        hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));
        return null;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
