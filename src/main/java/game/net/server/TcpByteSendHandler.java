package game.net.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Yunzhe.Jin
 * 2021/2/19 16:15
 */
@ChannelHandler.Sharable
public class TcpByteSendHandler extends MessageToByteEncoder<ByteBuf> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        int bodyLen = msg.readableBytes();
        out.ensureWritable(4 + bodyLen);
        out.writeInt(bodyLen);
        out.writeBytes(msg, msg.readerIndex(), bodyLen);
    }
}
