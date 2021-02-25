package game.module.event;

import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/2/25 11:00
 */
public interface IPlayerEventHandler {

    void handler(Player player, IEvent data);
}
