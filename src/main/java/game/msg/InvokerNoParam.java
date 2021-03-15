package game.msg;

import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.ModuleException;
import game.player.Player;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 15:10
 */
public class InvokerNoParam implements IInvoke {

    private final IPlayerHandler handler;

    private final int msgNo;


    public InvokerNoParam(int msgNo, IPlayerHandler handler) {
        this.handler = handler;
        this.msgNo = msgNo;
    }

    public void invoke(Player player, Message msg) {
        try {
            handler.handler(player);
        } catch (ModuleException e) {
            Logs.M.error("", e);
            player.getTransport().sendError(msg, e.getErrorNo());
        } catch (Throwable e) {
            Logs.C.error(e);
            player.getTransport().sendError(msg, ErrorEnum.ERR_1);
        }
    }

    public int getMsgNo() {
        return msgNo;
    }
}
