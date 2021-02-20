package net.client;

import game.base.Logs;
import game.proto.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/**
 * @author Yunzhe.Jin
 * 2020/3/26 20:20
 */
public class ClientHandler extends SimpleChannelInboundHandler<Message> {

    private static final Pattern DELIM = Pattern.compile("/");

    // Stateful properties
    private volatile Channel channel;

    private final BlockingQueue<Message> answer = new LinkedBlockingQueue<Message>();

    public ClientHandler() {
        super(false);
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        channel = ctx.channel();
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

        Logs.C.info("收到消息:{}", msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
