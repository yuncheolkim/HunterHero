package game.player;

import game.base.Constants;
import game.base.G;
import game.base.Logs;
import game.module.data.PlayerData;
import game.net.Transport;
import game.proto.LoginRes;
import game.proto.Message;
import game.repo.PlayerRepo;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

/**
 * 线程安全
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;

    private Transport transport = new Transport();

    private LocalDateTime createTime;

    private LocalDateTime loginTime;

    private PlayerData playerData = new PlayerData();

    public Player(long pid) {
        this.pid = pid;
        createTime = LocalDateTime.now();
        loginTime = createTime;
    }

    // 踢下线
    public void kick() {
        Logs.C.info("踢出用户:{},{}", pid, transport.getChannel());
        transport.close();
    }

    public void login() {
        loginTime = LocalDateTime.now();

        LoginRes.Builder builder = LoginRes.newBuilder();
        if (StringUtils.isEmpty(playerData.name)) {
            builder.setFirst(true);
        } else {

            builder.setName(playerData.name);
        }

        builder.setPlayerId(pid);

        transport.send(Message.newBuilder().setMsgNo(1).setBody(builder.build().toByteString()).build());
    }


    /**
     * 加载用户数据
     * @param code
     */
    public void load(String code) {
        // todo 根据code获取用户的账号, code从用户服务器生成

        PlayerRepo playerRepo = G.R.getPlayerRepo();
        String account = code;// todo for test

        if (playerRepo.has(code)) {
            playerData = playerRepo.load(account);
        } else {// 创建用户
            playerData.account = account;
            playerRepo.save(playerData);
        }
    }

    /**
     * 数据持久化
     */
    public void unload() {

    }

    /**
     * 下线
     */
    public void offline() {

    }

    public void setChannel(Channel channel) {
        transport.setChannel(channel);
        transport.getChannel().attr(Constants.pid).set(pid);
    }

    public long getPid() {
        return pid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public Transport getTransport() {
        return transport;
    }
}
