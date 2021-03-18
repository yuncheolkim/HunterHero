package game.exception;

import com.google.common.collect.ImmutableMap;

import java.util.HashSet;
import java.util.Set;

/**
 * 定义错误消息
 * 消息编号都要正数
 *
 * @author Yunzhe.Jin
 * 2020/3/31 16:47
 */
public enum ErrorEnum implements ModuleErrorNoResolve {
    /**
     * 系统异常
     */
    ERR_1(1, "系统异常"),
    ERR_2(2, "非法参数"),
    ERR_3(3, "数字不能为负"),
    ERR_101(101, "金币不足"),
    ERR_102(102, "已最高级"),
    ERR_103(103, "数字不能小于等于0"),
    ERR_104(104, "背包空间不足"),
    ERR_105(105, "资源不足"),

    ;

    private final int id;

    private final String module;

    ErrorEnum(int id, String module) {

        this.id = id;
        this.module = module;
    }

    private static final ImmutableMap<Integer, ModuleErrorNoResolve> map;

    static {
        ImmutableMap.Builder<Integer, ModuleErrorNoResolve> builder = ImmutableMap.builder();
        HashSet<Integer> ids = new HashSet<>();

        for (ErrorEnum value : ErrorEnum.values()) {
            if (!ids.add(value.id)) {
                throw new IllegalStateException("id重复:" + value.id);
            }
            builder.put(value.id, value);
        }

        map = builder.build();
    }

    public int getId() {
        return id;
    }

    public String getModule() {
        return module;
    }

    public static ModuleErrorNoResolve errStr(int errNo) {
        return map.get(errNo);
    }

    public static Set<Integer> allErrNo() {
        return map.keySet();
    }

    @Override
    public int errorNo() {
        return id;
    }

    @Override
    public String display() {
        return toString();
    }

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "id=" + id +
                ", module='" + module + '\'' +
                '}';
    }
}