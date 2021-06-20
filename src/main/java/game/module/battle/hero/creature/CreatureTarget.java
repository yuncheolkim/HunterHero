package game.module.battle.hero.creature;

import game.module.battle.find.BackTargetStrategy;
import game.module.battle.find.FrontTargetStrategy;
import game.module.battle.hero.base.BlankHero;

/**
 * 野怪
 *
 * @author Yunzhe.Jin
 * 2021/3/4 21:55
 */
public class CreatureTarget extends BlankHero {

    public CreatureTarget() {
        super();
        addTargetStrategy(new FrontTargetStrategy());
        addTargetStrategy(new BackTargetStrategy());
    }
}
