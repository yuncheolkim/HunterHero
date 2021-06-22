package game.module.battle.hero;

import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.ZhaoyunBuff1;
import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.ZhaoyunSkill2;

/**
 * @author Yunzhe.Jin
 * 2021/6/19 23:37
 */
public class Zhaoyun extends DefaultTargetHero {

    public Zhaoyun() {
        super(true);
        id = 1003;
    }

    @Override
    public void init() {
        super.init();

        addAction(ActionPoint.开场, hero -> {
            ZhaoyunBuff1 addBuff = new ZhaoyunBuff1();
            hero.addBuff(addBuff);
        });

        ZhaoyunSkill2 skill2 = new ZhaoyunSkill2();
        addSkill(skill2);
    }

    @Override
    protected void initTalent() {
    }
}
