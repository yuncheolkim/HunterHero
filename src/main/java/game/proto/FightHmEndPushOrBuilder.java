// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightHmEndPushOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightHmEndPush)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 是否胜利
   * </pre>
   *
   * <code>bool win = 4;</code>
   * @return The win.
   */
  boolean getWin();

  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  java.util.List<game.proto.data.Reward> 
      getRewardList();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  game.proto.data.Reward getReward(int index);
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  int getRewardCount();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  java.util.List<? extends game.proto.data.RewardOrBuilder> 
      getRewardOrBuilderList();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  game.proto.data.RewardOrBuilder getRewardOrBuilder(
      int index);
}
