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
public class RetInvoker<T extends MessageLite> implements IInvoke {

    private final IMsgRetHandler<T> handler;

    private final int msgNo;

    private final Supplier<Parser<T>> supplier;
    private Parser<T> parser;


    public RetInvoker(final int msgNo, final IMsgRetHandler<T> handler, final Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo;
        this.supplier = supplier;
    }

    public RetInvoker(final No msgNo, final IMsgRetHandler<T> handler, final Supplier<Parser<T>> supplier) {
        this.handler = handler;
        this.msgNo = msgNo.getNumber();
        this.supplier = supplier;
    }

    @Override
    public void invoke(final Player player, final Message msg) {
        T req = null;
        try {
            if (parser == null) {
                parser = supplier.get();
            }
            req = parser.parseFrom(msg.getBody());
            final MessageLite ret = this.handler.handler(player, req);
            if (ret != null) {
                player.getTransport().send(Message.newBuilder(msg).setBody(ret.toByteString()).build());
            }
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
