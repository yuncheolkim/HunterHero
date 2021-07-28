package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * 杀敌事件
 *
 * @author Yunzhe.Jin
 * 2021/2/25 11:03
 */
public class KillEvent implements IEvent {

    public int targetId;
    public int count;


    public KillEvent() {
    }

    public KillEvent(int targetId, int count) {
        this.targetId = targetId;
        this.count = count;
    }

    @Override
    public EventType type() {
        return EventType.KILL;
    }
}
