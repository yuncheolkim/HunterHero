package game.module.battle.action;

import game.module.battle.Hero;
import game.module.battle.HeroActionPointHandler;
import game.module.battle.HeroStats;

/**
 * 回合结束后处理
 * <p>
 * 护盾CD
 * buff CD
 * 技能CD
 *
 * @author Yunzhe.Jin
 * 2021/6/30 22:15
 */
public class RoundEndHandler implements HeroActionPointHandler {
    public static final RoundEndHandler INSTANCE = new RoundEndHandler();

    @Override
    public void handle(Hero hero) {

        //region test
        hero.recordShieldChange(null, -10);
        //endregion
        // 计算护盾
        HeroStats heroStats = hero.heroStats;
        int old = heroStats.getShield();
        if (old <= 0) {
            return;
        }
        heroStats.roundShield();
        if (old != heroStats.getShield()) {
            // 护盾减少记录
            hero.recordShieldChange(null, heroStats.getShield() - old);
        }

    }
}
