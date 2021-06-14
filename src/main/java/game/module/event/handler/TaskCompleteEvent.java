package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/6/14 15:14
 */
public class TaskCompleteEvent implements IEvent {

    public int taskId;

    public TaskCompleteEvent() {
    }

    public TaskCompleteEvent(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public EventType type() {
        return EventType.TASK_COMPLETE;
    }
}
