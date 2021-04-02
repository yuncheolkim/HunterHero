package game.base;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yunzhe.Jin
 * 2021/4/2 16:40
 */
public class DefaultLongIdGenerator implements LongIdGenerator {

    private AtomicLong id = new AtomicLong();

    @Override
    public long next() {
        return id.incrementAndGet();
    }
}
