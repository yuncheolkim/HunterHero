package game.player;

import game.base.Constants;
import io.netty.channel.Channel;
import org.joda.time.LocalDateTime;


/**
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private long pid;

    private Channel channel;

    private LocalDateTime createTime;

    public Player() {
        createTime = LocalDateTime.now();
    }

    // 踢下线
    public void kick() {
        if (channel.isOpen()) {

        }
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
        this.channel.attr(Constants.pid).set(pid);
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
