package game.module.battle.skill;

import game.manager.ConfigManager;
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
public class HuanzhongSkill1 extends Skill {


    public HuanzhongSkill1() {
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
            hero.fightingData.damage = CalcUtil.add100(hero.fightingData.damage, rate);
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

    public void talent1(int id) {
        data[0] += ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent3(int id) {
        data[0] += ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent4(int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
        data[3] = ConfigManager.talentDataBox.findById(id).i2;
    }

    public void talent5(int id) {
        data[4] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
