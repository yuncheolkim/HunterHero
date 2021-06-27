package game.config.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 20:58
 */
public class WeightConfigData<T extends BaseConfigData<T>> extends BaseConfigData<T> {


    public List<WeightData<Integer>> list = new ArrayList<>();

    public int allWeight;

    @Override
    protected void fill(DataConfigData d) {
        for (String tuple : d.s1.split("#")) {
            String[] split = tuple.split(":");
            int id = Integer.parseInt(split[0]);
            int weight = split.length > 1 ? Integer.parseInt(split[1]) : 1;

            WeightData<Integer> w = new WeightData<>();
            w.weight = weight;
            w.data = id;
            allWeight += weight;
            list.add(w);
        }
    }

}
