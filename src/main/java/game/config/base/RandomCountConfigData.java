package game.config.base;

import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 20:58
 */
public class RandomCountConfigData<T extends BaseConfigData<T>> extends BaseConfigData<T> {
    public int max;
    public int min;

    @Override
    protected void fill(DataConfigData d) {
        max = d.max;
        min = d.min;
    }


    public int random() {
        return CalcUtil.random(min, max);
    }
}
