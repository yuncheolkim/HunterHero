// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface FormationUpdateResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.FormationUpdateRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 formationId = 1;</code>
   * @return The formationId.
   */
  int getFormationId();

  /**
   * <code>repeated .Message.FormationPosUpdate data = 2;</code>
   */
  java.util.List<game.proto.data.FormationPosUpdate> 
      getDataList();
  /**
   * <code>repeated .Message.FormationPosUpdate data = 2;</code>
   */
  game.proto.data.FormationPosUpdate getData(int index);
  /**
   * <code>repeated .Message.FormationPosUpdate data = 2;</code>
   */
  int getDataCount();
  /**
   * <code>repeated .Message.FormationPosUpdate data = 2;</code>
   */
  java.util.List<? extends game.proto.data.FormationPosUpdateOrBuilder> 
      getDataOrBuilderList();
  /**
   * <code>repeated .Message.FormationPosUpdate data = 2;</code>
   */
  game.proto.data.FormationPosUpdateOrBuilder getDataOrBuilder(
      int index);
}