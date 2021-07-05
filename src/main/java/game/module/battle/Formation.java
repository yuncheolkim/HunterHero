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
        public int left(final Pos pos) {
            final int index = pos.getIndex();
            if (index == 0 || index == 3 || index == 20 || index == 16) {
                return -1;
            }
            return index - 1;
        }

        @Override
        public int right(final Pos pos) {
            final int index = pos.getIndex();
            if (index == 2 || index == 5 || index == 19 || index == 23) {
                return -1;
            }
            return index + 1;
        }

        @Override
        public int up(final Pos pos) {
            final int index = pos.getIndex();

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
        public int down(final Pos pos) {
            final int index = pos.getIndex();

            switch (index) {
                case 0:
                case 1:
                case 2:
                    return index + 3;
                case 16:
                case 17:
                case 18:
                case 19:
                    return index + 4;
            }

            return -1;
        }

        @Override
        public List<Integer> front(final Pos pos) {
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

        @Override
        public List<Integer> back(final Pos pos) {
            final List<Integer> array = front(pos);
            int add = 3;
            if (pos.getIndex() < 6) {
                add = 4;
            }

            for (int i = 0; i < array.size(); i++) {
                array.set(i, array.get(i) + add);
            }

            return array;
        }

        /**
         * 目标所在行的位置
         * @param pos
         * @return
         */
        @Override
        public List<Integer> row(final Pos pos) {
            List<Integer> array = null;
            final int index = pos.getIndex();

            if (index < 3) {
                array = Lists.newArrayList(0, 1, 2);
            } else if (index < 6) {
                array = Lists.newArrayList(3, 4, 5);
            } else if (index < 20) {
                array = Lists.newArrayList(16, 17, 18, 19);
            } else {
                array = Lists.newArrayList(20, 21, 22, 23);
            }

            return array;
        }
    };


    public int left(final Pos pos) {
        return 0;
    }

    public int right(final Pos pos) {
        return 0;
    }

    public int up(final Pos pos) {
        return 0;
    }

    public int down(final Pos pos) {
        return 0;
    }

    public List<Integer> front(final Pos pos) {
        final List<Integer> array = new ArrayList<>(0);


        return array;
    }

    public List<Integer> back(final Pos pos) {
        final List<Integer> array = front(pos);

        return array;
    }

    /**
     * 一行坐标
     *
     * @param pos
     * @return
     */
    public List<Integer> row(final Pos pos) {

        return null;
    }

    public List<Integer> around(final Pos pos) {
        final List<Integer> list = new ArrayList<>(8);

        findAround(pos, list);
        list.remove(new Integer(pos.getIndex()));
        return list;
    }

    private void findAround(final Pos pos, final List<Integer> list) {
        final int[] data = new int[4];

        data[0] = up(pos);
        data[1] = down(pos);
        data[2] = left(pos);
        data[3] = right(pos);

        for (int i = 0; i < data.length; i++) {
            final int index = data[i];
            if (index >= 0 && !list.contains(index)) {
                list.add(index);
            } else {
                data[i] = -1;
            }
        }

        for (final int index : data) {
            if (index >= 0) {
                findAround(Pos.from(index), list);
            }
        }
    }
}
