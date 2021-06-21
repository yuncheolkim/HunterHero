package game.module.battle.buff.hero;

import game.manager.ConfigManager;
import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;
import game.utils.CalcUtil;

/**
 * 敏捷如风
 *
 * @author Yunzhe.Jin
 * 2021/6/21 21:07
 */
public class ZhaoyunBuff1 extends DefaultDataBuff {

    private int rate = 10;

    public ZhaoyunBuff1() {
        effectPoint.put(ActionPoint.被攻击之前, 1);
        effectPoint.put(ActionPoint.闪避之后, 1);
        effectPoint.put(ActionPoint.受到伤害之后, 1);
        id = Constant.buff_zhaoyun_1;
        move = ConfigManager.buffDataBox
                .findById(id).move;
    }


    @Override
    public void process(ActionPoint actionPoint, Hero hero) {


        if (actionPoint == ActionPoint.闪避之后) {
            data.setInt1(0);
        } else if (actionPoint == ActionPoint.受到伤害之后) {
            data.setInt1(data.getInt1() + rate);
        } else if (actionPoint == ActionPoint.被攻击之前) {
            hero.fightingData.setAvoid(CalcUtil.calcRateFinal100(hero.fightingData.getAvoid(), 1));
        }
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
