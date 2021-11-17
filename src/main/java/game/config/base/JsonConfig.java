package game.config.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import game.base.Logs;
import game.base.constants.GameConstants;
import game.utils.FileUtils;
import game.utils.JsonUtil;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 16:57
 */
public class JsonConfig {

    private final String fileName;

    private Map<Integer, DataConfigData> map;

    private int initSize = 128;

    public JsonConfig(final String fileName) {
        this.fileName = fileName;
    }

    public JsonConfig(final String fileName, final int size) {
        this.fileName = fileName;
        initSize = size;
    }

    public Map<Integer, DataConfigData> load() {
        try {
            Logs.C.info(GameConstants.TOKEN_START + "加载配置文件:{}", fileName);
            final String s = FileUtils.readFile(fileName);
            final ImmutableMap.Builder<Integer, DataConfigData> b = ImmutableMap.builderWithExpectedSize(initSize);
            return b.putAll(JsonUtil.fromJsonString(s, new TypeReference<Map<Integer, DataConfigData>>() {
            })).build();
        } catch (final Exception e) {
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
