package game.module.task;

import game.base.G;
import game.config.base.DataConfigData;
import game.proto.data.TaskTarget;

/**
 * 任务目标类型
 *
 * @author Yunzhe.Jin
 * 2021/3/25 21:05
 */
public enum TaskTargetTypeEnum {
    /**
     * 送信,询问等
     */
    ASK(1),
    /**
     * 打怪
     */
    KILL(2),
    /**
     * 搜集物品
     */
    SEARCH(3),
    ;


    public final int id;

    TaskTargetTypeEnum(int i) {
        this.id = i;
    }

    public boolean happened(int sourceId, TaskTarget target) {
        DataConfigData data = G.C.taskMap5.get(target.getId());
        return data.v1 == sourceId && data.v2 > target.getValue();
    }

    public TaskTarget addValue(int addCount, TaskTarget target) {
        DataConfigData data = G.C.taskMap5.get(target.getId());
        int count = Math.min(target.getValue() + addCount, data.v2);

        return target.toBuilder()
                .setValue(count)
                .setComplete(count == data.v2)
                .build();
    }


}
