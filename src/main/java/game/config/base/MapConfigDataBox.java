package game.config.base;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:22
 */
public class MapConfigDataBox<T extends BaseConfigData<T>> extends ConfigDataBox<T> {

    protected Map<Integer, T> map;

    public MapConfigDataBox(final String path) {
        super(path);
    }

    @Override
    protected void parse(final Map<Integer, DataConfigData> dataMap) {
        final ImmutableMap.Builder<Integer, T> temp = ImmutableMap.builder();
        dataMap.forEach((integer, dataConfigData) -> temp.put(integer, supplier(dataConfigData)));
        map = temp.build();
    }

    @Override
    public T findById(final int id) {
        return map.get(id);
    }

    public List<T> all(Predicate<T> predicate) {
        return map.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void end() {
        for (final T t : map.values()) {
            t.end();
        }
    }

    @Override
    public void afterAllLoad() {
        map.values().forEach(BaseConfigData::afterAllLoad);
    }
}
