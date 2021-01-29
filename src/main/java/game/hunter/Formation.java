package game.hunter;

/**
 * @author Yunzhe.Jin
 * 2021/1/28 16:18
 */
public enum Formation {

    /**
     * -8 -7 -6 -5
     * -4 -3 -2 -1
     * -------------
     * 1 2 3
     * 4 5 6
     */
    A_4_4_B_3_3 {
        @Override
        public int left(Pos pos) {
            int index = pos.getIndex();
            if (index > 0) {
                if (index == 4) {
                    return 0;
                }
                return index - 1;

            } else {
                if (index == -5) {
                    return 0;
                }
                return index + 1;

            }

        }

        @Override
        public int right(Pos pos) {
            int index = pos.getIndex();
            if (index > 0) {
                if (index == 3 || index == 6) {
                    return 0;
                }
                return index + 1;

            } else {
                if (index == -4 || index == -8) {
                    return 0;
                }
                return index - 1;

            }
        }

        @Override
        public int up(Pos pos) {
            int index = pos.getIndex();

            if (index > 0) {
                if (index > 3) {
                    return index - 3;
                }
                return 0;
            } else {
                if (index > -5) {
                    return 0;
                }

                return index + 4;

            }
        }

        @Override
        public int down(Pos pos) {
            int index = pos.getIndex();

            if (index > 0) {
                if (index > 3) {
                    return 0;
                }
                return index + 3;
            } else {
                if (index > -5) {
                    return index - 4;
                }
                return 0;
            }
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
