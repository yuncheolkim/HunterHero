package game.module.battle.hero;

import game.module.battle.buff.hero.ZhaoyunBuff1;
import game.module.battle.hero.base.DefaultTargetHero;

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

    }

    @Override
    protected void initTalent() {
        ZhaoyunBuff1 addBuff = new ZhaoyunBuff1();
        addBuff(addBuff);
    }
}
