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
import java.util.List;
import java.util.stream.Collectors;

/**
 * 关羽技能2
 * 溅射伤害
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill2 extends Skill {
    /**
     * 溅射比例
     */
    private float v = 0.2f;

    public GuanyuSkill2() {
        actionPoint.put(ActionPoint.出手后,1);
        id = 200003;
        name = "GuanyuSkill2";
        cd = Constant.INFINITE;
    }

    @Override
    public boolean canProcess(Hero hero) {
        List<Hero> collect = attackHero(hero);
        return !collect.isEmpty();
    }

    private List<Hero> attackHero(Hero hero) {
        List<Hero> list = hero.getBattle().oppositeHeroes(hero.getSide());
        Hero currentTarget = hero.damageInfo.target;
        if (currentTarget == null) {
            return new ArrayList<>();
        }
        return list.stream()
                .filter(h -> h.getPos().getIndex() == currentTarget.getBattle().getFormation().left(currentTarget.getPos()) ||
                        h.getPos().getIndex() == currentTarget.getBattle().getFormation().right(currentTarget.getPos()))
                .filter(Hero::isAlive)
                .collect(Collectors.toList());
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record process = super.process(point,hero);
        List<Hero> collect = attackHero(hero);
        process.target = collect.stream().map(Hero::getSimple).collect(Collectors.toList());

        for (Hero target : collect) {
            DamageInfo damageInfo = new DamageInfo();
            damageInfo.sourceId = id;
            damageInfo.type = (DamageSourceType.SKILL);
            damageInfo.source = (hero);
            damageInfo.target = (target);
            damageInfo.sourceDamage = (CalcUtil.calcRateAdd(hero.damageInfo.allSourceDamage(), v));

            hero.damage(damageInfo);
        }
        return process;
    }
}
