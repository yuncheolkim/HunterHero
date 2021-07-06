package game.module.battle.buff.hero;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.Buff;
import game.module.battle.damage.DamageInfo;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

/**
 * 0:最大生命值伤害比例
 * 1:叠加数
 *
 * @author Yunzhe.Jin
 * 2021/7/4 21:04
 */
public class ZhuoShaoBuff extends Buff {
    public ZhuoShaoBuff(final int sourceId) {
        super(BattleConstant.buff_zhuoshao, sourceId);
    }

    @Override
    protected void process0(final ActionPoint actionPoint, final Hero hero) {

        switch (actionPoint) {
            case 回合结束后:
                final int damage = CalcUtil.change100(hero.getHp(), data[0]);
                if (damage > 0) {
                    final DamageInfo info = new DamageInfo();
                    info.type = DamageType.DAMAGE_BUFF;
                    info.sourceId = id;
                    info.sourceDamage = damage;
                    info.target = hero;
                    hero.reduceHp(info);
                }
                break;
        }
    }

    public void addDamageRate(final int rate) {
        data[0] = CalcUtil.final100(data[0], rate);
    }
}
