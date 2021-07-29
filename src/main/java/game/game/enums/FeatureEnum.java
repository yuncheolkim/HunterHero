package game.game.enums;

/**
 * @author Yunzhe.Jin
 * 2021/6/16 20:29
 */
public enum FeatureEnum {
    银行(0),
    钓鱼(1),
    跑镖(2),
    ;

    public final int id;

    FeatureEnum(int i) {
        id = 1 << i;
    }
}
