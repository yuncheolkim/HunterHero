package game.module.battle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/3/3 21:32
 */
public enum PosGen {

    RANDOM_8 {
        @Override
        public List<Integer> posList(int count) {
            int first = 16;
            List<Integer> r = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {

                r.add(first++);
            }
            return r;
        }
    };

    public abstract List<Integer> posList(int count);

}
