package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import static game.module.battle.action.ActionPoint.出手前;
import static game.module.battle.action.ActionPoint.出手后;

/**
 * 关羽技能1
 * <p>
 * 0:每次攻击增加伤害的比例
 * 1:最高可叠加上限
 * 2:暴击伤害 - T
 * 3:换目标后加成的伤害 - T
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill1 extends Skill {

    private int targetHeroId;

    /**
     * 当前叠加的伤害
     */
    private int curDamageRate;

    /**
     * 换目标后加成的伤害
     */
    private int addDamage;

    public GuanyuSkill1() {
        super(2);
        actionPoint.put(出手前, 1);
        actionPoint.put(出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final Hero currentTarget = hero.getBattle().getDamageInfo().target;
        final int addDamageRate = data[0];
        final int maxDamageRate = data[1];

        switch (actionPoint) {
            case 出手后 -> {
                if (targetHeroId == 0) {
                    targetHeroId = currentTarget.getId();
                    curDamageRate = 0;
                } else if (targetHeroId != currentTarget.getId()) {
                    curDamageRate = 0;
                    addDamage += data[3];
                }
                curDamageRate = Math.max(addDamageRate + curDamageRate, maxDamageRate);
            }
            case 出手前 -> {
                hero.fightingData.damage += CalcUtil.change100(hero.origin.damage, curDamageRate + addDamage);
                if (curDamageRate == maxDamageRate) {
                    hero.fightingData.critical += CalcUtil.change100(hero.origin.critical, data[2]);
                }
            }
        }

    }

    public void talent1(final int i1) {
        data[1] = i1;
    }

    public void talent2(final int i1) {
        data[0] = i1;
    }

    public void talent3(final int i1) {
        data[2] = i1;
    }

    public void talent4(final int i1) {
        data[3] = i1;
    }
}
