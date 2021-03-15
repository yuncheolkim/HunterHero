package game.msg;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.ModuleException;
import game.player.Player;
import game.proto.Message;

import java.util.function.Supplier;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 15:10
 */
public class Invoker<T extends MessageLite> implements IInvoke {

    private final IMsgHandler<T> handler;

    private final int msgNo;

    private final Supplier<Parser<T>> supplier;


    public Invoker(int msgNo, IMsgHandler<T> handler, Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo;
        this.supplier = supplier;
    }

    public void invoke(Player player, Message msg) {
        try {
            T req = supplier.get().parseFrom(msg.getBody());
            handler.handler(player, req);
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
