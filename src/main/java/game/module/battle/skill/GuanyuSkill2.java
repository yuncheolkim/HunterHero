package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 关羽技能2
 * 溅射伤害
 * <p>
 * 0:溅射比例
 * 1:是否一排 - T
 *
 * @author Yunzhe.Jin
 * 2021/1/11 10:30
 */
public class GuanyuSkill2 extends Skill {

    public GuanyuSkill2() {
        super(3);
        actionPoint.put(ActionPoint.出手后, 1);
        needRecord = true;
    }

    @Override
    public boolean canProcess(final Hero hero) {
        final List<Hero> collect = attackHero(hero);
        return !collect.isEmpty();
    }

    private List<Hero> attackHero(final Hero hero) {
        final Map<Integer, Hero> enemy = hero.getBattle().oppositeHeroes(hero.getSide());
        final Collection<Hero> list = enemy.values();
        final Hero currentTarget = hero.getBattle().getDamageInfo().target;
        if (currentTarget == null) {
            return new ArrayList<>();
        }
        if (data[1] != 0) {
            final List<Integer> row = currentTarget.getBattle().getFormation().row(currentTarget.getPos());
            final List<Hero> result = new ArrayList<>(4);
            for (final Integer pos : row) {
                if (pos == currentTarget.getPos().getIndex()) {
                    continue;
                }
                final Hero h = enemy.get(pos);
                if (h != null && h.isAlive()) {
                    result.add(h);
                }
            }

            return result;

        } else {

            return list.stream()
                    .filter(h -> h.getPos().getIndex() == currentTarget.getBattle().getFormation().left(currentTarget.getPos()) ||
                            h.getPos().getIndex() == currentTarget.getBattle().getFormation().right(currentTarget.getPos()) ||
                            h.getPos().getIndex() == currentTarget.getBattle().getFormation().down(currentTarget.getPos())
                    )
                    .filter(Hero::isAlive)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        final Record process = super.process(point, hero);
        final List<Hero> collect = attackHero(hero);
        process.targetList = collect.stream().map(h -> h.getPos().getIndex()).collect(Collectors.toList());

        final int rate = data[0];
        final DamageInfo damageInfo1 = hero.getBattle().getDamageInfo();
        for (final Hero target : collect) {
            final DamageInfo damageInfo = new DamageInfo();
            damageInfo.sourceId = id;
            damageInfo.type = DamageType.DAMAGE_SKILL;
            damageInfo.source = (hero);
            damageInfo.target = (target);
            damageInfo.sourceDamage = CalcUtil.add100(damageInfo1.allSourceDamage(), rate);

            hero.damage(damageInfo);
        }
        return process;
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {

    }

    public void talent1(final int id) {
        data[1] = 1;
    }

    public void talent2(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
