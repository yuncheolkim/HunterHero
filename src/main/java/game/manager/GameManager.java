package game.manager;

import com.google.protobuf.MessageLite;
import game.base.AbsLifecycle;
import game.module.login.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.scene.SceneHandler;
import game.module.task.TaskHandler;
import game.msg.IInvoke;
import game.msg.Invoker;
import game.proto.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yunzhe.Jin
 * 2021/2/20 14:28
 */
public class GameManager extends AbsLifecycle {

    private ConcurrentHashMap<Integer, IInvoke> handlerMap = new ConcurrentHashMap<>();

    private LoginHandler loginHandler = new LoginHandler();

    private int version = 1;

    public GameManager() {
        addHandler(new Invoker<>(3, PlayerHandler::createName, PlayerCreateNameReq::parser));
        addHandler(new Invoker<>(1001, TaskHandler::acceptTask, TaskReq::parser));
        addHandler(new Invoker<>(1002, TaskHandler::completeTask, TaskReq::parser));

        // scene
        addHandler(new Invoker<>(3001, SceneHandler::enterScene, EnterSceneReq::parser));
        addHandler(new Invoker<>(3002, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
        addHandler(new Invoker<>(3003, SceneHandler::exitFightArea, ExitFightAreaReq::parser));

        // inner
        addHandler(new Invoker<>(10, PlayerHandler::tick, Empty::parser));
        addHandler(new Invoker<>(11, PlayerHandler::dataFlush, Empty::parser));
    }

    private void addHandler(Invoker<?> taskReqInvoker) {
        handlerMap.put(taskReqInvoker.getMsgNo(), taskReqInvoker);
    }

    public IInvoke getHandler(Integer msgNo) {
        return  handlerMap.get(msgNo);
    }


    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    @Override
    public void start() {

        super.start();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
