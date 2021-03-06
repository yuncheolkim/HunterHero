package game.msg;

import game.base.Logs;
import game.exception.ErrorEnum;
import game.exception.EvilException;
import game.exception.ModuleException;
import game.module.player.Player;
import game.proto.Message;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 15:10
 */
public class InvokerNoParam implements IInvoke {

    private final IPlayerHandler handler;

    private final int msgNo;


    public InvokerNoParam(final No msgNo, final IPlayerHandler handler) {
        this.handler = handler;
        this.msgNo = msgNo.getNumber();
    }

    public InvokerNoParam(final int msgNo, final IPlayerHandler handler) {
        this.handler = handler;
        this.msgNo = msgNo;
    }

    @Override
    public void invoke(final Player player, final Message msg) {
        try {
            handler.handler(player);
        } catch (final ModuleException e) {
            Logs.M.error("", e);
            player.getTransport().sendError(msg, e.getErrorNo());
        } catch (final EvilException e) {
            Logs.evil.info("PID:{},No:{},[{}],msg:{}", player.getPid(), msg.getMsgNo(), e.getMessage(), "");
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
