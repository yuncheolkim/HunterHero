// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

public interface LadderResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *  1:单挑
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
}
