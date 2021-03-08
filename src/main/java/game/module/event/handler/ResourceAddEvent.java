package game.module.event.handler;

import game.game.ResourceEnum;
import game.module.event.EventType;
import game.module.event.IEvent;
import game.module.event.ResourceSourceEnum;

/**
 * @author Yunzhe.Jin
 * 2021/3/5 15:13
 */
public class ResourceAddEvent implements IEvent {
    public final ResourceEnum resource;

    // 0:player,other:hero
    public final int heroId;

    public final int count;

    public final ResourceSourceEnum source;

    public ResourceAddEvent(ResourceEnum resource, int heroId, int count, ResourceSourceEnum source) {
        this.heroId = heroId;
        this.count = count;
        this.source = source;
        this.resource = resource;
    }

    @Override
    public EventType type() {
        return EventType.RESOURCE_ADD;
    }
}
