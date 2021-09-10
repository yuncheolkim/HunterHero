// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: no.proto

package game.proto.no;

/**
 * Protobuf enum {@code MessageNo.No}
 */
public enum No
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NONE = 0;</code>
   */
  NONE(0),
  /**
   * <pre>
   * Login
   * </pre>
   *
   * <code>LoginReq = 1;</code>
   */
  LoginReq(1),
  /**
   * <pre>
   * Kick
   * </pre>
   *
   * <code>KickPush = 2;</code>
   */
  KickPush(2),
  /**
   * <code>PlayerCreateNameReq = 3;</code>
   */
  PlayerCreateNameReq(3),
  /**
   * <code>B_TICK = 10;</code>
   */
  B_TICK(10),
  /**
   * <code>B_DATA_PUSH = 11;</code>
   */
  B_DATA_PUSH(11),
  /**
   * <code>B_HERO_DATA = 12;</code>
   */
  B_HERO_DATA(12),
  /**
   * <code>B_FISH_HOOK = 13;</code>
   */
  B_FISH_HOOK(13),
  /**
   * <code>B_FISH_HOOK_EXPIRE = 14;</code>
   */
  B_FISH_HOOK_EXPIRE(14),
  /**
   * <code>B_LADDER_START = 15;</code>
   */
  B_LADDER_START(15),
  /**
   * <code>LadderResultInner = 16;</code>
   */
  LadderResultInner(16),
  /**
   * <code>LadderPrepareInner = 17;</code>
   */
  LadderPrepareInner(17),
  /**
   * <code>LadderCancelInner = 18;</code>
   */
  LadderCancelInner(18),
  /**
   * <pre>
   * Heartbeat
   * </pre>
   *
   * <code>HeartbeatReq = 101;</code>
   */
  HeartbeatReq(101),
  /**
   * <pre>
   * player
   * </pre>
   *
   * <code>PlayerMoveReq = 201;</code>
   */
  PlayerMoveReq(201),
  /**
   * <code>PlayerGoHotelReq = 202;</code>
   */
  PlayerGoHotelReq(202),
  /**
   * <code>PlayerChooseHotelReq = 203;</code>
   */
  PlayerChooseHotelReq(203),
  /**
   * <code>FeatureOpenPush = 204;</code>
   */
  FeatureOpenPush(204),
  /**
   * <pre>
   * 称谓 - title
   * </pre>
   *
   * <code>TitleChooseReq = 301;</code>
   */
  TitleChooseReq(301),
  /**
   * <code>TitleNewPush = 302;</code>
   */
  TitleNewPush(302),
  /**
   * <pre>
   * Task
   * </pre>
   *
   * <code>TaskAcceptReq = 1001;</code>
   */
  TaskAcceptReq(1001),
  /**
   * <code>TaskCompleteReq = 1002;</code>
   */
  TaskCompleteReq(1002),
  /**
   * <code>TaskNewPush = 1003;</code>
   */
  TaskNewPush(1003),
  /**
   * <code>TaskStatusChangePush = 1004;</code>
   */
  TaskStatusChangePush(1004),
  /**
   * <code>TaskNpcReq = 1005;</code>
   */
  TaskNpcReq(1005),
  /**
   * <code>TaskAbandonReq = 1006;</code>
   */
  TaskAbandonReq(1006),
  /**
   * <pre>
   * Home
   * </pre>
   *
   * <code>HomeOpenAreaRqRs = 1101;</code>
   */
  HomeOpenAreaRqRs(1101),
  /**
   * <code>HomeChangeReq = 1102;</code>
   */
  HomeChangeReq(1102),
  /**
   * <code>HomeHarvestReq = 1103;</code>
   */
  HomeHarvestReq(1103),
  /**
   * <code>HomeCleanReq = 1104;</code>
   */
  HomeCleanReq(1104),
  /**
   * <code>HomeLevelChange = 1105;</code>
   */
  HomeLevelChange(1105),
  /**
   * <code>HomeItemAddPush = 1106;</code>
   */
  HomeItemAddPush(1106),
  /**
   * <code>HomeUpgradeCookReq = 1107;</code>
   */
  HomeUpgradeCookReq(1107),
  /**
   * <code>HomeProductReq = 1108;</code>
   */
  HomeProductReq(1108),
  /**
   * <code>HomeTaskCompleteReq = 1109;</code>
   */
  HomeTaskCompleteReq(1109),
  /**
   * <code>HomeNewTaskDayPush = 1110;</code>
   */
  HomeNewTaskDayPush(1110),
  /**
   * <pre>
   * Fight
   * </pre>
   *
   * <code>FightStartReq = 2001;</code>
   */
  FightStartReq(2001),
  /**
   * <code>FightStartPush = 2002;</code>
   */
  FightStartPush(2002),
  /**
   * <code>FightEndReq = 2004;</code>
   */
  FightEndReq(2004),
  /**
   * <code>FightTestReq = 2005;</code>
   */
  FightTestReq(2005),
  /**
   * <code>FightHmStartReq = 2011;</code>
   */
  FightHmStartReq(2011),
  /**
   * <code>FightHmStartRes = 2012;</code>
   */
  FightHmStartRes(2012),
  /**
   * <code>FightHmActionReq = 2013;</code>
   */
  FightHmActionReq(2013),
  /**
   * <code>FightHmEndPush = 2014;</code>
   */
  FightHmEndPush(2014),
  /**
   * <pre>
   * Ladder
   * </pre>
   *
   * <code>LadderSetFormationReq = 2021;</code>
   */
  LadderSetFormationReq(2021),
  /**
   * <code>LadderCancelPush = 2022;</code>
   */
  LadderCancelPush(2022),
  /**
   * <code>LadderMatchReq = 2023;</code>
   */
  LadderMatchReq(2023),
  /**
   * <code>LadderResultPush = 2024;</code>
   */
  LadderResultPush(2024),
  /**
   * <code>LadderCancelReq = 2025;</code>
   */
  LadderCancelReq(2025),
  /**
   * <code>LadderFightEndReq = 2026;</code>
   */
  LadderFightEndReq(2026),
  /**
   * <code>LadderFightAutoEndInner = 2027;</code>
   */
  LadderFightAutoEndInner(2027),
  /**
   * <pre>
   * Battle
   * </pre>
   *
   * <code>BattleEnterReq = 2030;</code>
   */
  BattleEnterReq(2030),
  /**
   * <code>BattleEndPush = 2031;</code>
   */
  BattleEndPush(2031),
  /**
   * <pre>
   * Dungeon
   * </pre>
   *
   * <code>DungeonEnterReq = 2101;</code>
   */
  DungeonEnterReq(2101),
  /**
   * <code>DungeonFightReq = 2102;</code>
   */
  DungeonFightReq(2102),
  /**
   * <code>DungeonExitReq = 2103;</code>
   */
  DungeonExitReq(2103),
  /**
   * <pre>
   * Scene
   * </pre>
   *
   * <code>EnterSceneReq = 3001;</code>
   */
  EnterSceneReq(3001),
  /**
   * <code>EnterFightAreaReq = 3002;</code>
   */
  EnterFightAreaReq(3002),
  /**
   * <code>ExitFightAreaReq = 3003;</code>
   */
  ExitFightAreaReq(3003),
  /**
   * <pre>
   * Npc
   * </pre>
   *
   * <code>NpcShowChangePush = 3101;</code>
   */
  NpcShowChangePush(3101),
  /**
   * <pre>
   * Hero
   * </pre>
   *
   * <code>HeroUpReq = 4001;</code>
   */
  HeroUpReq(4001),
  /**
   * <code>HeroTalentChangeReq = 4002;</code>
   */
  HeroTalentChangeReq(4002),
  /**
   * <code>HeroChangePush = 4003;</code>
   */
  HeroChangePush(4003),
  /**
   * <code>HeroEquipmentReq = 4004;</code>
   */
  HeroEquipmentReq(4004),
  /**
   * <code>NewHeroPush = 4005;</code>
   */
  NewHeroPush(4005),
  /**
   * <pre>
   * Formation
   * </pre>
   *
   * <code>FormationCreateReq = 4101;</code>
   */
  FormationCreateReq(4101),
  /**
   * <code>FormationListReq = 4102;</code>
   */
  FormationListReq(4102),
  /**
   * <code>FormationUpdateReq = 4103;</code>
   */
  FormationUpdateReq(4103),
  /**
   * <code>FormationDeleteReq = 4104;</code>
   */
  FormationDeleteReq(4104),
  /**
   * <code>FormationSettingReq = 4105;</code>
   */
  FormationSettingReq(4105),
  /**
   * <pre>
   * Resource
   * </pre>
   *
   * <code>ResourceChangePush = 5001;</code>
   */
  ResourceChangePush(5001),
  /**
   * <code>PlayerLevelChangePush = 5002;</code>
   */
  PlayerLevelChangePush(5002),
  /**
   * <code>ExpChangePush = 5003;</code>
   */
  ExpChangePush(5003),
  /**
   * <code>MaxPowerChangePush = 5004;</code>
   */
  MaxPowerChangePush(5004),
  /**
   * <code>RecoverPowerReq = 5005;</code>
   */
  RecoverPowerReq(5005),
  /**
   * <pre>
   * Express
   * </pre>
   *
   * <code>ExpressStartRqRs = 5101;</code>
   */
  ExpressStartRqRs(5101),
  /**
   * <code>ExpressCompleteReq = 5102;</code>
   */
  ExpressCompleteReq(5102),
  /**
   * <code>ExpressOpenReq = 5103;</code>
   */
  ExpressOpenReq(5103),
  /**
   * <pre>
   * Bag
   * </pre>
   *
   * <code>BagInfoChangePush = 6001;</code>
   */
  BagInfoChangePush(6001),
  /**
   * <code>BagCleanReq = 6002;</code>
   */
  BagCleanReq(6002),
  /**
   * <pre>
   * Item
   * 丢弃物品
   * </pre>
   *
   * <code>ItemDiscardReq = 7001;</code>
   */
  ItemDiscardReq(7001),
  /**
   * <pre>
   * 购买物品
   * </pre>
   *
   * <code>ItemBuyReq = 7002;</code>
   */
  ItemBuyReq(7002),
  /**
   * <pre>
   * 银行背包,转移物品
   * </pre>
   *
   * <code>ItemExchangeReq = 7003;</code>
   */
  ItemExchangeReq(7003),
  /**
   * <pre>
   * 出售物品
   * </pre>
   *
   * <code>ItemSellReq = 7004;</code>
   */
  ItemSellReq(7004),
  /**
   * <pre>
   * Temple
   * </pre>
   *
   * <code>TempleHeroBuyReq = 7101;</code>
   */
  TempleHeroBuyReq(7101),
  /**
   * <pre>
   * fish
   * </pre>
   *
   * <code>FishReq = 8001;</code>
   */
  FishReq(8001),
  /**
   * <code>FishHookReq = 8002;</code>
   */
  FishHookReq(8002),
  /**
   * <code>FishEnterAreaReq = 8003;</code>
   */
  FishEnterAreaReq(8003),
  /**
   * <code>FishExitAreaReq = 8004;</code>
   */
  FishExitAreaReq(8004),
  /**
   * <code>FishHookPush = 8005;</code>
   */
  FishHookPush(8005),
  /**
   * <pre>
   * Chat
   * </pre>
   *
   * <code>ChatMessageReq = 9001;</code>
   */
  ChatMessageReq(9001),
  /**
   * <code>ChatMessagePush = 9002;</code>
   */
  ChatMessagePush(9002),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NONE = 0;</code>
   */
  public static final int NONE_VALUE = 0;
  /**
   * <pre>
   * Login
   * </pre>
   *
   * <code>LoginReq = 1;</code>
   */
  public static final int LoginReq_VALUE = 1;
  /**
   * <pre>
   * Kick
   * </pre>
   *
   * <code>KickPush = 2;</code>
   */
  public static final int KickPush_VALUE = 2;
  /**
   * <code>PlayerCreateNameReq = 3;</code>
   */
  public static final int PlayerCreateNameReq_VALUE = 3;
  /**
   * <code>B_TICK = 10;</code>
   */
  public static final int B_TICK_VALUE = 10;
  /**
   * <code>B_DATA_PUSH = 11;</code>
   */
  public static final int B_DATA_PUSH_VALUE = 11;
  /**
   * <code>B_HERO_DATA = 12;</code>
   */
  public static final int B_HERO_DATA_VALUE = 12;
  /**
   * <code>B_FISH_HOOK = 13;</code>
   */
  public static final int B_FISH_HOOK_VALUE = 13;
  /**
   * <code>B_FISH_HOOK_EXPIRE = 14;</code>
   */
  public static final int B_FISH_HOOK_EXPIRE_VALUE = 14;
  /**
   * <code>B_LADDER_START = 15;</code>
   */
  public static final int B_LADDER_START_VALUE = 15;
  /**
   * <code>LadderResultInner = 16;</code>
   */
  public static final int LadderResultInner_VALUE = 16;
  /**
   * <code>LadderPrepareInner = 17;</code>
   */
  public static final int LadderPrepareInner_VALUE = 17;
  /**
   * <code>LadderCancelInner = 18;</code>
   */
  public static final int LadderCancelInner_VALUE = 18;
  /**
   * <pre>
   * Heartbeat
   * </pre>
   *
   * <code>HeartbeatReq = 101;</code>
   */
  public static final int HeartbeatReq_VALUE = 101;
  /**
   * <pre>
   * player
   * </pre>
   *
   * <code>PlayerMoveReq = 201;</code>
   */
  public static final int PlayerMoveReq_VALUE = 201;
  /**
   * <code>PlayerGoHotelReq = 202;</code>
   */
  public static final int PlayerGoHotelReq_VALUE = 202;
  /**
   * <code>PlayerChooseHotelReq = 203;</code>
   */
  public static final int PlayerChooseHotelReq_VALUE = 203;
  /**
   * <code>FeatureOpenPush = 204;</code>
   */
  public static final int FeatureOpenPush_VALUE = 204;
  /**
   * <pre>
   * 称谓 - title
   * </pre>
   *
   * <code>TitleChooseReq = 301;</code>
   */
  public static final int TitleChooseReq_VALUE = 301;
  /**
   * <code>TitleNewPush = 302;</code>
   */
  public static final int TitleNewPush_VALUE = 302;
  /**
   * <pre>
   * Task
   * </pre>
   *
   * <code>TaskAcceptReq = 1001;</code>
   */
  public static final int TaskAcceptReq_VALUE = 1001;
  /**
   * <code>TaskCompleteReq = 1002;</code>
   */
  public static final int TaskCompleteReq_VALUE = 1002;
  /**
   * <code>TaskNewPush = 1003;</code>
   */
  public static final int TaskNewPush_VALUE = 1003;
  /**
   * <code>TaskStatusChangePush = 1004;</code>
   */
  public static final int TaskStatusChangePush_VALUE = 1004;
  /**
   * <code>TaskNpcReq = 1005;</code>
   */
  public static final int TaskNpcReq_VALUE = 1005;
  /**
   * <code>TaskAbandonReq = 1006;</code>
   */
  public static final int TaskAbandonReq_VALUE = 1006;
  /**
   * <pre>
   * Home
   * </pre>
   *
   * <code>HomeOpenAreaRqRs = 1101;</code>
   */
  public static final int HomeOpenAreaRqRs_VALUE = 1101;
  /**
   * <code>HomeChangeReq = 1102;</code>
   */
  public static final int HomeChangeReq_VALUE = 1102;
  /**
   * <code>HomeHarvestReq = 1103;</code>
   */
  public static final int HomeHarvestReq_VALUE = 1103;
  /**
   * <code>HomeCleanReq = 1104;</code>
   */
  public static final int HomeCleanReq_VALUE = 1104;
  /**
   * <code>HomeLevelChange = 1105;</code>
   */
  public static final int HomeLevelChange_VALUE = 1105;
  /**
   * <code>HomeItemAddPush = 1106;</code>
   */
  public static final int HomeItemAddPush_VALUE = 1106;
  /**
   * <code>HomeUpgradeCookReq = 1107;</code>
   */
  public static final int HomeUpgradeCookReq_VALUE = 1107;
  /**
   * <code>HomeProductReq = 1108;</code>
   */
  public static final int HomeProductReq_VALUE = 1108;
  /**
   * <code>HomeTaskCompleteReq = 1109;</code>
   */
  public static final int HomeTaskCompleteReq_VALUE = 1109;
  /**
   * <code>HomeNewTaskDayPush = 1110;</code>
   */
  public static final int HomeNewTaskDayPush_VALUE = 1110;
  /**
   * <pre>
   * Fight
   * </pre>
   *
   * <code>FightStartReq = 2001;</code>
   */
  public static final int FightStartReq_VALUE = 2001;
  /**
   * <code>FightStartPush = 2002;</code>
   */
  public static final int FightStartPush_VALUE = 2002;
  /**
   * <code>FightEndReq = 2004;</code>
   */
  public static final int FightEndReq_VALUE = 2004;
  /**
   * <code>FightTestReq = 2005;</code>
   */
  public static final int FightTestReq_VALUE = 2005;
  /**
   * <code>FightHmStartReq = 2011;</code>
   */
  public static final int FightHmStartReq_VALUE = 2011;
  /**
   * <code>FightHmStartRes = 2012;</code>
   */
  public static final int FightHmStartRes_VALUE = 2012;
  /**
   * <code>FightHmActionReq = 2013;</code>
   */
  public static final int FightHmActionReq_VALUE = 2013;
  /**
   * <code>FightHmEndPush = 2014;</code>
   */
  public static final int FightHmEndPush_VALUE = 2014;
  /**
   * <pre>
   * Ladder
   * </pre>
   *
   * <code>LadderSetFormationReq = 2021;</code>
   */
  public static final int LadderSetFormationReq_VALUE = 2021;
  /**
   * <code>LadderCancelPush = 2022;</code>
   */
  public static final int LadderCancelPush_VALUE = 2022;
  /**
   * <code>LadderMatchReq = 2023;</code>
   */
  public static final int LadderMatchReq_VALUE = 2023;
  /**
   * <code>LadderResultPush = 2024;</code>
   */
  public static final int LadderResultPush_VALUE = 2024;
  /**
   * <code>LadderCancelReq = 2025;</code>
   */
  public static final int LadderCancelReq_VALUE = 2025;
  /**
   * <code>LadderFightEndReq = 2026;</code>
   */
  public static final int LadderFightEndReq_VALUE = 2026;
  /**
   * <code>LadderFightAutoEndInner = 2027;</code>
   */
  public static final int LadderFightAutoEndInner_VALUE = 2027;
  /**
   * <pre>
   * Battle
   * </pre>
   *
   * <code>BattleEnterReq = 2030;</code>
   */
  public static final int BattleEnterReq_VALUE = 2030;
  /**
   * <code>BattleEndPush = 2031;</code>
   */
  public static final int BattleEndPush_VALUE = 2031;
  /**
   * <pre>
   * Dungeon
   * </pre>
   *
   * <code>DungeonEnterReq = 2101;</code>
   */
  public static final int DungeonEnterReq_VALUE = 2101;
  /**
   * <code>DungeonFightReq = 2102;</code>
   */
  public static final int DungeonFightReq_VALUE = 2102;
  /**
   * <code>DungeonExitReq = 2103;</code>
   */
  public static final int DungeonExitReq_VALUE = 2103;
  /**
   * <pre>
   * Scene
   * </pre>
   *
   * <code>EnterSceneReq = 3001;</code>
   */
  public static final int EnterSceneReq_VALUE = 3001;
  /**
   * <code>EnterFightAreaReq = 3002;</code>
   */
  public static final int EnterFightAreaReq_VALUE = 3002;
  /**
   * <code>ExitFightAreaReq = 3003;</code>
   */
  public static final int ExitFightAreaReq_VALUE = 3003;
  /**
   * <pre>
   * Npc
   * </pre>
   *
   * <code>NpcShowChangePush = 3101;</code>
   */
  public static final int NpcShowChangePush_VALUE = 3101;
  /**
   * <pre>
   * Hero
   * </pre>
   *
   * <code>HeroUpReq = 4001;</code>
   */
  public static final int HeroUpReq_VALUE = 4001;
  /**
   * <code>HeroTalentChangeReq = 4002;</code>
   */
  public static final int HeroTalentChangeReq_VALUE = 4002;
  /**
   * <code>HeroChangePush = 4003;</code>
   */
  public static final int HeroChangePush_VALUE = 4003;
  /**
   * <code>HeroEquipmentReq = 4004;</code>
   */
  public static final int HeroEquipmentReq_VALUE = 4004;
  /**
   * <code>NewHeroPush = 4005;</code>
   */
  public static final int NewHeroPush_VALUE = 4005;
  /**
   * <pre>
   * Formation
   * </pre>
   *
   * <code>FormationCreateReq = 4101;</code>
   */
  public static final int FormationCreateReq_VALUE = 4101;
  /**
   * <code>FormationListReq = 4102;</code>
   */
  public static final int FormationListReq_VALUE = 4102;
  /**
   * <code>FormationUpdateReq = 4103;</code>
   */
  public static final int FormationUpdateReq_VALUE = 4103;
  /**
   * <code>FormationDeleteReq = 4104;</code>
   */
  public static final int FormationDeleteReq_VALUE = 4104;
  /**
   * <code>FormationSettingReq = 4105;</code>
   */
  public static final int FormationSettingReq_VALUE = 4105;
  /**
   * <pre>
   * Resource
   * </pre>
   *
   * <code>ResourceChangePush = 5001;</code>
   */
  public static final int ResourceChangePush_VALUE = 5001;
  /**
   * <code>PlayerLevelChangePush = 5002;</code>
   */
  public static final int PlayerLevelChangePush_VALUE = 5002;
  /**
   * <code>ExpChangePush = 5003;</code>
   */
  public static final int ExpChangePush_VALUE = 5003;
  /**
   * <code>MaxPowerChangePush = 5004;</code>
   */
  public static final int MaxPowerChangePush_VALUE = 5004;
  /**
   * <code>RecoverPowerReq = 5005;</code>
   */
  public static final int RecoverPowerReq_VALUE = 5005;
  /**
   * <pre>
   * Express
   * </pre>
   *
   * <code>ExpressStartRqRs = 5101;</code>
   */
  public static final int ExpressStartRqRs_VALUE = 5101;
  /**
   * <code>ExpressCompleteReq = 5102;</code>
   */
  public static final int ExpressCompleteReq_VALUE = 5102;
  /**
   * <code>ExpressOpenReq = 5103;</code>
   */
  public static final int ExpressOpenReq_VALUE = 5103;
  /**
   * <pre>
   * Bag
   * </pre>
   *
   * <code>BagInfoChangePush = 6001;</code>
   */
  public static final int BagInfoChangePush_VALUE = 6001;
  /**
   * <code>BagCleanReq = 6002;</code>
   */
  public static final int BagCleanReq_VALUE = 6002;
  /**
   * <pre>
   * Item
   * 丢弃物品
   * </pre>
   *
   * <code>ItemDiscardReq = 7001;</code>
   */
  public static final int ItemDiscardReq_VALUE = 7001;
  /**
   * <pre>
   * 购买物品
   * </pre>
   *
   * <code>ItemBuyReq = 7002;</code>
   */
  public static final int ItemBuyReq_VALUE = 7002;
  /**
   * <pre>
   * 银行背包,转移物品
   * </pre>
   *
   * <code>ItemExchangeReq = 7003;</code>
   */
  public static final int ItemExchangeReq_VALUE = 7003;
  /**
   * <pre>
   * 出售物品
   * </pre>
   *
   * <code>ItemSellReq = 7004;</code>
   */
  public static final int ItemSellReq_VALUE = 7004;
  /**
   * <pre>
   * Temple
   * </pre>
   *
   * <code>TempleHeroBuyReq = 7101;</code>
   */
  public static final int TempleHeroBuyReq_VALUE = 7101;
  /**
   * <pre>
   * fish
   * </pre>
   *
   * <code>FishReq = 8001;</code>
   */
  public static final int FishReq_VALUE = 8001;
  /**
   * <code>FishHookReq = 8002;</code>
   */
  public static final int FishHookReq_VALUE = 8002;
  /**
   * <code>FishEnterAreaReq = 8003;</code>
   */
  public static final int FishEnterAreaReq_VALUE = 8003;
  /**
   * <code>FishExitAreaReq = 8004;</code>
   */
  public static final int FishExitAreaReq_VALUE = 8004;
  /**
   * <code>FishHookPush = 8005;</code>
   */
  public static final int FishHookPush_VALUE = 8005;
  /**
   * <pre>
   * Chat
   * </pre>
   *
   * <code>ChatMessageReq = 9001;</code>
   */
  public static final int ChatMessageReq_VALUE = 9001;
  /**
   * <code>ChatMessagePush = 9002;</code>
   */
  public static final int ChatMessagePush_VALUE = 9002;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static No valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static No forNumber(int value) {
    switch (value) {
      case 0: return NONE;
      case 1: return LoginReq;
      case 2: return KickPush;
      case 3: return PlayerCreateNameReq;
      case 10: return B_TICK;
      case 11: return B_DATA_PUSH;
      case 12: return B_HERO_DATA;
      case 13: return B_FISH_HOOK;
      case 14: return B_FISH_HOOK_EXPIRE;
      case 15: return B_LADDER_START;
      case 16: return LadderResultInner;
      case 17: return LadderPrepareInner;
      case 18: return LadderCancelInner;
      case 101: return HeartbeatReq;
      case 201: return PlayerMoveReq;
      case 202: return PlayerGoHotelReq;
      case 203: return PlayerChooseHotelReq;
      case 204: return FeatureOpenPush;
      case 301: return TitleChooseReq;
      case 302: return TitleNewPush;
      case 1001: return TaskAcceptReq;
      case 1002: return TaskCompleteReq;
      case 1003: return TaskNewPush;
      case 1004: return TaskStatusChangePush;
      case 1005: return TaskNpcReq;
      case 1006: return TaskAbandonReq;
      case 1101: return HomeOpenAreaRqRs;
      case 1102: return HomeChangeReq;
      case 1103: return HomeHarvestReq;
      case 1104: return HomeCleanReq;
      case 1105: return HomeLevelChange;
      case 1106: return HomeItemAddPush;
      case 1107: return HomeUpgradeCookReq;
      case 1108: return HomeProductReq;
      case 1109: return HomeTaskCompleteReq;
      case 1110: return HomeNewTaskDayPush;
      case 2001: return FightStartReq;
      case 2002: return FightStartPush;
      case 2004: return FightEndReq;
      case 2005: return FightTestReq;
      case 2011: return FightHmStartReq;
      case 2012: return FightHmStartRes;
      case 2013: return FightHmActionReq;
      case 2014: return FightHmEndPush;
      case 2021: return LadderSetFormationReq;
      case 2022: return LadderCancelPush;
      case 2023: return LadderMatchReq;
      case 2024: return LadderResultPush;
      case 2025: return LadderCancelReq;
      case 2026: return LadderFightEndReq;
      case 2027: return LadderFightAutoEndInner;
      case 2030: return BattleEnterReq;
      case 2031: return BattleEndPush;
      case 2101: return DungeonEnterReq;
      case 2102: return DungeonFightReq;
      case 2103: return DungeonExitReq;
      case 3001: return EnterSceneReq;
      case 3002: return EnterFightAreaReq;
      case 3003: return ExitFightAreaReq;
      case 3101: return NpcShowChangePush;
      case 4001: return HeroUpReq;
      case 4002: return HeroTalentChangeReq;
      case 4003: return HeroChangePush;
      case 4004: return HeroEquipmentReq;
      case 4005: return NewHeroPush;
      case 4101: return FormationCreateReq;
      case 4102: return FormationListReq;
      case 4103: return FormationUpdateReq;
      case 4104: return FormationDeleteReq;
      case 4105: return FormationSettingReq;
      case 5001: return ResourceChangePush;
      case 5002: return PlayerLevelChangePush;
      case 5003: return ExpChangePush;
      case 5004: return MaxPowerChangePush;
      case 5005: return RecoverPowerReq;
      case 5101: return ExpressStartRqRs;
      case 5102: return ExpressCompleteReq;
      case 5103: return ExpressOpenReq;
      case 6001: return BagInfoChangePush;
      case 6002: return BagCleanReq;
      case 7001: return ItemDiscardReq;
      case 7002: return ItemBuyReq;
      case 7003: return ItemExchangeReq;
      case 7004: return ItemSellReq;
      case 7101: return TempleHeroBuyReq;
      case 8001: return FishReq;
      case 8002: return FishHookReq;
      case 8003: return FishEnterAreaReq;
      case 8004: return FishExitAreaReq;
      case 8005: return FishHookPush;
      case 9001: return ChatMessageReq;
      case 9002: return ChatMessagePush;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<No>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      No> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<No>() {
          public No findValueByNumber(int number) {
            return No.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return game.proto.no.NoOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final No[] VALUES = values();

  public static No valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private No(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:MessageNo.No)
}

