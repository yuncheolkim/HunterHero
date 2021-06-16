package game.module.event.handler;

import game.game.FeatureEnum;
import game.module.event.IPlayerEventHandler;
import game.player.Player;

/**
 * @author Yunzhe.Jin
 * 2021/6/14 15:15
 */
public class TaskCompleteEventHandler implements IPlayerEventHandler<TaskCompleteEvent> {


    @Override
    public void handler(Player player, TaskCompleteEvent data) {

        // 钓鱼任务完成，开启钓鱼技能
        if (data.taskId == 4) {
            player.pd.setSkillFishLevel(1);
            player.pd.setOpenFeature(player.pd.getOpenFeature() | FeatureEnum.钓鱼.id);
        } else if (data.taskId == 1) {

            // 开启银行
            player.pd.setOpenFeature(player.pd.getOpenFeature() | FeatureEnum.银行.id);
        }

    }
}
