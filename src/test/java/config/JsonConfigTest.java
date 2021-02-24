package config;

import com.fasterxml.jackson.core.type.TypeReference;
import game.config.JsonConfig;
import game.config.TaskDialogConfigData;
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
            protected TypeReference<Map<Integer, TaskDialogConfigData>> type() {
                return new TypeReference<Map<Integer, TaskDialogConfigData>>() {
                };
            }
        };


        Map<Integer, TaskDialogConfigData> load = config.load();
        TaskDialogConfigData taskDialogConfigData = load.get(1001);

        System.out.println(load);
    }

}
