package game.manager;

import game.anno.GameHandler;
import game.base.AbsLifecycle;
import game.base.G;
import game.base.Logs;
import game.base.Work;
import game.module.chat.ChatScene;
import game.module.cmd.CmdHandler;
import game.module.fight.LadderFightScene;
import game.module.hero.DefaultHeroCalcProcess;
import game.module.ladder.match.LadderMatchScene;
import game.module.login.LoginHandler;
import game.msg.IInvoke;
import game.msg.Invoker;
import game.msg.InvokerNoParam;
import game.proto.CmdReq;
import game.utils.ClassUtils;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static game.utils.AssisUtils.createHandler;

/**
 * 游戏管理
 * 消息注册
 *
 * @author Yunzhe.Jin
 * 2021/2/20 14:28
 */
public class GameManager extends AbsLifecycle {

    private final ConcurrentHashMap<Integer, IInvoke> handlerMap = new ConcurrentHashMap<>();

    private final LoginHandler loginHandler = new LoginHandler();

    private final DefaultHeroCalcProcess heroCalcProcess = new DefaultHeroCalcProcess();

    public GameManager() {
    }

    private void addHandler(final IInvoke taskReqInvoker) {
        handlerMap.put(taskReqInvoker.getMsgNo(), taskReqInvoker);
    }

    public IInvoke getHandler(final Integer msgNo) {
        return handlerMap.get(msgNo);
    }


    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    // scene
    private final ChatScene chatScene = new ChatScene();

    /**
     * 单线程处理
     */
    private final LadderMatchScene ladderMatchScene = new LadderMatchScene(1);

    private final LadderMatchScene ladderMatch = new LadderMatchScene(2);

    private final LadderFightScene fightScene = new LadderFightScene();


    @Override
    public void start() {
        // 初始化 业务逻辑处理
        initHandler();
        initHandler1();
        // 初始化 场景
        initScene();
        super.start();
    }

    private void initHandler1() {

        try {
            Set<Class<?>> search = ClassUtils.search("game.module", null);

            search.stream()
                    .filter(classInfo -> classInfo.getPackageName().startsWith("game.module"))
                    .filter(classInfo -> classInfo.getName().endsWith("Handler")).forEach(classInfo -> {
                        for (Method m : classInfo.getDeclaredMethods()) {
                            if (m.isAnnotationPresent(GameHandler.class)) {
                                Logs.C.info("[Handler] ==========> {}:{}", classInfo.getName(), m.getName());

                                try {
                                    addHandler(createHandler(classInfo, m));
                                } catch (Exception e) {
                                    Logs.C.error(e, "解析失败:{},{}", classInfo.getName(), m.getName());
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void initHandler() {
        // 测试
        addHandler(new Invoker<>(-1, CmdHandler::cmd, CmdReq::parser));
        // relogin
        addHandler(new InvokerNoParam(-2, loginHandler::relogin));
    }

    private void initScene() {
        chatScene.setWork(G.W.getSceneWork());
        Work matchWork = G.W.getMatchWork();
        ladderMatchScene.setWork(matchWork);
        ladderMatch.setWork(matchWork);
        fightScene.setWork(G.W.getHeroCalcWork(fightScene.getId()));
    }

    public DefaultHeroCalcProcess getHeroCalcProcess() {
        return heroCalcProcess;
    }

    public ChatScene getChatScene() {
        return chatScene;
    }

    public LadderMatchScene getLadderMatchScene() {
        return ladderMatchScene;
    }

    public LadderMatchScene getLadderMultiMatch() {
        return ladderMatch;
    }

    public LadderFightScene getFightScene() {
        return fightScene;
    }
}
