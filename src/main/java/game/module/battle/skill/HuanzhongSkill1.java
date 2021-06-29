package game.module.battle.skill;

import game.module.battle.BattleConstant;
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
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class HuanzhongSkill1 extends Skill {

    /**
     * 攻击目标数量
     */
    private int count = 2;

    /**
     * 伤害
     */
    private int rate = 60;

    /**
     * 额外发射率
     */
    private int happenRate = 0;

    /**
     * 额外发射数量
     */
    private int happenCount = 0;

    public HuanzhongSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 10;
        name = "多重箭";
        cd = BattleConstant.INFINITE;
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
        hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));

        hero.addAction(ActionPoint.开场, h -> {
            h.property.damage = CalcUtil.calcRateChangeValue(h.property.damage, rate);
        });

        if (happenRate > 0) {
            final int happen = happenRate;
            final int c = happenCount;
            hero.addAction(ActionPoint.回合开始前, h -> {

                final boolean h1 = CalcUtil.happened100(happen);

                int add = 0;
                if (h1) {
                    add = c;
                }
                for (final FindTargetStrategy targetStrategy : hero.getTargetStrategies()) {
                    if (targetStrategy instanceof MultipleBackTargetStrategy) {
                        ((MultipleBackTargetStrategy) targetStrategy).setAdd(add);
                    }
                    if (targetStrategy instanceof MultipleFrontTargetStrategy) {
                        ((MultipleFrontTargetStrategy) targetStrategy).setAdd(add);
                    }
                }
            });
        }

        return null;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public void addCount(final int c) {
        this.count += c;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void addRate(final int rate) {
        this.rate += rate;
    }

    public void setHappenRate(final int happenRate) {
        this.happenRate = happenRate;
    }

    public void setHappenCount(final int happenCount) {
        this.happenCount = happenCount;
    }
}
