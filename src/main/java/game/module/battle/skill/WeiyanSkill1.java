package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 吸血30%伤害, 不受buff影响
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:55
 */
public class WeiyanSkill1 extends Skill {

    private int rate = 30;

    public WeiyanSkill1() {
        actionPoint.put(ActionPoint.出手后, 1);
        id = 10;
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.damageInfo;
        final int i = damageInfo.allSourceDamage();

        final int addHp = CalcUtil.calcRateChangeValue(i, rate);

        if (addHp > 0 && !hero.isFullHp()) {
            hero.addHp(addHp);
        }
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }
}
