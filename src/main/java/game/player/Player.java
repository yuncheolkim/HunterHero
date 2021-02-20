package game.player;

import game.base.Constants;
import game.base.Logs;
import game.msg.MsgUtil;
import io.netty.channel.Channel;
import org.joda.time.LocalDateTime;

/**
 * 线程安全
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;

    private volatile Channel channel;

    private LocalDateTime createTime;

    private LocalDateTime loginTime;

    public Player(long pid) {
        this.pid = pid;
        createTime = LocalDateTime.now();
        loginTime = createTime;
    }

    // 踢下线
    public void kick() {
        if (channel.isOpen()) {
            Logs.C.info("踢出用户:{},{}", pid, channel);
            channel.writeAndFlush(MsgUtil.kickMsg());
            channel.close();
        }


    }

    public void login() {
        loginTime = LocalDateTime.now();
    }

    /**
     * 加载用户数据
     */
    public void load() {

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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

}
