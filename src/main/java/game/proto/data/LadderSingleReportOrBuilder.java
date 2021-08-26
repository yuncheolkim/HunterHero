// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface LadderSingleReportOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderSingleReport)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 winId = 1;</code>
   * @return The winId.
   */
  long getWinId();

  /**
   * <pre>
   * 先出手的玩家
   * </pre>
   *
   * <code>int64 first = 2;</code>
   * @return The first.
   */
  long getFirst();

  /**
   * <code>.Message.LadderSinglePlayer p1 = 5;</code>
   * @return Whether the p1 field is set.
   */
  boolean hasP1();
  /**
   * <code>.Message.LadderSinglePlayer p1 = 5;</code>
   * @return The p1.
   */
  game.proto.data.LadderSinglePlayer getP1();
  /**
   * <code>.Message.LadderSinglePlayer p1 = 5;</code>
   */
  game.proto.data.LadderSinglePlayerOrBuilder getP1OrBuilder();

  /**
   * <code>.Message.LadderSinglePlayer p2 = 6;</code>
   * @return Whether the p2 field is set.
   */
  boolean hasP2();
  /**
   * <code>.Message.LadderSinglePlayer p2 = 6;</code>
   * @return The p2.
   */
  game.proto.data.LadderSinglePlayer getP2();
  /**
   * <code>.Message.LadderSinglePlayer p2 = 6;</code>
   */
  game.proto.data.LadderSinglePlayerOrBuilder getP2OrBuilder();
}
