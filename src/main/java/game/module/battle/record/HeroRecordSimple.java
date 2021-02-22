package game.module.battle.record;

import com.google.common.base.MoreObjects;
import game.module.battle.Pos;

/**
 * @author Yunzhe.Jin
 * 2021/1/18 16:53
 */
public class HeroRecordSimple {
    public int id;

    public Pos pos;

    public int hp;

    public int angry;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("pos", pos)
                .add("hp", hp)
                .toString();
    }
}