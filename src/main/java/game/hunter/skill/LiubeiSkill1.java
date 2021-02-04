package game.hunter.skill;

import game.hunter.Hero;
import game.hunter.Skill;
import game.hunter.action.ActionPoint;
import game.hunter.buff.hero.LiubeiBuff1;
import game.hunter.record.UseSkillRecord;

import java.util.List;
import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/2/2 15:04
 */
public class LiubeiSkill1 extends Skill {

    public LiubeiSkill1() {
        actionPoint = ActionPoint.回合开始前;
        id = 200004;
        name = "激励";
    }

    @Override
    public UseSkillRecord process(Hero hero) {
        UseSkillRecord record = super.process(hero);

        List<Hero> list = hero.getBattle().mySideHeroes(hero.getSide());

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
