package game.module.event.handler;

import game.game.enums.ResourceSourceEnum;
import game.module.event.EventType;
import game.module.event.IEvent;

/**
 * @author Yunzhe.Jin
 * 2021/3/11 17:44
 */
public class ExpAddEvent implements IEvent {
    public int heroId;

    public int addExp;

    public int curExp;

    public ResourceSourceEnum source;

    public ExpAddEvent() {
    }

    public ExpAddEvent(int heroId, int addExp, int curExp, ResourceSourceEnum source) {
        this.heroId = heroId;
        this.addExp = addExp;
        this.curExp = curExp;
        this.source = source;
    }

    @Override
    public EventType type() {
        return EventType.EXP_ADD;
    }
}
