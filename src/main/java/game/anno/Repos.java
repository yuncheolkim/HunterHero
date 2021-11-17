package game.anno;

/**
 * @author Yunzhe.Jin
 * 2021/11/17 11:00
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Repos {

    String config();

}
