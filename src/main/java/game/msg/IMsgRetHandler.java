package game.msg;

import com.google.protobuf.MessageLite;
import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:10
 */
public interface IMsgRetHandler<T extends MessageLite> {

    MessageLite handler(Player player, T request);
}
