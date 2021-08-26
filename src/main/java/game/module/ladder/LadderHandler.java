package game.module.ladder;

import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.LadderSetFormationReq;
import game.proto.data.PlayerHero;

/**
 * 排位赛
 * 单挑
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:35
 */
public class LadderHandler {

    /**
     * 设置战斗阵型
     *
     * @param player
     * @param req
     */
    public static void formation(final Player player, final LadderSetFormationReq req) {
        PlayerHero heroOrDefault = player.pd.getHeroOrDefault(req.getHeroId(), null);
        ModuleAssert.notNull(heroOrDefault);
        player.pd.getLadderInfoBuilder().setHeroId(req.getHeroId());
    }

    /**
     * 找对手
     *
     * @param player
     * @param req
     */
    public static void match(final Player player) {

    }

}
