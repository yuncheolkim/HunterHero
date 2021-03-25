package game.module.task;

/**
 * @author Yunzhe.Jin
 * 2021/3/25 21:05
 */
public enum TaskTargetTypeEnum {
    ASK(1),
    KILL(2),
    SEARCH(3),
    ;


    public final int id;

    TaskTargetTypeEnum(int i) {
        this.id = i;
    }
}
