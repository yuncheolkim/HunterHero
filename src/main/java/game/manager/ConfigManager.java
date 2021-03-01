package game.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import game.base.AbsLifecycle;
import game.config.*;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 18:58
 */
public class ConfigManager extends AbsLifecycle {

    public Map<Integer, DataConfigData1> dataMap1;

    public Map<Integer, DataConfigData2> dataMap2;

    public Map<Integer, DataConfigData3> dataMap3;

    public Map<Integer, DataConfigData4> dataMap4;

    public Map<Integer, DataConfigData5> dataMap5;

    public Map<Integer, DataConfigData6> dataMap6;

    public Map<Integer, DataConfigData7> dataMap7;
    public Map<Integer, DataConfigData8> dataMap8;

    public Map<Integer, DataConfigData9> dataMap9;

    public Map<Integer, TaskConfigData1> taskMap1;

    public Map<Integer, TaskConfigData2> taskMap2;

    public Map<Integer, TaskConfigData3> taskMap3;

    public Map<Integer, TaskConfigData4> taskMap4;

    public Map<Integer, TaskConfigData5> taskMap5;

    public Map<Integer, HeroConfigData1> heroMap1;
    @Override
    public void start() {
        super.start();
        dataMap1 = new JsonConfig("data/data_1-hero.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData1>>() {
                };
            }
        }.load();
        dataMap2 = new JsonConfig("data/data_2-skill.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData2>>() {
                };
            }
        }.load();
        dataMap3 = new JsonConfig("data/data_3-buff.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData3>>() {
                };
            }
        }.load();
        dataMap4 = new JsonConfig("data/data_4-npc.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData4>>() {
                };
            }
        }.load();
        dataMap5 = new JsonConfig("data/data_5-怪物id.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData5>>() {
                };
            }
        }.load();
        dataMap6 = new JsonConfig("data/data_6-item.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData6>>() {
                };
            }
        }.load();
        dataMap7 = new JsonConfig("data/data_7-地区.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData7>>() {
                };
            }
        }.load();
        dataMap8 = new JsonConfig("data/data_8-参数.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData8>>() {
                };
            }
        }.load();
        dataMap9 = new JsonConfig("data/data_9-经验.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, DataConfigData9>>() {
                };
            }
        }.load();
        taskMap1 = new JsonConfig("data/task_1-对话.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData1>>() {
                };
            }
        }.load();

        taskMap2 = new JsonConfig("data/task_2-对话选项.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData2>>() {
                };
            }
        }.load();
        taskMap3 = new JsonConfig("data/task_3-选项内容.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData3>>() {
                };
            }
        }.load();
        taskMap4 = new JsonConfig("data/task_4-任务.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData4>>() {
                };
            }
        }.load();
        taskMap5 = new JsonConfig("data/task_5-任务目标.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData5>>() {
                };
            }
        }.load();
        heroMap1 = new JsonConfig("data/hero_1-base.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, HeroConfigData1>>() {
                };
            }
        }.load();

        /////
    }
}
