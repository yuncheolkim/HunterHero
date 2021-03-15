package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * 英雄提升
 *
 * @author Yunzhe.Jin
 * 2021/3/8 11:20
 */
public class HeroPowerUpEvent implements IEvent {
    public int heroId;

    public HeroPowerUpEvent() {
    }

    public HeroPowerUpEvent(int heroId) {
        this.heroId = heroId;
    }

    @Override
    public EventType type() {
        return EventType.HERO_POWER_UP;
    }
}
