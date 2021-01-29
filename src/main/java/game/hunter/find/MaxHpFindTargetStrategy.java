package game.hunter.find;

import game.hunter.FindTargetStrategy;
import game.hunter.Hero;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/1/13 14:34
 */
public class MaxHpFindTargetStrategy implements FindTargetStrategy {
    @Override
    public boolean find(Hero search, List<Hero> found) {
        Optional<Hero> max = search.getBattle().oppositeHeroes(search.getSide()).stream()
                .filter(Hero::isAlive).max(Comparator.comparingInt(Hero::getHp));
        max.ifPresent(found::add);

        return found.isEmpty();
    }
}
