// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightHmStartResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightHmStartRes)
    com.google.protobuf.MessageOrBuilder {

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
}
