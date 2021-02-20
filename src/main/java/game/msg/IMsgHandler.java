package game.msg;

import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:10
 */
public interface IMsgHandler<M> {

    Object handler(Player player, M request);
}
