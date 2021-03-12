// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

public interface PlayerBackDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.PlayerBackData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 fightTime = 1;</code>
   * @return The fightTime.
   */
  long getFightTime();

  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @return A list containing the fightArea.
   */
  java.util.List<java.lang.Integer> getFightAreaList();
  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @return The count of fightArea.
   */
  int getFightAreaCount();
  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @param index The index of the element to return.
   * @return The fightArea at the given index.
   */
  int getFightArea(int index);

  /**
   * <code>int64 powerRecoverTime = 3;</code>
   * @return The powerRecoverTime.
   */
  long getPowerRecoverTime();

  /**
   * <code>int64 createTime = 4;</code>
   * @return The createTime.
   */
  long getCreateTime();

  /**
   * <code>int64 loginTime = 5;</code>
   * @return The loginTime.
   */
  long getLoginTime();

  /**
   * <code>int64 updateTime = 6;</code>
   * @return The updateTime.
   */
  long getUpdateTime();
}
