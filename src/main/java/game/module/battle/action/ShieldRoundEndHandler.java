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
public class ShieldRoundEndHandler implements HeroActionPointHandler {
    public static final ShieldRoundEndHandler INSTANCE = new ShieldRoundEndHandler();

    @Override
    public void handle(final Hero hero) {

        // 计算护盾
        final HeroStats heroStats = hero.heroStats;
        final int old = heroStats.getShield();
        if (old > 0) {
            heroStats.roundShield();
            if (old != heroStats.getShield()) {
                // 护盾减少记录
                hero.recordShieldChange(null, heroStats.getShield() - old);
            }
        }


    }

}
