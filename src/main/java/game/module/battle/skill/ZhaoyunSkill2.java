package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 有20%概率攻击2次
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class ZhaoyunSkill2 extends Skill {

    private int canAttackCount = 2;

    private int curAttack;

    /**
     * 发生连击的概率
     */
    private int rate = 20;

    public ZhaoyunSkill2() {
        id = 7;
        actionPoint.put(ActionPoint.出手前, 1);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    protected void process(Record record, ActionPoint actionPoint, Hero hero) {

        if (actionPoint == ActionPoint.出手前) {
            curAttack++;
        } else if (actionPoint == ActionPoint.出手后) {
            if (curAttack < canAttackCount) {

                hero.setContinueAction(CalcUtil.happened100(20));

            } else {
                curAttack = 0;
                hero.setContinueAction(false);
            }
        }
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
