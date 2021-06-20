package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;

/**
 * 多重箭,可以同时打多个目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class HuanzhongSkill2 extends Skill {

    /**
     * 万分比
     */
    private int rate = 2000;

    public HuanzhongSkill2() {
        id = 5;
        actionPoint.put(ActionPoint.开场, 1);
    }

    @Override
    public Record process(ActionPoint actionPoint, Hero hero) {
        Record process = super.process(actionPoint, hero);
        hero.origin.setDefReduce(hero.origin.getDefReduce() + rate);
        hero.property.setDefReduce(hero.origin.getDefReduce());
        return process;
    }


    public void setRate(int rate) {
        this.rate = rate;
    }
}
