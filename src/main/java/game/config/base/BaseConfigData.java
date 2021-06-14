package game.config.base;

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
        fill(data);
        return (T) this;
    }

    protected void fill(DataConfigData d) {

    }
}
