package game.net.server;

import com.google.protobuf.MessageLiteOrBuilder;
import game.base.Logs;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/2/19 16:05
 */
@ChannelHandler.Sharable
public class TestEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
        out.add(msg);
        Logs.C.debug(msg.toString());
    }
}
