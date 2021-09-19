package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;
import game.proto.data.FightType;

/**
 * @author Yunzhe.Jin
 * 2021/7/25 15:29
 */
public class BattleEndEvent implements IEvent {

    public boolean success;
    public int battleId;
    public FightType fightType;

    @Override
    public EventType type() {
        return EventType.BATTLE_END;
    }
}
