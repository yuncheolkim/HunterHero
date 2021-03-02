package game.player;

import game.base.Constants;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.config.HeroConfigDataBase;
import game.net.Transport;
import game.proto.LoginRes;
import game.proto.Message;
import game.proto.data.PlayerData;
import game.proto.data.PlayerHero;
import game.repo.PlayerRepo;
import game.utils.CalcUtil;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import java.util.Date;

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

    //    private PlayerData playerData = new PlayerData();
    private PlayerData.Builder pd = PlayerData.newBuilder();

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
        builder.setData(pd);
        if (StringUtils.isEmpty(pd.getName())) {
            builder.setFirst(true);
        }

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

        if (playerRepo.has(account)) {
            pd = playerRepo.load(account);
        } else {// 创建用户
            pd.setAccount(account);
            initFirstPlayer();
            playerRepo.save(pd.build());
        }
        afterLoad();
    }

    private void afterLoad() {
        loginTime = LocalDateTime.fromDateFields(new Date(pd.getLastLoginTime()));
        updateTime = LocalDateTime.fromDateFields(new Date(pd.getUpdateTime()));
        pd.getResourceBuilder().setNeedExp(G.C.dataMap9.get(pd.getLevel()).exp);
    }

    /**
     * 创建角色数据
     */
    private void initFirstPlayer() {
        // 等级
        pd.setLevel(1);

        pd.getResourceBuilder().setPower(G.C.dataMap8.get(1).count);
        pd.getResourceBuilder().setMaxPower(G.C.dataMap8.get(1).count);
        pd.getResourceBuilder().setPowerRecoverSecond(G.C.dataMap8.get(2).count);

        // 初始化任务
        pd.getTaskBuilder().putAcceptableTask(1, true);

        // 场景 新手村
        pd.getSceneDataBuilder().setId(1).setPos(game.proto.data.ScenePos.newBuilder().setX(4).setY(-20));

        // 英雄
        PlayerHero.Builder builder = pd.addHeroBuilder().setId(1001).setLevel(1);
        HeroConfigDataBase d = G.C.heroMap1001.get(1);

        builder.getPropertyBuilder()
                .setHp(d.hp)
                .setDamage(d.damage)
                .setDef(d.def)
                .setAvoid(d.avoid)
                .setCritical(d.critical)
                .setCriticalDamage(d.criticalDamage)
                .setSpeed(d.speed);

        builder.getPropertyEffectBuilder()
                .setDefRate(CalcUtil.calcRateProperty(d.def,d.defBase))
                .setAvoidRate(CalcUtil.calcRateProperty(d.avoid,d.avoidBase))
                .setCriticalRate(CalcUtil.calcRateProperty(d.critical,d.criticalBase));



    }

    /**
     * 数据持久化
     */
    public void saveData() {

        pd.setLastLoginTime(loginTime.toDate().getTime());
        pd.setUpdateTime(updateTime.toDate().getTime());

        PlayerData copy = pd.build();
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

    public PlayerData.Builder getPd() {
        return pd;
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
