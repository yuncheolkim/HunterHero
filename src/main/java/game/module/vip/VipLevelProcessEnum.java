package game.module.vip;

import game.module.player.Player;

/**
 * vip 等级处理
 *
 * @author Yunzhe.Jin
 * 2021/7/30 17:42
 */
public enum VipLevelProcessEnum {
    V_1(1),
    ;

    public final int id;

    VipLevelProcessEnum(int id) {
        this.id = id;
    }

    public void process(Player player) {

    }

}
