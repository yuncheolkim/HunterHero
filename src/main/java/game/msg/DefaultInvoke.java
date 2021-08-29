package game.msg;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.EvilException;
import game.exception.ModuleException;
import game.player.Player;
import game.proto.Message;

/**
 * @author Yunzhe.Jin
 * 2021/8/29 23:24
 */
public class DefaultInvoke implements IInvoke {

    private Parser parser;


    IHandler handler;

    @Override
    public void invoke(Player player, Message msg) {

        MessageLite req;
        try {

            req = (MessageLite) parser.parseFrom(msg.getBody());
            MessageLite result = this.handler.handler(player, req);
            if (result != null) {
                player.getTransport().send(msg.toBuilder().setBody(result.toByteString()).build());
            }
        } catch (final ModuleException e) {
            Logs.M.error("", e);
            player.getTransport().sendError(msg, e.getErrorNo());
        } catch (final EvilException e) {
            Logs.evil.info("PID:{},No:{},[{}],msg:{}", player.getPid(), msg.getMsgNo(), e.getMessage(), msg);
        } catch (final Throwable e) {
            Logs.C.error(e);
            player.getTransport().sendError(msg, ErrorEnum.ERR_1);
        }
    }

    @Override
    public int getMsgNo() {
        return 0;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setHandler(IHandler handler) {
        this.handler = handler;
    }
}
