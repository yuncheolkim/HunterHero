package game.module.hero;

import game.base.G;
import game.config.DataConfigData;
import game.player.Player;
import game.proto.data.PlayerHero;
import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/3/9 15:14
 */
public class HeroService {

    /**
     * 获得新英雄
     * @param player
     */
    public static void addHero(Player player, int heroId) {

        PlayerHero.Builder builder = PlayerHero.newBuilder();
        DataConfigData d = G.C.heroMap1001.get(1);
        builder.setId(heroId);
        builder.setLevel(1);

        builder.getPropertyBuilder()
                .setHp(d.hp)
                .setDamage(d.damage)
                .setDef(d.def)
                .setAvoid(d.avoid)
                .setCritical(d.critical)
                .setCriticalDamage(d.criticalDamage)
                .setSpeed(d.speed);

        builder.getPropertyEffectBuilder()
                .setDefRate(CalcUtil.calcRateProperty(d.def, d.defBase))
                .setAvoidRate(CalcUtil.calcRateProperty(d.avoid, d.avoidBase))
                .setCriticalRate(CalcUtil.calcRateProperty(d.critical, d.criticalBase));

        player.getPd().putHero(1001, builder.build());

    }
}
