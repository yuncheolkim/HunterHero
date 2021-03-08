package game.module.hero;

import game.base.G;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.module.event.handler.HeroPowerUpEvent;
import game.player.Player;
import game.proto.HeroUpReq;
import game.proto.data.HeroRealm;
import game.proto.data.PlayerData;
import game.proto.data.PlayerHero;

/**
 * @author Yunzhe.Jin
 * 2021/2/27 18:31
 */
public class HeroHandler {

    /**
     * 升级历练
     * @param player
     * @param req
     */
    public static void lilian(Player player, HeroUpReq req) {
        PlayerData.Builder pd = player.getPd();
        PlayerHero hero = pd.getHeroOrThrow(req.getHeroId());
        int level = 1;
        if (hero.containsLiLian(req.getStepId())) {
            HeroRealm realm = hero.getLiLianMap().get(req.getStepId());
            level = realm.getLevel() + 1;
        }
        DataConfigData dataConfigData = G.C.dataMap12.get(level);
        ModuleAssert.notNull(dataConfigData, ErrorEnum.ERR_102);
        // Gold
        player.consumeGold(dataConfigData.gold, ConsumeTypeEnum.历练);

        HeroRealm realm = HeroRealm.newBuilder()
                .setId(req.getStepId())
                .setLevel(level)
                .build();

        PlayerHero.Builder builder = hero.toBuilder().putLiLian(req.getStepId(), realm);
        pd.putHero(req.getHeroId(), builder.build());

        G.E.firePlayerEvent(player, new HeroPowerUpEvent(hero.getId()));

    }

    /**
     * 升级修炼
     * @param player
     * @param req
     */
    public static void xiulian(Player player, HeroUpReq req) {
        PlayerData.Builder pd = player.getPd();
        PlayerHero hero = pd.getHeroOrThrow(req.getHeroId());
        int level = 1;
        if (hero.containsXiuLian(req.getStepId())) {
            HeroRealm realm = hero.getLiLianMap().get(req.getStepId());
            level = realm.getLevel() + 1;
        }
        DataConfigData dataConfigData = G.C.dataMap12.get(level);
        ModuleAssert.notNull(dataConfigData, ErrorEnum.ERR_102);
        // Gold
        player.consumeGold(dataConfigData.gold, ConsumeTypeEnum.修炼);

        HeroRealm realm = HeroRealm.newBuilder()
                .setId(req.getStepId())
                .setLevel(level)
                .build();

        PlayerHero.Builder builder = hero.toBuilder().putXiuLian(req.getStepId(), realm);
        pd.putHero(req.getHeroId(), builder.build());

        G.E.firePlayerEvent(player, new HeroPowerUpEvent(hero.getId()));
    }


}
