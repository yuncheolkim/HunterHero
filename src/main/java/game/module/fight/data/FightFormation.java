package game.module.fight.data;

import game.module.battle.Hero;
import game.module.battle.Side;
import game.proto.data.FightType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/8/28 22:20
 */
public class FightFormation {

    public long matchId;
    public long uid;
    public String userName;
    public Side side;
    public List<Hero> heroList = new ArrayList<>();
    public int score;

    public FightType battleType;
}
