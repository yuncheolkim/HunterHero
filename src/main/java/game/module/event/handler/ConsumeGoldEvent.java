package game.module.event.handler;

import game.game.ConsumeTypeEnum;
import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/8 10:51
 */
public class ConsumeGoldEvent implements IEvent {

    public int count;

    public ConsumeTypeEnum type;

    public ConsumeGoldEvent() {
    }

    public ConsumeGoldEvent(int count, ConsumeTypeEnum type) {
        this.count = count;
        this.type = type;
    }


    @Override
    public EventType type() {
        return EventType.CONSUME_GOLD;
    }
}
