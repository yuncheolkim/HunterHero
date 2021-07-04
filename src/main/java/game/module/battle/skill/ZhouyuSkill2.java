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
 * 每层灼烧增加20%伤害
 * <p>
 * 0: 伤害比例
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
                    final int overlapCount = zhuoshao.data[1] * data[0];
                    hero.fightingData.critical = CalcUtil.final100(hero.fightingData.critical, overlapCount);
                }
                break;

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
