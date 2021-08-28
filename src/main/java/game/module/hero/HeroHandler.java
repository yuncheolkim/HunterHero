package game.module.hero;

import game.anno.InsideMsgHandler;
import game.base.constants.GameConstants;
import game.config.data.ItemConfigData;
import game.config.data.PropertyConfigData;
import game.exception.ErrorEnum;
import game.exception.EvilAssert;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.manager.ConfigManager;
import game.manager.EventManager;
import game.module.event.handler.HeroPowerUpEvent;
import game.player.Player;
import game.proto.*;
import game.proto.data.*;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/2/27 18:31
 */
public class HeroHandler {
    /**
     * 升级历练
     *
     * @param player
     * @param req
     */
    public static void powerUp(final Player player, final HeroUpReq req) {
        final PlayerData.Builder pd = player.getPd();
        final PlayerHero hero = pd.getHeroOrThrow(req.getHeroId());
        int level = 1;
        if (hero.containsPowerUp(req.getStepId())) {
            final HeroRealm realm = hero.getPowerUpMap().get(req.getStepId());
            level = realm.getLevel() + 1;
        }
        final PropertyConfigData dataConfigData = ConfigManager.GetPowerUpData(req.getStepId(), level);
        ModuleAssert.notNull(dataConfigData, ErrorEnum.ERR_5);
        // Gold
        player.consumeGold(dataConfigData.gold, ConsumeTypeEnum.历练);

        final HeroRealm realm = HeroRealm.newBuilder()
                .setId(req.getStepId())
                .setLevel(level)
                .build();

        final PlayerHero.Builder builder = hero.toBuilder().putPowerUp(req.getStepId(), realm);
        pd.putHero(req.getHeroId(), builder.build());

        EventManager.firePlayerEvent(player, new HeroPowerUpEvent(hero.getId()));

    }


    /**
     * 装备物品
     */
    public static void equip(final Player player, final HeroEquipmentReq req) {
        final BagSlot bagSlot = player.pd.getBagMap().get(req.getSlotId());
        ModuleAssert.notNull(bagSlot);
        final ItemConfigData item = ConfigManager.getItem(bagSlot.getData().getItemId());

        final PlayerHero hero = player.pd.getHeroOrThrow(req.getHeroId());
        EvilAssert.isTrue(item.level <= hero.getLevel(), "物品等级大于英雄等级");

        final int type2 = item.type2;

        final Equipment equipment = hero.getEquipmentMap().get(type2);
        // 从背包删除
        player.removeBagItem(GameConstants.ITEM_BAG, 1, bagSlot.getSlotId());

        // 放到装备栏
        final PlayerHero.Builder builder = hero.toBuilder();
        builder.putEquipment(type2, Equipment.newBuilder()
                .setId(item.id)
                .setLevel(item.level)
                .setProperty(bagSlot.getData().getProperty())
                .build());

        player.pd.putHero(hero.getId(), builder.build());

        EventManager.firePlayerEvent(player, new HeroPowerUpEvent(hero.getId()));

        // 旧物品返回到背包
        if (equipment != null) {
            player.setItem(req.getSlotId(), ItemData.newBuilder()
                    .setItemId(equipment.getId()).setCount(1).setProperty(equipment.getProperty())
                    .build(), GameConstants.ITEM_BAG);

        }

    }

    /**
     * 更新英雄属性
     *
     * @param player
     * @param hero
     */
    @InsideMsgHandler
    public static void updateHero(final Player player, final PlayerHero hero) {
        player.getPd().putHero(hero.getId(), hero);
        // Push
        player.getTransport().send(No.HeroChangePush, HeroChangePush.newBuilder().setHero(hero).build());
    }

    /**
     * 修改天赋
     * todo 等级检查
     *
     * @param player
     * @param req
     */
    public static HeroTalentChangeRes HeroTalentChangeReq(final Player player, final HeroTalentChangeReq req) {

        final PlayerHero heroOrThrow = player.pd.getHeroOrThrow(req.getHeroId());
        final PlayerHero.Builder builder = heroOrThrow.toBuilder().setTalent(req.getTalent());
        player.pd.putHero(req.getHeroId(), builder.buildPartial());


        EventManager.firePlayerEvent(player, new HeroPowerUpEvent(heroOrThrow.getId()));

        return HeroTalentChangeRes.newBuilder()
                .setHeroId(req.getHeroId()).setTalent(req.getTalent()).buildPartial();
    }


}
