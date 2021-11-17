package game.module.event;

import game.module.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/2/25 11:00
 */
public interface IPlayerEventHandler<T extends IEvent> {

    void handler(Player player, T data);
}
