package game.net;

import com.google.protobuf.MessageLite;
import game.exception.ErrorEnum;
import game.exception.ModuleErrorNoResolve;
import game.proto.Message;
import game.proto.no.No;
import io.netty.channel.Channel;

/**
 * 数据传输
 *
 * @author Yunzhe.Jin
 * 2021/2/23 14:26
 */
public class Transport {
    protected volatile Channel channel;

    public void send(final No msgNo, final MessageLite msg) {
        send(msgNo.getNumber(), msg);
    }

    public void send(final int msgNo, final MessageLite msg) {
        if (channel.isActive()) {
            channel.writeAndFlush(Message.newBuilder().setMsgNo(msgNo).setBody(msg.toByteString()));
        }
    }


    public void send(final Message message) {
        if (channel.isActive()) {
            channel.writeAndFlush(message);
        }
    }

    public void sendError(final ErrorEnum errorEnum) {
        if (channel.isActive()) {
            channel.writeAndFlush(Message.newBuilder().setError(errorEnum.errorNo()).build());
        }
    }

    public void sendError(final Message msg, final ModuleErrorNoResolve error) {
        if (channel.isActive()) {
            channel.writeAndFlush(Message.newBuilder()
                    .setSeq(msg.getSeq())
                    .setMsgNo(msg.getMsgNo())
                    .setError(error.errorNo()).build());
        }
    }

    public void close() {
        if (channel.isActive()) {
            channel.close();
        }
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(final Channel channel) {
        this.channel = channel;
    }
}
