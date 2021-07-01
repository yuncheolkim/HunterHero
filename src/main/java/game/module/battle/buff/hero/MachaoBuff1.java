package game.module.battle.buff.hero;

import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;
import game.utils.CalcUtil;

/**
 * 每次被攻击增加10%暴击 如果暴击敌人,则清除效果
 *
 * @author Yunzhe.Jin
 * 2021/6/21 21:07
 */
public class MachaoBuff1 extends DefaultDataBuff {

    /**
     * 暴击比例
     */
    private int rate = 10;

    public MachaoBuff1() {
        effectPoint.put(ActionPoint.出手前, 1);
        effectPoint.put(ActionPoint.暴击之后, 1);
        effectPoint.put(ActionPoint.受到伤害之后, 1);
        effectPoint.put(ActionPoint.出手结束后, 1);
        id = BattleConstant.buff_machao_1;
        move = ConfigManager.buffDataBox.findById(id).move;
    }


    @Override
    public void process0(final ActionPoint actionPoint, final Hero hero) {


        switch (actionPoint) {
            case 暴击之后:
                data.setInt1(0);
                break;
            case 受到伤害之后:
                data.setInt1(data.getInt1() + rate);
                break;
            case 出手前:
                if (data.getInt1() > 0) {
                    hero.fightingData.setCritical(CalcUtil.final100(hero.fightingData.getCritical(), data.getInt1()));
                }
                break;
//            case 出手结束后:
//                data.setInt1(0);
//                break;

        }
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

}
