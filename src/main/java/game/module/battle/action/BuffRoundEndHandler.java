package game.module.battle.action;

import game.module.battle.Hero;
import game.module.battle.HeroActionPointHandler;
import game.module.battle.buff.Buff;

/**
 * @author Yunzhe.Jin
 * 2021/7/1 15:17
 */
public class BuffRoundEndHandler implements HeroActionPointHandler {
    private Buff buff;

    public BuffRoundEndHandler(final Buff buff) {
        this.buff = buff;
    }

    @Override
    public void handle(final Hero hero) {

    }
}
