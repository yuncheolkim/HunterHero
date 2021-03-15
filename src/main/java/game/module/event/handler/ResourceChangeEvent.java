package game.module.event.handler;

import game.game.ConsumeTypeEnum;
import game.game.ResourceEnum;
import game.game.ResourceSourceEnum;
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

    public ResourceSourceEnum source;
    public ConsumeTypeEnum consume;

    public ResourceChangeEvent() {
    }

    public ResourceChangeEvent(ResourceEnum resource, int heroId, int count, ResourceSourceEnum source) {
        this.heroId = heroId;
        this.count = count;
        this.source = source;
        this.resource = resource;
    }

    public ResourceChangeEvent(ResourceEnum resource, int heroId, int count, ConsumeTypeEnum consume) {
        this.heroId = heroId;
        this.count = count;
        this.consume = consume;
        this.resource = resource;

    }

    @Override
    public EventType type() {
        return EventType.RESOURCE_ADD;
    }
}
