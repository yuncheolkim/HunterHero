package game.module.shop;

import game.anno.GameHandler;
import game.base.constants.GameConstants;
import game.config.data.ItemConfigData;
import game.config.data.ShopConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.enums.ConsumeTypeEnum;
import game.game.enums.ItemTypeEnum;
import game.game.enums.ResourceEnum;
import game.game.enums.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.module.player.Player;
import game.proto.ItemBuyReq;
import game.proto.ItemSellReq;
import game.proto.data.BagSlot;
import game.proto.data.ItemData;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/3/15 23:56
 */
public class ShopHandler {

    /**
     * 购买物品
     *
     * @param player
     * @param req
     */
    @GameHandler(No.ItemBuyReq)
    public static void buyItem(final Player player, final ItemBuyReq req) {
        final ItemConfigData item = ConfigManager.getItem(req.getItemId());


        // 判断 商店是否有这个物品
        final ShopConfigData shop = ConfigManager.getShop(req.getShopId());
        ModuleAssert.isTrue(shop.items.contains(req.getItemId()));

        // 暂时金币
        if (item.resourceType == ResourceEnum.GOLD) {
            ModuleAssert.isTrue(player.hasGold(item.value), ErrorEnum.ERR_103);
            final ItemData.Builder builder = ItemData.newBuilder()
                    .setItemId(req.getItemId())
                    .setCount(req.getCount());

            if (item.type == ItemTypeEnum.EQUIPMENT) {
                // 填充属性
                builder.setProperty(item.property);
            }

            player.addItem(builder.buildPartial(), GameConstants.ITEM_BAG);
            player.consumeGold(item.value, ConsumeTypeEnum.商店);
        }
    }


    /**
     * 出售物品
     *
     * @param player
     * @param req
     */
    @GameHandler(No.ItemSellReq)
    public static void sellItem(final Player player, final ItemSellReq req) {
        final BagSlot bagSlot = player.getPd().getBagMap().get(req.getSlotId());
        ModuleAssert.notNull(bagSlot);

        final ItemConfigData item = ConfigManager.getItem(bagSlot.getData().getItemId());

        final int count = Math.min(bagSlot.getData().getCount(), req.getCount());

        if (item.sell > 0) {
            // 移除物品
            player.removeBagItem(GameConstants.ITEM_BAG, count, req.getSlotId());
            player.addGold(count * item.sell, ResourceSourceEnum.出售物品);
        }
    }
}
