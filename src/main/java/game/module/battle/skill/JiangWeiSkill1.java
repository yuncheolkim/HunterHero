package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

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
                    skill3.addPower(data[0]);
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
