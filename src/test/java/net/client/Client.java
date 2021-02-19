package net.client;

import game.proto.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.function.Consumer;

/**
 * @author Yunzhe.Jin
 * 2020/4/7 14:56
 */
public class Client {
    private EventLoopGroup group;
    private Channel ch;
    private ChannelFuture connect;
    private Consumer<ChannelPipeline> consumer = null;

    public Client() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void connect(String host, int port) throws InterruptedException {
        group = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap();
        b.group(group)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ClientInitializer());
                        if (consumer != null){
                            consumer.accept(p);
                        }
                    }
                });
        connect = b.connect(host, port);
        ch = connect.sync().channel();
    }

    public void addHandler(Consumer<ChannelPipeline> consumer) {
        this.consumer = consumer;
    }

    public ChannelFuture getConnect() {
        return connect;
    }

    public void stop() {
        if (group != null) {
            group.shutdownGracefully();
        }
    }

    public Channel getCh() {
        return ch;
    }

    public void send(Message message) {
        ch.writeAndFlush(message);
    }

}
