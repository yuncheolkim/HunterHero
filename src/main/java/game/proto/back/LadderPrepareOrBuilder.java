// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

public interface LadderPrepareOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderPrepare)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 matchId = 1;</code>
   * @return The matchId.
   */
  long getMatchId();

  /**
   * <code>bool auto = 2;</code>
   * @return The auto.
   */
  boolean getAuto();

  /**
   * <pre>
   * 1:单挑
   * </pre>
   *
   * <code>int32 type = 3;</code>
   * @return The type.
   */
  int getType();

  /**
   * <pre>
   * 1:先手 2:后手
   * </pre>
   *
   * <code>int32 order = 4;</code>
   * @return The order.
   */
  int getOrder();
}