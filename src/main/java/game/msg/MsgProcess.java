package game.msg;

import game.base.G;
import game.player.Player;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:42
 */
public class MsgProcess implements Runnable {
    protected Message message;

    protected Player player;

    public MsgProcess(Message message, Player player) {
        this.message = message;
        this.player = player;
    }

    @Override
    public void run() {
        G.G.getHandler(message.getMsgNo()).handler(player, message);
    }
}
