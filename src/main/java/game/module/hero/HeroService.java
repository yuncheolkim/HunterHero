package game.module.hero;

import game.base.constants.GameConstants;
import game.config.data.HeroBaseConfigData;
import game.config.data.ItemConfigData;
import game.exception.ModuleAssert;
import game.game.enums.ItemTypeEnum;
import game.manager.ConfigManager;
import game.module.player.Player;
import game.proto.NewHeroPush;
import game.proto.data.ItemData;
import game.proto.data.PlayerHero;
import game.proto.data.Property;
import game.proto.no.No;
import game.utils.CalcUtil;

/**
 * @author Yunzhe.Jin
 * 2021/3/9 15:14
 */
public class HeroService {


    /**
     * 添加装备
     *
     * @param player
     * @param itemId
     */
    public static void addEquipment(final Player player, final int itemId) {
        final ItemConfigData item = ConfigManager.getItem(itemId);
        ModuleAssert.isTrue(item.type == ItemTypeEnum.EQUIPMENT);

        player.addItem(ItemData.newBuilder().setItemId(itemId)
                .setCount(1)
                .setProperty(item.property).build(), GameConstants.ITEM_BAG);

    }

    /**
     * 是否有英雄
     *
     * @param player
     * @param heroId
     * @return
     */
    public static boolean hasHero(final Player player, final int heroId) {
        return player.pd.containsHero(heroId);
    }


    /**
     * 添加英雄
     *
     * @param player
     * @param heroId
     * @param push
     */
    public static void addHero(final Player player, final int heroId, final boolean push) {
        if (player.getPd().getHeroMap().containsKey(heroId)) {
            return;
        }

        final PlayerHero.Builder builder = PlayerHero.newBuilder();
        final HeroBaseConfigData d = ConfigManager.heroBaseProperty(heroId, 1);
        builder.setId(heroId);
        builder.setLevel(1);
        builder.setTalent(99999);
        builder.setProperty(d.property);


        final Property property = builder.getProperty();
        builder.getPropertyEffectBuilder()
                .setDefRate(CalcUtil.calcRateProperty(property.getDef(), property.getDefBase()))
                .setAvoidRate(CalcUtil.calcRateProperty(property.getAvoid(), property.getAvoidBase()))
                .setCriticalRate(CalcUtil.calcRateProperty(property.getCritical(), property.getCriticalBase()));

        final PlayerHero newHero = builder.build();
        player.getPd().putHero(heroId, newHero);

        if (push) {
            player.send(No.NewHeroPush, NewHeroPush.newBuilder().setHero(newHero).build());
        }
    }

}
