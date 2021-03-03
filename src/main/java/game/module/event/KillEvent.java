package game.module.event;

import game.game.TargetType;

/**
 * 杀敌事件
 * @author Yunzhe.Jin
 * 2021/2/25 11:03
 */
public class KillEvent implements IEvent {

    public int targetId;

    public TargetType targetType;

    @Override
    public EventType type() {
        return EventType.KILL;
    }
}