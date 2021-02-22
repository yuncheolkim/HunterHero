package game.anno;

import java.lang.annotation.*;

/**
 * @author Yunzhe.Jin
 * 2020/5/9 18:20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface GameHandler {

    /**
     * 消息编号
     *
     * @return
     */
    int no();

    /**
     * 消息体
     *
     * @return
     */
    Class<?> msg() default Void.class;

    String desc() default "";

    int gameId() default 0;

}
