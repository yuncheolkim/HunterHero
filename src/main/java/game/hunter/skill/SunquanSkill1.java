package game.hunter.skill;

import game.hunter.CalcUtil;
import game.hunter.Constant;
import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.record.UseSkillRecord;

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
