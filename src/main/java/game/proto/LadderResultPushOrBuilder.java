// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface LadderResultPushOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderResultPush)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.FightRecord record = 1;</code>
   * @return Whether the record field is set.
   */
  boolean hasRecord();
  /**
   * <code>.Message.FightRecord record = 1;</code>
   * @return The record.
   */
  game.proto.data.FightRecord getRecord();
  /**
   * <code>.Message.FightRecord record = 1;</code>
   */
  game.proto.data.FightRecordOrBuilder getRecordOrBuilder();

  /**
   * <pre>
   * 最终分数
   * </pre>
   *
   * <code>int32 score = 2;</code>
   * @return The score.
   */
  int getScore();

  /**
   * <pre>
   * 增加分数
   * </pre>
   *
   * <code>int32 add = 3;</code>
   * @return The add.
   */
  int getAdd();

  /**
   * <code>.Message.LadderSingleReport report = 4;</code>
   * @return Whether the report field is set.
   */
  boolean hasReport();
  /**
   * <code>.Message.LadderSingleReport report = 4;</code>
   * @return The report.
   */
  game.proto.data.LadderSingleReport getReport();
  /**
   * <code>.Message.LadderSingleReport report = 4;</code>
   */
  game.proto.data.LadderSingleReportOrBuilder getReportOrBuilder();
}