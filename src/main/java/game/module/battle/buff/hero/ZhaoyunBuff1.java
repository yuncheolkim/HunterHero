package game.module.battle.buff.hero;

import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.DefaultDataBuff;
import game.utils.CalcUtil;

/**
 * 敏捷如风
 * 每次被攻击增加10%闪避,如果闪避成功则重新计算
 *
 * @author Yunzhe.Jin
 * 2021/6/21 21:07
 */
public class ZhaoyunBuff1 extends DefaultDataBuff {

    /**
     * 闪避比例
     */
    private int rate = 10;

    /**
     * 增加护甲比例
     */
    private int defRateData = 0;

    /**
     * 伤害加成增加量
     */
    private int attRateAdd = 0;

    /**
     * 闪避次数
     */
    private int avoidTime = 1;


    private int avoidTimeData = 1;

    public ZhaoyunBuff1() {
        effectPoint.put(ActionPoint.被攻击之前, 1);
        effectPoint.put(ActionPoint.闪避之后, 1);
        effectPoint.put(ActionPoint.受到伤害之后, 1);
        effectPoint.put(ActionPoint.出手结束后, 1);
        id = BattleConstant.buff_zhaoyun_1;
        move = ConfigManager.buffDataBox
                .findById(id).move;
    }


    @Override
    public void process0(final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 闪避之后:
                if (--avoidTime == 0) {
                    data.setInt1(0);
                    data.setInt2(0);
                }
                break;
            case 受到伤害之后:
                data.setInt1(data.getInt1() + rate);
                if (defRateData > 0) {
                    data.setInt2(data.getInt2() + defRateData);
                }
                break;
            case 被攻击之前:
                hero.fightingData.setAvoid(CalcUtil.final100(hero.fightingData.getAvoid(), data.getInt1()));
                if (data.getInt2() > 0) {
                    hero.fightingData.setDef(CalcUtil.final100(hero.fightingData.getDef(), data.getInt2()));
                }

                // 加攻击
                if (attRateAdd > 0) {
                    data.setInt3(data.getInt3() + attRateAdd);
                }
                break;
            case 出手结束后:
                data.setInt3(0);
                avoidTime = avoidTimeData;
                break;
            case 出手前:
                if (data.getInt3() > 0) {
                    hero.fightingData.setDamage(CalcUtil.final100(hero.fightingData.getDamage(), data.getInt3()));
                }

                break;
        }
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public void setDefRateData(final int defRateData) {
        this.defRateData = defRateData;
    }

    public void setAttRateAdd(final int attRateAdd) {
        this.attRateAdd = attRateAdd;
        effectPoint.put(ActionPoint.出手前, 1);

    }

    public void setAvoidTime(final int avoidTime) {
        this.avoidTime = avoidTime;
        this.avoidTimeData = avoidTime;
    }
}
