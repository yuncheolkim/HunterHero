package game.manager;

import game.base.AbsLifecycle;
import game.base.G;
import game.module.bag.BagHandler;
import game.module.chat.ChatHandler;
import game.module.chat.ChatScene;
import game.module.cmd.CmdHandler;
import game.module.dungeon.DungeonHandler;
import game.module.escort.ExpressHandler;
import game.module.fight.FightHandler;
import game.module.fight.FightScene;
import game.module.fish.FishHandler;
import game.module.formation.FormationHandler;
import game.module.hero.DefaultHeroCalcProcess;
import game.module.hero.HeroHandler;
import game.module.home.HomeHandler;
import game.module.ladder.match.LadderMatchGameScene;
import game.module.login.LoginHandler;
import game.module.player.PlayerHandler;
import game.module.scene.SceneHandler;
import game.module.shop.ShopHandler;
import game.module.task.TaskHandler;
import game.module.temple.TempleHandler;
import game.module.title.TitleHandler;
import game.msg.*;
import game.proto.*;
import game.proto.back.FishData;
import game.proto.back.LadderPrepare;
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
    private final LadderMatchGameScene ladderScene = new LadderMatchGameScene();
    private final FightScene fightScene = new FightScene();


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
        addHandler(new Invoker<>(MsgNoBackInner.B_LADDER_START_VALUE, PlayerHandler::prepareLadder, LadderPrepare::parser));

        // heart
        addHandler(new InvokerReturn<>(No.HeartbeatReq, PlayerHandler::heartbeat, HeartbeatReq::parser));
        // player
        addHandler(new Invoker<>(No.PlayerCreateNameReq, PlayerHandler::createName, PlayerCreateNameReq::parser));
        addHandler(new Invoker<>(No.PlayerMoveReq, PlayerHandler::move, PlayerMoveReq::parser));
        addHandler(new InvokerNoParam(No.PlayerGoHotelReq, PlayerHandler::hotel));
        addHandler(new RetInvoker<>(No.PlayerChooseHotelReq, PlayerHandler::chooseHotel, PlayerChooseHotelReq::parser));
        // title
        addHandler(new RetInvoker<>(No.TitleChooseReq, TitleHandler::TitleChooseReq, TitleChooseReq::parser));
        // Resource
        addHandler(new Invoker<>(No.RecoverPowerReq, PlayerHandler::addPower, RecoverPowerReq::parser));
        // task
        addHandler(new Invoker<>(No.TaskAcceptReq, TaskHandler::acceptTask, TaskReq::parser));
        addHandler(new Invoker<>(No.TaskCompleteReq, TaskHandler::completeTask, TaskReq::parser));
        addHandler(new RetInvoker<>(No.TaskNpcReq, TaskHandler::TaskNpcReq, TaskNpcReq::parser));
        addHandler(new RetInvoker<>(No.TaskAbandonReq, TaskHandler::TaskAbandonReq, TaskAbandonReq::parser));

        // scene
        addHandler(new Invoker<>(No.EnterSceneReq, SceneHandler::enterScene, EnterSceneReq::parser));
        addHandler(new Invoker<>(No.EnterFightAreaReq, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
        addHandler(new Invoker<>(No.ExitFightAreaReq, SceneHandler::exitFightArea, ExitFightAreaReq::parser));
        // fight
        addHandler(new Invoker<>(No.FightStartReq, FightHandler::fight, FightStartReq::parser));
        addHandler(new InvokerNoParam(No.FightEndReq, FightHandler::endFight));
        addHandler(new RetInvoker<>(No.FightTestReq, FightHandler::fightExercise, FightTestReq::parser));
        // fight hm
        addHandler(new Invoker<>(No.FightHmStartReq, FightHandler::manualFight, FightStartReq::parser));
        addHandler(new Invoker<>(No.FightHmActionReq, FightHandler::manualFightAction, FightHmActionReq::parser));
        // battle
        addHandler(new Invoker<>(No.BattleEnterReq, FightHandler::battleEnter, BattleEnterReq::parser));
        // hero
        addHandler(new Invoker<>(No.HeroUpReq, HeroHandler::powerUp, HeroUpReq::parser));
        addHandler(new RetInvoker<>(No.HeroTalentChangeReq, HeroHandler::HeroTalentChangeReq, HeroTalentChangeReq::parser));
        // bag
        addHandler(new Invoker<>(No.BagCleanReq, BagHandler::clean, BagCleanReq::parser));
        addHandler(new Invoker<>(No.ItemDiscardReq, BagHandler::discardItem, ItemDiscardReq::parser));
        addHandler(new Invoker<>(No.ItemExchangeReq, BagHandler::exchangeItem, ItemExchangeReq::parser));
        // 购买物品
        addHandler(new Invoker<>(No.ItemBuyReq, ShopHandler::buyItem, ItemBuyReq::parser));
        // 出售物品
        addHandler(new Invoker<>(No.ItemSellReq, ShopHandler::sellItem, ItemSellReq::parser));
        // 装备物品
        addHandler(new Invoker<>(No.HeroEquipmentReq, HeroHandler::equip, HeroEquipmentReq::parser));
        // 阵型
        addHandler(new RetInvoker<>(No.FormationCreateReq, FormationHandler::create, FormationCreateReq::parser));
        addHandler(new Invoker<>(No.FormationDeleteReq, FormationHandler::delete, FormationDeleteReq::parser));
        addHandler(new RetInvoker<>(No.FormationUpdateReq, FormationHandler::update, FormationUpdateReq::parser));
        addHandler(new RetInvoker<>(No.FormationSettingReq, FormationHandler::setting, FormationSettingReq::parser));

        // 钓鱼
        addHandler(new Invoker<>(No.FishReq, FishHandler::fish, FishReq::parser));
        addHandler(new Invoker<>(No.FishHookReq, FishHandler::fishHook, FishHookReq::parser));
        addHandler(new Invoker<>(No.FishEnterAreaReq, FishHandler::enterArea, FishEnterAreaReq::parser));
        addHandler(new Invoker<>(No.FishExitAreaReq, FishHandler::exitArea, FishExitAreaReq::parser));
        // Chat
        addHandler(new Invoker<>(No.ChatMessageReq, ChatHandler::chat, ChatMessageReq::parser));
        // Temple
        addHandler(new RetInvoker<>(No.TempleHeroBuyReq, TempleHandler::TempleHeroBuyReq, TempleHeroBuyReq::parser));
        // Dungeon
        addHandler(new RetInvoker<>(No.DungeonEnterReq, DungeonHandler::enter, DungeonEnterReq::parser));
        addHandler(new Invoker<>(No.DungeonFightReq, DungeonHandler::fight, DungeonFightReq::parser));
        addHandler(new RetInvoker<>(No.DungeonExitReq, DungeonHandler::exit, DungeonExitReq::parser));
        // Express
        addHandler(new InvokerNoParam(No.ExpressOpenReq, ExpressHandler::open));
        addHandler(new RetInvoker<>(No.ExpressStartRqRs, ExpressHandler::start, ExpressStartRqRs::parser));
        addHandler(new RetInvoker<>(No.ExpressCompleteReq, ExpressHandler::complete, ExpressCompleteReq::parser));
        // Home
        addHandler(new RetInvoker<>(No.HomeOpenAreaRqRs, HomeHandler::openArea, HomeOpenAreaRqRs::parser));
        addHandler(new Invoker<>(No.HomeChangeReq, HomeHandler::change, HomeChangeReq::parser));
        addHandler(new RetInvoker<>(No.HomeHarvestReq, HomeHandler::harvest, HomeHarvestReq::parser));
        addHandler(new Invoker<>(No.HomeCleanReq, HomeHandler::clean, HomeCleanReq::parser));
        addHandler(new InvokerNoParam(No.HomeUpgradeCookReq, HomeHandler::upgradeCook));
        addHandler(new Invoker<>(No.HomeProductReq, HomeHandler::product, HomeProductReq::parser));
        addHandler(new Invoker<>(No.HomeTaskCompleteReq, HomeHandler::taskComplete, HomeTaskCompleteReq::parser));

    }

    private void initScene() {
        chatScene.setWork(G.W.getSceneWork());
        ladderScene.setWork(G.W.getMatchWork());
        fightScene.setWork(G.W.getHeroCalcWork(fightScene.getId()));
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

    public LadderMatchGameScene getLadderScene() {
        return ladderScene;
    }

    public FightScene getFightScene() {
        return fightScene;
    }
}
