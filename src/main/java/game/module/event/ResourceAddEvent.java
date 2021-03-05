package game.module.event;

import game.game.ResourceEnum;

/**
 * @author Yunzhe.Jin
 * 2021/3/5 15:13
 */
public class ResourceAddEvent implements IEvent {
    public final ResourceEnum resource;
    public final int count;
    public final ResourceSourceEnum source;

    public ResourceAddEvent(ResourceEnum resource, int count, ResourceSourceEnum source) {
        this.count = count;
        this.source = source;
        this.resource = resource;
    }

    @Override
    public EventType type() {
        return EventType.RESOURCE_ADD;
    }
}
