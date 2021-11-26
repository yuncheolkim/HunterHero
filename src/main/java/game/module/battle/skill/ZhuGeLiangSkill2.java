package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

import java.util.Map;

/**
 * 5点雷电,触发神锤,200%伤害
 * <p>
 * 0: 能量点
 * 1: 伤害比例
 * 2: 攻击人数
 * 3: 转化生命比例 - T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class ZhuGeLiangSkill2 extends Skill {


    public ZhuGeLiangSkill2() {
        super(36);
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
        final ZhuGeLiangSkill1 skill = (ZhuGeLiangSkill1) hero.findSkill(35).get();

        final int acc = skill.getAcc();
        final int need = data[0];
        if (acc >= need) {
            skill.setAcc(acc - need);
            //
            final DamageInfo damageInfo = hero.getBattle().getDamageInfo();

            final Hero[] targetList = findTarget(damageInfo.target, data[2]);

            for (final Hero target : targetList) {
                final DamageInfo tempInfo = new DamageInfo();
                tempInfo.sourceId = id;
                tempInfo.type = DamageType.DAMAGE_SKILL;
                tempInfo.source = hero;
                tempInfo.target = target;
                tempInfo.origin = hero;
                tempInfo.sourceDamage = CalcUtil.change100(hero.fightingData.damage, data[1]);
                hero.damage(tempInfo);

                //神锤回血
                if (data[3] > 0) {
                    hero.addHp(CalcUtil.change100(tempInfo.sourceDamage, data[3]));
                }

            }
        }
    }

    private Hero[] findTarget(final Hero target, final int count) {
        final Hero[] list = new Hero[count];

        list[0] = target;
        if (count > 1) {

            final Map<Integer, Hero> heroMap = target.getBattle().mySideHeroes(target.getSide());

            int index = 1;
            for (final Hero value : heroMap.values()) {
                if (value == target) {
                    continue;
                }

                if (value.isAlive()) {
                    list[index++] = value;
                    if (index == count) {
                        break;
                    }
                }
            }
        }

        return list;
    }

    /**
     * 神锤伤害提高到300%
     *
     * @param id
     */
    public void talent1(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 神锤攻击2个敌人
     *
     * @param id
     */
    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 神锤伤害转化为生命
     *
     * @param id
     */
    public void talent3(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 能量消耗减少1点
     *
     * @param id
     */
    public void talent4(final int id) {
        data[0] -= ConfigManager.talentDataBox.findById(id).i1;
    }

}
