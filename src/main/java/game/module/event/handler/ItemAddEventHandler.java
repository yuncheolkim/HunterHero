package game.module.event.handler;

import game.base.G;
import game.config.DataConfigData;
import game.game.ItemTypeEnum;
import game.module.event.IPlayerEventHandler;
import game.module.task.TaskService;
import game.module.task.TaskTargetTypeEnum;
import game.player.Player;

/**
 * 增加物品
 * item表里面的东西
 *
 * @author Yunzhe.Jin
 * 2021/3/12 14:33
 */
public class ItemAddEventHandler implements IPlayerEventHandler<ItemAddEvent> {
    @Override
    public void handler(Player player, ItemAddEvent data) {
        final int itemId = data.itemData.getItemId();
        final int addCount = data.itemData.getCount();
        DataConfigData item = G.C.getItem(itemId);

        // 检查任务
        if (item.type1 == ItemTypeEnum.TASK.id) {
            TaskService.calcTaskProcess(player, itemId, addCount, TaskTargetTypeEnum.SEARCH);
        }


    }
}
