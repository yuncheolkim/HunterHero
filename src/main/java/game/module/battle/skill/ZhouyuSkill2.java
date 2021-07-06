package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Optional;

/**
 * 每层灼烧增加20%暴击
 * <p>
 * 0: 增加暴击比例
 * 1: 增加伤害比例 - T
 * 2: 增加暴击伤害 - T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class ZhouyuSkill2 extends Skill {

    public ZhouyuSkill2() {
        super(35);
        actionPoint.put(ActionPoint.出手前, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final Optional<Buff> buff = damageInfo.target.findBuff(BattleConstant.buff_zhuoshao);
                if (buff.isPresent()) {
                    final Buff zhuoshao = buff.get();
                    final int count = zhuoshao.data[1];
                    hero.fightingData.critical = CalcUtil.final100(hero.fightingData.critical, count * data[0]);
                    hero.fightingData.damage = CalcUtil.final100(hero.fightingData.damage, count * data[1]);
                    hero.fightingData.criticalDamageRate += data[2];
                }
                break;
        }
    }


    /**
     * 每层灼烧增加30%暴击
     *
     * @param id
     */
    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 每层灼烧增加20%伤害
     *
     * @param id
     */
    public void talent2(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 攻击灼烧目标暴击伤害提高50%
     *
     * @param id
     */
    public void talent3(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
