package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 增加敌方失去血量百分比的伤害
 * <p>
 * 0: 伤害比例
 * 1: 没有暴击后伤害提高比例 - T
 * 2: 降低暴击-T
 * 3: 提高伤害-T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DianWeiSkill1 extends Skill {

    private boolean critical;

    public DianWeiSkill1() {
        super(45);
        addActionPoint(ActionPoint.出手前);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手前:
                final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
                final float v = CalcUtil.change100(damageInfo.target.hpLoseRate(), data[0]);
                hero.fightingData.damage += CalcUtil.change100(hero.fightingData.damage, v);
                if (!critical) {
                    hero.fightingData.damage += CalcUtil.change100(hero.fightingData.damage, data[1]);
                }
                break;
            case 出手后:
                critical = hero.getBattle().getDamageInfo().sourceCriticalDamage > 0;
                break;
            case 开场:
                hero.origin.critical -= CalcUtil.change100(hero.origin.critical, data[2]);
                hero.origin.damage += CalcUtil.change100(hero.origin.damage, data[3]);
                hero.property.critical = hero.origin.critical;
                hero.property.damage = hero.origin.damage;
                break;
        }
    }


    public void talent1(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
        addActionPoint(ActionPoint.出手后);
    }

    public void talent2(final int v1, final int v2) {
        data[2] = v1;
        data[3] = v2;
        addActionPoint(ActionPoint.开场);
    }


}
