package game.module.battle.skill;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 受到的伤害减少20%
 *
 * @author Yunzhe.Jin
 * 2021/2/9 10:18
 */
public class SunquanSkill2 extends Skill {

    private final int rate = 20;

    public SunquanSkill2() {
        actionPoint.put(ActionPoint.受到伤害之前, 1);
        id = 200009;
        name = "威慑";
        cd = BattleConstant.INFINITE;
    }


    @Override
    public Record process(final ActionPoint actionPoint, final Hero hero) {
        final Record process = super.process(actionPoint, hero);

        hero.damageInfo.reduceDamage(rate);

        return process;
    }
}
