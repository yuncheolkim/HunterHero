package game.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import game.base.AbsLifecycle;
import game.base.G;
import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.config.base.IConfigParse;
import game.config.base.JsonConfig;
import game.config.box.*;
import game.config.data.*;
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


    public static Map<Integer, DataConfigData> dataMap5;


    public Map<Integer, DataConfigData> dataMap7;


    public Map<Integer, DataConfigData> dataMap12;

    public Map<Integer, DataConfigData> dataMap13;


    public static Map<Integer, DataConfigData> taskMap4;

    // Npc任务
    public Multimap<Integer, DataConfigData> npcTaskMap = ArrayListMultimap.create(128, 16);

    public static Multimap<Integer, DataConfigData> levelTaskMap = ArrayListMultimap.create(60, 4);

    // 参数
    public static final ParamConfigData paramConfigData = new ParamConfigData();

    private Map<Integer, TransformConfigData> transformMap;

    // 18-shop
    private static Map<Integer, ShopConfigData> shopMap;

    // Data box
    public static final HeroBaseDataBox heroBaseDataBox = new HeroBaseDataBox();

    public static final TitleDataBox titleDataBox = new TitleDataBox();

    public static final FishAreaDataBox fishAreaDataBox = new FishAreaDataBox();

    public static final FishDataBox fishWeightAreaDataBox = new FishDataBox();

    public static final ExpDataBox expDataBox = new ExpDataBox();

    public static final BattleFormationDataBox battleFormationDataBox = new BattleFormationDataBox();

    public static final ItemDataBox itemDataBox = new ItemDataBox();

    public static final EnemyCountDataBox enemyCountDataBox = new EnemyCountDataBox();

    public static final DropItemAreaDataBox dropItemAreaDataBox = new DropItemAreaDataBox();

    public static final DropItemEnemyDataBox dropItemEnemyDataBox = new DropItemEnemyDataBox();

    public static final HeroDataBox heroDataBox = new HeroDataBox();

    public static final TalentDataBox talentDataBox = new TalentDataBox();

    public static final BuffDataBox buffDataBox = new BuffDataBox();

    public static final TaskTargetDataBox taskTargetDataBox = new TaskTargetDataBox();

    public static final Enemy1DataBox enemy1DataBox = new Enemy1DataBox();

    public static final EnemyPropertyDataBox enemyPropertyDataBox = new EnemyPropertyDataBox();

    public static final SkillDataBox skillDataBox = new SkillDataBox();

    private static final List<IConfigParse> list = new ArrayList<>(32);

    static {
        list.add(heroBaseDataBox);
        list.add(battleFormationDataBox);
        list.add(titleDataBox);
        list.add(fishAreaDataBox);
        list.add(fishWeightAreaDataBox);
        list.add(expDataBox);
        list.add(itemDataBox);
        list.add(enemyCountDataBox);
        list.add(dropItemAreaDataBox);
        list.add(dropItemEnemyDataBox);
        list.add(heroDataBox);
        list.add(talentDataBox);
        list.add(buffDataBox);
        list.add(taskTargetDataBox);
        list.add(enemy1DataBox);
        list.add(enemyPropertyDataBox);
        list.add(skillDataBox);
    }

    @Override
    public void start() {
        super.start();
        dataMap5 = new JsonConfig("data/data_5-怪物id.json").load();
        dataMap7 = new JsonConfig("data/data_7-地区.json", 16).load();
        dataMap12 = new JsonConfig("data/data_12-历练.json", 64).load();
        dataMap13 = new JsonConfig("data/data_13-修炼.json", 32).load();
        taskMap4 = new JsonConfig("data/task_4-任务.json").load();
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

        // 解析配置表
        for (final IConfigParse iConfigParse : list) {
            iConfigParse.parse();
        }
        for (final IConfigParse iConfigParse : list) {
            iConfigParse.afterAllLoad();
        }
        for (final IConfigParse iConfigParse : list) {
            iConfigParse.end();
        }
    }

    public static Property makePropertyFromHero(final DataConfigData f) {
        return makeProperty(heroBaseDataBox.findById(f.level).property, f);
    }

    /**
     * @param v
     * @param factory
     * @return
     */
    public static Property makeProperty(final Property v, final DataConfigData f) {
        return Property.newBuilder()
                .setHp(CalcUtil.add100(v.getHp(), f.hp))
                .setDamage(CalcUtil.add100(v.getDamage(), f.damage))
                .setDef(CalcUtil.add100(v.getDef(), f.def))
                .setDefBase(CalcUtil.add100(v.getDefBase(), f.defBase))
                .setAvoid(CalcUtil.add100(v.getAvoid(), f.avoid))
                .setAvoidBase(CalcUtil.add100(v.getAvoidBase(), f.avoidBase))
                .setCritical(CalcUtil.add100(v.getCritical(), f.critical))
                .setCriticalBase(CalcUtil.add100(v.getCriticalBase(), f.criticalBase))
                .setCriticalDamage(CalcUtil.add100(v.getCriticalDamage(), f.criticalDamage))
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
    public static int needExp(final int level) {
        final ExpConfigData dataConfigData = expDataBox.findById(level);
        if (dataConfigData == null) {
            return Integer.MAX_VALUE;
        }
        return dataConfigData.needExp;
    }

    public static ExpConfigData getExp(final int level) {
        return expDataBox.findById(level);
    }

    /**
     * 获得英雄基础属性
     *
     * @param heroId
     * @param level
     * @return
     */
    public static HeroBaseConfigData heroBaseProperty(final int heroId, final int level) {
        // todo
        return heroBaseDataBox.findById(level);
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


    public static Enemy1ConfigData getFightArea(final int areaId) {
        return enemy1DataBox.findById(areaId);
    }

    public static ItemConfigData getItem(final int itemId) {
        return itemDataBox.findById(itemId);
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

    public static int GetInitPower() {
        return paramConfigData.initPower;
    }

    public static ShopConfigData getShop(final int id) {
        return shopMap.get(id);
    }

    public static TitleConfigData getTitle(final int id) {
        return titleDataBox.findById(id);
    }

    public static String getHeroName(final int heroId) {
        return heroDataBox.findById(heroId).name;
    }


    public static String getEnemyName(final int id) {
        return dataMap5.get(id).name;
    }
}

