package game.module.battle;

/**
 * @author Yunzhe.Jin
 * 2021/1/11 10:38
 */
public enum Side {
    A, B;

    public Side opposite() {
        return this == A ? B : A;
    }
}
