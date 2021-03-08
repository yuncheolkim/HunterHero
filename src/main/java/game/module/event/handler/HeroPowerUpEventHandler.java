package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.player.Player;

/**
 * 英雄属性变化，重新计算属性
 * @author Yunzhe.Jin
 * 2021/3/8 11:21
 */
public class HeroPowerUpEventHandler implements IPlayerEventHandler<HeroPowerUpEvent> {
    @Override
    public void handler(Player player, HeroPowerUpEvent data) {

    }
}
