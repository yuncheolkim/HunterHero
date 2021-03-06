// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

public interface LadderResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string userName = 1;</code>
   * @return The userName.
   */
  java.lang.String getUserName();
  /**
   * <code>string userName = 1;</code>
   * @return The bytes for userName.
   */
  com.google.protobuf.ByteString
      getUserNameBytes();

  /**
   * <pre>
   * 分数变化
   * </pre>
   *
   * <code>int32 score = 2;</code>
   * @return The score.
   */
  int getScore();

  /**
   * <pre>
   *  1:单挑,2:多人
   * </pre>
   *
   * <code>int32 type = 3;</code>
   * @return The type.
   */
  int getType();

  /**
   * <code>.Message.FightRecord record = 4;</code>
   * @return Whether the record field is set.
   */
  boolean hasRecord();
  /**
   * <code>.Message.FightRecord record = 4;</code>
   * @return The record.
   */
  game.proto.data.FightRecord getRecord();
  /**
   * <code>.Message.FightRecord record = 4;</code>
   */
  game.proto.data.FightRecordOrBuilder getRecordOrBuilder();

  /**
   * <pre>
   * 先出手用户
   * </pre>
   *
   * <code>int64 firstUid = 5;</code>
   * @return The firstUid.
   */
  long getFirstUid();

  /**
   * <code>.Message.LadderSinglePlayer p1 = 6;</code>
   * @return Whether the p1 field is set.
   */
  boolean hasP1();
  /**
   * <code>.Message.LadderSinglePlayer p1 = 6;</code>
   * @return The p1.
   */
  game.proto.data.LadderSinglePlayer getP1();
  /**
   * <code>.Message.LadderSinglePlayer p1 = 6;</code>
   */
  game.proto.data.LadderSinglePlayerOrBuilder getP1OrBuilder();

  /**
   * <code>.Message.LadderSinglePlayer p2 = 7;</code>
   * @return Whether the p2 field is set.
   */
  boolean hasP2();
  /**
   * <code>.Message.LadderSinglePlayer p2 = 7;</code>
   * @return The p2.
   */
  game.proto.data.LadderSinglePlayer getP2();
  /**
   * <code>.Message.LadderSinglePlayer p2 = 7;</code>
   */
  game.proto.data.LadderSinglePlayerOrBuilder getP2OrBuilder();
}
