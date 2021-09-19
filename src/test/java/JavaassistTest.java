import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.module.endless.EndlessHandler;
import game.module.event.IPlayerEventHandler;
import game.module.event.handler.BattleEndEvent;
import game.module.ladder.LadderHandler;
import game.msg.DefaultInvoke;
import game.msg.IHandler;
import game.msg.IPlayerHandler;
import game.player.Player;
import game.proto.Message;
import game.proto.back.LadderResult;
import game.utils.AssisUtils;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.junit.Test;

import java.lang.reflect.Method;

import static game.utils.AssisUtils.createHandler;

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
        Class<LadderHandler> ladderHandlerClass = LadderHandler.class;
        CtClass cc = pool.get(ladderHandlerClass.getName());

        CtMethod test1 = cc.getDeclaredMethod("test1");


        CtClass handlerClass = pool.makeClass("Handler");
        handlerClass.setInterfaces(new CtClass[]{
                pool.get(IHandler.class.getName())
        });
        //新增一个方法
        CtClass ctClass = pool.get(LadderResult.class.getName());
        CtMethod ctMethod = new CtMethod(pool.get(MessageLite.class.getName()), "handler", new CtClass[]{
                pool.get(Player.class.getName()),
                ctClass
        }, handlerClass);
        ctMethod.setModifiers(Modifier.PUBLIC);

        ctMethod.setBody("{" +
                "return " + ladderHandlerClass.getName() + ".test1($1,$2);" +
                "}");
        ctMethod.setBody(test1, null);
        handlerClass.addMethod(ctMethod);

        Parser parse = null;

        System.out.println(handlerClass.toString());
        if (test1.getParameterTypes().length > 1) {
            CtClass aClass = test1.getParameterTypes()[1];

            Method parser1 = ladderHandlerClass.getMethod("test1", Player.class, LadderResult.class).getParameterTypes()[1].getDeclaredMethod("parser");
            parse = (Parser) parser1.invoke(null);
        }


        DefaultInvoke defaultInvoke = new DefaultInvoke();
        IHandler handler = (IHandler) handlerClass.toClass().newInstance();
        handler.handler(null, LadderResult.newBuilder().build());
        defaultInvoke.setHandler(handler);
        defaultInvoke.setParser(parse);
        defaultInvoke.invoke(null, Message.newBuilder()
                .setBody(LadderResult.newBuilder().setType(111).build().toByteString()).build());
    }

    @Test
    public void test4() throws Exception {
        DefaultInvoke handlerClass = createHandler(LadderHandler.class, LadderHandler.class.getDeclaredMethod("test1", Player.class, LadderResult.class));
    }

    @Test
    public void test5() throws Exception {
        createHandler(LadderHandler.class, LadderHandler.class.getDeclaredMethod("ladderCancel", Player.class));
    }

    @Test
    public void test6() throws Exception {
        createHandler(LadderHandler.class, LadderHandler.class.getDeclaredMethod("match", Player.class));

    }


    @Test
    public void eventHandlerTest() throws Exception {
        IPlayerEventHandler endBattleEventHandler = AssisUtils.createEvent(EndlessHandler.class, EndlessHandler.class.getDeclaredMethod("endBattleEventHandler", Player.class, BattleEndEvent.class));
        endBattleEventHandler.handler(null, new BattleEndEvent());

    }

}
