package game.net;

import game.exception.ErrorEnum;
import game.exception.ModuleErrorNoResolve;
import game.msg.MsgUtil;
import game.proto.Message;
import io.netty.channel.Channel;

/**
 * 数据传输
 * @author Yunzhe.Jin
 * 2021/2/23 14:26
 */
public class Transport {
    protected volatile Channel channel;


    public void send(Message message) {
        if (channel.isActive()) {
            channel.writeAndFlush(MsgUtil.kickMsg());
        }
    }

    public void sendError(ErrorEnum errorEnum) {
        if (channel.isActive()) {
            channel.writeAndFlush(Message.newBuilder().setError(errorEnum.errorNo()).build());
        }
    }

    public void sendError(Message msg, ModuleErrorNoResolve error) {
        if (channel.isActive()) {
            channel.writeAndFlush(Message.newBuilder()
                    .setSeq(msg.getSeq())
                    .setMsgNo(msg.getMsgNo())
                    .setError(error.errorNo()).build());
        }
    }

    public void close() {
        channel.close();
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
