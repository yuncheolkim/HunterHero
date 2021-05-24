// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface RewardOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.Reward)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.RewardType type = 100;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.Message.RewardType type = 100;</code>
   * @return The type.
   */
  game.proto.data.RewardType getType();

  /**
   * <code>int32 rewardId = 1;</code>
   * @return The rewardId.
   */
  int getRewardId();

  /**
   * <code>int32 count = 2;</code>
   * @return The count.
   */
  int getCount();

  /**
   * <pre>
   * 奖励英雄经验 0：玩家获得经验,大于0：英雄获得经验
   * </pre>
   *
   * <code>int32 heroId = 3;</code>
   * @return The heroId.
   */
  int getHeroId();

  /**
   * <pre>
   * 装备
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   * @return Whether the property field is set.
   */
  boolean hasProperty();
  /**
   * <pre>
   * 装备
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   * @return The property.
   */
  game.proto.data.Property getProperty();
  /**
   * <pre>
   * 装备
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   */
  game.proto.data.PropertyOrBuilder getPropertyOrBuilder();
}
