package game.module.battle.buff;

/**
 * @author Yunzhe.Jin
 * 2021/1/8 15:55
 */
public interface IBuffVal {
    default int i1() {
        return 0;
    }

    default int i2() {
        return 0;
    }

    default int i3() {
        return 0;
    }

    default int i4() {
        return 0;
    }

    default int i5() {
        return 0;
    }

    default float f1() {
        return 0.0f;
    }

    default float f2() {
        return 0.0f;
    }

    default float f3() {
        return 0.0f;
    }

    default float f4() {
        return 0.0f;
    }

    default float f5() {
        return 0.0f;
    }

    default <T> T obj() {
        return null;
    }


    void merge(IBuffVal from);
}
