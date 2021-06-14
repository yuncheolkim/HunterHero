package game.config.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 20:30
 */
public abstract class WeightMapConfigDataBox<T extends BaseConfigData<T>> extends MapConfigDataBox<T> {


    private Map<Integer, List<T>> listMap;

    public WeightMapConfigDataBox(String path) {
        super(path);
    }

    @Override
    protected void parse(Map<Integer, DataConfigData> dataMap) {
        super.parse(dataMap);

        final Map<Integer, List<T>> map1 = new HashMap<>();
        for (final Map.Entry<Integer, T> entry : map.entrySet()) {
            final List<T> m2 = map1.computeIfAbsent(collectId(entry.getValue()), id -> new ArrayList<>());
            m2.add(entry.getValue());
        }
        listMap = map1;
    }

    protected abstract int collectId(T t);


    public List<T> findByCollectId(int id) {
        return listMap.get(id);
    }

}
