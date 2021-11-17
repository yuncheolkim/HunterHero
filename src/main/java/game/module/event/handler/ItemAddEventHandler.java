package game.module.event.handler;

import game.module.event.IPlayerEventHandler;
import game.module.task.TaskService;
import game.module.task.TaskTargetTypeEnum;
import game.module.player.Player;

/**
 * 增加物品
 * item表里面的东西
 *
 * @author Yunzhe.Jin
 * 2021/3/12 14:33
 */
public class ItemAddEventHandler implements IPlayerEventHandler<ItemAddEvent> {
    @Override
    public void handler(final Player player, final ItemAddEvent data) {
        final int itemId = data.itemData.getItemId();
        final int addCount = data.itemData.getCount();
//        final DataConfigData item = ConfigManager.getItem(itemId);

        // 检查任务
        TaskService.calcTaskProcess(player, itemId, addCount, TaskTargetTypeEnum.SEARCH);


    }
}
