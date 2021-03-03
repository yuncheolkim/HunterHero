package game.manager;

import game.base.AbsLifecycle;
import game.config.DataConfigData;
import game.config.JsonConfig;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 18:58
 */
public class ConfigManager extends AbsLifecycle {

    public Map<Integer, DataConfigData> dataMap1;

    public Map<Integer, DataConfigData> dataMap2;

    public Map<Integer, DataConfigData> dataMap3;

    public Map<Integer, DataConfigData> dataMap4;

    public Map<Integer, DataConfigData> dataMap5;

    public Map<Integer, DataConfigData> dataMap6;

    public Map<Integer, DataConfigData> dataMap7;

    public Map<Integer, DataConfigData> dataMap8;

    public Map<Integer, DataConfigData> dataMap9;

    public Map<Integer, DataConfigData> dataMap10;

    public Map<Integer, DataConfigData> dataMap11;

    public Map<Integer, DataConfigData> dataMap12;

    public Map<Integer, DataConfigData> dataMap13;

    public Map<Integer, DataConfigData> dataMap14;

    public Map<Integer, DataConfigData> taskMap1;

    public Map<Integer, DataConfigData> taskMap2;

    public Map<Integer, DataConfigData> taskMap3;

    public Map<Integer, DataConfigData> taskMap4;

    public Map<Integer, DataConfigData> taskMap5;

    public Map<Integer, DataConfigData> heroMap1001;

    /////////////


    @Override
    public void start() {
        super.start();
        dataMap1 = new JsonConfig("data/data_1-hero.json").load();
        dataMap2 = new JsonConfig("data/data_2-skill.json").load();
        dataMap3 = new JsonConfig("data/data_3-buff.json").load();
        dataMap4 = new JsonConfig("data/data_4-npc.json").load();
        dataMap5 = new JsonConfig("data/data_5-怪物id.json").load();
        dataMap6 = new JsonConfig("data/data_6-item.json").load();
        dataMap7 = new JsonConfig("data/data_7-地区.json").load();
        dataMap8 = new JsonConfig("data/data_8-参数.json").load();
        dataMap9 = new JsonConfig("data/data_9-经验.json").load();
        dataMap10 = new JsonConfig("data/data_10-资源.json").load();
        dataMap11 = new JsonConfig("data/data_11-称谓.json").load();
        dataMap12 = new JsonConfig("data/data_12-历练.json").load();
        dataMap13 = new JsonConfig("data/data_13-修炼.json").load();
        dataMap14 = new JsonConfig("data/data_14-历练修炼选项.json").load();
        taskMap1 = new JsonConfig("data/task_1-对话.json").load();

        taskMap2 = new JsonConfig("data/task_2-对话选项.json").load();
        taskMap3 = new JsonConfig("data/task_3-选项内容.json").load();
        taskMap4 = new JsonConfig("data/task_4-任务.json").load();
        taskMap5 = new JsonConfig("data/task_5-任务目标.json").load();
        heroMap1001 = new JsonConfig("data/hero_1001.json").load();

        ///// 进一步加工


    }
}
