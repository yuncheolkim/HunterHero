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

            search.stream().filter(classInfo -> {
                return classInfo.getPackageName().startsWith("game.module");
            }).filter(classInfo -> classInfo.getName().endsWith("Handler")).forEach(classInfo -> {

                Class<?> clazz = classInfo;
                for (Method m : clazz.getDeclaredMethods()) {
                    if (m.isAnnotationPresent(GameHandler.class)) {
                        Logs.C.info("[Handler] ==========> {}:{}", classInfo.getName(), m.getName());

                        try {
                            addHandler(createHandler(clazz, m));
                            if (m.getParameters().length == 1) {
                            } else {

                            }
                        } catch (Exception e) {
                            Logs.C.error(e, "解析失败:{},{}", clazz.getName(), m.getName());
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
        // inner
//        addHandler(new InvokerNoParam(No.B_TICK_VALUE, PlayerHandler::tick));
//        addHandler(new Invoker<>(No.B_DATA_PUSH_VALUE, PlayerHandler::dataFlush, Empty::parser));
//        addHandler(new Invoker<>(No.B_HERO_DATA_VALUE, HeroHandler::updateHero, PlayerHero::parser));
//        addHandler(new Invoker<>(No.B_FISH_HOOK_VALUE, FishHandler::fishHook, FishData::parser));
//        addHandler(new Invoker<>(No.B_FISH_HOOK_EXPIRE_VALUE, FishHandler::waitHook, FishData::parser));
//        addHandler(new Invoker<>(No.LadderPrepare, LadderHandler::prepareLadder, LadderPrepare::parser));
//        addHandler(new Invoker<>(No.LadderResult, LadderHandler::ladderResult, LadderResult::parser));
//        addHandler(new InvokerNoParam(No.LadderCancelin, LadderHandler::ladderCancel));
//        addHandler(new Invoker<>(No.LadderResult, LadderHandler::ladderResult, LadderResult.parser()));

        // heart
//        addHandler(new InvokerReturn<>(No.HeartbeatReq, PlayerHandler::heartbeat, HeartbeatReq::parser));
        // player
//        addHandler(new Invoker<>(No.PlayerCreateNameReq, PlayerHandler::createName, PlayerCreateNameReq::parser));
//        addHandler(new Invoker<>(No.PlayerMoveReq, PlayerHandler::move, PlayerMoveReq::parser));
//        addHandler(new InvokerNoParam(No.PlayerGoHotelReq, PlayerHandler::hotel));
//        addHandler(new RetInvoker<>(No.PlayerChooseHotelReq, PlayerHandler::chooseHotel, PlayerChooseHotelReq::parser));
        // title
//        addHandler(new RetInvoker<>(No.TitleChooseReq, TitleHandler::TitleChooseReq, TitleChooseReq::parser));
        // Resource
//        addHandler(new Invoker<>(No.RecoverPowerReq, PlayerHandler::addPower, RecoverPowerReq::parser));
        // task
//        addHandler(new Invoker<>(No.TaskAcceptReq, TaskHandler::acceptTask, TaskReq::parser));
//        addHandler(new Invoker<>(No.TaskCompleteReq, TaskHandler::completeTask, TaskReq::parser));
//        addHandler(new RetInvoker<>(No.TaskNpcReq, TaskHandler::TaskNpcReq, TaskNpcReq::parser));
//        addHandler(new RetInvoker<>(No.TaskAbandonReq, TaskHandler::TaskAbandonReq, TaskAbandonReq::parser));

        // scene
//        addHandler(new Invoker<>(No.EnterSceneReq, SceneHandler::enterScene, EnterSceneReq::parser));
//        addHandler(new Invoker<>(No.EnterFightAreaReq, SceneHandler::enterFightArea, EnterFightAreaReq::parser));
//        addHandler(new Invoker<>(No.ExitFightAreaReq, SceneHandler::exitFightArea, ExitFightAreaReq::parser));
        // fight
//        addHandler(new Invoker<>(No.FightStartReq, FightHandler::fight, FightStartReq::parser));
//        addHandler(new InvokerNoParam(No.FightEndReq, FightHandler::endFight));
//        addHandler(new RetInvoker<>(No.FightTestReq, FightHandler::fightExercise, FightTestReq::parser));
        // fight hm
//        addHandler(new Invoker<>(No.FightHmStartReq, FightHandler::manualFight, FightStartReq::parser));
//        addHandler(new Invoker<>(No.FightHmActionReq, FightHandler::manualFightAction, FightHmActionReq::parser));

        // Ladder

        // battle
//        addHandler(new Invoker<>(No.BattleEnterReq, FightHandler::battleEnter, BattleEnterReq::parser));
        // hero
//        addHandler(new Invoker<>(No.HeroUpReq, HeroHandler::powerUp, HeroUpReq::parser));
//        addHandler(new RetInvoker<>(No.HeroTalentChangeReq, HeroHandler::HeroTalentChangeReq, HeroTalentChangeReq::parser));
        // bag
//        addHandler(new Invoker<>(No.BagCleanReq, BagHandler::clean, BagCleanReq::parser));
//        addHandler(new Invoker<>(No.ItemDiscardReq, BagHandler::discardItem, ItemDiscardReq::parser));
//        addHandler(new Invoker<>(No.ItemExchangeReq, BagHandler::exchangeItem, ItemExchangeReq::parser));
        // 购买物品
//        addHandler(new Invoker<>(No.ItemBuyReq, ShopHandler::buyItem, ItemBuyReq::parser));
        // 出售物品
//        addHandler(new Invoker<>(No.ItemSellReq, ShopHandler::sellItem, ItemSellReq::parser));
        // 装备物品
//        addHandler(new Invoker<>(No.HeroEquipmentReq, HeroHandler::equip, HeroEquipmentReq::parser));
        // 阵型
//        addHandler(new RetInvoker<>(No.FormationCreateReq, FormationHandler::create, FormationCreateReq::parser));
//        addHandler(new Invoker<>(No.FormationDeleteReq, FormationHandler::delete, FormationDeleteReq::parser));
//        addHandler(new RetInvoker<>(No.FormationUpdateReq, FormationHandler::update, FormationUpdateReq::parser));
//        addHandler(new RetInvoker<>(No.FormationSettingReq, FormationHandler::setting, FormationSettingReq::parser));

        // 钓鱼
//        addHandler(new Invoker<>(No.FishReq, FishHandler::fish, FishReq::parser));
//        addHandler(new Invoker<>(No.FishHookReq, FishHandler::fishHook, FishHookReq::parser));
//        addHandler(new Invoker<>(No.FishEnterAreaReq, FishHandler::enterArea, FishEnterAreaReq::parser));
//        addHandler(new Invoker<>(No.FishExitAreaReq, FishHandler::exitArea, FishExitAreaReq::parser));
        // Chat
//        addHandler(new Invoker<>(No.ChatMessageReq, ChatHandler::chat, ChatMessageReq::parser));
        // Temple
//        addHandler(new RetInvoker<>(No.TempleHeroBuyReq, TempleHandler::TempleHeroBuyReq, TempleHeroBuyReq::parser));
        // Dungeon
//        addHandler(new RetInvoker<>(No.DungeonEnterReq, DungeonHandler::enter, DungeonEnterReq::parser));
//        addHandler(new Invoker<>(No.DungeonFightReq, DungeonHandler::fight, DungeonFightReq::parser));
//        addHandler(new RetInvoker<>(No.DungeonExitReq, DungeonHandler::exit, DungeonExitReq::parser));
        // Express
//        addHandler(new InvokerNoParam(No.ExpressOpenReq, ExpressHandler::open));
//        addHandler(new RetInvoker<>(No.ExpressStartRqRs, ExpressHandler::start, ExpressStartRqRs::parser));
//        addHandler(new RetInvoker<>(No.ExpressCompleteReq, ExpressHandler::complete, ExpressCompleteReq::parser));
        // Home
//        addHandler(new RetInvoker<>(No.HomeOpenAreaRqRs, HomeHandler::openArea, HomeOpenAreaRqRs::parser));
//        addHandler(new Invoker<>(No.HomeChangeReq, HomeHandler::change, HomeChangeReq::parser));
//        addHandler(new RetInvoker<>(No.HomeHarvestReq, HomeHandler::harvest, HomeHarvestReq::parser));
//        addHandler(new Invoker<>(No.HomeCleanReq, HomeHandler::clean, HomeCleanReq::parser));
//        addHandler(new InvokerNoParam(No.HomeUpgradeCookReq, HomeHandler::upgradeCook));
//        addHandler(new Invoker<>(No.HomeProductReq, HomeHandler::product, HomeProductReq::parser));
//        addHandler(new Invoker<>(No.HomeTaskCompleteReq, HomeHandler::taskComplete, HomeTaskCompleteReq::parser));

    }

    private void initScene() {
        chatScene.setWork(G.W.getSceneWork());
        Work matchWork = G.W.getMatchWork();
        ladderMatchScene.setWork(matchWork);
        ladderMatch.setWork(matchWork);
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
