package game.module.battle.buff.hero;

import game.base.Logs;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.module.battle.damage.DamageInfo;

/**
 * 祝福光环
 * <p>
 * 减少5%伤害
 *
 * @author Yunzhe.Jin
 * 2021/7/7 14:33
 */
public class ZhuFuBuff extends Buff {

    public ZhuFuBuff(final int sourceHeroId) {
        super(BattleConstant.buff_zhufu, sourceHeroId);
    }

    @Override
    protected void process0(final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        if (damageInfo.origin == hero) {
            return;
        }
        Logs.trace("ZhuFuBuff", data[0] / 100.f);
        hero.getBattle().getDamageInfo().reduceDamage(data[0] / 100.0f);
    }
}
