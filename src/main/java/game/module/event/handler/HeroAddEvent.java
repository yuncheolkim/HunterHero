package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/12 15:11
 */
public class HeroAddEvent implements IEvent {
    public int heroId;

    @Override
    public EventType type() {
        return EventType.HERO_ADD;
    }
}
