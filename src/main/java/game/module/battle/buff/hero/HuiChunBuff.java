package game.module.battle.buff.hero;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.utils.CalcUtil;

/**
 * 回春
 * <p>
 * 每回合结束的时候恢复10%最大血量
 * <p>
 * 0: 回复比例
 * 1:伤害提高比例
 * 2:暴击提高比例
 * 3:护甲提高比例
 *
 * @author Yunzhe.Jin
 * 2021/7/7 14:33
 */
public class HuiChunBuff extends Buff {

    public HuiChunBuff(final int sourceHeroId) {
        super(BattleConstant.buff_huichun, sourceHeroId);
    }

    @Override
    protected void process0(final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 回合结束后:
                // 恢复最大血量的血量
                hero.addHp(CalcUtil.change100(hero.property.maxHp, data[0]));
                break;
            case 出手前:
                if (data[1] > 0) {
                    hero.fightingData.damage += CalcUtil.change100(hero.fightingData.damage, data[1]);
                }
                if (data[2] > 0) {
                    hero.fightingData.critical += CalcUtil.change100(hero.fightingData.critical, data[2]);
                }
                break;
            case 被攻击之前:
                if (data[3] > 0) {
                    hero.fightingData.def += CalcUtil.change100(hero.fightingData.def, data[3]);
                }
                break;
        }
    }

    public void setHpRate(final int i) {
        data[0] = i;
    }

    public void setDamageRate(final int i) {
        data[1] = i;
        addEffectPoint(ActionPoint.出手前);
    }

    public void setCriticalRate(final int i) {
        data[2] = i;
        addEffectPoint(ActionPoint.出手前);
    }

    public void setDefRate(final int i) {
        data[3] = i;
        addEffectPoint(ActionPoint.被攻击之前);
    }
}
