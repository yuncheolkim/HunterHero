package pool;

import com.google.common.base.Stopwatch;
import io.netty.util.internal.ObjectPool;
import org.junit.Test;

import java.util.Random;

/**
 * @author Yunzhe.Jin
 * 2021/6/3 10:25
 */
public class TestPool1 {
    private static final ObjectPool<Data> RECYCLER = ObjectPool.newPool(
            new ObjectPool.ObjectCreator<Data>() {
                @Override
                public Data newObject(final ObjectPool.Handle<Data> handle) {
                    return new Data(handle);
                }
            });

    @Test
    public void test1() {

        final int v = 0;
        final Stopwatch s = Stopwatch.createStarted();
        final int i1 = new Random(System.currentTimeMillis()).nextInt(2) + 5000000;
        System.out.println(i1);
        for (int i = 0; i < i1; i++) {
            v1 += i;
//            T1(d);
//            d.v = i;
//
//            v += d.v;
//            d.recycle();
        }

        System.out.println(v);
        System.out.println(s.toString());
    }

    private static int v1 = 0;

    private void T1(final Data d) {

        v1 += d.v;
    }

    static class Data {
        public int v;

        private ObjectPool.Handle<Data> handle;

        public Data() {
        }

        public Data(final ObjectPool.Handle<Data> handle) {

            this.handle = handle;
        }

        public void recycle() {
            handle.recycle(this);
        }
    }
}
