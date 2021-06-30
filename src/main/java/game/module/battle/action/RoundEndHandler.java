package game.module.battle.action;

import game.module.battle.Hero;
import game.module.battle.HeroActionPointHandler;

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

    }
}
