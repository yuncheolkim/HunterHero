package game.module.battle.hero.base;

import game.module.battle.Hero;
import game.module.battle.find.BackTargetStrategy;
import game.module.battle.find.FrontTargetStrategy;

/**
 * @author Yunzhe.Jin
 * 2021/6/21 23:15
 */
public class DefaultTargetHero extends Hero {

    public DefaultTargetHero() {
        this(true);
    }

    public DefaultTargetHero(final boolean front) {
        if (front) {

            addTargetStrategy(new FrontTargetStrategy());
            addTargetStrategy(new BackTargetStrategy());
        } else {
            addTargetStrategy(new BackTargetStrategy());
            addTargetStrategy(new FrontTargetStrategy());
        }
    }
}
