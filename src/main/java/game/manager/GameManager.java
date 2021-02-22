package game.manager;

import com.google.protobuf.MessageLite;
import game.base.AbsLifecycle;
import game.module.player.LoginHandler;
import game.module.task.TaskHandler;
import game.msg.Invoker;
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
    }

    private void addHandler(Invoker<TaskReq> taskReqInvoker) {
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
