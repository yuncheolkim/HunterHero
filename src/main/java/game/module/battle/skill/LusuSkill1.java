package game.module.battle.skill;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.find.MultipleBackTargetStrategy;
import game.module.battle.find.MultipleFrontTargetStrategy;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 冰锥,攻击8目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class LusuSkill1 extends Skill {

    /**
     * 攻击目标数量
     */
    private int count = 8;

    /**
     * 伤害
     */
    private int rate = 20;

    public LusuSkill1() {
        actionPoint.put(ActionPoint.开场, 1);
        id = 10;
        name = "冰锥";
        cd = BattleConstant.INFINITE;
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
        hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));

        hero.addAction(ActionPoint.开场, h -> {
            h.property.damage = CalcUtil.calcRateChangeValue(h.property.damage, rate);
        });

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
}
