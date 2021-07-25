package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class DungeonInfoConfigData extends BaseConfigData<DungeonInfoConfigData> {

    public List<Integer> boss = new ArrayList<>();

    @Override
    protected void fill(DataConfigData d) {
        boss.addAll(d.list1);
    }
}
