package game.module.shop;

import game.base.G;
import game.base.GameConstants;
import game.base.IIdDisplay;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.game.ItemTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
import game.manager.ConfigManager;
import game.player.Player;
import game.proto.ItemBuyReq;
import game.proto.ItemSellReq;
import game.proto.data.BagSlot;
import game.proto.data.ItemData;

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
    public static void buyItem(Player player, ItemBuyReq req) {
        DataConfigData item = G.C.getItem(req.getItemId());

        IIdDisplay display = ResourceEnum.display(item.resourceId);
        // 暂时金币
        if (display == ResourceEnum.GOLD) {
            ModuleAssert.isTrue(player.hasGold(item.value), ErrorEnum.ERR_103);
            ItemData.Builder builder = ItemData.newBuilder()
                    .setItemId(req.getItemId())
                    .setCount(req.getCount());

            if (item.type1 == ItemTypeEnum.EQUIPMENT.id) {
                // 填充属性
                builder.setProperty(ConfigManager.makeProperty(item));
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
    public static void sellItem(Player player, ItemSellReq req) {
        BagSlot bagSlot = player.getPd().getBagMap().get(req.getSlotId());
        ModuleAssert.notNull(bagSlot);

        DataConfigData item = G.C.getItem(bagSlot.getData().getItemId());

        IIdDisplay display = ResourceEnum.display(item.resourceId);

        int count = Math.min(bagSlot.getData().getCount(), req.getCount());

        if (display == ResourceEnum.GOLD) {
            // 移除物品
            player.removeBagItem(GameConstants.ITEM_BAG, count, req.getSlotId());
            player.addGold(count * item.sell, ResourceSourceEnum.出售物品);
        }
    }
}
