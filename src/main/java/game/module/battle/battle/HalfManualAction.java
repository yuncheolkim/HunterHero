package game.module.battle.battle;

import game.base.util.Tuple2;
import game.module.battle.Side;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/7/18 14:25
 */
public class HalfManualAction {

    public Side side;

    /**
     * from -> to
     */
    public List<Tuple2<Integer, Integer>> actions = new ArrayList<>(8);

}
