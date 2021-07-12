package game.module.battle.skill;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Optional;

/**
 * 每次攻击获得一点能量
 * <p>
 * 0: 获得能量数
 * 1: 暴击增加数
 * 2: 伤害增加数
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class JiangWeiSkill1 extends Skill {

    private int criticalRate;

    private int damageRate;

    public JiangWeiSkill1() {
        super(50);
        addActionPoint(ActionPoint.出手后);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                final Optional<Skill> skill = hero.findSkill(52);
                if (skill.isPresent()) {
                    final JiangWeiSkill3 skill3 = (JiangWeiSkill3) skill.get();
                    Logs.trace("增加能量", hero.getSimple(), data[0]);
                    skill3.addPower(data[0]);
                }
                if (data[1] > 0) {
                    criticalRate += data[1] * data[0];
                    Logs.trace("暴击累加", criticalRate);
                }

                if (data[2] > 0) {
                    damageRate += data[2] * data[0];
                    Logs.trace("伤害累加", damageRate);

                }
                break;
            case 出手前:
                if (criticalRate > 0) {
                    //region debug
                    final int old = hero.fightingData.critical;
                    //endregion
                    hero.fightingData.critical += CalcUtil.change100(hero.fightingData.critical, criticalRate);
                    Logs.trace("出手前", "增加暴击：", old, hero.fightingData.critical);
                }

                if (damageRate > 0) {
                    final int old = hero.fightingData.damage;
                    hero.fightingData.damage += CalcUtil.change100(hero.fightingData.damage, damageRate);
                    Logs.trace("出手前", "增加伤害：", old, hero.fightingData.damage);
                }

                break;
        }
    }


    /**
     * 攻击获得2点能量
     *
     * @param v
     */
    public void talent1(final int v) {
        data[0] = v;
    }

    /**
     * 每点能量本场暴击增加1%
     *
     * @param v
     */
    public void talent2(final int v) {
        data[1] = v;
        addActionPoint(ActionPoint.出手前);
    }

    /**
     * 每点能量本场伤害增加2%
     *
     * @param v
     */
    public void talent3(final int v) {
        data[2] = v;
        addActionPoint(ActionPoint.出手前);
    }
}
