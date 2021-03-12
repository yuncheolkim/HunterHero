package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;
import game.proto.data.ItemData;

/**
 * @author Yunzhe.Jin
 * 2021/3/12 14:33
 */
public class ItemAddEvent implements IEvent {
    public ItemData itemData;

    public ItemAddEvent() {
    }

    @Override
    public EventType type() {
        return EventType.ITEM_ADD;
    }
}
