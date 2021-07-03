package game.module.battle.hero;

import game.module.battle.hero.base.DefaultTargetHero;
import game.module.battle.skill.XiaHouDunSkill1;

/**
 * 夏侯惇
 *
 * @author Yunzhe.Jin
 * 2021/6/28 21:48
 */
public class XiaHouDun extends DefaultTargetHero {
    public XiaHouDun() {
        super(true);
    }

    @Override
    protected void initTalent() {
        XiaHouDunSkill1 skill1 = new XiaHouDunSkill1();


        addSkill(skill1);

    }
}
