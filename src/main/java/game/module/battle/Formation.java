package game.module.battle;

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

}
