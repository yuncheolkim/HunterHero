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
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill1 extends Skill {

    private int targetHeroId;

    /**
     * 每次增加伤害比例
     */
    private int addDamageRate = 10;

    /**
     * 最高可叠加数
     */
    private int maxDamageRate = 50;

    /**
     * 当前叠加的伤害
     */
    private int curDamageRate;

    /**
     * 暴击伤害
     */
    private int addCritical;

    public GuanyuSkill1() {
        id = 2;
        actionPoint.put(出手前, 1);
        actionPoint.put(出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final Hero currentTarget = hero.damageInfo.target;

        switch (actionPoint) {
            case 出手后:
                if (targetHeroId == 0) {
                    targetHeroId = currentTarget.getId();
                    curDamageRate = 0;
                }
                curDamageRate = Math.max(addDamageRate + curDamageRate, maxDamageRate);
                break;
            case 出手前:
                hero.fightingData.damage += CalcUtil.add100(hero.origin.damage, curDamageRate);

                if (curDamageRate == maxDamageRate) {
                    hero.fightingData.critical += CalcUtil.add100(hero.origin.critical, addCritical);

                }
                break;
        }

    }

    public void setAddDamageRate(final int addDamageRate) {
        this.addDamageRate = addDamageRate;
    }

    public void setAddCritical(final int addCritical) {
        this.addCritical = addCritical;
    }

    public void setMaxDamageRate(int maxDamageRate) {
        this.maxDamageRate = maxDamageRate;
    }


}
