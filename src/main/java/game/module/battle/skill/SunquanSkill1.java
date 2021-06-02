package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 每1回合恢复失去血量的20%血量
 *
 * @author Yunzhe.Jin
 * 2021/2/9 10:18
 */
public class SunquanSkill1 extends Skill {

    private final int rate = 20;

    public SunquanSkill1() {
        actionPoint.put(ActionPoint.回合结束后, 1);
        id = 200008;
        name = "克己";
        cd = Constant.INFINITE;
    }

    @Override
    public Record process(final ActionPoint actionPoint, final Hero hero) {
        final Record process = super.process(actionPoint, hero);

        final int maxHp = hero.property.getMaxHp();
        final int hp = hero.getHp();

        final int add = CalcUtil.calcRateAdd(maxHp - hp, rate);
        if (add <= 0) {
            return null;
        }
        hero.addHp(add);

        return process;
    }
}
