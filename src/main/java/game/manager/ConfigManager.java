package game.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import game.base.AbsLifecycle;
import game.base.G;
import game.config.*;
import game.config.base.BaseConfigData;
import game.config.base.JsonConfig;
import game.config.drop.DropItemConfigData;
import game.config.enmey.EnemyAreaConfigData;
import game.config.enmey.EnemyConfigData;
import game.config.enmey.EnemyCountConfigData;
import game.config.enmey.EnemyTemplateDataBox;
import game.config.fish.FishAreaDataBox;
import game.config.param.ParamConfigData;
import game.proto.data.Property;
import game.utils.CalcUtil;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 所有游戏配置表
 *
 * @author Yunzhe.Jin
 * 2021/2/24 18:58
 */
public class ConfigManager extends AbsLifecycle {

    public Map<Integer, DataConfigData> dataMap1;

    public Map<Integer, DataConfigData> dataMap2;

    public Map<Integer, DataConfigData> dataMap3;

    public Map<Integer, DataConfigData> dataMap4;

    public Map<Integer, DataConfigData> dataMap5;


    public Map<Integer, DataConfigData> dataMap7;

    public Map<Integer, DataConfigData> dataMap9;

    public Map<Integer, DataConfigData> dataMap10;

    public Map<Integer, DataConfigData> dataMap11;

    public Map<Integer, DataConfigData> dataMap12;

    public Map<Integer, DataConfigData> dataMap13;

    public Map<Integer, DataConfigData> dataMap14;

    public Map<Integer, DataConfigData> dataMap15;

    public Map<Integer, DataConfigData> dataMap16;

    public Map<Integer, DataConfigData> dataMap17;

    public Map<Integer, DataConfigData> dataMap18;

    public Map<Integer, DataConfigData> taskMap1;

    public Map<Integer, DataConfigData> taskMap2;

    public Map<Integer, DataConfigData> taskMap3;

    public static Map<Integer, DataConfigData> taskMap4;

    public Map<Integer, DataConfigData> taskMap5;

    public Map<Integer, DataConfigData> heroMap1001;


    /////////////

    public Map<Integer, EnemyAreaConfigData> enemyInfoMap;

    public Map<Integer, List<EnemyCountConfigData>> enemyCountMap;

    // 区域掉落
    public Map<Integer, List<DropItemConfigData>> areaDropMap;

    // 敌人掉落
    public Map<Integer, List<DropItemConfigData>> enemyDropMap;

    // item
    private static Map<Integer, DataConfigData> itemMap;

    // Npc任务
    public Multimap<Integer, DataConfigData> npcTaskMap = ArrayListMultimap.create(128, 16);
    public static Multimap<Integer, DataConfigData> levelTaskMap = ArrayListMultimap.create(60, 4);

    // 参数
    public static final ParamConfigData paramConfigData = new ParamConfigData();

    private Map<Integer, TransformConfigData> transformMap;

    // 18-shop
    private static Map<Integer, ShopConfigData> shopMap;

    private static final EnemyTemplateDataBox enemyTemplateBox = new EnemyTemplateDataBox();

    // 11-称谓
    private static final TitleDataBox titleDataBox = new TitleDataBox();
    // fish
    public static final FishAreaDataBox fishAreaDataBox = new FishAreaDataBox();

    @Override

    public void start() {
        super.start();
        dataMap1 = new JsonConfig("data/data_1-hero.json", 32).load();
        dataMap2 = new JsonConfig("data/data_2-skill.json").load();
        dataMap3 = new JsonConfig("data/data_3-buff.json").load();
        dataMap4 = new JsonConfig("data/data_4-npc.json").load();
        dataMap5 = new JsonConfig("data/data_5-怪物id.json").load();
        dataMap7 = new JsonConfig("data/data_7-地区.json", 16).load();
        dataMap9 = new JsonConfig("data/data_9-经验.json", 64).load();
        dataMap10 = new JsonConfig("data/data_10-资源.json", 16).load();
        dataMap11 = new JsonConfig("data/data_11-称谓.json", 32).load();
        dataMap12 = new JsonConfig("data/data_12-历练.json", 64).load();
        dataMap13 = new JsonConfig("data/data_13-修炼.json", 32).load();
        dataMap14 = new JsonConfig("data/data_14-历练修炼选项.json").load();
        dataMap15 = new JsonConfig("data/data_15-enemy.json").load();
        dataMap16 = new JsonConfig("data/data_16-区域敌人数量.json").load();
        dataMap17 = new JsonConfig("data/data_17-掉落.json").load();
        dataMap18 = new JsonConfig("data/data_18-商店.json").load();
        taskMap1 = new JsonConfig("data/task_1-对话.json").load();

        taskMap2 = new JsonConfig("data/task_2-对话选项.json").load();
        taskMap3 = new JsonConfig("data/task_3-选项内容.json").load();
        taskMap4 = new JsonConfig("data/task_4-任务.json").load();
        taskMap5 = new JsonConfig("data/task_5-任务目标.json").load();
        heroMap1001 = new JsonConfig("data/hero_base.json").load();

        // item
        final ImmutableMap.Builder<Integer, DataConfigData> itemConfigDataBuilder = ImmutableMap.builderWithExpectedSize(64);
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_base.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-1.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-2.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-3.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-4.json").load());
        itemMap = itemConfigDataBuilder.build();


        ///// 进一步加工
        // 21-怪模版
        enemyTemplateBox.parse();

        final Map<Integer, EnemyAreaConfigData> map = new HashMap<>();

        for (final DataConfigData value : dataMap15.values()) {

            final EnemyAreaConfigData enemyAreaConfigData = map.computeIfAbsent(value.enemyAreaId, id -> {
                final EnemyAreaConfigData d = new EnemyAreaConfigData();
                d.id = id;
                d.enemyList = new ArrayList<>();
                return d;
            });

            final EnemyConfigData enemyConfigData = new EnemyConfigData();

            enemyConfigData.id = value.enemyId;
            enemyConfigData.weight = value.weight;
            enemyConfigData.level = value.level;
            enemyConfigData.property = makeProperty(GetEnemyTemplate(value.level), value);

            enemyAreaConfigData.weightAll += enemyConfigData.weight;

            enemyAreaConfigData.enemyList.add(enemyConfigData);
        }
        enemyInfoMap = map;

        final Map<Integer, List<EnemyCountConfigData>> map1 = new HashMap<>();
        for (final DataConfigData value : dataMap16.values()) {

            final List<EnemyCountConfigData> m2 = map1.computeIfAbsent(value.enemyAreaId, id -> new ArrayList<>());

            final EnemyCountConfigData e = new EnemyCountConfigData();
            e.weight = value.weight;
            e.count = value.count;
            m2.add(e);
        }

        enemyCountMap = map1;
        // drop
        final Map<Integer, List<DropItemConfigData>> map2 = new HashMap<>();
        final Map<Integer, List<DropItemConfigData>> map3 = new HashMap<>();
        for (final DataConfigData value : dataMap17.values()) {
            final DropItemConfigData d = new DropItemConfigData();
            d.count = value.count;
            d.rate = value.weight;
            d.itemId = value.itemId;
            if (value.type == 1) {
                final List<DropItemConfigData> list = map3.computeIfAbsent(value.enemyId, integer -> new ArrayList<>());
                list.add(d);
            } else if (value.type == 2) {
                final List<DropItemConfigData> list = map2.computeIfAbsent(value.areaId, integer -> new ArrayList<>());
                list.add(d);
            }
        }

        areaDropMap = map2;
        enemyDropMap = map3;

        final Map<Integer, List<DropItemConfigData>> map4 = new HashMap<>();

        // npc task
        for (final DataConfigData value : taskMap4.values()) {
            npcTaskMap.put(value.npcId, value);
        }
        // level task
        for (final DataConfigData task : taskMap4.values()) {
            levelTaskMap.put(task.level, task);
        }

        // param
        new JsonConfig("data/data_8-参数.json", 32).load().values().forEach(paramConfigData::Init);

        // 20-传送点
        transformMap = makeMapData("data/data_20-传送点.json", TransformConfigData::new);

        // 18-商店
        shopMap = makeMapData("data/data_18-商店.json", ShopConfigData::new);

        // 11-称谓
        titleDataBox.parse();
        // fish
        fishAreaDataBox.parse();

    }

    /**
     * @param v
     * @param factory
     * @return
     */
    public static Property makeProperty(final Property v, final DataConfigData f) {
        return Property.newBuilder()
                .setHp(CalcUtil.calcRateAdd(v.getHp(), f.hp))
                .setDamage(CalcUtil.calcRateAdd(v.getDamage(), f.damage))
                .setDef(CalcUtil.calcRateAdd(v.getDef(), f.def))
                .setDefBase(CalcUtil.calcRateAdd(v.getDefBase(), f.defBase))
                .setAvoid(CalcUtil.calcRateAdd(v.getAvoid(), f.avoid))
                .setAvoidBase(CalcUtil.calcRateAdd(v.getAvoidBase(), f.avoidBase))
                .setCritical(CalcUtil.calcRateAdd(v.getCritical(), f.critical))
                .setCriticalBase(CalcUtil.calcRateAdd(v.getCriticalBase(), f.criticalBase))
                .setCriticalDamage(CalcUtil.calcRateAdd(v.getCriticalDamage(), f.criticalDamage))
                .build();
    }

    public static Property makeProperty(final DataConfigData v) {
        return Property.newBuilder()
                .setHp(v.hp)
                .setDamage(v.damage)
                .setDef(v.def)
                .setDefBase(v.defBase)
                .setAvoid(v.avoid)
                .setAvoidBase(v.avoidBase)
                .setCritical(v.critical)
                .setCriticalBase(v.criticalBase)
                .setCriticalDamage(v.criticalDamage)
                .build();
    }

    /**
     * 配置数据
     *
     * @param path
     * @param supplier
     * @param <T>
     * @return
     */
    private <T extends BaseConfigData<T>> Map<Integer, T> makeMapData(final String path, final Supplier<T> supplier) {
        final ImmutableMap.Builder<Integer, T> temp = ImmutableMap.builder();
        new JsonConfig(path).load().forEach((integer, dataConfigData) -> temp.put(integer, supplier.get().convert(dataConfigData)));
        return temp.build();
    }

    private <T extends BaseConfigData<T>> List<T> makeListData(final String path, final Supplier<T> supplier) {
        final Map<Integer, DataConfigData> load = new JsonConfig(path).load();
        final Object[] l = new Object[load.size() + 16];
        load.forEach((integer, dataConfigData) -> l[dataConfigData.id] = supplier.get().convert(dataConfigData)
        );


        return Arrays.stream(l).map(o -> (T) o).collect(Collectors.toList());
    }

    /**
     * 升级需要的经验
     *
     * @param level
     * @return
     */
    public int needExp(final int level) {
        final DataConfigData dataConfigData = dataMap9.get(level);
        if (dataConfigData == null) {
            return Integer.MAX_VALUE;
        }
        return dataConfigData.exp;
    }

    /**
     * 获得英雄基础属性
     *
     * @param heroId
     * @param level
     * @return
     */
    public DataConfigData heroBaseProperty(final int heroId, final int level) {
        // todo
        return heroMap1001.get(level);
    }

    /**
     * 背包初始容量
     *
     * @return
     */
    public int bagCapacity() {
        return paramConfigData.bagCapacity;
    }

    /**
     * 银行初始容量
     *
     * @return
     */
    public int bankCapacity() {
        return paramConfigData.bankCapacity;
    }

    public EnemyAreaConfigData getFightArea(final int areaId) {
        return enemyInfoMap.get(areaId);
    }

    public static DataConfigData getItem(final int itemId) {
        return itemMap.get(itemId);
    }

    /**
     * 任务
     *
     * @param taskId
     * @return
     */
    public DataConfigData getTask(final int taskId) {
        return taskMap4.get(taskId);
    }

    /**
     * npc任务
     *
     * @return
     */
    public Collection<DataConfigData> getNpcTask(final int npcId) {
        return npcTaskMap.get(npcId);
    }

    /**
     * 钓鱼消耗的体力
     *
     * @return
     */
    public int powerFish() {
        return paramConfigData.fishPower;
    }

    public ParamConfigData getParamConfigData() {
        return paramConfigData;
    }

    public DataConfigData GetPowerUpData(final int id, final int level) {

        if (id < 10) {
            return G.C.dataMap12.get(level);
        } else if (id < 20) {
            return G.C.dataMap13.get(level);
        }
        return null;
    }

    public TransformConfigData transformConfigData(final int id) {
        return transformMap.get(id);
    }

    public static Property GetEnemyTemplate(final int level) {
        return enemyTemplateBox.findById(level).property;
    }

    public static int GetInitPower() {
        return paramConfigData.initPower;
    }

    public static ShopConfigData getShop(final int id) {
        return shopMap.get(id);
    }

    public static TitleConfigData getTitle(final int id) {
        return titleDataBox.findById(id);
    }

}

