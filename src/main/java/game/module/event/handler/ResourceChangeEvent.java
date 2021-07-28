package game.module.event.handler;

import game.game.enums.ConsumeTypeEnum;
import game.game.enums.ResourceEnum;
import game.game.enums.ResourceSourceEnum;
import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/5 15:13
 */
public class ResourceChangeEvent implements IEvent {
    public ResourceEnum resource;

    // 0:player,other:hero
    public int heroId;

    public int count;

    public int curCount;

    public ResourceSourceEnum source;

    public ConsumeTypeEnum consume;

    public ResourceChangeEvent() {
    }

    public ResourceChangeEvent(final ResourceEnum resource, final int heroId, final int count, final ResourceSourceEnum source) {
        this.heroId = heroId;
        this.count = count;
        this.source = source;
        this.resource = resource;
    }

    public ResourceChangeEvent(final ResourceEnum resource, final int heroId, final int count, final ConsumeTypeEnum consume) {
        this.heroId = heroId;
        this.count = count;
        this.consume = consume;
        this.resource = resource;

    }

    public ResourceChangeEvent setCurCount(final int c) {
        this.curCount = c;

        return this;
    }

    @Override
    public EventType type() {
        return EventType.RESOURCE_ADD;
    }
}
