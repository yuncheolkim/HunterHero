package game.module.battle.skill;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;

import static game.module.battle.action.ActionPoint.暴击后;

/**
 * 消耗{0}点能量必暴击
 * <p>
 * 0: 暴能条件数量
 * 1: 暴击伤害增加量 - T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class JiangWeiSkill3 extends Skill {

    private int power;

    public JiangWeiSkill3() {
        super(52);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                if (power >= data[0]) {
                    Logs.trace("JiangWeiSkill3  触发必暴", power, data[0]);
                    hero.fightingData.mustCritical = true;
                    power -= data[0];
                }
                break;
            case 暴击后:
                if (hero.fightingData.mustCritical) {
                    final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                    Logs.trace("天赋：增加暴击伤害>>>", damageInfo);
                    damageInfo.addCriticalDamage(data[1]);
                    Logs.trace("天赋：增加暴击伤害<<<", damageInfo);
                }
                break;
        }
    }

    public void addPower(final int v) {
        power += v;
    }

    /**
     * 3点能量后暴击
     *
     * @param v
     */
    public void talent1(final int v) {
        data[0] = v;
    }

    /**
     * 能量暴击伤害提高50%
     *
     * @param v
     */
    public void talent2(final int v) {
        data[1] = v;
        addActionPoint(暴击后);
    }
}
