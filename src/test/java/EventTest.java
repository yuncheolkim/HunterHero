import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.ExpAddEventHandler;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author Yunzhe.Jin
 * 2021/3/11 18:06
 */
public class EventTest {
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InstantiationException {

        IPlayerEventHandler<?> handler = new ExpAddEventHandler();
        for (Method declaredMethod : handler.getClass().getMethods()) {
            if (declaredMethod.getName().equals("handler") && !declaredMethod.isBridge()) {
                Class<?> idClazz = declaredMethod.getParameterTypes()[1];
                IEvent o = (IEvent) idClazz.newInstance();
                System.out.println(o.type());
            }
        }
    }

}
