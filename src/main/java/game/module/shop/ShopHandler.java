package game.module.shop;

import game.base.G;
import game.base.IIdDisplay;
import game.config.DataConfigData;
import game.exception.ErrorEnum;
import game.exception.ModuleAssert;
import game.game.ConsumeTypeEnum;
import game.game.ResourceEnum;
import game.player.Player;
import game.proto.ItemBuyReq;
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
            player.addItem(ItemData.newBuilder().setItemId(req.getItemId()).setCount(req.getCount()).build());
            player.consumeGold(item.value, ConsumeTypeEnum.商店);
        }
    }
}
