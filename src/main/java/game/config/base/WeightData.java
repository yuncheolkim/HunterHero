package game.config.base;

import game.base.IWeight;

/**
 * @author Yunzhe.Jin
 * 2021/6/27 22:50
 */
public class WeightData<T> implements IWeight {

    public T data;
    public int weight;


    @Override
    public int weight() {
        return weight;
    }
}

