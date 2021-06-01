package game.base.util;

/**
 * @author Yunzhe.Jin
 * 2021/6/1 22:26
 */
public class Tuple2<A, B> {
    public final A first;
    public final B second;

    public Tuple2(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "{" + first + ", " + second + "}";
    }
}
