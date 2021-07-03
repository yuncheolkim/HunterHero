package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/7/3 12:53
 */
public class XiaHouDunSkill1 extends Skill {
    public XiaHouDunSkill1() {
        super(25);
        actionPoint.put(ActionPoint.受到伤害之后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 受到伤害之后:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                if (damageInfo.source == hero) {
                    return;
                }
                final DamageInfo damage = new DamageInfo();
                damage.sourceId = id;
                damage.type = DamageType.DAMAGE_SKILL;
                damage.source = hero;
                damage.target = damageInfo.source;
                final float rate = hero.hpLoseRate();
                damage.sourceDamage = CalcUtil.add100(damageInfo.allSourceDamage(), rate);

                damageInfo.source.damage(damage);

                break;
        }
    }
}
