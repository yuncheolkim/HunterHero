package game.manager;

import game.base.AbsLifecycle;
import game.base.G;
import game.game.scene.GameScene;
import game.module.bag.BagHandler;
import game.module.cmd.CmdHandler;
import game.module.fight.FightHandler;
import game.module.fish.FishHandler;
import game.module.formation.FormationHandler;
import game.module.hero.DefaultHeroCalcProcess;
import game.module.hero.HeroHandler;
import game.module.login.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.scene.ChatScene;
import game.module.scene.SceneHandler;
import game.module.shop.ShopHandler;
import game.module.task.TaskHandler;
import game.msg.*;
import game.proto.*;
import game.proto.back.FishData;
import game.proto.back.MsgNo;
import game.proto.back.MsgNoBackInner;
import game.proto.data.PlayerHero;
import game.proto.no.No;

import java.util.concurrent.ConcurrentHashMap;

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

    private int version = 1;

    private final DefaultHeroCalcProcess heroCalcProcess = new DefaultHeroCalcProcess();

    public GameManager() {
    }

    private void addHandler(IInvoke taskReqInvoker) {
        handlerMap.put(taskReqInvoker.getMsgNo(), taskReqInvoker);
    }

    public IInvoke getHandler(Integer msgNo) {
        return handlerMap.get(msgNo);
    }


    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    // scene
    private GameScene chatScene = new ChatScene();

    @Override
    public void start() {
        // 初始化 业务逻辑处理
        initHandler();

        // 初始化 场景
        initScene();
        super.start();
    }

    private void initHandler() {
        // 测试
        addHandler(new Invoker<>(-1, CmdHandler::cmd, CmdReq::parser));
        // relogin
        addHandler(new InvokerNoParam(-2, loginHandler::relogin));
        // inner
        addHandler(new InvokerNoParam(MsgNoBackInner.B_TICK_VALUE, PlayerHandler::tick));
        addHandler(new Invoker<>(MsgNoBackInner.B_DATA_PUSH_VALUE, PlayerHandler::dataFlush, Empty::parser));
        addHandler(new Invoker<>(MsgNoBackInner.B_HERO_DATA_VALUE, HeroHandler::updateHero, PlayerHero::parser));
        addHandler(new Invoker<>(MsgNoBackInner.B_FISH_HOOK_VALUE, FishHandler::fishHook, FishData::parser));
        addHandler(new Invoker<>(MsgNoBackInner.B_FISH_HOOK_EXPIRE_VALUE, FishHandler::waitHook, FishData::parser));

        // heart
        addHandler(new InvokerReturn<>(MsgNo.heartbeat_VALUE, PlayerHandler::heartbeat, HeartbeatReq::parser));
        // player
        addHandler(new Invoker<>(MsgNo.player_create_name_VALUE, PlayerHandler::createName, PlayerCreateNameReq::parser));
        addHandler(new Invoker<>(No.PlayerMoveReq_VALUE, PlayerHandler::move, PlayerMoveReq::parser));
        // task
        addHandler(new Invoker<>(MsgNo.task_accept_VALUE, TaskHandler::acceptTask, TaskReq::parser));
        addHandler(new Invoker<>(MsgNo.task_complete_VALUE, TaskHandler::completeTask, TaskReq::parser));
        addHandler(new RetInvoker<>(MsgNo.TaskNpcReqNo_VALUE, TaskHandler::findNpcTask, TaskNpcReq::parser));

        // scene
        addHandler(new Invoker<>(MsgNo.scene_enter_VALUE, SceneHandler::enterScene, EnterSceneReq::parser));
        addHandler(new Invoker<>(MsgNo.scene_enter_fight_area_VALUE, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
        addHandler(new Invoker<>(MsgNo.scene_leave_fight_area_VALUE, SceneHandler::exitFightArea, ExitFightAreaReq::parser));
        // fight
        addHandler(new Invoker<>(No.FightStartReq_VALUE, FightHandler::fight, FightStartReq::parser));
        addHandler(new Invoker<>(No.FightEndReq_VALUE, FightHandler::endFight, Empty::parser));
        addHandler(new RetInvoker<>(MsgNo.FightTestReqNo_VALUE, FightHandler::fightExercise, FightTestReq::parser));
        // hero
        addHandler(new Invoker<>(MsgNo.hero_update_lilian_VALUE, HeroHandler::lilian, HeroUpReq::parser));
        addHandler(new Invoker<>(MsgNo.hero_update_xiulian_VALUE, HeroHandler::xiulian, HeroUpReq::parser));
        // bag
        addHandler(new Invoker<>(MsgNo.BagCleanReqNo_VALUE, BagHandler::clean, BagCleanReq::parser));
        addHandler(new Invoker<>(MsgNo.ItemDiscardReqNo_VALUE, BagHandler::discardItem, ItemDiscardReq::parser));
        addHandler(new Invoker<>(MsgNo.ItemExchangeReqNo_VALUE, BagHandler::exchangeItem, ItemExchangeReq::parser));
        // 购买物品
        addHandler(new Invoker<>(MsgNo.ItemBuyReqNo_VALUE, ShopHandler::buyItem, ItemBuyReq::parser));
        // 出售物品
        addHandler(new Invoker<>(MsgNo.ItemSellReqNo_VALUE, ShopHandler::sellItem, ItemSellReq::parser));
        // 装备物品
        addHandler(new Invoker<>(MsgNo.HeroEquipmentReqNo_VALUE, HeroHandler::equip, HeroEquipmentReq::parser));
        // 阵型
        addHandler(new RetInvoker<>(MsgNo.FormationCreateReqNo_VALUE, FormationHandler::create, FormationCreateReq::parser));
        addHandler(new Invoker<>(MsgNo.FormationDeleteReqNo_VALUE, FormationHandler::delete, FormationDeleteReq::parser));
        addHandler(new RetInvoker<>(MsgNo.FormationUpdateReqNo_VALUE, FormationHandler::update, FormationUpdateReq::parser));
        addHandler(new RetInvoker<>(MsgNo.FormationSettingReqNo_VALUE, FormationHandler::setting, FormationSettingReq::parser));

        // 钓鱼
        addHandler(new Invoker<>(No.FishReq_VALUE, FishHandler::fish, FishReq::parser));
        addHandler(new Invoker<>(No.FishHookReq_VALUE, FishHandler::fishHook, FishHookReq::parser));

    }

    private void initScene() {

        chatScene.setWork(G.W.getSceneWork());

    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public DefaultHeroCalcProcess getHeroCalcProcess() {
        return heroCalcProcess;
    }

    public GameScene getChatScene() {
        return chatScene;
    }
}
