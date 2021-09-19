// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface PlayerDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.PlayerData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 pid = 1;</code>
   * @return The pid.
   */
  long getPid();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string account = 3;</code>
   * @return The account.
   */
  java.lang.String getAccount();
  /**
   * <code>string account = 3;</code>
   * @return The bytes for account.
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <pre>
   * 称谓
   * </pre>
   *
   * <code>string title = 4;</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <pre>
   * 称谓
   * </pre>
   *
   * <code>string title = 4;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>int32 level = 9;</code>
   * @return The level.
   */
  int getLevel();

  /**
   * <pre>
   * 回城 CD 恢复时间点,毫秒数
   * </pre>
   *
   * <code>int64 hotelCd = 10;</code>
   * @return The hotelCd.
   */
  long getHotelCd();

  /**
   * <pre>
   * 回城旅店位置id
   * </pre>
   *
   * <code>int32 hotelId = 11;</code>
   * @return The hotelId.
   */
  int getHotelId();

  /**
   * <pre>
   * 收集的称谓
   * </pre>
   *
   * <code>repeated int32 collectTitle = 13;</code>
   * @return A list containing the collectTitle.
   */
  java.util.List<java.lang.Integer> getCollectTitleList();
  /**
   * <pre>
   * 收集的称谓
   * </pre>
   *
   * <code>repeated int32 collectTitle = 13;</code>
   * @return The count of collectTitle.
   */
  int getCollectTitleCount();
  /**
   * <pre>
   * 收集的称谓
   * </pre>
   *
   * <code>repeated int32 collectTitle = 13;</code>
   * @param index The index of the element to return.
   * @return The collectTitle at the given index.
   */
  int getCollectTitle(int index);

  /**
   * <pre>
   * Fish
   * </pre>
   *
   * <code>int32 fishAreaId = 14;</code>
   * @return The fishAreaId.
   */
  int getFishAreaId();

  /**
   * <pre>
   * 钓鱼技能等级
   * </pre>
   *
   * <code>int32 skillFishLevel = 15;</code>
   * @return The skillFishLevel.
   */
  int getSkillFishLevel();

  /**
   * <pre>
   * 正在进行的战役
   * </pre>
   *
   * <code>int32 battleId = 16;</code>
   * @return The battleId.
   */
  int getBattleId();

  /**
   * <pre>
   * NpcShowEnum 显示与否npc
   * </pre>
   *
   * <code>int32 showNpc = 17;</code>
   * @return The showNpc.
   */
  int getShowNpc();

  /**
   * <pre>
   * vip等级
   * </pre>
   *
   * <code>int32 vipLevel = 18;</code>
   * @return The vipLevel.
   */
  int getVipLevel();

  /**
   * <pre>
   * vip经验
   * </pre>
   *
   * <code>int32 vipExp = 19;</code>
   * @return The vipExp.
   */
  int getVipExp();

  /**
   * <pre>
   * 功能开启标记
   * 1:银行
   * </pre>
   *
   * <code>int32 openFeature = 100;</code>
   * @return The openFeature.
   */
  int getOpenFeature();

  /**
   * <pre>
   * 任务信息
   * </pre>
   *
   * <code>.Message.PlayerTask task = 101;</code>
   * @return Whether the task field is set.
   */
  boolean hasTask();
  /**
   * <pre>
   * 任务信息
   * </pre>
   *
   * <code>.Message.PlayerTask task = 101;</code>
   * @return The task.
   */
  game.proto.data.PlayerTask getTask();
  /**
   * <pre>
   * 任务信息
   * </pre>
   *
   * <code>.Message.PlayerTask task = 101;</code>
   */
  game.proto.data.PlayerTaskOrBuilder getTaskOrBuilder();

  /**
   * <pre>
   * 所在场景
   * </pre>
   *
   * <code>.Message.SceneData sceneData = 201;</code>
   * @return Whether the sceneData field is set.
   */
  boolean hasSceneData();
  /**
   * <pre>
   * 所在场景
   * </pre>
   *
   * <code>.Message.SceneData sceneData = 201;</code>
   * @return The sceneData.
   */
  game.proto.data.SceneData getSceneData();
  /**
   * <pre>
   * 所在场景
   * </pre>
   *
   * <code>.Message.SceneData sceneData = 201;</code>
   */
  game.proto.data.SceneDataOrBuilder getSceneDataOrBuilder();

  /**
   * <pre>
   * 资源信息
   * </pre>
   *
   * <code>.Message.Resource resource = 301;</code>
   * @return Whether the resource field is set.
   */
  boolean hasResource();
  /**
   * <pre>
   * 资源信息
   * </pre>
   *
   * <code>.Message.Resource resource = 301;</code>
   * @return The resource.
   */
  game.proto.data.Resource getResource();
  /**
   * <pre>
   * 资源信息
   * </pre>
   *
   * <code>.Message.Resource resource = 301;</code>
   */
  game.proto.data.ResourceOrBuilder getResourceOrBuilder();

  /**
   * <pre>
   * 当前跑镖信息
   * </pre>
   *
   * <code>.Message.ExpressInfo expressInfo = 310;</code>
   * @return Whether the expressInfo field is set.
   */
  boolean hasExpressInfo();
  /**
   * <pre>
   * 当前跑镖信息
   * </pre>
   *
   * <code>.Message.ExpressInfo expressInfo = 310;</code>
   * @return The expressInfo.
   */
  game.proto.data.ExpressInfo getExpressInfo();
  /**
   * <pre>
   * 当前跑镖信息
   * </pre>
   *
   * <code>.Message.ExpressInfo expressInfo = 310;</code>
   */
  game.proto.data.ExpressInfoOrBuilder getExpressInfoOrBuilder();

  /**
   * <pre>
   * 跑镖列表
   * </pre>
   *
   * <code>repeated int32 expressId = 311;</code>
   * @return A list containing the expressId.
   */
  java.util.List<java.lang.Integer> getExpressIdList();
  /**
   * <pre>
   * 跑镖列表
   * </pre>
   *
   * <code>repeated int32 expressId = 311;</code>
   * @return The count of expressId.
   */
  int getExpressIdCount();
  /**
   * <pre>
   * 跑镖列表
   * </pre>
   *
   * <code>repeated int32 expressId = 311;</code>
   * @param index The index of the element to return.
   * @return The expressId at the given index.
   */
  int getExpressId(int index);

  /**
   * <pre>
   * 英雄信息
   * </pre>
   *
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */
  int getHeroCount();
  /**
   * <pre>
   * 英雄信息
   * </pre>
   *
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */
  boolean containsHero(
      int key);
  /**
   * Use {@link #getHeroMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.PlayerHero>
  getHero();
  /**
   * <pre>
   * 英雄信息
   * </pre>
   *
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.PlayerHero>
  getHeroMap();
  /**
   * <pre>
   * 英雄信息
   * </pre>
   *
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */

  game.proto.data.PlayerHero getHeroOrDefault(
      int key,
      game.proto.data.PlayerHero defaultValue);
  /**
   * <pre>
   * 英雄信息
   * </pre>
   *
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */

  game.proto.data.PlayerHero getHeroOrThrow(
      int key);

  /**
   * <pre>
   * 战斗中的信息
   * </pre>
   *
   * <code>repeated .Message.FightEnemyInfo fightInfo = 501;</code>
   */
  java.util.List<game.proto.data.FightEnemyInfo> 
      getFightInfoList();
  /**
   * <pre>
   * 战斗中的信息
   * </pre>
   *
   * <code>repeated .Message.FightEnemyInfo fightInfo = 501;</code>
   */
  game.proto.data.FightEnemyInfo getFightInfo(int index);
  /**
   * <pre>
   * 战斗中的信息
   * </pre>
   *
   * <code>repeated .Message.FightEnemyInfo fightInfo = 501;</code>
   */
  int getFightInfoCount();
  /**
   * <pre>
   * 战斗中的信息
   * </pre>
   *
   * <code>repeated .Message.FightEnemyInfo fightInfo = 501;</code>
   */
  java.util.List<? extends game.proto.data.FightEnemyInfoOrBuilder> 
      getFightInfoOrBuilderList();
  /**
   * <pre>
   * 战斗中的信息
   * </pre>
   *
   * <code>repeated .Message.FightEnemyInfo fightInfo = 501;</code>
   */
  game.proto.data.FightEnemyInfoOrBuilder getFightInfoOrBuilder(
      int index);

  /**
   * <pre>
   * 战斗是否手动
   * </pre>
   *
   * <code>bool manual = 502;</code>
   * @return The manual.
   */
  boolean getManual();

  /**
   * <pre>
   * 不同FightType下, 英雄的剩余血量
   * </pre>
   *
   * <code>map&lt;int32, .Message.FightHeroHpData&gt; heroHpInfo = 503;</code>
   */
  int getHeroHpInfoCount();
  /**
   * <pre>
   * 不同FightType下, 英雄的剩余血量
   * </pre>
   *
   * <code>map&lt;int32, .Message.FightHeroHpData&gt; heroHpInfo = 503;</code>
   */
  boolean containsHeroHpInfo(
      int key);
  /**
   * Use {@link #getHeroHpInfoMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.FightHeroHpData>
  getHeroHpInfo();
  /**
   * <pre>
   * 不同FightType下, 英雄的剩余血量
   * </pre>
   *
   * <code>map&lt;int32, .Message.FightHeroHpData&gt; heroHpInfo = 503;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.FightHeroHpData>
  getHeroHpInfoMap();
  /**
   * <pre>
   * 不同FightType下, 英雄的剩余血量
   * </pre>
   *
   * <code>map&lt;int32, .Message.FightHeroHpData&gt; heroHpInfo = 503;</code>
   */

  game.proto.data.FightHeroHpData getHeroHpInfoOrDefault(
      int key,
      game.proto.data.FightHeroHpData defaultValue);
  /**
   * <pre>
   * 不同FightType下, 英雄的剩余血量
   * </pre>
   *
   * <code>map&lt;int32, .Message.FightHeroHpData&gt; heroHpInfo = 503;</code>
   */

  game.proto.data.FightHeroHpData getHeroHpInfoOrThrow(
      int key);

  /**
   * <code>.Message.FightType fightType = 504;</code>
   * @return The enum numeric value on the wire for fightType.
   */
  int getFightTypeValue();
  /**
   * <code>.Message.FightType fightType = 504;</code>
   * @return The fightType.
   */
  game.proto.data.FightType getFightType();

  /**
   * <pre>
   * 地下城
   * </pre>
   *
   * <code>.Message.Dungeon dungeon = 510;</code>
   * @return Whether the dungeon field is set.
   */
  boolean hasDungeon();
  /**
   * <pre>
   * 地下城
   * </pre>
   *
   * <code>.Message.Dungeon dungeon = 510;</code>
   * @return The dungeon.
   */
  game.proto.data.Dungeon getDungeon();
  /**
   * <pre>
   * 地下城
   * </pre>
   *
   * <code>.Message.Dungeon dungeon = 510;</code>
   */
  game.proto.data.DungeonOrBuilder getDungeonOrBuilder();

  /**
   * <pre>
   * 排位信息
   * </pre>
   *
   * <code>.Message.LadderInfo ladderSingleInfo = 520;</code>
   * @return Whether the ladderSingleInfo field is set.
   */
  boolean hasLadderSingleInfo();
  /**
   * <pre>
   * 排位信息
   * </pre>
   *
   * <code>.Message.LadderInfo ladderSingleInfo = 520;</code>
   * @return The ladderSingleInfo.
   */
  game.proto.data.LadderInfo getLadderSingleInfo();
  /**
   * <pre>
   * 排位信息
   * </pre>
   *
   * <code>.Message.LadderInfo ladderSingleInfo = 520;</code>
   */
  game.proto.data.LadderInfoOrBuilder getLadderSingleInfoOrBuilder();

  /**
   * <pre>
   * 排位满英雄
   * </pre>
   *
   * <code>.Message.LadderInfo ladderMultiInfo = 521;</code>
   * @return Whether the ladderMultiInfo field is set.
   */
  boolean hasLadderMultiInfo();
  /**
   * <pre>
   * 排位满英雄
   * </pre>
   *
   * <code>.Message.LadderInfo ladderMultiInfo = 521;</code>
   * @return The ladderMultiInfo.
   */
  game.proto.data.LadderInfo getLadderMultiInfo();
  /**
   * <pre>
   * 排位满英雄
   * </pre>
   *
   * <code>.Message.LadderInfo ladderMultiInfo = 521;</code>
   */
  game.proto.data.LadderInfoOrBuilder getLadderMultiInfoOrBuilder();

  /**
   * <pre>
   * 是否正在查找对手
   * </pre>
   *
   * <code>bool inMatch = 522;</code>
   * @return The inMatch.
   */
  boolean getInMatch();

  /**
   * <pre>
   * 排位id
   * </pre>
   *
   * <code>int64 matchId = 523;</code>
   * @return The matchId.
   */
  long getMatchId();

  /**
   * <pre>
   * 排位类型
   * </pre>
   *
   * <code>int32 matchType = 524;</code>
   * @return The matchType.
   */
  int getMatchType();

  /**
   * <pre>
   * 无尽模式当前层数
   * </pre>
   *
   * <code>int32 endlessLayer = 530;</code>
   * @return The endlessLayer.
   */
  int getEndlessLayer();

  /**
   * <pre>
   * 背包
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bag = 601;</code>
   */
  int getBagCount();
  /**
   * <pre>
   * 背包
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bag = 601;</code>
   */
  boolean containsBag(
      int key);
  /**
   * Use {@link #getBagMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.BagSlot>
  getBag();
  /**
   * <pre>
   * 背包
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bag = 601;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.BagSlot>
  getBagMap();
  /**
   * <pre>
   * 背包
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bag = 601;</code>
   */

  game.proto.data.BagSlot getBagOrDefault(
      int key,
      game.proto.data.BagSlot defaultValue);
  /**
   * <pre>
   * 背包
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bag = 601;</code>
   */

  game.proto.data.BagSlot getBagOrThrow(
      int key);

  /**
   * <pre>
   * 背包容量
   * </pre>
   *
   * <code>int32 bagCapacity = 602;</code>
   * @return The bagCapacity.
   */
  int getBagCapacity();

  /**
   * <pre>
   * 银行容量
   * </pre>
   *
   * <code>int32 bankCapacity = 603;</code>
   * @return The bankCapacity.
   */
  int getBankCapacity();

  /**
   * <pre>
   * 银行
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bank = 604;</code>
   */
  int getBankCount();
  /**
   * <pre>
   * 银行
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bank = 604;</code>
   */
  boolean containsBank(
      int key);
  /**
   * Use {@link #getBankMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.BagSlot>
  getBank();
  /**
   * <pre>
   * 银行
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bank = 604;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.BagSlot>
  getBankMap();
  /**
   * <pre>
   * 银行
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bank = 604;</code>
   */

  game.proto.data.BagSlot getBankOrDefault(
      int key,
      game.proto.data.BagSlot defaultValue);
  /**
   * <pre>
   * 银行
   * </pre>
   *
   * <code>map&lt;int32, .Message.BagSlot&gt; bank = 604;</code>
   */

  game.proto.data.BagSlot getBankOrThrow(
      int key);

  /**
   * <pre>
   * 阵型
   * </pre>
   *
   * <code>repeated .Message.Formation formation = 701;</code>
   */
  java.util.List<game.proto.data.Formation> 
      getFormationList();
  /**
   * <pre>
   * 阵型
   * </pre>
   *
   * <code>repeated .Message.Formation formation = 701;</code>
   */
  game.proto.data.Formation getFormation(int index);
  /**
   * <pre>
   * 阵型
   * </pre>
   *
   * <code>repeated .Message.Formation formation = 701;</code>
   */
  int getFormationCount();
  /**
   * <pre>
   * 阵型
   * </pre>
   *
   * <code>repeated .Message.Formation formation = 701;</code>
   */
  java.util.List<? extends game.proto.data.FormationOrBuilder> 
      getFormationOrBuilderList();
  /**
   * <pre>
   * 阵型
   * </pre>
   *
   * <code>repeated .Message.Formation formation = 701;</code>
   */
  game.proto.data.FormationOrBuilder getFormationOrBuilder(
      int index);

  /**
   * <pre>
   * 默认阵型id
   * </pre>
   *
   * <code>int32 defaultFormationIndex = 702;</code>
   * @return The defaultFormationIndex.
   */
  int getDefaultFormationIndex();

  /**
   * <pre>
   * 竞技场防守阵型id
   * </pre>
   *
   * <code>int32 arenaFormationIndex = 703;</code>
   * @return The arenaFormationIndex.
   */
  int getArenaFormationIndex();

  /**
   * <pre>
   * 阵型map
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; formationIndex = 704;</code>
   */
  int getFormationIndexCount();
  /**
   * <pre>
   * 阵型map
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; formationIndex = 704;</code>
   */
  boolean containsFormationIndex(
      int key);
  /**
   * Use {@link #getFormationIndexMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getFormationIndex();
  /**
   * <pre>
   * 阵型map
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; formationIndex = 704;</code>
   */
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getFormationIndexMap();
  /**
   * <pre>
   * 阵型map
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; formationIndex = 704;</code>
   */

  int getFormationIndexOrDefault(
      int key,
      int defaultValue);
  /**
   * <pre>
   * 阵型map
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; formationIndex = 704;</code>
   */

  int getFormationIndexOrThrow(
      int key);

  /**
   * <pre>
   * 家园
   * </pre>
   *
   * <code>.Message.HomeData homeData = 801;</code>
   * @return Whether the homeData field is set.
   */
  boolean hasHomeData();
  /**
   * <pre>
   * 家园
   * </pre>
   *
   * <code>.Message.HomeData homeData = 801;</code>
   * @return The homeData.
   */
  game.proto.data.HomeData getHomeData();
  /**
   * <pre>
   * 家园
   * </pre>
   *
   * <code>.Message.HomeData homeData = 801;</code>
   */
  game.proto.data.HomeDataOrBuilder getHomeDataOrBuilder();
}
