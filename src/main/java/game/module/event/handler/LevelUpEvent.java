package game.module.event.handler;

import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/7 16:06
 */
public class LevelUpEvent implements IEvent {
    // 0:player,other hero
    public int heroId;

    public int level;

    public int oldLevel;

    public LevelUpEvent() {
    }

    public LevelUpEvent(final int heroId, final int level, final int oldLevel) {
        this.heroId = heroId;
        this.level = level;
        this.oldLevel = oldLevel;
    }

    public LevelUpEvent(final int level, final int oldLevel) {
        this.level = level;
        this.oldLevel = oldLevel;
        heroId = 0;
    }

    public LevelUpEvent setOldLevel(final int oldLevel) {
        this.oldLevel = oldLevel;
        return this;
    }

    @Override
    public EventType type() {
        return EventType.LEVEL_UP;
    }
}
