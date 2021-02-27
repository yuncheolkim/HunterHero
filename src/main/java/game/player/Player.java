package game.player;

import game.base.Constants;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.game.ScenePos;
import game.module.player.PlayerData;
import game.module.scene.SceneData;
import game.net.Transport;
import game.proto.LoginRes;
import game.proto.Message;
import game.repo.PlayerRepo;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

/**
 * 线程安全
 *
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;

    private Transport transport = new Transport();

    private LocalDateTime createTime;

    private LocalDateTime loginTime;

    private PlayerData playerData = new PlayerData();

    private LocalDateTime updateTime;

    public Player(long pid) {
        this.pid = pid;
        createTime = LocalDateTime.now();
        loginTime = createTime;
        updateTime = createTime;
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
        builder.setLevel(playerData.level);
        builder.setExp(playerData.exp);
        builder.setLevelUpExp(playerData.needExp);
        builder.setPlayerId(pid);
        // scene
        builder.setSceneData(game.proto.SceneData.newBuilder()
                .setId(playerData.sceneData.id)
                .setPos(game.proto.ScenePos.newBuilder()
                        .setX(playerData.sceneData.scenePos.x)
                        .setY(playerData.sceneData.scenePos.y)
                )
        );

        transport.send(Message.newBuilder().setMsgNo(1).setBody(builder.build().toByteString()).build());
    }


    /**
     * 加载用户数据
     *
     * @param code
     */
    public void load(String code) {
        // todo 根据code获取用户的账号, code从用户服务器生成

        PlayerRepo playerRepo = G.R.getPlayerRepo();
        String account = code;// todo for test

        if (playerRepo.has(code)) {
            playerData = playerRepo.load(account);
            playerData.write(this);
            initData();
        } else {// 创建用户
            playerData.account = account;
            initFirstPlayer();
            playerRepo.save(playerData);
        }
    }

    private void initData() {
        playerData.needExp = G.C.dataMap9.get(playerData.level).exp;
    }

    /**
     * 创建角色数据
     */
    private void initFirstPlayer() {
        // 初始化任务
        playerData.acceptTask.add(1);
        // 等级
        playerData.level = 1;
        //经验
        playerData.needExp = G.C.dataMap9.get(1).exp;
        // 场景 新手村
        SceneData sceneData = new SceneData();
        sceneData.id = 1;
        sceneData.scenePos = new ScenePos(4,-20);
        playerData.sceneData = sceneData;

    }

    /**
     * 数据持久化
     */
    public void saveData() {

        playerData.read(this);
        PlayerData copy = playerData.copy();
        Work dataPersistenceWork = G.W.getDataPersistenceWork(pid);

        dataPersistenceWork.addTask(() -> {
            PlayerRepo playerRepo = G.R.getPlayerRepo();
            playerRepo.save(copy);
        });
    }

    /**
     * 下线
     */
    public void offline() {

    }

    public void update() {


        updateTime = LocalDateTime.now();
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

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
