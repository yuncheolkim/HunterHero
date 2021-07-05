package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 减少暴击概率
 * 0:吸血比例
 *
 * @author Yunzhe.Jin
 * 2021/7/5 16:43
 */
public class CriticalReduceSkill extends Skill {

    public CriticalReduceSkill() {
        super(1004);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 出手后:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final int i = damageInfo.allSourceDamage();

                final int addHp = CalcUtil.add100(i, data[0]);

                hero.addHp(addHp);
                break;
        }

    }

    public void setBloodRate(final int rate) {
        data[0] = rate;
    }
}
