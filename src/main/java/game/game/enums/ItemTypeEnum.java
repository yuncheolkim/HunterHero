package game.game.enums;

/**
 * @author Yunzhe.Jin
 * 2021/3/25 20:15
 */
public enum ItemTypeEnum {
    /**
     * 商店物品
     */
    NORMAL(1),
    /**
     * 垃圾物品
     */
    USELESS(2),
    /**
     * 材料
     */
    MATERIAL(3),

    /**
     * 装备
     */
    EQUIPMENT(4),

    /**
     * 消耗品
     */
    CONSUME(5),

    /**
     * 任务
     */
    TASK(6),
    ;

    public final int id;

    ItemTypeEnum(int i) {
        this.id = i;
    }


    public static ItemTypeEnum find(int id) {
        for (ItemTypeEnum value : ItemTypeEnum.values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }
}
