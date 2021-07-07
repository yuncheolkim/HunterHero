package game.module.battle.buff.hero;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.utils.CalcUtil;

/**
 * 回春
 * <p>
 * 每回合结束的时候恢复5%最大血量
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
        // 恢复最大血量的血量
        hero.addHp(CalcUtil.change100(hero.property.maxHp, data[0]));
    }
}
