package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 有30%概率攻击2次
 * 0:连击概率
 * 1:连击次数
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class ZhaoyunSkill2 extends Skill {

    /**
     * 当前出手次数
     */
    private int curAttack;

    public ZhaoyunSkill2() {
        super(7);
        actionPoint.put(ActionPoint.出手前, 1);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {


        if (actionPoint == ActionPoint.出手前) {
            curAttack++;
        } else if (actionPoint == ActionPoint.出手后) {
            final int rate = data[0];
            final int canAttackCount = data[1];
            if (curAttack < canAttackCount) {
                hero.setContinueAction(CalcUtil.happened100(rate));
            } else {
                curAttack = 0;
                hero.setContinueAction(false);
            }
        }
    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

}

