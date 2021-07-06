package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 造成伤害吸血
 * 0:吸血比例
 *
 * @author Yunzhe.Jin
 * 2021/7/5 16:43
 */
public class DamageBloodSkill extends Skill {

    public DamageBloodSkill() {
        super(1004);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 出手后:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final int i = damageInfo.allSourceDamage();

                final int addHp = CalcUtil.change100(i, data[0]);

                hero.addHp(addHp);
                break;
        }

    }

    public void setBloodRate(final int rate) {
        data[0] = rate;
    }
}
