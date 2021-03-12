package game.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要持久化的数据
 *
 * @author Yunzhe.Jin
 * 2020/5/9 18:20
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface SaveData {

}
