package game.utils;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import game.anno.GameHandler;
import game.module.event.IEvent;
import game.module.event.IPlayerEventHandler;
import game.module.player.Player;
import game.msg.DefaultInvoke;
import game.msg.IHandler;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/8/30 21:59
 */
public class AssisUtils {


    public static DefaultInvoke createHandler(Class<?> cls, Method method) throws Exception {
        int number = method.getAnnotation(GameHandler.class).value().getNumber();
        ClassPool pool = ClassPool.getDefault();
        CtClass handlerClass = pool.makeClass("Handler_" + number);
        handlerClass.setInterfaces(new CtClass[]{
                pool.get(IHandler.class.getName())
        });
        Class<?>[] parameters = method.getParameterTypes();
        CtClass[] pa = new CtClass[parameters.length];
        List<String> paramStr = new ArrayList<>(parameters.length);
        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameter = parameters[i];
            pa[i] = pool.get(parameter.getName());
            paramStr.add("(" + parameter.getName() + ")$" + (i + 1));
        }

        boolean hasReturn = true;
        if (method.getReturnType().equals(Void.TYPE)) {
            hasReturn = false;
        }

        CtMethod ctMethod = new CtMethod(pool.get(MessageLite.class.getName()), "handler", new CtClass[]{
                pool.get(Player.class.getName()),
                pool.get(MessageLite.class.getName()),
        }, handlerClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        String callBody = cls.getName() + "." + method.getName() +
                "(" + paramStr.stream().collect(Collectors.joining(",")) + ");";

        if (hasReturn) {
            ctMethod.setBody("{" + "return " + callBody + "}");
        } else {
            ctMethod.setBody("{" + "" + callBody + " return null;}");
        }
        handlerClass.addMethod(ctMethod);


        Parser parse = null;

        if (parameters.length > 1) {
            Method parser1 = parameters[1].getDeclaredMethod("parser");
            parse = (Parser) parser1.invoke(null);
        }

        DefaultInvoke defaultInvoke = new DefaultInvoke();
        IHandler handler = (IHandler) handlerClass.toClass().newInstance();
        defaultInvoke.setHandler(handler);
        defaultInvoke.setParser(parse);
        defaultInvoke.setMsgNo(number);

        return defaultInvoke;
    }


    public static IPlayerEventHandler createEvent(Class<?> cls, Method method) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass handlerClass = pool.makeClass(cls.getName() + method.getName());

        Class<?>[] parameters = method.getParameterTypes();
        CtClass[] pa = new CtClass[parameters.length];
        handlerClass.setInterfaces(new CtClass[]{
                pool.get(IPlayerEventHandler.class.getName())
        });

        CtMethod ctMethod = new CtMethod(CtClass.voidType, "handler", new CtClass[]{
                pool.get(Player.class.getName()),
                pool.get(IEvent.class.getName()),
        }, handlerClass);
        ctMethod.setModifiers(Modifier.PUBLIC);

        List<String> paramStr = new ArrayList<>(parameters.length);
        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameter = parameters[i];
            pa[i] = pool.get(parameter.getName());
            paramStr.add("(" + parameter.getName() + ")$" + (i + 1));
        }


        String callBody = cls.getName() + "." + method.getName() +
                "(" + String.join(",", paramStr) + ");";
        ctMethod.setBody("{" + callBody + " }");
        handlerClass.addMethod(ctMethod);

        return (IPlayerEventHandler<? extends IEvent>) handlerClass.toClass().newInstance();
    }

}
