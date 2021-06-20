package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.HeroActionPointHandler;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.OneAttackBuff;
import game.module.battle.buff.data.OneAttackBuffData;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 关羽技能1
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill1 extends Skill {
    private OneAttackBuffData data;

    private int addDamageRate;
    private int addCritical;

    private HeroActionPointHandler action;

    public GuanyuSkill1() {
        id = 200002;
        name = "GuanyuSkill1";
        actionPoint.put(ActionPoint.出手后, 1);
        priority = 1;
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);
        OneAttackBuffData d = new OneAttackBuffData();
        d.setStack(data.getStack());
        d.setCurrent(data.getCurrent());
        hero.addBuff(new OneAttackBuff(hero.damageInfo.target, d));
        OneAttackBuff buff = (OneAttackBuff) hero.findBuff(Constant.buff_guanyu_skill1).get();

        if (addCritical > 0) {
            if (buff.isMax() && action == null) {
                action = h -> {
                    h.fightingData.setCritical(CalcUtil.calcRateFinal(h.fightingData.getCritical(), addCritical));
                };
                hero.addAction(ActionPoint.出手前, action);
            } else if (!buff.isMax() && action != null) {
                hero.removeAction(ActionPoint.出手前, action);
                action = null;
            }
        }


        final Hero currentTarget = hero.damageInfo.target;

        if (currentTarget.isDead()) {
            hero.property.damage += CalcUtil.calcRateChangeValue(hero.origin.damage, addDamageRate);
        }

        return record;
    }

    public void setData(OneAttackBuffData data) {
        this.data = data;
    }

    public void setAddDamageRate(int addDamageRate) {
        this.addDamageRate = addDamageRate;
    }

    public void setAddCritical(int addCritical) {
        this.addCritical = addCritical;
    }
}
