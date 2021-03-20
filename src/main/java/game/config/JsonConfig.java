package game.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import game.base.GameConstants;
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

    private final String fileName;

    private Map<Integer, DataConfigData> map;

    private int initSize = 128;

    public JsonConfig(String fileName) {
        this.fileName = fileName;
    }

    public JsonConfig(String fileName, int size) {
        this.fileName = fileName;
        initSize = size;
    }

    public Map<Integer, DataConfigData> load() {
        try {
            Logs.C.info(GameConstants.TOKEN_START + "加载配置文件:{}", fileName);
            String s = FileUtils.readFile(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI());
            ImmutableMap.Builder<Integer, DataConfigData> b = ImmutableMap.builderWithExpectedSize(initSize);
            return b.putAll(JsonUtil.fromJsonString(s, new TypeReference<Map<Integer, DataConfigData>>() {
            })).build();
        } catch (Exception e) {
            Logs.C.error(fileName, e);
            throw new RuntimeException(e);
        } finally {
            Logs.C.info(GameConstants.TOKEN_END + "加载配置文件结束:{}", fileName);
        }
    }

    public Map<Integer, DataConfigData> getMap() {
        return map;
    }
}
