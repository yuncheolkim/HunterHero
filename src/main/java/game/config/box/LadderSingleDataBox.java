package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.LadderSingleConfigData;

import java.util.TreeMap;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class LadderSingleDataBox extends MapConfigDataBox<LadderSingleConfigData> {


    public LadderSingleDataBox() {
        super("data/ladder_single.json");
    }


    @Override
    public void end() {
        super.end();
        map = new TreeMap<>(map);
    }

    public LadderSingleConfigData findScore(int score) {
        TreeMap<Integer, LadderSingleConfigData> m = (TreeMap) map;
        return m.floorEntry(score).getValue();
    }
}
