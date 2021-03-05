package game.module.event;

/**
 * 获取物品事件
 * @author Yunzhe.Jin
 * 2021/2/25 11:03
 */
public class ItemAddEvent implements IEvent {

    public int itemId;

    public int count;

    @Override
    public EventType type() {
        return EventType.ITEM_TAKE;
    }
}
