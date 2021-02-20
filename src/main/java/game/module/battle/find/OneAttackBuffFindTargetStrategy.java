package game.module.battle.find;

import game.module.battle.FindTargetStrategy;
import game.module.battle.Hero;
import game.module.battle.buff.Buff;
import game.module.battle.buff.OneAttackBuff;

import java.util.List;
import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/1/13 14:46
 */
public class OneAttackBuffFindTargetStrategy implements FindTargetStrategy {
    @Override
    public boolean find(Hero search, List<Hero> found) {
        Optional<Buff> first = search.getBuffMap().values().stream().filter(buff -> buff.getClass() == OneAttackBuff.class).findFirst();
        if (first.isPresent()) {
            OneAttackBuff buff = (OneAttackBuff) first.get();

            if (buff.target.isAlive()) {
                found.add(buff.target);
                return false;
            }
        }

        return true;
    }
}
