package game.config.base;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:22
 */
public abstract class MapConfigDataBox<T extends BaseConfigData<T>> extends ConfigDataBox<T> {

    protected Map<Integer, T> map;

    public MapConfigDataBox(String path) {
        super(path);
    }

    @Override
    protected void parse(Map<Integer, DataConfigData> dataMap) {
        final ImmutableMap.Builder<Integer, T> temp = ImmutableMap.builder();
        dataMap.forEach((integer, dataConfigData) -> temp.put(integer, supplier(dataConfigData)));
        map = temp.build();
    }

    @Override
    public T findById(int id) {
        return map.get(id);
    }
}
