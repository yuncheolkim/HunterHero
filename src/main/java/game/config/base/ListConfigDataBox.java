package game.config.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:22
 */
public abstract class ListConfigDataBox<T extends BaseConfigData<T>> extends ConfigDataBox<T> {

    private List<T> list;

    public ListConfigDataBox(String path) {
        super(path);
    }

    @Override
    protected void parse(Map<Integer, DataConfigData> load) {

        final int count = load.size() + 16;
        list = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            list.add(null);
        }
        load.forEach((integer, dataConfigData) -> list.set(dataConfigData.id, supplier(dataConfigData)));
    }

    @Override
    public T findById(int id) {
        return list.get(id);
    }
}
