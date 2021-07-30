package game.game.enums;

/**
 * @author Yunzhe.Jin
 * 2021/6/16 20:29
 */
public enum FeatureEnum {
    银行(0),
    钓鱼(1),
    跑镖(2),
    家园(3),
    ;

    public final int id;

    public final int index;

    FeatureEnum(int i) {
        index = i;
        id = 1 << i;
    }
}
