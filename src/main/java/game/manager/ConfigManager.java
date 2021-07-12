package game.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import game.base.AbsLifecycle;
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


    public Map<Integer, DataConfigData> dataMap7;


    public static Map<Integer, DataConfigData> taskMap4;

    // Npc任务
    public Multimap<Integer, DataConfigData> npcTaskMap = ArrayListMultimap.create(128, 16);

    public static Multimap<Integer, DataConfigData> levelTaskMap = ArrayListMultimap.create(60, 4);

    // 参数
    public static final ParamConfigData paramConfigData = new ParamConfigData();

    private Map<Integer, TransformConfigData> transformMap;

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

    public static final EmptyDataBox enemyNameBox = new EmptyDataBox("data/enemy_怪列表.json");

    public static final PropertyDataBox lilianBox = new PropertyDataBox("data/hero_历练.json");

    public static final PropertyDataBox xiulianBox = new PropertyDataBox("data/hero_修炼.json");

    public static final TempleHeroDataBox templeHeroDataBox = new TempleHeroDataBox();
    public static final ShopDataBox shopDataBox = new ShopDataBox();

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
        list.add(enemyNameBox);
        list.add(lilianBox);
        list.add(xiulianBox);
        list.add(templeHeroDataBox);
        list.add(shopDataBox);
    }

    @Override
    public void start() {
        super.start();
        dataMap7 = new JsonConfig("data/data_7-地区.json", 16).load();
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
                .setHp(CalcUtil.change100(v.getHp(), f.hp))
                .setDamage(CalcUtil.change100(v.getDamage(), f.damage))
                .setDef(CalcUtil.change100(v.getDef(), f.def))
                .setDefBase(CalcUtil.change100(v.getDefBase(), f.defBase))
                .setAvoid(CalcUtil.change100(v.getAvoid(), f.avoid))
                .setAvoidBase(CalcUtil.change100(v.getAvoidBase(), f.avoidBase))
                .setCritical(CalcUtil.change100(v.getCritical(), f.critical))
                .setCriticalBase(CalcUtil.change100(v.getCriticalBase(), f.criticalBase))
                .setCriticalDamage(CalcUtil.change100(v.getCriticalDamage(), f.criticalDamage))
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
        //region todo 需要根据heroid获取数据
        return heroBaseDataBox.findById(level);
        //endregion
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

    public static PropertyConfigData GetPowerUpData(final int id, final int level) {

        if (id < 10) {
            return lilianBox.findById(level);
        } else if (id < 20) {
            return xiulianBox.findById(level);
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
        return shopDataBox.findById(id);
    }

    public static TitleConfigData getTitle(final int id) {
        return titleDataBox.findById(id);
    }

    public static String getHeroName(final int heroId) {
        return heroDataBox.findById(heroId).name;
    }


    public static String getEnemyName(final int id) {
        return enemyNameBox.findById(id).name;
    }
}

