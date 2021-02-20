package game.net.server;

import game.base.Lifecycle;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 */
public class TcpServer implements IServer {
    Logger log = LoggerFactory.getLogger("server");

    private final int port;

    private Channel channel;

    public TcpServer(int port) {
        this.port = port;
    }

    private LinkedList<Lifecycle> starter = new LinkedList<>();

    public void addStart(Lifecycle lifecycle) {
        starter.add(lifecycle);
    }

    protected List<ChannelHandler> channelHandlerList() {
        ArrayList<ChannelHandler> channelHandlers = new ArrayList<>(0);
        channelHandlers.add(new TestEncoder());
        return channelHandlers;
    }

    public void start() {
        Thread thread = new DefaultThreadFactory("server-服务").newThread(() -> {

            NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
            NioEventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup)
                        .option(ChannelOption.SO_REUSEADDR, true)
                        .childOption(ChannelOption.SO_KEEPALIVE, true)
                        .channel(NioServerSocketChannel.class)
                        .handler(new LoggingHandler(LogLevel.INFO))
                        .childHandler(new TcpServerInitializer(channelHandlerList()));
                try {
                    channel = b.bind(port).sync().channel();
                    channel.closeFuture().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.info("Server InterruptedException");
                }
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        });
        thread.start();


        // starter
        starter.forEach(Lifecycle::start);
    }

    public void stop() {
        log.info("退出服务器");
        starter.forEach(Lifecycle::stop);
        ChannelFuture close = channel.close();
        close.awaitUninterruptibly(1, TimeUnit.SECONDS);
    }
}
