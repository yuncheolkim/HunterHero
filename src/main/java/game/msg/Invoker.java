package game.msg;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.EvilException;
import game.exception.ModuleException;
import game.player.Player;
import game.proto.Message;
import game.proto.no.No;

import java.util.function.Supplier;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 15:10
 */
public class Invoker<T extends MessageLite> implements IInvoke {

    private final IMsgHandler<T> handler;

    private final int msgNo;

    private Supplier<Parser<T>> supplier;

    private Parser<T> parser;

    public Invoker(final int msgNo, final IMsgHandler<T> handler, final Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo;
        this.supplier = supplier;
    }

    public Invoker(No msgNo, final IMsgHandler<T> handler, final Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo.getNumber();
        this.supplier = supplier;
    }

    public Invoker(No msgNo, final IMsgHandler<T> handler, final Parser<T> parser) {
        this.handler = handler;
        this.msgNo = msgNo.getNumber();
        this.parser = parser;
    }

    @Override
    public void invoke(final Player player, final Message msg) {

        T req = null;
        try {
            if (parser == null) {
                parser = supplier.get();
            }
            req = parser.parseFrom(msg.getBody());
            handler.handler(player, req);
        } catch (final ModuleException e) {
            Logs.M.error("", e);
            player.getTransport().sendError(msg, e.getErrorNo());
        } catch (final EvilException e) {
            Logs.evil.info("PID:{},No:{},[{}],msg:{}", player.getPid(), msg.getMsgNo(), e.getMessage(), req);
        } catch (final Throwable e) {
            Logs.C.error(e);
            player.getTransport().sendError(msg, ErrorEnum.ERR_1);
        }
    }

    @Override
    public int getMsgNo() {
        return msgNo;
    }
}
