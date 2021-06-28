package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 回合结束后恢复伤害的20%血量
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:55
 */
public class WeiyanSkill2 extends Skill {

    private int rate = 20;

    /**
     * 上次的伤害
     */
    private int damaged = 0;

    public WeiyanSkill2() {
        actionPoint.put(ActionPoint.受到伤害之后, 1);
        actionPoint.put(ActionPoint.回合结束后, 1);
        id = 12;
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.damageInfo;
        if (actionPoint == ActionPoint.受到伤害之后) {
            damaged += damageInfo.attackedDamage;
        } else if (actionPoint == ActionPoint.回合结束后) {

            if (damaged > 0 && hero.isAlive()) {
                final int addHp = CalcUtil.calcRateChangeValue(damaged, rate);
                if (addHp > 0) {
                    hero.addHp(addHp);
                }
                damaged = 0;
            }
        }


    }

    public void setRate(final int rate) {
        this.rate = rate;
    }
}
