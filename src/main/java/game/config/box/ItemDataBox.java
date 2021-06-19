package game.config.box;

import com.google.common.collect.Lists;
import game.config.base.MapConfigDataBox;
import game.config.data.ItemConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class ItemDataBox extends MapConfigDataBox<ItemConfigData> {


    public ItemDataBox() {
        super(null);
        pathList = Lists.newArrayList(
                "data/item_base.json",
                "data/item_任务6.json",
                "data/item_材料3.json",
                "data/item_装备4-1.json",
                "data/item_装备4-2.json",
                "data/item_装备4-3.json",
                "data/item_装备4-4.json"
        );
    }
}
