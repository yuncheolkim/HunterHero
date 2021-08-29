import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.module.ladder.LadderHandler;
import game.msg.DefaultInvoke;
import game.msg.IHandler;
import game.msg.IPlayerHandler;
import game.player.Player;
import game.proto.Message;
import game.proto.back.LadderResult;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author Yunzhe.Jin
 * 2021/8/29 22:01
 */
public class JavaassistTest {


    @Test
    public void test1() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(PersonService.class.getName());
        cc.setName("good");
        cc.setInterfaces(new CtClass[]{
                pool.get(IPlayerHandler.class.getName())
        });


        //新增一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "handler", new CtClass[]{
                pool.get(Player.class.getName())
        }, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(\"i want to be your friend\");}");
        cc.addMethod(ctMethod);

        Object person = cc.toClass().newInstance();

        IPlayerHandler person1 = (IPlayerHandler) person;
        person1.handler(null);
        // 调用 personFly 方法
//        Method personFlyMethod = person.getClass().getMethod("personFly");
//        personFlyMethod.invoke(person);
//        //调用 joinFriend 方法
//        Method execute = person.getClass().getMethod("joinFriend");
//        execute.invoke(person);
    }

    @Test
    public void test2() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(LadderHandler.class.getName());

        CtMethod test1 = cc.getDeclaredMethod("test1");
        CtMethod test2 = cc.getDeclaredMethod("test2");


        CtClass newClass = pool.makeClass("Handler");
        newClass.setInterfaces(new CtClass[]{
                pool.get(IPlayerHandler.class.getName())
        });
        //新增一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "handler", new CtClass[]{
                pool.get(Player.class.getName())
        }, newClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
//        ctMethod.setBody("{System.out.println(\"i want to be your friend\");}");
        ctMethod.setBody(test1, null);
        newClass.addMethod(ctMethod);
        IPlayerHandler handler = (IPlayerHandler) newClass.toClass().newInstance();
        handler.handler(null);
    }

    @Test
    public void test3() throws Exception {
        Parser<LadderResult> p = LadderResult.parser();
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(LadderHandler.class.getName());

        CtMethod test1 = cc.getDeclaredMethod("test1");


        CtClass handlerClass = pool.makeClass("Handler");
        handlerClass.setInterfaces(new CtClass[]{
                pool.get(IHandler.class.getName())
        });
        //新增一个方法
        CtMethod ctMethod = new CtMethod(pool.get(MessageLite.class.getName()), "handler", new CtClass[]{
                pool.get(Player.class.getName()),
                pool.get(MessageLite.class.getName())
        }, handlerClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody(test1, null);
        handlerClass.addMethod(ctMethod);

        Parser parse = null;

        if (test1.getParameterTypes().length > 1) {
            CtClass aClass = test1.getParameterTypes()[1];
            Method parser1 = LadderHandler.class.getMethod("test1", Player.class, LadderResult.class).getParameterTypes()[1].getDeclaredMethod("parser");
            parse = (Parser) parser1.invoke(null);
        }


        DefaultInvoke defaultInvoke = new DefaultInvoke();
        defaultInvoke.setHandler((IHandler) handlerClass.toClass().newInstance());
        defaultInvoke.setParser(parse);
        defaultInvoke.invoke(null, Message.newBuilder()
                .setBody(LadderResult.newBuilder().setType(111).build().toByteString()).build());
    }
}
