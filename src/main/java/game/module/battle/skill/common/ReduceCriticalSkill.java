package game.module.battle.skill.common;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import static game.module.battle.action.ActionPoint.暴击计算;

/**
 * 减少暴击
 * 0:减少比例
 *
 * @author Yunzhe.Jin
 * 2021/7/5 16:43
 */
public class ReduceCriticalSkill extends Skill {

    public ReduceCriticalSkill() {
        super(1005);
        actionPoint.put(暴击计算, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 暴击计算:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final int cri = damageInfo.source.fightingData.critical;
                damageInfo.source.fightingData.critical = CalcUtil.change100(cri, data[0]);
                break;
        }

    }

    public void setRate(final int rate) {
        data[0] = rate;
    }
}
