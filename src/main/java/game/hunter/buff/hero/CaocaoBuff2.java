package game.hunter.buff.hero;

import game.hunter.Hero;
import game.hunter.action.ActionPoint;
import game.hunter.buff.DefaultDataBuff;

/**
 * 激励
 * 增加攻击力
 * @author Yunzhe.Jin
 * 2021/2/3 18:09
 */
public class CaocaoBuff2 extends DefaultDataBuff {

    public CaocaoBuff2() {
        // 增加比例
        data.setInt1(20);
        effectPoint.put(ActionPoint.增加buff后, 1);
        id = 300006;
        name = "护甲";
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
    }
}
