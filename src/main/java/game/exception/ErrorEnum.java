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
    ERR_3(3, "数字应大于0"),
    ERR_4(4, "金币不足"),
    ERR_5(5, "已最高级"),
    ERR_6(6, "体力已满"),
    ERR_7(7, "雷石不足"),
    ERR_8(8, "英雄已存在"),
    ERR_102(102, "物品不足"),
    ERR_103(103, "数字不能小于等于0"),
    ERR_104(104, "背包空间不足"),
    ERR_105(105, "资源不足"),
    ERR_106(106, "体力不足"),
    ERR_110(110, "钓鱼中"),
    ERR_111(111, "不在钓鱼中"),
    ERR_112(112, "不在钓鱼区域中"),
    ERR_113(121, "已经在战斗中"),
    ERR_201(201, "回城CD中"),
    ERR_202(202, "已经在跑镖中"),

    ;

    private final int id;

    private final String module;

    ErrorEnum(final int id, final String module) {

        this.id = id;
        this.module = module;
    }

    private static final ImmutableMap<Integer, ModuleErrorNoResolve> map;

    static {
        final ImmutableMap.Builder<Integer, ModuleErrorNoResolve> builder = ImmutableMap.builder();
        final HashSet<Integer> ids = new HashSet<>();

        for (final ErrorEnum value : ErrorEnum.values()) {
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

    public static ModuleErrorNoResolve errStr(final int errNo) {
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