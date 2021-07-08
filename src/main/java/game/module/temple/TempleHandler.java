package game.module.temple;

import game.config.data.TempleHeroConfigData;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.manager.ConfigManager;
import game.module.hero.HeroService;
import game.player.Player;
import game.proto.TempleHeroBuyReq;
import game.proto.TempleHeroBuyRes;

import static game.exception.ErrorEnum.ERR_8;
import static game.game.ConsumeTypeEnum.神殿购买英雄;

/**
 * 神殿
 *
 * @author Yunzhe.Jin
 * 2021/4/15 15:36
 */
public class TempleHandler {
    /**
     * 购买英雄
     *
     * @param player
     * @param req
     */
    public static TempleHeroBuyRes TempleHeroBuyReq(final Player player, final TempleHeroBuyReq req) {

        final TempleHeroConfigData data = ConfigManager.templeHeroDataBox.findById(req.getId());
        EvilAssert.notNull(data, "商店找不到对应英雄");

        // 检查是否已经有英雄连
        ModuleAssert.isFalse(HeroService.hasHero(player, data.heroId), ERR_8);
        if (req.getType() == 1) {
            // 金币
            player.consumeGold(data.gold, 神殿购买英雄);
        } else {
            // 宝石
            player.consumeGemAssert(神殿购买英雄, data.gem);
        }

        HeroService.addHero(player, data.heroId, true);

        return TempleHeroBuyRes.newBuilder().setId(req.getId()).build();
    }

}
