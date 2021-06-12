package game.config.base;

import game.config.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/5/25 10:27
 */
public class BaseConfigData<T extends BaseConfigData<T>> {
    public int id;

    public String name;


    public T convert(DataConfigData data) {
        this.id = data.id;
        this.name = data.name;
        return (T) this;
    }
}
