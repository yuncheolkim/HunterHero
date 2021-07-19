package game.module.battle.battle;

import game.proto.data.FightHmHeroPos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/7/18 14:25
 */
public class HalfManualAction {

    public long pid;

    /**
     * from -> to
     */
    public List<FightHmHeroPos> actions = new ArrayList<>(8);

}
