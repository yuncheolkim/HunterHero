package game.module.battle.skill;

import game.base.Logs;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

import java.util.Optional;

/**
 * 暴击增加能量
 * <p>
 * 0: 暴击增加能量数
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class JiangWeiSkill2 extends Skill {


    public JiangWeiSkill2() {
        super(51);
        actionPoint.put(ActionPoint.暴击后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 暴击后:
                final Optional<Skill> skill = hero.findSkill(52);
                if (skill.isPresent() && !hero.fightingData.mustCritical) {
                    final JiangWeiSkill3 skill3 = (JiangWeiSkill3) skill.get();
                    Logs.trace("暴击后", "增加点数", data[0]);
                    skill3.addPower(data[0]);
                }
                break;
        }
    }


    /**
     * 暴击获得3点能量
     *
     * @param v
     */
    public void talent1(final int v) {
        data[0] = v;
    }


}
