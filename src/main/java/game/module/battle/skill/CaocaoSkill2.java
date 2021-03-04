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
    private int rate = 100;

    public CaocaoSkill2() {
        actionPoint.put(ActionPoint.被攻击之前, 1);
        id = 200007;
        name = "护驾";
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);

        Battle battle = hero.getBattle();
        boolean happened = CalcUtil.happened(battle.getRandom(), rate, 100);

        if (!happened) {
            return null;
        }
        List<Hero> collect = hero.friends().stream()
                .filter(Hero::isAlive)
                .filter(h -> h.getId() != Caocao.ID)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            return null;
        }

        Logs.trace("护驾");
        int i = battle.getRandom().nextInt(collect.size());

        hero.damageInfo.target = collect.get(i);

        return record;
    }
}
