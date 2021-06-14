package game.config.base;

import game.base.Logs;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:14
 */
public abstract class ConfigDataBox<T extends BaseConfigData<T>> {
    private final String path;
    protected final Type type;
    protected List<String> pathList;

    public ConfigDataBox(String path) {
        this.path = path;

        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        } else {
            this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        }
    }


    public void parse() {
        if (pathList != null) {
            Map<Integer, DataConfigData> dataMap = new HashMap<>();

            for (String path : pathList) {
                Map<Integer, DataConfigData> load = new JsonConfig(path).load();
                for (DataConfigData value : load.values()) {
                    if (dataMap.containsKey(value.id)) {
                        throw new IllegalArgumentException("键值重复:" + value.id);
                    }
                    dataMap.put(value.id, value);
                }
            }

            parse(dataMap);

        } else {
            parse(new JsonConfig(path).load());
        }

    }

    protected abstract void parse(Map<Integer, DataConfigData> dataMap);

    protected T supplier(DataConfigData data) {
        T type = null;
        try {
            type = ((Class<T>) this.type).newInstance();
        } catch (Exception e) {
            Logs.C.error(e, path);
        }
        assert type != null;
        return type.convert(data);

    }


    public abstract T findById(int id);

    public ConfigDataBox<T> setPathList(List<String> pathList) {
        this.pathList = pathList;
        return this;
    }
}
