package game.player;

import game.base.Constants;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.game.ResourceEnum;
import game.module.event.ResourceSourceEnum;
import game.module.event.handler.ConsumeGoldEvent;
import game.module.event.handler.LevelUpEvent;
import game.module.event.handler.ResourceAddEvent;
import game.module.hero.HeroService;
import game.net.Transport;
import game.proto.LoginRes;
import game.proto.Message;
import game.proto.back.PlayerBackData;
import game.proto.data.PlayerData;
import game.proto.data.PlayerHero;
import game.repo.PlayerRepo;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 线程安全
 *
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;

    private Transport transport = new Transport();

    private PlayerData.Builder pd = PlayerData.newBuilder();

    /**
     * 后端数据
     */
    public PlayerBackData.Builder D = PlayerBackData.newBuilder();

    private LocalDateTime createTime;

    private LocalDateTime loginTime;

    private LocalDateTime updateTime;

    /**
     * 体力最后一次恢复时间
     */
    private long powerRecoverTime;

    /**
     * 下一次触发战斗时间
     */
    public long nextFightTime;

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

    /**
     * 加载基本数据后处理
     */
    private void afterLoad() {
        loginTime = LocalDateTime.fromDateFields(new Date(pd.getLastLoginTime()));
        updateTime = LocalDateTime.fromDateFields(new Date(pd.getUpdateTime()));
        pd.getResourceBuilder().setNeedExp(G.C.dataMap9.get(pd.getLevel()).exp);

        // 检查战斗区域
        int id = pd.getSceneDataBuilder().getId();
        DataConfigData dataConfigData = G.C.dataMap7.get(id);

        List<Integer> l = new ArrayList<>(D.getFightAreaList());
        D.clearFightArea();

        for (Integer areaId : l) {
            if (dataConfigData.enemyAreaList.contains(areaId)) {
                D.addFightArea(areaId);
            }
        }
        if (D.getFightAreaCount() == 0) {
            pd.clearFightInfo();
        }
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
        HeroService.addHero(this, 1001);
        HeroService.addHero(this, 1002);

        // 资源
        addGold(400000, ResourceSourceEnum.TEST);

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

    public void addGold(int count, ResourceSourceEnum from) {
        pd.getResourceBuilder().setGold(pd.getResourceBuilder().getGold() + count);

        G.E.firePlayerEvent(this, new ResourceAddEvent(ResourceEnum.GOLD, 0, count, from));
    }

    private boolean hasGold(int count) {
        return pd.getResourceBuilder().getGold() >= count;
    }

    /**
     * 消耗金币
     *
     * @param gold
     * @param consume
     */
    public void consumeGold(int gold, ConsumeTypeEnum consume) {
        ModuleAssert.isTrue(hasGold(gold), ErrorEnum.ERR_101);

        pd.getResourceBuilder().setGold(pd.getResourceBuilder().getGold() - gold);

        G.E.firePlayerEvent(this, new ConsumeGoldEvent(gold, consume));
    }

    /**
     * 增加玩家经验
     *
     * @param count
     * @param from
     */
    public void addPlayerExp(int count, ResourceSourceEnum from) {
        int exp = pd.getResourceBuilder().getExp() + count;
        int level = pd.getLevel();
        int maxExp = G.C.needExp(level);

        while (exp >= maxExp) {
            level++;
            // 升级
            G.E.firePlayerEvent(this, new LevelUpEvent(level));

            exp -= maxExp;
            maxExp = G.C.needExp(level);
        }

        pd.getResourceBuilder().setExp(exp);
        pd.setLevel(level);

        G.E.firePlayerEvent(this, new ResourceAddEvent(ResourceEnum.EXP, 0, count, from));
    }

    /**
     * 增加英雄经验
     *
     * @param heroId
     * @param count
     * @param from
     */
    public void addHeroExp(int heroId, int count, ResourceSourceEnum from) {
        PlayerHero playerHero = pd.getHeroMap().get(heroId);

        PlayerHero.Builder builder = playerHero.toBuilder();
        int exp = builder.getExp();
        int level = playerHero.getLevel();
        int maxExp = G.C.needExp(level);

        while (exp >= maxExp) {
            level++;
            // 升级
            G.E.firePlayerEvent(this, new LevelUpEvent(heroId, level));

            exp -= maxExp;
            maxExp = G.C.needExp(level);
        }
        builder.setExp(exp);
        builder.setLevel(level);
        pd.putHero(heroId, builder.build());

        G.E.firePlayerEvent(this, new ResourceAddEvent(ResourceEnum.EXP, heroId, count, from));
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

    public long getPowerRecoverTime() {
        return powerRecoverTime;
    }

    public void setPowerRecoverTime(long powerRecoverTime) {
        this.powerRecoverTime = powerRecoverTime;
    }


}
