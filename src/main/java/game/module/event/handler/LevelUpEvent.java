package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/7 16:06
 */
public class LevelUpEvent implements IEvent {
    // 0:player,other hero
    public final int heroId;
    public final int level;

    public LevelUpEvent(int heroId, int level) {
        this.heroId = heroId;
        this.level = level;
    }

    public LevelUpEvent(int level) {
        this.level = level;
        heroId = 0;
    }

    @Override
    public EventType type() {
        return EventType.LEVEL_UP;
    }
}
