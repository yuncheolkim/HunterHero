package game.manager;

import game.base.AbsLifecycle;
import game.module.fight.FightHandler;
import game.module.hero.HeroHandler;
import game.module.login.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.scene.SceneHandler;
import game.module.task.TaskHandler;
import game.msg.IInvoke;
import game.msg.Invoker;
import game.proto.*;
import game.proto.back.MsgNo;

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
        // player
        addHandler(new Invoker<>(MsgNo.player_create_name_VALUE, PlayerHandler::createName, PlayerCreateNameReq::parser));

        // task
        addHandler(new Invoker<>(MsgNo.task_accept_VALUE, TaskHandler::acceptTask, TaskReq::parser));
        addHandler(new Invoker<>(MsgNo.task_complete_VALUE, TaskHandler::completeTask, TaskReq::parser));

        // scene
        addHandler(new Invoker<>(MsgNo.scene_enter_VALUE, SceneHandler::enterScene, EnterSceneReq::parser));
        addHandler(new Invoker<>(MsgNo.scene_enter_fight_area_VALUE, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
        addHandler(new Invoker<>(MsgNo.scene_leave_fight_area_VALUE, SceneHandler::exitFightArea, ExitFightAreaReq::parser));

        // fight
        addHandler(new Invoker<>(MsgNo.fight_start_VALUE, FightHandler::fight, FightStartReq::parser));
        addHandler(new Invoker<>(MsgNo.fight_end_VALUE, FightHandler::endFight, Empty::parser));

        // hero
        addHandler(new Invoker<>(MsgNo.hero_update_lilian_VALUE, HeroHandler::lilian, HeroUpReq::parser));
        addHandler(new Invoker<>(MsgNo.hero_update_xiulian_VALUE, HeroHandler::xiulian, HeroUpReq::parser));

        // inner
        addHandler(new Invoker<>(10, PlayerHandler::tick, Empty::parser));
        addHandler(new Invoker<>(11, PlayerHandler::dataFlush, Empty::parser));
    }

    private void addHandler(Invoker<?> taskReqInvoker) {
        handlerMap.put(taskReqInvoker.getMsgNo(), taskReqInvoker);
    }

    public IInvoke getHandler(Integer msgNo) {
        return handlerMap.get(msgNo);
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
