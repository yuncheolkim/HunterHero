package game.config.base;

/**
 * @author Yunzhe.Jin
 * 2021/6/27 21:58
 */
public class RandomConfigDataBox<T extends RandomCountConfigData<T>> extends MapConfigDataBox<T> {
    public RandomConfigDataBox(String path) {
        super(path);
    }

    public int random(int id) {
        T data = findById(id);
        return data.random();
    }
}
