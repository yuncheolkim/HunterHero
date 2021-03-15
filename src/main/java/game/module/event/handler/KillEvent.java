package game.module.event.handler;

import game.game.TargetType;
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

    private TargetType targetType;

    public KillEvent() {
    }

    public KillEvent(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public EventType type() {
        return EventType.KILL;
    }
}
