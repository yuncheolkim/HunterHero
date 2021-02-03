package game.hunter.buff.hero;

import game.hunter.action.ActionPoint;
import game.hunter.buff.DefaultDataBuff;

/**
 * 激励
 * 增加攻击力
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class LiubeiBuff1 extends DefaultDataBuff {

    public LiubeiBuff1() {
        effectPoint.put(ActionPoint.增加buff后, 1);
        id = 300003;
        name = "激励";
        initRound(2);
    }
}
