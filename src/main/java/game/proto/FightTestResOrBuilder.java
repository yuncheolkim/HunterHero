// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightTestResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightTestRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool win = 1;</code>
   * @return The win.
   */
  boolean getWin();

  /**
   * <code>.Message.FightRecord record = 4;</code>
   * @return Whether the record field is set.
   */
  boolean hasRecord();
  /**
   * <code>.Message.FightRecord record = 4;</code>
   * @return The record.
   */
  game.proto.FightRecord getRecord();
  /**
   * <code>.Message.FightRecord record = 4;</code>
   */
  game.proto.FightRecordOrBuilder getRecordOrBuilder();
}
