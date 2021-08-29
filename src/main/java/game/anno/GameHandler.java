package game.anno;

import game.proto.no.No;

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
    No no();

    boolean inner() default false;

    /**
     * 消息体
     *
     * @return
     */
    Class<?> msg() default Void.class;

    String desc() default "";

    int gameId() default 0;

}
