package game.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要从持久化数据加工的字段
 * 需要在保存,加载的时候进行加工
 *
 * @author Yunzhe.Jin
 * 2020/5/9 18:20
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface ProcessPersistenceData {

}
