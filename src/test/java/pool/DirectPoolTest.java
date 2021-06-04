package pool;

import com.google.common.base.Stopwatch;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yunzhe.Jin
 * 2021/6/4 11:33
 */
public class DirectPoolTest {
    public static void main(final String[] args) throws InterruptedException {
        final PooledByteBufAllocator pooledByteBufAllocator = new PooledByteBufAllocator(true);
        final int initialCapacity = 1024 * 1024 * 1024 / 4;
        final ByteBuf byteBuf = pooledByteBufAllocator.heapBuffer(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            byteBuf.writeInt(i);
        }

        int a = 0;

        final Stopwatch s = Stopwatch.createStarted();

        System.out.println("start");
        final Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            a += byteBuf.getInt(random.nextInt(1000000));
        }

        System.out.println(a);

        System.out.println(s.toString());
        TimeUnit.SECONDS.sleep(300);
    }
}
