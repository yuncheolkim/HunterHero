package game.config.base;

import game.base.Logs;
import game.config.DataConfigData;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:14
 */
public abstract class ConfigDataBox<T extends BaseConfigData<T>> {
    private final String path;
    protected final Type type;

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

        parse(new JsonConfig(path).load());
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
}
