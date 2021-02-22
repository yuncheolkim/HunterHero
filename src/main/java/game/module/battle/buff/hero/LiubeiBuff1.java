package game.module.battle.buff.hero;

import game.module.battle.CalcUtil;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;

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
        effectPoint.put(ActionPoint.重新计算属性, 1);
        id = 300003;
        name = "激励";
        initRound(2);
    }

    @Override
    public void process(ActionPoint actionPoint, Hero hero) {
        hero.property.damage += CalcUtil.calcRateAdd(hero.origin.damage, data.getInt1());
    }
}