package game.net.server;

import cn.hutool.log.Log;
import game.base.G;
import game.base.GameConstants;
import game.base.Logs;
import game.msg.LoginMsgProcess;
import game.msg.MsgProcess;
import game.player.Player;
import game.proto.Message;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.Attribute;

import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2020/3/26 19:33
 */
@ChannelHandler.Sharable
public class TcpServerHandler extends SimpleChannelInboundHandler<Message> {

    private static Log log = Logs.C;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("客户端连接成功,{}", ctx.channel());
        super.channelActive(ctx);


    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
//        log.info("收到消息：\n{}-{}\n{}", MsgNo.forNumber(msg.getMsgNo()), ctx, msg);
        int msgNo = msg.getMsgNo();

        if (isLogin(msgNo)) {
            if (ctx.channel().hasAttr(GameConstants.pid)) {
                // 重复登录
                return;
            }
            G.W.getLoginWork().addTask(new LoginMsgProcess(ctx.channel(), msg));
        } else if (!ctx.channel().hasAttr(GameConstants.pid)) {
            // 没有登录
            return;
        } else {
            Attribute<Long> attr = ctx.channel().attr(GameConstants.pid);
            Optional<Player> player = G.P.findPlayer(attr.get());
            if (player.isPresent()) {
                G.W.getPlayerWork(player.get().getPid()).addTask(new MsgProcess(msg, player.get()));
            } else {
                Logs.C.error("channel:{} 存在,用户不存在？？{}", ctx.channel(), attr.get());
            }
        }

        // todo
    }

    private boolean isLogin(int msgNo) {
        return msgNo == 1;
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("客户端断开连接:" + ctx.channel().remoteAddress());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("客户端发生异常,{}", ctx.channel(), cause);
        super.exceptionCaught(ctx, cause);
    }
}
