// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightStartPushOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightStartPush)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  java.util.List<game.proto.data.FightEnemyInfo> 
      getInfoList();
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  game.proto.data.FightEnemyInfo getInfo(int index);
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  int getInfoCount();
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  java.util.List<? extends game.proto.data.FightEnemyInfoOrBuilder> 
      getInfoOrBuilderList();
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  game.proto.data.FightEnemyInfoOrBuilder getInfoOrBuilder(
      int index);
}