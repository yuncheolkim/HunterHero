package game.module.battle.skill;

import game.base.Logs;
import game.module.battle.Battle;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.hero.Caocao;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class CaocaoSkill2 extends Skill {

    /**
     * 35%概率触发护驾
     */
    private final int rate = 100;

    public CaocaoSkill2() {
        super(1);
        actionPoint.put(ActionPoint.被攻击之前, 1);
        id = 200007;
    }

    @Override
    public Record process(final ActionPoint point, final Hero hero) {
        final Record record = super.process(point, hero);

        final Battle battle = hero.getBattle();
        final boolean happened = CalcUtil.happened(battle.getRandom(), rate, 100);

        if (!happened) {
            return null;
        }
        final List<Hero> collect = hero.friends().values().stream()
                .filter(Hero::isAlive)
                .filter(h -> h.getId() != Caocao.ID)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            return null;
        }

        Logs.trace("护驾");
        final int i = battle.getRandom().nextInt(collect.size());

        hero.damageInfo.target = collect.get(i);

        return record;
    }
}
