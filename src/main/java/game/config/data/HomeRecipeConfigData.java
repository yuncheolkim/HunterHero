package game.config.data;

import game.base.util.Tuple2;
import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class HomeRecipeConfigData extends BaseConfigData<HomeRecipeConfigData> {


    public int count;
    public List<Tuple2<Integer, Integer>> recipe = new ArrayList<>();

    @Override
    protected void fill(DataConfigData d) {

        if (StringUtils.isEmpty(d.s1)) {
            return;
        }
        for (String s : d.s1.split("#")) {
            String[] split = s.split("=");
            recipe.add(new Tuple2<>(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        count = d.i1;
    }
}
