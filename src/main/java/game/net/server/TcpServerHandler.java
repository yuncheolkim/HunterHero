package game.net.server;

import game.base.Logs;
import game.proto.Message;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2020/3/26 19:33
 */
@ChannelHandler.Sharable
public class TcpServerHandler extends SimpleChannelInboundHandler<Message> {

    private static Logger log = Logs.C;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("客户端连接成功,{}", ctx.channel());
        super.channelActive(ctx);

        new Thread(() -> {

            while (true) {

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Message.newBuilder().setVersion(1));
            }

        }).start();

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        log.info("收到消息：{}-{}", ctx, msg);
        int msgNo = msg.getMsgNo();


        // todo
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
