package game.net;

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
        if (channel.isOpen()) {
            channel.writeAndFlush(MsgUtil.kickMsg());
        }
    }

    public void sendError(){

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
