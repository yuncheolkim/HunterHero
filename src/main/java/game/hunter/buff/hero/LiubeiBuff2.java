package game.hunter.buff.hero;

import game.hunter.action.ActionPoint;
import game.hunter.buff.Buff;

/**
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class LiubeiBuff2 extends Buff {

    public LiubeiBuff2() {
        effectPoint.put(ActionPoint.增加buff后, 1);
        id = 300004;
        name = "以德服人";
    }
}
