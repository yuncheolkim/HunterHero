// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightTestReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightTestReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Message.FightHeroPos a = 1;</code>
   */
  java.util.List<game.proto.data.FightHeroPos> 
      getAList();
  /**
   * <code>repeated .Message.FightHeroPos a = 1;</code>
   */
  game.proto.data.FightHeroPos getA(int index);
  /**
   * <code>repeated .Message.FightHeroPos a = 1;</code>
   */
  int getACount();
  /**
   * <code>repeated .Message.FightHeroPos a = 1;</code>
   */
  java.util.List<? extends game.proto.data.FightHeroPosOrBuilder> 
      getAOrBuilderList();
  /**
   * <code>repeated .Message.FightHeroPos a = 1;</code>
   */
  game.proto.data.FightHeroPosOrBuilder getAOrBuilder(
      int index);

  /**
   * <code>repeated .Message.FightEnemyInfo b = 2;</code>
   */
  java.util.List<game.proto.data.FightEnemyInfo> 
      getBList();
  /**
   * <code>repeated .Message.FightEnemyInfo b = 2;</code>
   */
  game.proto.data.FightEnemyInfo getB(int index);
  /**
   * <code>repeated .Message.FightEnemyInfo b = 2;</code>
   */
  int getBCount();
  /**
   * <code>repeated .Message.FightEnemyInfo b = 2;</code>
   */
  java.util.List<? extends game.proto.data.FightEnemyInfoOrBuilder> 
      getBOrBuilderList();
  /**
   * <code>repeated .Message.FightEnemyInfo b = 2;</code>
   */
  game.proto.data.FightEnemyInfoOrBuilder getBOrBuilder(
      int index);
}
