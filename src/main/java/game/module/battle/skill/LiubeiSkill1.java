package game.module.battle.skill;

import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LiubeiBuff1;
import game.module.battle.record.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill1 extends Skill {

    public LiubeiSkill1() {
        actionPoint.put(ActionPoint.回合开始前, 1);
        id = 200004;
        name = "激励";
    }

    @Override
    public Record process(ActionPoint point, Hero hero) {
        Record record = super.process(point, hero);

        List<Hero> list = new ArrayList<>(hero.getBattle().mySideHeroes(hero.getSide()).values());

        Optional<Hero> any = list.stream().filter(Hero::isAlive)
                .filter(hero1 -> !hero1.hasBuff(300003)).findAny();
        LiubeiBuff1 addBuff = new LiubeiBuff1();
        if (any.isPresent()) {
            any.get().addBuff(addBuff);
        } else {
            list.get(0).addBuff(addBuff);
        }

        return record;
    }
}
