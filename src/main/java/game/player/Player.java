package game.player;

import com.google.protobuf.MessageLite;
import game.anno.ProcessPersistenceData;
import game.anno.SaveData;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.base.constants.GameConstants;
import game.config.base.DataConfigData;
import game.config.data.ItemConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.game.ItemTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.bag.BagUpdateService;
import game.module.bag.ItemBoxData;
import game.module.event.handler.ExpAddEvent;
import game.module.event.handler.ItemAddEvent;
import game.module.event.handler.LevelUpEvent;
import game.module.event.handler.ResourceChangeEvent;
import game.module.hero.HeroService;
import game.net.Transport;
import game.proto.BagInfoChangePush;
import game.proto.LoginRes;
import game.proto.Message;
import game.proto.ResourceChangePush;
import game.proto.back.MsgNo;
import game.proto.back.PlayerBackData;
import game.proto.data.*;
import game.proto.no.No;
import game.repo.PlayerRepo;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static game.base.constants.GameConstants.MAX_PLAYER_LEVEL;
import static game.module.bag.BagService.findBagUpdateService;

/**
 * 线程安全
 *
 * @author Yunzhe.Jin
 * 2021/2/19 18:09
 */
public class Player {
    private final long pid;


    private final Transport transport = new Transport();

    /**
     * 前后端都需要的数据
     * 需持久化
     */
    @SaveData
    public PlayerData.Builder pd = PlayerData.newBuilder();

    /**
     * 后端数据
     * 需要
     */
    @SaveData
    public PlayerBackData.Builder D = PlayerBackData.newBuilder();

    private LocalDateTime createTime;

    @ProcessPersistenceData
    private LocalDateTime loginTime;

    @ProcessPersistenceData
    private LocalDateTime updateTime;


    /**
     * 背包数据
     */
    @ProcessPersistenceData
    public ItemBoxData bag = new ItemBoxData();

    /**
     * 银行数据
     */
    @ProcessPersistenceData
    public ItemBoxData bank = new ItemBoxData();

    public FishAction fishAction = new FishAction();

    public Player(final long pid) {
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

        final LoginRes.Builder builder = LoginRes.newBuilder();
        builder.setData(pd);
        if (StringUtils.isEmpty(pd.getName())) {
            builder.setFirst(true);
        }

        transport.send(Message.newBuilder().setMsgNo(MsgNo.login_req_VALUE).setBody(builder.build().toByteString()).build());
    }

    public void relogin() {
        final LoginRes.Builder builder = LoginRes.newBuilder();
        builder.setData(pd);
        if (StringUtils.isEmpty(pd.getName())) {
            builder.setFirst(true);
        }

        transport.send(Message.newBuilder().setMsgNo(MsgNo.login_req_VALUE).setBody(builder.build().toByteString()).build());

        prepareData();

    }

    /**
     * 加载用户数据
     *
     * @param code
     */
    public void load(final String code) {
        // todo 根据code获取用户的账号, code从用户服务器生成

        final PlayerRepo playerRepo = G.R.getPlayerRepo();
        final String account = code;// todo for test

        if (playerRepo.has(account)) {
            final game.proto.back.SaveData.Builder load = playerRepo.load(account);
            pd = load.getPdBuilder();
            D = load.getBackDataBuilder();
        } else {// 创建用户
            pd.setAccount(account);
            initFirstPlayer();
            saveData();
        }
        prepareData();
    }

    /**
     * 加载基本数据后处理
     */
    public void prepareData() {
        loginTime = LocalDateTime.fromDateFields(new Date(D.getLoginTime()));
        updateTime = LocalDateTime.fromDateFields(new Date(D.getUpdateTime()));
        pd.getResourceBuilder().setNeedExp(ConfigManager.needExp(pd.getLevel()));

        // 检查战斗区域
        final int id = pd.getSceneDataBuilder().getId();
        final DataConfigData dataConfigData = G.C.dataMap7.get(id);
        final List<Integer> l = new ArrayList<>(D.getFightAreaList());
        D.clearFightArea();
        for (final Integer areaId : l) {
            if (dataConfigData.enemyAreaList != null) {
                if (dataConfigData.enemyAreaList.contains(areaId)) {
                    D.addFightArea(areaId);
                }
            }
        }
        if (D.getFightAreaCount() == 0) {
            pd.clearFightInfo();
        }

        // 背包
        bag = new ItemBoxData();
        for (final BagSlot bagSlot : pd.getBagMap().values()) {
            bag.bagSlotMap.put(bagSlot.getData().getItemId(), bagSlot);
        }
        bag.capacity = pd.getBagCapacity();
        bag.count = pd.getBagCount();
        bank = new ItemBoxData();
        // 银行
        for (final BagSlot bagSlot : pd.getBankMap().values()) {
            bank.bagSlotMap.put(bagSlot.getData().getItemId(), bagSlot);
        }
        bank.capacity = pd.getBankCapacity();
        bank.count = pd.getBankCount();

    }

    /**
     * 创建角色数据
     */
    private void initFirstPlayer() {
        // 等级
        pd.setPid(pid);
        pd.setLevel(1);

        // Power
        pd.getResourceBuilder().setPower(ConfigManager.GetInitPower());
        pd.getResourceBuilder().setMaxPower(ConfigManager.GetInitPower());
        pd.getResourceBuilder().setPowerRecoverSecond(ConfigManager.paramConfigData.recoverPowerPeriod);
        D.setPowerRecoverTime(System.currentTimeMillis());

        // 场景: 新手村
        pd.getSceneDataBuilder().setId(1).setPos(game.proto.data.ScenePos.newBuilder().setX(4).setY(-20));

        // 背包容量
        pd.setBagCapacity(G.C.bagCapacity());
        // 银行容量
        pd.setBankCapacity(G.C.bankCapacity());
        // Task
        pd.setTask(PlayerTask.newBuilder());
        // Hotel
        pd.setHotelId(1);

        // 英雄 test
        addHero(1001);
        addHero(1002);
    }

    /**
     * 数据持久化
     */
    public void saveData() {

        D.setLoginTime(loginTime.toDate().getTime());
        D.setUpdateTime(updateTime.toDate().getTime());

        final Work dataPersistenceWork = G.W.getDataPersistenceWork(pid);

        final game.proto.back.SaveData data = game.proto.back.SaveData.newBuilder()
                .setBackData(D.build())
                .setPd(pd.build())
                .build();

        dataPersistenceWork.addTask(() -> {
            final PlayerRepo playerRepo = G.R.getPlayerRepo();
            playerRepo.save(data);
        });
    }


    /**
     * 获得英雄
     *
     * @param heroId
     */
    public void addHero(final int heroId) {
        HeroService.addHero(this, heroId, false);
    }

    /**
     * 增加金币
     *
     * @param count
     * @param from
     */
    public void addGold(final int count, final ResourceSourceEnum from) {
        ModuleAssert.isTrue(count > 0, ErrorEnum.ERR_103);

        pd.getResourceBuilder().setGold(pd.getResourceBuilder().getGold() + count);

        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.GOLD, 0, count, from));
    }

    public boolean hasGold(final int count) {
        return pd.getResourceBuilder().getGold() >= count;
    }

    /**
     * 消耗金币
     *
     * @param gold
     * @param consume
     */
    public void consumeGold(final int gold, final ConsumeTypeEnum consume) {
        ModuleAssert.isTrue(gold > 0, ErrorEnum.ERR_103);
        ModuleAssert.isTrue(hasGold(gold), ErrorEnum.ERR_4);

        pd.getResourceBuilder().setGold(pd.getResourceBuilder().getGold() - gold);
        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.GOLD, 0, gold * -1, consume));

    }

    public void addGem(final int count, final ResourceSourceEnum from) {
        ModuleAssert.isTrue(count > 0, ErrorEnum.ERR_103);

        pd.getResourceBuilder().setLei(pd.getResourceBuilder().getLei() + count);

        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.GEM, 0, count, from));
    }

    /**
     * 增加玩家经验
     *
     * @param count
     * @param from
     */
    public void addPlayerExp(final int count, final ResourceSourceEnum from) {
        int exp = pd.getResourceBuilder().getExp() + count;
        final int oldLevel = pd.getLevel();
        int level = pd.getLevel();

        if (level >= MAX_PLAYER_LEVEL) {
            return;
        }
        int maxExp = ConfigManager.needExp(level);

        while (exp >= maxExp && level < MAX_PLAYER_LEVEL) {
            level++;

            exp -= maxExp;
            maxExp = ConfigManager.needExp(level);
        }

        pd.getResourceBuilder().setExp(exp);

        if (oldLevel != level) {
            // 升级
            setPlayerLevel(level, oldLevel);
        }
        EventManager.firePlayerEvent(this, new ExpAddEvent(0, count, exp, from));
    }

    /**
     * 设置等级
     *
     * @param level
     * @param oldLevel
     */
    public void setPlayerLevel(final int level, final int oldLevel) {
        if (level >= MAX_PLAYER_LEVEL) {
            return;
        }
        pd.setLevel(level);
        EventManager.firePlayerEvent(this, new LevelUpEvent(level, oldLevel));
    }

    /**
     * 增加英雄经验
     *
     * @param heroId
     * @param count
     * @param from
     */
    public void addHeroExp(final int heroId, final int count, final ResourceSourceEnum from) {
        final PlayerHero playerHero = pd.getHeroMap().get(heroId);

        final PlayerHero.Builder builder = playerHero.toBuilder();
        int exp = builder.getExp() + count;
        final int oldLevel = playerHero.getLevel();
        int level = playerHero.getLevel();
        int maxExp = ConfigManager.needExp(level);

        while (exp >= maxExp) {
            level++;
            // 升级

            exp -= maxExp;
            maxExp = ConfigManager.needExp(level);
        }
        builder.setExp(exp);
        builder.setLevel(level);
        pd.putHero(heroId, builder.build());

        if (oldLevel != level) {
            EventManager.firePlayerEvent(this, new LevelUpEvent(heroId, level, oldLevel));
        }

        EventManager.firePlayerEvent(this, new ExpAddEvent(heroId, count, exp, from));
    }

    /**
     * 增加能量
     *
     * @param count
     */
    public void addPower(final long count, final ResourceSourceEnum from) {

        final Resource.Builder resourceBuilder = pd.getResourceBuilder();
        final int old = resourceBuilder.getPower();

        resourceBuilder.setPower((int) Math.min(old + count, resourceBuilder.getMaxPower()));
        final int add = resourceBuilder.getPower() - old;
        if (add > 0) {
            EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.POWER, 0, add, from));
        }
    }

    /**
     * 消耗体力
     *
     * @param count
     * @param typeEnum
     */
    public boolean consumePower(final ConsumeTypeEnum typeEnum, final int count) {

        if (pd.getResourceBuilder().getPower() < count) {
            return false;
        }

        pd.getResourceBuilder().setPower(pd.getResourceBuilder().getPower() - count);
        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.POWER, 0, -count, typeEnum));
        return true;
    }

    /**
     * 体力是否已满
     *
     * @return
     */
    public boolean isFullPower() {
        final Resource.Builder resourceBuilder = pd.getResourceBuilder();
        return resourceBuilder.getPower() >= resourceBuilder.getMaxPower();
    }

    /**
     * 消耗雷石
     *
     * @param typeEnum
     * @param count
     * @return
     */
    public boolean consumeGem(final ConsumeTypeEnum typeEnum, final int count) {
        if (pd.getResourceBuilder().getLei() < count || count <= 0) {
            return false;
        }
        pd.getResourceBuilder().setLei(pd.getResourceBuilder().getLei() - count);
        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.GEM, 0, -count, typeEnum));

        return true;
    }

    public void consumeGemAssert(final ConsumeTypeEnum typeEnum, final int count) {
        ModuleAssert.isTrue(consumeGem(typeEnum, count));
    }


    /**
     * 设置体力上限
     *
     * @param power
     */
    public void setMaxPower(final int power) {
        pd.getResourceBuilder().setMaxPower(power);
        getTransport().send(No.MaxPowerChangePush, ResourceChangePush.newBuilder().setCurCount(power).build());

    }

    /**
     * 重置体力为最大值
     *
     * @param resourceEnum
     */
    public void resetPower(final ResourceSourceEnum resourceEnum) {
        final int count = pd.getResourceBuilder().getMaxPower() - pd.getResourceBuilder().getPower();
        pd.getResourceBuilder().setPower(pd.getResourceBuilder().getMaxPower());
        EventManager.firePlayerEvent(this, new ResourceChangeEvent(ResourceEnum.POWER, 0, count, resourceEnum)
                .setCurCount(pd.getResourceBuilder().getPower()));
    }


    /**
     * 放置物品到背包指定位置
     * todo 没有检查slotId是否已经有物品
     *
     * @param data
     * @param type
     */
    public void setItem(final int slotId, final ItemData data, final int type) {
        final BagInfoChangePush.Builder bagPushBuilder = BagInfoChangePush.newBuilder();
        final BagUpdateService bagUpdateService = findBagUpdateService(type);
        final BagSlot slot = BagSlot.newBuilder().setSlotId(slotId).setData(data).build();
        bagPushBuilder.addSlot(slot);

        // Player data update
        for (final BagSlot bagSlot : bagPushBuilder.getSlotList()) {
            bagUpdateService.update(this, bagSlot);
        }

        // event
        EventManager.firePlayerEvent(this, new ItemAddEvent(data));

        // push
        transport.send(MsgNo.BagInfoChangePushNo_VALUE, bagPushBuilder.setType(type).build());

    }

    public void addItemToBag(ItemData data) {
        addItem(data, GameConstants.ITEM_BAG);
    }

    /**
     * 添加物品
     *
     * @param data
     */
    public void addItem(final ItemData data, final int type) {
        final BagUpdateService bagUpdateService = findBagUpdateService(type);
        final ItemBoxData box = bagUpdateService.box(this);
        ModuleAssert.isPositive(data.getCount());

        final ItemConfigData dataConfigData = ConfigManager.getItem(data.getItemId());

        // 任务物品不进背包
        if (dataConfigData.type != ItemTypeEnum.TASK) {

            final BagInfoChangePush.Builder bagPushBuilder = BagInfoChangePush.newBuilder();

            final int stack = dataConfigData.stack;
            final List<BagSlot> change = new ArrayList<>(10);
            int remainCount = stack * box.remain();
            if (stack > 1) {// 可堆叠
                if (box.bagSlotMap.containsKey(data.getItemId())) {
                    // 已经有物品
                    final Collection<BagSlot> bagSlots = box.bagSlotMap.get(data.getItemId());
                    for (final BagSlot bagSlot : bagSlots) {
                        if (bagSlot.getData().getCount() < stack) {
                            remainCount += stack - bagSlot.getData().getCount();
                            change.add(bagSlot);
                        }
                    }
                }
            }

            int count = data.getCount();
            ModuleAssert.isTrue(remainCount >= count, ErrorEnum.ERR_104);

            for (final BagSlot changedSlot : change) {
                box.bagSlotMap.remove(changedSlot.getData().getItemId(), changedSlot);

                final int oldCount = changedSlot.getData().getCount();
                final int added = Math.min(stack - oldCount, count);
                count -= added;

                final BagSlot.Builder builder = changedSlot.toBuilder();
                builder.getDataBuilder().setCount(oldCount + added);
                final BagSlot slot = builder.build();

                // change info
                bagPushBuilder.addSlot(slot);
                if (count == 0) {
                    break;
                }
            }
            // 如果还有剩余，则在寻找空闲的格子
            if (count > 0) {

                for (int i = 0; i < box.capacity; i++) {
                    if (bagUpdateService.find(this, i) == null) {
                        // 添加物品
                        final int added = Math.min(stack, count);
                        count -= added;

                        final BagSlot slot = BagSlot.newBuilder().setSlotId(i).setData(data.toBuilder().setCount(added)).build();
                        // change info
                        bagPushBuilder.addSlot(slot);
                        if (count == 0) {
                            break;
                        }
                    }
                }
            }

            // Player data update
            for (final BagSlot bagSlot : bagPushBuilder.getSlotList()) {
                bagUpdateService.update(this, bagSlot);
            }

            // push
            transport.send(MsgNo.BagInfoChangePushNo_VALUE, bagPushBuilder.setType(type).build());
        }

        // event
        EventManager.firePlayerEvent(this, new ItemAddEvent(data));

    }

//    private BagUpdateService findBagUpdateService(final int type) {
//        if (type == 1) {
//            return BagUpdateService.updatePlayerBag;
//        }
//        return updatePlayerBank;
//    }

    /**
     * 整理背包
     * 1:bag
     * 2:bank
     */
    public void cleanBag(final int type) {
        final BagUpdateService bagUpdateService = findBagUpdateService(type);
        final List<BagSlot> collect = bagUpdateService.findAll(this).values().stream().sorted((o1, o2) -> {
            if (o1.getData().getItemId() == o2.getData().getItemId()) {
                return o2.getData().getCount() - o1.getData().getCount();
            }
            return o1.getData().getItemId() - o2.getData().getItemId();
        }).collect(Collectors.toList());
        bagUpdateService.clean(this);
        final List<BagSlot> zipItemList = new ArrayList<>(collect.size());
        int lastIndex = 0;
        for (int i = 0; i < collect.size(); i++) {
            BagSlot bagSlot = collect.get(i);
            if (i > 0) {
                final BagSlot beforeSlot = zipItemList.get(lastIndex);
                if (beforeSlot.getData().getItemId() == bagSlot.getData().getItemId()) {

                    final ItemConfigData dataConfigData = ConfigManager.getItem(beforeSlot.getData().getItemId());
                    final int stack = dataConfigData.stack;
                    final int beforeCount = beforeSlot.getData().getCount();
                    if (stack > 1 && beforeCount < stack) {
                        final int canAdd = stack - beforeCount;

                        final int count = bagSlot.getData().getCount();
                        final BagSlot.Builder beforeBagSlotBild = beforeSlot.toBuilder();
                        if (canAdd < count) {
                            beforeBagSlotBild.getDataBuilder().setCount(stack);
                            bagSlot = bagSlot.toBuilder().setData(bagSlot.getData().toBuilder().setCount(count - canAdd)).build();
                        } else {
                            beforeBagSlotBild.getDataBuilder().setCount(beforeCount + count);
                            bagSlot = null;
                        }
                        zipItemList.set(lastIndex, beforeBagSlotBild.build());
                    }


                }
            }


            if (bagSlot != null) {
                zipItemList.add(bagSlot);
            }

            lastIndex = zipItemList.size() - 1;
        }

        for (int i = 0; i < zipItemList.size(); i++) {
            BagSlot bagSlot = zipItemList.get(i);
            bagSlot = bagSlot.toBuilder().setSlotId(i).build();
            bagUpdateService.update(this, bagSlot);
        }

        // push
        transport.send(MsgNo.BagInfoChangePushNo_VALUE, BagInfoChangePush.newBuilder()
                .setType(type)
                .setClean(true).addAllSlot(bagUpdateService.findAll(this).values()).build());
    }

    /**
     * 从背包/银行移除物品
     *
     * @param type   1:bag,2:bank
     * @param count
     * @param slotId
     */
    public void removeBagItem(final int type, final int count, final int slotId) {
        if (count <= 0) {
            return;
        }
        final BagUpdateService bagUpdateService = findBagUpdateService(type);

        BagSlot bagSlot = bagUpdateService.find(this, slotId);
        bagUpdateService.box(this).bagSlotMap.remove(bagSlot.getData().getItemId(), bagSlot);
        final int remain = Math.max(bagSlot.getData().getCount() - count, 0);

        bagSlot = bagSlot.toBuilder().setData(bagSlot.getData().toBuilder().setCount(remain)).build();
        bagUpdateService.update(this, bagSlot);

        final BagInfoChangePush.Builder builder = BagInfoChangePush.newBuilder().setType(type);
        builder.addSlot(bagSlot.toBuilder().setData(bagSlot.getData().toBuilder().setCount(remain).build()).build());
        transport.send(MsgNo.BagInfoChangePushNo_VALUE, builder.build());
    }


    public int nextId() {
        final int i = D.getLocalId() + 1;
        D.setLocalId(i);
        return i;
    }

    /**
     * 下线
     */
    public void offline() {

    }

    public void update() {

        updateTime = LocalDateTime.now();
    }

    public void setChannel(final Channel channel) {
        transport.setChannel(channel);
        transport.getChannel().attr(GameConstants.pid).set(pid);
    }

    /**
     * @param millisecond
     * @param msgNo       发送的消息号
     */
    public void scheduleAfter(final long millisecond, final int msgNo) {
        G.S.doSchedule(() -> G.sendToPlayer(pid, msgNo), millisecond);
    }

    public void scheduleAfter(final long millisecond, final int msgNo, final MessageLite messageLite) {
        G.S.doSchedule(() -> G.sendToPlayer(pid, msgNo, messageLite), millisecond);
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

    public void send(final No msgNo, final MessageLite msg) {
        transport.send(msgNo.getNumber(), msg);
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

    public void setCreateTime(final LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setLoginTime(final LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public void setUpdateTime(final LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }


}
