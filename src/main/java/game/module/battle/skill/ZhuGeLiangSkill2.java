package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

/**
 * 5点雷电,触发神锤,200%伤害
 * <p>
 * 0: 能量点
 * 1: 伤害比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class ZhuGeLiangSkill2 extends Skill {


    public ZhuGeLiangSkill2() {
        super(37);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                attack(record, hero);
                break;
        }
    }

    private void attack(final Record record, final Hero hero) {
        final ZhuGeLiangSkill1 skill = (ZhuGeLiangSkill1) hero.findSkill(36).get();

        final int acc = skill.getAcc();
        final int need = data[0];
        if (acc >= need) {
            skill.setAcc(acc - need);
            //
            final DamageInfo damageInfo = hero.getBattle().getDamageInfo();

            final DamageInfo tempInfo = new DamageInfo();
            tempInfo.sourceId = id;
            tempInfo.type = DamageType.DAMAGE_SKILL;
            tempInfo.source = hero;
            tempInfo.target = damageInfo.target;
            tempInfo.origin = hero;
            tempInfo.sourceDamage = CalcUtil.add100(hero.fightingData.damage, data[1]);
            hero.damage(tempInfo);
        }

    }


    public void talent1(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent3(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent4(final int id) {
        data[1] += ConfigManager.talentDataBox.findById(id).i1;
        data[2] += ConfigManager.talentDataBox.findById(id).i2;
    }
}
