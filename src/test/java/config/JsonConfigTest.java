package config;

import com.fasterxml.jackson.core.type.TypeReference;
import game.config.JsonConfig;
import game.config.TaskConfigData1;
import game.config.TaskConfigData2;
import game.config.TaskConfigData4;
import org.junit.Test;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:03
 */
public class JsonConfigTest {


    @Test
    public void test1() {

        JsonConfig config = new JsonConfig("data/task_对话.json") {
            @Override
            protected TypeReference<Map<Integer, TaskConfigData1>> type() {
                return new TypeReference<Map<Integer, TaskConfigData1>>() {
                };
            }
        };


        Map<Integer, TaskConfigData1> load = config.load();
        TaskConfigData1 taskConfigData1 = load.get(1001);

        System.out.println(load);
    }

    @Test
    public void test2() {

        JsonConfig config = new JsonConfig("data/task_2-对话选项.json") {
            @Override
            protected TypeReference<Map<Integer, TaskConfigData2>> type() {
                return new TypeReference<Map<Integer, TaskConfigData2>>() {
                };
            }
        };


        Map<Integer, TaskConfigData2> load = config.load();
        TaskConfigData2 task1ConfigData = load.get(1);

        System.out.println(load);
    }
    @Test
    public void task5() {

        JsonConfig config = new JsonConfig("data/task_4-任务.json") {
            @Override
            protected TypeReference type() {
                return new TypeReference<Map<Integer, TaskConfigData4>>() {
                };
            }
        };


        Map<Integer, TaskConfigData4> load = config.load();
        TaskConfigData4 task1ConfigData = load.get(1);

        System.out.println(load);
    }
}
