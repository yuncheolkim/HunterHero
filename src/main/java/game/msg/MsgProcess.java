package game.msg;

import game.base.G;
import game.base.Logs;
import game.player.Player;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:42
 */
public class MsgProcess implements Runnable {
    protected Message message;

    private long pid;

    protected Player player;

    public MsgProcess(Message message, Player player) {
        this.message = message;
        this.player = player;
    }

    public MsgProcess(Message message, long pid) {
        this.message = message;
        this.pid = pid;
    }

    @Override
    public void run() {

        IInvoke handler = G.G.getHandler(message.getMsgNo());
        if (handler != null) {
            if (player == null) {
                handler.invoke(G.P.findPlayer(pid).get(), message);
            } else {
                handler.invoke(player, message);
            }
        } else {
            Logs.C.warn("不存在handler:{}", message.getMsgNo());
        }
    }
}
