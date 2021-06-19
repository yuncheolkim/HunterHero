package game.config.base;

/**
 * @author Yunzhe.Jin
 * 2021/5/25 10:27
 */
public class BaseConfigData<T extends BaseConfigData<T>> {
    public int id;

    public String name;
    public int level;

    private DataConfigData data;


    public T convert(DataConfigData data) {
        this.id = data.id;
        this.name = data.name;
        this.level = data.level;
        fill(data);

        this.data = data;
        return (T) this;
    }

    protected void fill(DataConfigData d) {

    }

    public final void afterAllLoad() {
        afterAllLoad0(data);
    }

    protected void afterAllLoad0(DataConfigData data) {

    }

    public final void end() {
        data = null;
    }
}
