package game.module.task;

/**
 * @author Yunzhe.Jin
 * 2021/5/14 20:03
 */
public enum TaskStatusEnum {
    完成未提交(1),
    提交任务(2),
    接受任务(3),
    进度更新(4),
    ;

    public final int id;

    TaskStatusEnum(int i) {

        id = i;
    }
}
