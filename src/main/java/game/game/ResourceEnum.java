package game.game;

import com.google.common.collect.ImmutableMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yunzhe.Jin
 * 2021/3/5 14:56
 */
public enum ResourceEnum implements INoDisplay {
    /**
     * 系统异常
     */
    GOLD(1, "金币"),
    LEI(2, "雷石"),
    EXP(1, "经验"),
    POWER(1, "能量"),
    ;

    public final int id;

    public final String display;

    ResourceEnum(int id, String module) {

        this.id = id;
        this.display = module;
    }

    private static final ImmutableMap<Integer, INoDisplay> map;

    static {
        ImmutableMap.Builder<Integer, INoDisplay> builder = ImmutableMap.builder();
        HashSet<Integer> ids = new HashSet<>();

        for (ResourceEnum value : ResourceEnum.values()) {
            if (!ids.add(value.id)) {
                throw new IllegalStateException("id重复:" + value.id);
            }
            builder.put(value.id, value);
        }

        map = builder.build();
    }

    public static INoDisplay display(int errNo) {
        return map.get(errNo);
    }

    public static Set<Integer> allNo() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "id=" + id +
                ", module='" + display + '\'' +
                '}';
    }

    @Override
    public int errorNo() {
        return id;
    }

    @Override
    public String display() {
        return display;
    }
}