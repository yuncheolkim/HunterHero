package game.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import game.base.AbsLifecycle;
import game.config.DataConfigData;
import game.config.JsonConfig;
import game.config.drop.DropItemConfigData;
import game.config.enmey.EnemyAreaConfigData;
import game.config.enmey.EnemyConfigData;
import game.config.enmey.EnemyCountConfigData;
import game.config.param.ParamConfigData;

import java.util.*;

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

    public Map<Integer, DataConfigData> dataMap8;

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

    public Map<Integer, DataConfigData> taskMap4;

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
    private Map<Integer, DataConfigData> itemMap;

    // Npc任务
    public Multimap<Integer, DataConfigData> npcTaskMap = ArrayListMultimap.create(128, 16);

    // 参数
    private ParamConfigData paramConfigData = new ParamConfigData();


    @Override
    public void start() {
        super.start();
        dataMap1 = new JsonConfig("data/data_1-hero.json", 32).load();
        dataMap2 = new JsonConfig("data/data_2-skill.json").load();
        dataMap3 = new JsonConfig("data/data_3-buff.json").load();
        dataMap4 = new JsonConfig("data/data_4-npc.json").load();
        dataMap5 = new JsonConfig("data/data_5-怪物id.json").load();
        dataMap7 = new JsonConfig("data/data_7-地区.json", 16).load();
        dataMap8 = new JsonConfig("data/data_8-参数.json", 32).load();
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
        heroMap1001 = new JsonConfig("data/hero_1001.json").load();

        // item
        ImmutableMap.Builder<Integer, DataConfigData> itemConfigDataBuilder = ImmutableMap.builderWithExpectedSize(64);
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_base.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-1.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-2.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-3.json").load());
        itemConfigDataBuilder.putAll(new JsonConfig("data/item_装备4-4.json").load());
        itemMap = itemConfigDataBuilder.build();


        ///// 进一步加工
        Map<Integer, EnemyAreaConfigData> map = new HashMap<>();

        for (DataConfigData value : dataMap15.values()) {

            EnemyAreaConfigData enemyAreaConfigData = map.computeIfAbsent(value.enemyAreaId, id -> {
                EnemyAreaConfigData d = new EnemyAreaConfigData();
                d.id = id;
                d.enemyList = new ArrayList<>();
                return d;
            });

            EnemyConfigData enemyConfigData = new EnemyConfigData();

            enemyConfigData.id = value.enemyId;
            enemyConfigData.weight = value.weight;
            enemyConfigData.level = value.level;
            enemyConfigData.hp = value.hp;
            enemyConfigData.damage = value.damage;
            enemyConfigData.def = value.def;
            enemyConfigData.defBase = value.defBase;
            enemyConfigData.avoid = value.avoid;
            enemyConfigData.avoidBase = value.avoidBase;
            enemyConfigData.critical = value.critical;
            enemyConfigData.criticalBase = value.criticalBase;
            enemyConfigData.criticalDamage = value.criticalDamage;
            enemyConfigData.speed = value.speed;
            enemyAreaConfigData.weightAll += enemyConfigData.weight;

            enemyAreaConfigData.enemyList.add(enemyConfigData);
        }
        enemyInfoMap = map;

        Map<Integer, List<EnemyCountConfigData>> map1 = new HashMap<>();
        for (DataConfigData value : dataMap16.values()) {

            List<EnemyCountConfigData> m2 = map1.computeIfAbsent(value.enemyAreaId, id -> new ArrayList<>());

            EnemyCountConfigData e = new EnemyCountConfigData();
            e.weight = value.weight;
            e.count = value.count;
            m2.add(e);
        }

        enemyCountMap = map1;
        // drop
        Map<Integer, List<DropItemConfigData>> map2 = new HashMap<>();
        Map<Integer, List<DropItemConfigData>> map3 = new HashMap<>();
        for (DataConfigData value : dataMap17.values()) {
            DropItemConfigData d = new DropItemConfigData();
            d.count = value.count;
            d.rate = value.weight;
            d.itemId = value.itemId;
            if (value.type == 1) {
                List<DropItemConfigData> list = map3.computeIfAbsent(value.enemyId, integer -> new ArrayList<>());
                list.add(d);
            } else if (value.type == 2) {
                List<DropItemConfigData> list = map2.computeIfAbsent(value.areaId, integer -> new ArrayList<>());
                list.add(d);
            }
        }

        areaDropMap = map2;
        enemyDropMap = map3;

        Map<Integer, List<DropItemConfigData>> map4 = new HashMap<>();

        // npc
        for (DataConfigData value : taskMap4.values()) {
            npcTaskMap.put(value.npcId, value);
        }

        // param

        paramConfigData.fishPower = dataMap8.get(5).count;
        paramConfigData.fishSuccessTime = dataMap8.get(6).count;

    }

    /**
     * 升级需要的经验
     *
     * @param level
     * @return
     */
    public int needExp(int level) {
        DataConfigData dataConfigData = dataMap9.get(level);
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
    public DataConfigData heroBaseProperty(int heroId, int level) {
        // tood
        return heroMap1001.get(level);
    }

    /**
     * 背包初始容量
     *
     * @return
     */
    public int bagCapacity() {
        return dataMap8.get(3).count;
    }

    /**
     * 银行初始容量
     *
     * @return
     */
    public int bankCapacity() {
        return dataMap8.get(4).count;
    }

    public EnemyAreaConfigData getFightArea(int areaId) {
        return enemyInfoMap.get(areaId);
    }

    public DataConfigData getItem(int itemId) {
        return itemMap.get(itemId);
    }

    /**
     * 任务
     *
     * @param taskId
     * @return
     */
    public DataConfigData getTask(int taskId) {
        return taskMap4.get(taskId);
    }

    /**
     * npc任务
     *
     * @return
     */
    public Collection<DataConfigData> getNpcTask(int npcId) {

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
}

