package game.module.battle.skill;

import game.module.battle.Constant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.damage.DamageSourceType;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 关羽技能2
 * 溅射伤害
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill2 extends Skill {
    /**
     * 溅射比例
     */
    private int rate = 40;

    public GuanyuSkill2() {
        actionPoint.put(ActionPoint.出手后, 1);
        id = 200003;
        name = "GuanyuSkill2";
        cd = Constant.INFINITE;
    }

    @Override
    public boolean canProcess(final Hero hero) {
        final List<Hero> collect = attackHero(hero);
        return !collect.isEmpty();
    }

    private List<Hero> attackHero(final Hero hero) {
        final Collection<Hero> list = hero.getBattle().oppositeHeroes(hero.getSide()).values();
        final Hero currentTarget = hero.damageInfo.target;
        if (currentTarget == null) {
            return new ArrayList<>();
        }
        return list.stream()
                .filter(h -> h.getPos().getIndex() == currentTarget.getBattle().getFormation().left(currentTarget.getPos()) ||
                        h.getPos().getIndex() == currentTarget.getBattle().getFormation().right(currentTarget.getPos()) ||
                        h.getPos().getIndex() == currentTarget.getBattle().getFormation().down(currentTarget.getPos())
                )
                .filter(Hero::isAlive)
                .collect(Collectors.toList());
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        final Record process = super.process(point, hero);
        final List<Hero> collect = attackHero(hero);
        process.targetList = collect.stream().map(h -> h.getPos().getIndex()).collect(Collectors.toList());

        for (final Hero target : collect) {
            final DamageInfo damageInfo = new DamageInfo();
            damageInfo.sourceId = id;
            damageInfo.type = (DamageSourceType.SKILL);
            damageInfo.source = (hero);
            damageInfo.target = (target);
            damageInfo.sourceDamage = CalcUtil.calcRateAdd(hero.damageInfo.allSourceDamage(), rate);

            hero.damage(damageInfo);
        }
        return process;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
