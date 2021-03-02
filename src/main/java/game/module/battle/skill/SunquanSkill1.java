package game.module.battle.skill;

import game.utils.CalcUtil;
import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.UseSkillRecord;

/**
 * 每1回合恢复失去血量的20%血量
 * @author Yunzhe.Jin
 * 2021/2/9 10:18
 */
public class SunquanSkill1 extends Skill {

    private int rate = 20;

    public SunquanSkill1() {
        actionPoint.put(ActionPoint.回合结束后, 1);
        id = 200008;
        name = "克己";
        cd = Constant.INFINITE;
    }

    @Override
    public UseSkillRecord process(ActionPoint actionPoint, Hero hero) {
        UseSkillRecord process = super.process(actionPoint, hero);

        int maxHp = hero.property.getMaxHp();
        int hp = hero.getHp();

        int add = CalcUtil.calcRateAdd(maxHp - hp, rate);
        if (add <= 0) {
            return null;
        }
        hero.addHp(add);

        return process;
    }
}
