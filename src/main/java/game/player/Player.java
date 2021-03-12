package game.player;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import game.anno.SaveData;
import game.base.Constants;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.module.event.handler.*;
import game.net.Transport;
import game.proto.LoginRes;
import game.proto.Message;
import game.proto.back.PlayerBackData;
import game.proto.data.*;
import game.repo.PlayerRepo;
import game.utils.CalcUtil;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static game.base.Constants.MAX_PLAYER_LEVEL;

/**
 * 线程安全
 *
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;

    private Transport transport = new Transport();

    /**
     * 前后端都需要的数据
     * 需持久化
     */
    @SaveData
    private PlayerData.Builder pd = PlayerData.newBuilder();

    /**
     * 后端数据
     * 需要
     */
    @SaveData
    public PlayerBackData.Builder D = PlayerBackData.newBuilder();

    @SaveData
    private LocalDateTime createTime;

    @SaveData
    private LocalDateTime loginTime;

    @SaveData
    private LocalDateTime updateTime;

    /**
     * 体力最后一次恢复时间
     */
    @SaveData
    private long powerRecoverTime;

    /**
     * 下一次触发战斗时间
     */
    public long nextFightTime;

    /**
     * key: itemId
     */
    private Multimap<Integer, BagSlot> bagSlotMap = ArrayListMultimap.create();

    public Player(long pid) {
        this.pid = pid;
        createTime = LocalDateTime.now();
        loginTime = createTime;
        updateTime = createTime;
    }

    /**
     * 踢下线
     */
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

        // 背包
        for (BagSlot bagSlot : pd.getBagMap().values()) {
            bagSlotMap.put(bagSlot.getData().getItemId(), bagSlot);
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

        // 英雄 test
        addHero(1001);
        addHero(1002);


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
     * 获得英雄
     *
     * @param heroId
     */
    public void addHero(int heroId) {

        if (getPd().getHeroMap().containsKey(heroId)) {
            return;
        }

        PlayerHero.Builder builder = PlayerHero.newBuilder();
        DataConfigData d = G.C.heroMap1001.get(1);
        builder.setId(heroId);
        builder.setLevel(1);

        builder.getPropertyBuilder()
                .setHp(d.hp)
                .setDamage(d.damage)
                .setDef(d.def)
                .setAvoid(d.avoid)
                .setCritical(d.critical)
                .setCriticalDamage(d.criticalDamage)
                .setSpeed(d.speed);

        builder.getPropertyEffectBuilder()
                .setDefRate(CalcUtil.calcRateProperty(d.def, d.defBase))
                .setAvoidRate(CalcUtil.calcRateProperty(d.avoid, d.avoidBase))
                .setCriticalRate(CalcUtil.calcRateProperty(d.critical, d.criticalBase));

        getPd().putHero(heroId, builder.build());

    }

    /**
     * 增加金币
     *
     * @param count
     * @param from
     */
    public void addGold(int count, ResourceSourceEnum from) {
        ModuleAssert.isTrue(count > 0, ErrorEnum.ERR_103);

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
        ModuleAssert.isTrue(gold > 0, ErrorEnum.ERR_103);
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
        int oldLevel = pd.getLevel();
        int level = pd.getLevel();

        if (level >= MAX_PLAYER_LEVEL) {
            return;
        }
        int maxExp = G.C.needExp(level);

        while (exp >= maxExp && level < MAX_PLAYER_LEVEL) {
            level++;

            exp -= maxExp;
            maxExp = G.C.needExp(level);
        }

        pd.getResourceBuilder().setExp(exp);

        if (oldLevel != level) {
            // 升级
            setPlayerLevel(level);
        }
        G.E.firePlayerEvent(this, new ExpAddEvent(0, count, exp, from));
    }

    /**
     * 设置等级
     *
     * @param level
     */
    public void setPlayerLevel(int level) {
        if (level >= MAX_PLAYER_LEVEL) {
            return;
        }
        pd.setLevel(level);
        G.E.firePlayerEvent(this, new LevelUpEvent(level));
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
        int exp = builder.getExp() + count;
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

        G.E.firePlayerEvent(this, new ExpAddEvent(heroId, count, exp, from));
    }

    /**
     * 增加能量
     *
     * @param count
     */
    public void addPower(long count, ResourceSourceEnum from) {

        Resource.Builder resourceBuilder = pd.getResourceBuilder();
        int old = resourceBuilder.getPower();

        resourceBuilder.setPower((int) Math.min(old + count, resourceBuilder.getMaxPower()));
        int add = resourceBuilder.getPower() - old;
        if (add > 0) {
            G.E.firePlayerEvent(this, new ResourceAddEvent(ResourceEnum.EXP, 0, add, from));
        }
    }

    /**
     * 添加物品
     *
     * @param data
     */
    public void addItem(ItemData data) {

        PlayerData.Builder pd = getPd();
        Map<Integer, BagSlot> bagMap = pd.getBagMap();


        ItemAddEvent event = new ItemAddEvent();
        event.itemData = data;
        G.E.firePlayerEvent(this, event);
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
