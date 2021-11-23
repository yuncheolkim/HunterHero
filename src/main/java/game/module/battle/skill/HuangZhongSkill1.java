package game.module.battle.skill;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.find.MultipleBackTargetStrategy;
import game.module.battle.find.MultipleFrontTargetStrategy;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 多重箭,可以同时打多个目标
 * 0:个数
 * 1:伤害比例
 * 2:额外发射概率 - T
 * 3:额外发射数量 - T
 * 4:额外伤害 - T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class HuangZhongSkill1 extends Skill {


    public HuangZhongSkill1() {
        super(4);
        actionPoint.put(ActionPoint.开场, 1);
        actionPoint.put(ActionPoint.出手前, 1);
        actionPoint.put(ActionPoint.回合开始前, 1);
    }


    @Override
    protected void process(final Record record, final ActionPoint point, final Hero hero) {

        final int count = data[0];
        final int rate = data[1] + data[4];
        final int happenRate = data[2];
        final int happenCount = data[3];
        if (point == ActionPoint.出手前) {
            hero.fightingData.damage = CalcUtil.change100(hero.fightingData.damage, rate);
        } else if (point == ActionPoint.回合开始前) {
            if (happenRate == 0) {
                return;
            }
            final boolean h1 = CalcUtil.happened100(happenRate);
            int add = 0;
            if (h1) {
                add = happenCount;
            }
            for (final FindTargetStrategy targetStrategy : hero.getTargetStrategies()) {
                if (targetStrategy instanceof MultipleBackTargetStrategy) {
                    ((MultipleBackTargetStrategy) targetStrategy).setAdd(add);
                }
                if (targetStrategy instanceof MultipleFrontTargetStrategy) {
                    ((MultipleFrontTargetStrategy) targetStrategy).setAdd(add);
                }
            }
        } else if (point == ActionPoint.开场) {
            hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
            hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));
        }
    }

    public void talent1(final int v) {
        data[0] += v;
    }

    public void talent2(final int v) {
        data[1] = v;
    }

    public void talent3(final int v) {
        data[0] += v;
    }

    public void talent4(final int i1, int i2) {
        data[2] = i1;
        data[3] = i2;
    }

    public void talent5(final int i1) {
        data[4] = i1;
    }
}
