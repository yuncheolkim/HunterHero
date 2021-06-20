package game.module.battle;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/1/28 16:18
 */
public enum Formation {

    /**
     * 23 22 21 20
     * 19 18 17 16
     * -------------
     * 0 1 2
     * 3 4 5
     */
    A_3_3_B_4_4 {
        @Override
        public int left(Pos pos) {
            int index = pos.getIndex();
            if (index == 0 || index == 3 || index == 20 || index == 16) {
                return -1;
            }
            return index - 1;
        }

        @Override
        public int right(Pos pos) {
            int index = pos.getIndex();
            if (index == 2 || index == 5 || index == 19 || index == 23) {
                return -1;
            }
            return index + 1;
        }

        @Override
        public int up(Pos pos) {
            int index = pos.getIndex();

            switch (index) {
                case 3:
                case 4:
                case 5:
                    return index - 3;
                case 20:
                case 21:
                case 22:
                case 23:
                    return index - 4;
            }

            return -1;
        }

        @Override
        public int down(Pos pos) {
            int index = pos.getIndex();


            switch (index) {
                case 3:
                case 4:
                case 5:
                case 20:
                case 21:
                case 22:
                case 23:
                    return -1;
            }

            return index + 1;
        }
    };


    public int left(Pos pos) {
        return 0;
    }

    public int right(Pos pos) {
        return 0;
    }

    public int up(Pos pos) {
        return 0;
    }

    public int down(Pos pos) {
        return 0;
    }

    public List<Integer> front(Pos pos) {
        List<Integer> array = new ArrayList<>(0);
        switch (pos.getIndex()) {
            case 0:
            case 3:
                array = Lists.newArrayList(18, 19, 16, 17);
                break;
            case 1:
            case 4:
                array = Lists.newArrayList(17, 18, 19, 16);
                break;
            case 2:
            case 5:
                array = Lists.newArrayList(16, 18, 19, 17);
                break;
            case 16:
            case 20:
            case 17:
            case 21:
                array = Lists.newArrayList(2, 1, 0);
                break;
            case 18:
            case 22:
                array = Lists.newArrayList(1, 0, 2);
                break;
            case 19:
            case 23:
                array = Lists.newArrayList(0, 1, 2);
                break;
        }

        return array;
    }

    public List<Integer> back(Pos pos) {
        List<Integer> array = front(pos);
        int add = 3;
        if (pos.getIndex() < 6) {
            add = 4;
        }

        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + add);
        }

        return array;
    }
}
