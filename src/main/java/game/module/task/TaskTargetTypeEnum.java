package game.module.task;

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
    /**
     * 打怪拿物品
     */
    KILL_SEARCH(4),
    ;


    public final int id;

    TaskTargetTypeEnum(int i) {
        this.id = i;
    }

}
