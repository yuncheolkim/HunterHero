package game.module.ladder.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Yunzhe.Jin
 * 2021/9/2 22:04
 */
public class TreeMapList {

    TreeMap<Long, List<MatchTempData>> tree = new TreeMap<>();

    public void put(Long key, MatchTempData v) {
        List<MatchTempData> matchTempData = tree.computeIfAbsent(key, k -> new ArrayList<>());
        matchTempData.add(v);
    }

    public Map.Entry<Long, List<MatchTempData>> ceil(Long key) {
        return tree.ceilingEntry(key);
    }

    public Map.Entry<Long, List<MatchTempData>> floor(Long key) {
        return tree.floorEntry(key);
    }

}

