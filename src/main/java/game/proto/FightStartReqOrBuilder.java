// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FightStartReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FightStartReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  java.util.List<game.proto.data.FightHeroPos> 
      getPosList();
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  game.proto.data.FightHeroPos getPos(int index);
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  int getPosCount();
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  java.util.List<? extends game.proto.data.FightHeroPosOrBuilder> 
      getPosOrBuilderList();
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  game.proto.data.FightHeroPosOrBuilder getPosOrBuilder(
      int index);
}