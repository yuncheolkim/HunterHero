package game.module.battle.status;

import game.module.battle.Hero;

/**
 * 血量变化
 *
 * @author Yunzhe.Jin
 * 2021/1/11 14:37
 */
public class HealthChangeInfo {

    private int oldValue;

    private int newValue;

    private Hero target;

    public int getOldValue() {
        return oldValue;
    }

    public void setOldValue(int oldValue) {
        this.oldValue = oldValue;
    }

    public int getNewValue() {
        return newValue;
    }

    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }

    public Hero getTarget() {
        return target;
    }

    public void setTarget(Hero target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "HealthChangeInfo{" +
                "oldValue=" + oldValue +
                ", newValue=" + newValue +
                ", target=" + target +
                '}';
    }
}
