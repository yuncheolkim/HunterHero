package game.manager;

import com.google.protobuf.MessageLite;
import game.base.AbsLifecycle;
import game.module.player.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.task.TaskHandler;
import game.msg.Invoker;
import game.proto.Empty;
import game.proto.PlayerCreateNameReq;
import game.proto.TaskReq;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:28
 */
public class GameManager extends AbsLifecycle {

    private ConcurrentHashMap<Integer, Invoker<? extends MessageLite>> handlerMap = new ConcurrentHashMap<>();

    private LoginHandler loginHandler = new LoginHandler();

    public GameManager() {
        addHandler(new Invoker<>(1001, TaskHandler::addTask, TaskReq::parser));
        addHandler(new Invoker<>(3, PlayerHandler::createName, PlayerCreateNameReq::parser));
        addHandler(new Invoker<>(4, PlayerHandler::tick, Empty::parser));
    }

    private void addHandler(Invoker<?> taskReqInvoker) {
        handlerMap.put(taskReqInvoker.getMsgNo(), taskReqInvoker);
    }

    public <T extends MessageLite> Invoker<T> getHandler(Integer msgNo) {
        return (Invoker<T>) handlerMap.get(msgNo);
    }


    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    @Override
    public void start() {


        super.start();
    }
}
