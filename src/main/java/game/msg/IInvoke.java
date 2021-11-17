package game.msg;

import game.module.player.Player;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 22:30
 */
public interface IInvoke {
    void invoke(Player player, Message msg);

    int getMsgNo();
}
