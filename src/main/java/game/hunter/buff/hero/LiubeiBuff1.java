package game.hunter.buff.hero;

import game.hunter.CalcUtil;
import game.hunter.Hero;
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
        // 增加比例
        data.setInt1(20);
        effectPoint.put(ActionPoint.增加buff后, 1);
        id = 300003;
        name = "激励";
        initRound(2);
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
        hero.property.damage += CalcUtil.calcRateAdd(hero.origin.damage, data.getInt1());
    }
}
