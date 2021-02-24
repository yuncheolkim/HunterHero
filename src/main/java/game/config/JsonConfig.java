package game.config;

import com.fasterxml.jackson.core.type.TypeReference;
import game.base.Logs;
import game.utils.FileUtils;
import game.utils.JsonUtil;

import java.util.Map;
import java.util.Objects;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 16:57
 */
public class JsonConfig {

    private String fileName;


    public JsonConfig(String fileName) {
        this.fileName = fileName;
    }

    public <T> Map<Integer, T> load() {
        try {
            String s = FileUtils.readFile(Objects.requireNonNull(getClass().getClassLoader().getResource("data/task_对话.json")).toURI());
            return JsonUtil.fromJsonString(s, type());
        } catch (Exception e) {
            Logs.C.error(fileName, e);
        }
        return null;
    }

    protected <T> TypeReference<Map<Integer, T>> type() {
        return new TypeReference<Map<Integer, T>>() {
        };
    }

}
