// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface FightRecordOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightRecord)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Message.RoundRecord round = 1;</code>
   */
  java.util.List<game.proto.data.RoundRecord> 
      getRoundList();
  /**
   * <code>repeated .Message.RoundRecord round = 1;</code>
   */
  game.proto.data.RoundRecord getRound(int index);
  /**
   * <code>repeated .Message.RoundRecord round = 1;</code>
   */
  int getRoundCount();
  /**
   * <code>repeated .Message.RoundRecord round = 1;</code>
   */
  java.util.List<? extends game.proto.data.RoundRecordOrBuilder> 
      getRoundOrBuilderList();
  /**
   * <code>repeated .Message.RoundRecord round = 1;</code>
   */
  game.proto.data.RoundRecordOrBuilder getRoundOrBuilder(
      int index);

  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  java.util.List<game.proto.data.HeroDataRecord> 
      getSideAList();
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  game.proto.data.HeroDataRecord getSideA(int index);
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  int getSideACount();
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
      getSideAOrBuilderList();
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  game.proto.data.HeroDataRecordOrBuilder getSideAOrBuilder(
      int index);

  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  java.util.List<game.proto.data.HeroDataRecord> 
      getSideBList();
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  game.proto.data.HeroDataRecord getSideB(int index);
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  int getSideBCount();
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
      getSideBOrBuilderList();
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  game.proto.data.HeroDataRecordOrBuilder getSideBOrBuilder(
      int index);

  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>bool win = 4;</code>
   * @return The win.
   */
  boolean getWin();

  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  java.util.List<game.proto.data.Reward> 
      getRewardList();
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  game.proto.data.Reward getReward(int index);
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  int getRewardCount();
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  java.util.List<? extends game.proto.data.RewardOrBuilder> 
      getRewardOrBuilderList();
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  game.proto.data.RewardOrBuilder getRewardOrBuilder(
      int index);

  /**
   * <code>int64 winUid = 6;</code>
   * @return The winUid.
   */
  long getWinUid();

  /**
   * <code>.Message.FightType type = 7;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.Message.FightType type = 7;</code>
   * @return The type.
   */
  game.proto.data.FightType getType();
}
