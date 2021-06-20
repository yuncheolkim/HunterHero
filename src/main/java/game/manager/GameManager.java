package game.manager;

import game.base.AbsLifecycle;
import game.base.G;
import game.module.bag.BagHandler;
import game.module.chat.ChatHandler;
import game.module.chat.ChatScene;
import game.module.cmd.CmdHandler;
import game.module.fight.FightHandler;
import game.module.fish.FishHandler;
import game.module.formation.FormationHandler;
import game.module.hero.DefaultHeroCalcProcess;
import game.module.hero.HeroHandler;
import game.module.login.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.scene.SceneHandler;
import game.module.shop.ShopHandler;
import game.module.task.TaskHandler;
import game.module.title.TitleHandler;
import game.msg.*;
import game.proto.*;
import game.proto.back.FishData;
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
        addHandler(new InvokerReturn<>(No.HeartbeatReq_VALUE, PlayerHandler::heartbeat, HeartbeatReq::parser));
        // player
        addHandler(new Invoker<>(No.PlayerCreateNameReq_VALUE, PlayerHandler::createName, PlayerCreateNameReq::parser));
        addHandler(new Invoker<>(No.PlayerMoveReq_VALUE, PlayerHandler::move, PlayerMoveReq::parser));
        addHandler(new InvokerNoParam(No.PlayerGoHotelReq_VALUE, PlayerHandler::hotel));
        addHandler(new RetInvoker<>(No.PlayerChooseHotelReq_VALUE, PlayerHandler::chooseHotel, PlayerChooseHotelReq::parser));
        // title
        addHandler(new RetInvoker<>(No.TitleChooseReq_VALUE, TitleHandler::TitleChooseReq, TitleChooseReq::parser));
        // Resource
        addHandler(new Invoker<>(No.RecoverPowerReq_VALUE, PlayerHandler::addPower, RecoverPowerReq::parser));
        // task
        addHandler(new Invoker<>(No.TaskAcceptReq_VALUE, TaskHandler::acceptTask, TaskReq::parser));
        addHandler(new Invoker<>(No.TaskCompleteReq_VALUE, TaskHandler::completeTask, TaskReq::parser));
        addHandler(new RetInvoker<>(No.TaskNpcReq_VALUE, TaskHandler::findNpcTask, TaskNpcReq::parser));

        // scene
        addHandler(new Invoker<>(No.EnterSceneReq_VALUE, SceneHandler::enterScene, EnterSceneReq::parser));
        addHandler(new Invoker<>(No.EnterFightAreaReq_VALUE, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
        addHandler(new Invoker<>(No.ExitFightAreaReq_VALUE, SceneHandler::exitFightArea, ExitFightAreaReq::parser));
        // fight
        addHandler(new Invoker<>(No.FightStartReq_VALUE, FightHandler::fight, FightStartReq::parser));
        addHandler(new InvokerNoParam(No.FightEndReq_VALUE, FightHandler::endFight));
        addHandler(new RetInvoker<>(No.FightTestReq_VALUE, FightHandler::fightExercise, FightTestReq::parser));
        // battle
        addHandler(new Invoker<>(No.BattleEnterReq_VALUE, FightHandler::battleEnter, BattleEnterReq::parser));
        // hero
        addHandler(new Invoker<>(No.HeroUpReq_VALUE, HeroHandler::powerUp, HeroUpReq::parser));
        addHandler(new RetInvoker<>(No.HeroTalentChangeReq_VALUE, HeroHandler::HeroTalentChangeReq, HeroTalentChangeReq::parser));
        // bag
        addHandler(new Invoker<>(No.BagCleanReq_VALUE, BagHandler::clean, BagCleanReq::parser));
        addHandler(new Invoker<>(No.ItemDiscardReq_VALUE, BagHandler::discardItem, ItemDiscardReq::parser));
        addHandler(new Invoker<>(No.ItemExchangeReq_VALUE, BagHandler::exchangeItem, ItemExchangeReq::parser));
        // 购买物品
        addHandler(new Invoker<>(No.ItemBuyReq_VALUE, ShopHandler::buyItem, ItemBuyReq::parser));
        // 出售物品
        addHandler(new Invoker<>(No.ItemSellReq_VALUE, ShopHandler::sellItem, ItemSellReq::parser));
        // 装备物品
        addHandler(new Invoker<>(No.HeroEquipmentReq_VALUE, HeroHandler::equip, HeroEquipmentReq::parser));
        // 阵型
        addHandler(new RetInvoker<>(No.FormationCreateReq_VALUE, FormationHandler::create, FormationCreateReq::parser));
        addHandler(new Invoker<>(No.FormationDeleteReq_VALUE, FormationHandler::delete, FormationDeleteReq::parser));
        addHandler(new RetInvoker<>(No.FormationUpdateReq_VALUE, FormationHandler::update, FormationUpdateReq::parser));
        addHandler(new RetInvoker<>(No.FormationSettingReq_VALUE, FormationHandler::setting, FormationSettingReq::parser));

        // 钓鱼
        addHandler(new Invoker<>(No.FishReq_VALUE, FishHandler::fish, FishReq::parser));
        addHandler(new Invoker<>(No.FishHookReq_VALUE, FishHandler::fishHook, FishHookReq::parser));
        addHandler(new Invoker<>(No.FishEnterAreaReq_VALUE, FishHandler::enterArea, FishEnterAreaReq::parser));
        addHandler(new Invoker<>(No.FishExitAreaReq_VALUE, FishHandler::exitArea, FishExitAreaReq::parser));
        // Chat
        addHandler(new Invoker<>(No.ChatMessageReq_VALUE, ChatHandler::chat, ChatMessageReq::parser));

    }

    private void initScene() {

        chatScene.setWork(G.W.getSceneWork());
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public DefaultHeroCalcProcess getHeroCalcProcess() {
        return heroCalcProcess;
    }

    public ChatScene getChatScene() {
        return chatScene;
    }
}
