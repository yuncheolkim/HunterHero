package game.module.battle.skill;

import game.base.Logs;
import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

import static game.module.battle.action.ActionPoint.受到伤害之前;
import static game.module.battle.action.ActionPoint.回合开始前;

/**
 * 0: 反弹比例
 * 1: 减少伤害回合
 * 2: 减少伤害比例
 * 3: 增加护盾量
 * 4: 回合数
 *
 * @author Yunzhe.Jin
 * 2021/7/3 12:53
 */
public class XiaHouDunSkill1 extends Skill {

    private int round;

    public XiaHouDunSkill1() {
        super(25);
        actionPoint.put(ActionPoint.受到伤害之后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        if (damageInfo.origin == hero) {
            return;
        }
        switch (actionPoint) {
            case 受到伤害之后:
                final DamageInfo damage = new DamageInfo();
                damage.sourceId = id;
                damage.type = DamageType.DAMAGE_SKILL;
                damage.source = hero;
                damage.origin = damageInfo.origin;
                damage.target = damageInfo.source;
                float rate = hero.hpLoseRate();
                rate = CalcUtil.final100(rate, data[0]);

                damage.sourceDamage = CalcUtil.add100(damageInfo.allSourceDamage(), rate);

                damageInfo.source.damage(damage);

                if (data[3] > 0) {
                    final int addShield = CalcUtil.add100(damage.sourceDamage, data[3]);
                    hero.addShield(data[4], addShield, null);
                }
                break;
            case 回合开始前:
                --round;
                break;
            case 受到伤害之前:
                if (round == 0) {
                    Logs.trace("XiaHouDunSkill1", data[2] / 100.f);
                    hero.getBattle().getDamageInfo().reduceDamage(data[2] / 100.0f);
                    round = data[1];
                }
                break;

        }
    }

    public void talent1(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
        data[2] = ConfigManager.talentDataBox.findById(id).i2;
        round = data[1];
        actionPoint.put(回合开始前, 1);
        actionPoint.put(受到伤害之前, 1);
    }

    public void talent2(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
        data[4] = ConfigManager.talentDataBox.findById(id).i2;
    }

    public void talent3(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
