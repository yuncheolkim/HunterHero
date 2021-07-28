package game.game.enums;

/**
 * @author Yunzhe.Jin
 * 2021/3/25 20:15
 */
public enum ItemQualityEnum implements IIdEnum {
    /**
     * 白
     */
    W(1),
    /**
     * 绿
     */
    G(2),
    /**
     * 蓝
     */
    B(3),

    /**
     * 紫
     */
    P(4),

    /**
     * 橙色
     */
    O(5),

    /**
     * 红
     */
    R(6),
    ;

    public final int id;

    ItemQualityEnum(int i) {
        this.id = i;
    }

    @Override
    public int id() {
        return this.id;
    }


    public static ItemQualityEnum find(int id) {
        for (ItemQualityEnum value : ItemQualityEnum.values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }
}
