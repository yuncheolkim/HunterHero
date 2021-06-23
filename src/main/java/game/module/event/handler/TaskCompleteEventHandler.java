package game.module.event.handler;

import game.game.FeatureEnum;
import game.module.event.IPlayerEventHandler;
import game.module.player.PlayerService;
import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/6/14 15:15
 */
public class TaskCompleteEventHandler implements IPlayerEventHandler<TaskCompleteEvent> {


    @Override
    public void handler(Player player, TaskCompleteEvent data) {

        // 钓鱼任务完成，开启钓鱼技能
        switch (data.taskId) {
            case 4:
                player.pd.setSkillFishLevel(1);
                PlayerService.openFeature(player, FeatureEnum.钓鱼);
                break;
            case 1:
                // 开启银行
                PlayerService.openFeature(player, FeatureEnum.银行);
                break;
            case 16:// 解决案件后 触发免费英雄
                PlayerService.showOrHideNpc(player, 14, true);
                break;
        }

    }
}
