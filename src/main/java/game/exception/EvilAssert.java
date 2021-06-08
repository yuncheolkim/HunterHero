package game.exception;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 外挂行为
 *
 * @author Yunzhe.Jin
 * 2020/3/31 16:50
 */
public class EvilAssert {

    // is true
    public static void isTrue(final boolean condition, final Supplier<String> supplier) {
        if (!condition) {
            throw new EvilException(supplier.get());
        }
    }

    // is false
    public static void isFalse(final boolean condition, final Supplier<String> supplier) {
        isTrue(!condition, supplier);
    }

    // not null
    public static void notNull(@Nullable final Object o, final String msg) {
        if (o == null) {
            throw getException(msg);
        }
    }

    // is null
    public static void isNull(@Nullable final Object o, final String msg) {
        if (Objects.nonNull(o)) {
            throw getException(msg);
        }
    }


    // Not empty
    public static void notEmpty(final Collection<?> collection, final String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            throw getException(msg);
        }
    }

    //isEmpty
    public static void isEmpty(final Collection<?> collection, final String msg) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw getException(msg);
        }
    }

    // Not blank
    public static void notBlank(final CharSequence str, final String msg) {
        if (StringUtils.isBlank(str)) {
            throw getException(msg);
        }
    }

    private static EvilException getException(final String msg) {
        return new EvilException(msg);
    }

    //
    public static void isPositive(final int num, final String msg) {
        if (num <= 0) {
            throw new EvilException(msg);
        }
    }

}