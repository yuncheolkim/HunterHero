package game.game;

/**
 * @author Yunzhe.Jin
 * 2021/3/25 20:15
 */
public enum ItemTypeEnum {
    NORMAL(1),
    USELESS(2),
    /**
     * 材料
     */
    MATERIAL(3),

    EQUIPMENT(4),

    CONSUME(5),

    TASK(6),
    ;

    public final int id;

    ItemTypeEnum(int i) {
        this.id = i;
    }
}
