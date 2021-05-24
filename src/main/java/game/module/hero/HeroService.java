package game.module.hero;

import game.base.G;
import game.base.GameConstants;
import game.config.DataConfigData;
import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.data.ItemData;

import static game.module.hero.EquipmentService.makeProperty;

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
    public static void addEquipment(Player player, int itemId) {
        DataConfigData item = G.C.getItem(itemId);
        ModuleAssert.isTrue(item.type1 == 4);

        player.addItem(ItemData.newBuilder().setItemId(itemId)
                .setCount(1)
                .setProperty(makeProperty(item)).build(), GameConstants.ITEM_BAG);

    }


    public static boolean hasHero(Player player, int heroId) {
        return player.pd.containsHero(heroId);
    }
}
