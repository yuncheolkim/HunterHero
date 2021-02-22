package game.net.server;

import game.proto.Message;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2020/3/26 19:33
 */
public class TcpServerInitializer extends ChannelInitializer<SocketChannel> {

    private static TcpServerHandler SERVER_HANDLER = new TcpServerHandler();
    private List<ChannelHandler> channelHandlerList;

    public TcpServerInitializer(List<ChannelHandler> channelHandlerList) {
        this.channelHandlerList = channelHandlerList;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 客户端传过来的时候 varint 编码的长度
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(Message.getDefaultInstance()));
        // 服务器给前端的时候4字节头固定格式
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new TcpByteSendHandler());
        pipeline.addLast(new ProtobufEncoder());
        for (ChannelHandler channelHandler : channelHandlerList) {
            pipeline.addLast(channelHandler);
        }
        pipeline.addLast(SERVER_HANDLER);
    }
}
