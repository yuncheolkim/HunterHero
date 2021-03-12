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
   * <code>int64 lastLoginTime = 4;</code>
   * @return The lastLoginTime.
   */
  long getLastLoginTime();

  /**
   * <code>int64 updateTime = 5;</code>
   * @return The updateTime.
   */
  long getUpdateTime();

  /**
   * <code>int32 level = 9;</code>
   * @return The level.
   */
  int getLevel();

  /**
   * <code>.Message.PlayerTask task = 101;</code>
   * @return Whether the task field is set.
   */
  boolean hasTask();
  /**
   * <code>.Message.PlayerTask task = 101;</code>
   * @return The task.
   */
  game.proto.data.PlayerTask getTask();
  /**
   * <code>.Message.PlayerTask task = 101;</code>
   */
  game.proto.data.PlayerTaskOrBuilder getTaskOrBuilder();

  /**
   * <code>.Message.SceneData sceneData = 201;</code>
   * @return Whether the sceneData field is set.
   */
  boolean hasSceneData();
  /**
   * <code>.Message.SceneData sceneData = 201;</code>
   * @return The sceneData.
   */
  game.proto.data.SceneData getSceneData();
  /**
   * <code>.Message.SceneData sceneData = 201;</code>
   */
  game.proto.data.SceneDataOrBuilder getSceneDataOrBuilder();

  /**
   * <code>.Message.Resource resource = 301;</code>
   * @return Whether the resource field is set.
   */
  boolean hasResource();
  /**
   * <code>.Message.Resource resource = 301;</code>
   * @return The resource.
   */
  game.proto.data.Resource getResource();
  /**
   * <code>.Message.Resource resource = 301;</code>
   */
  game.proto.data.ResourceOrBuilder getResourceOrBuilder();

  /**
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */
  int getHeroCount();
  /**
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
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.PlayerHero>
  getHeroMap();
  /**
   * <code>map&lt;int32, .Message.PlayerHero&gt; hero = 401;</code>
   */

  game.proto.data.PlayerHero getHeroOrDefault(
      int key,
      game.proto.data.PlayerHero defaultValue);
  /**
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
}
