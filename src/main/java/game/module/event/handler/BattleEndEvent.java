package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/7/25 15:29
 */
public class BattleEndEvent implements IEvent {

    public boolean success;
    public int battleId;

    @Override
    public EventType type() {
        return EventType.BATTLE_END;
    }
}
