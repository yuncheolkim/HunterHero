package game.module.battle.skill;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 对冰冻目标造成额外100%伤害
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class LusuSkill3 extends Skill {


    public LusuSkill3() {
        super(22);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final boolean buff = damageInfo.target.hasBuff(BattleConstant.buff_lusu_1);

                if (buff) {
                    hero.fightingData.damage = CalcUtil.final100(hero.fightingData.damage, data[0]);
                }
                break;
        }
    }

    public void talent1(final int id) {
        data[0] = id;
    }
}
