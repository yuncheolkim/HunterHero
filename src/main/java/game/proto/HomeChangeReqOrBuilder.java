// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface HomeChangeReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.HomeChangeReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.HomePosData data = 5;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <code>.Message.HomePosData data = 5;</code>
   * @return The data.
   */
  game.proto.data.HomePosData getData();
  /**
   * <code>.Message.HomePosData data = 5;</code>
   */
  game.proto.data.HomePosDataOrBuilder getDataOrBuilder();

  /**
   * <code>repeated .Message.HomeRect rect = 6;</code>
   */
  java.util.List<game.proto.data.HomeRect> 
      getRectList();
  /**
   * <code>repeated .Message.HomeRect rect = 6;</code>
   */
  game.proto.data.HomeRect getRect(int index);
  /**
   * <code>repeated .Message.HomeRect rect = 6;</code>
   */
  int getRectCount();
  /**
   * <code>repeated .Message.HomeRect rect = 6;</code>
   */
  java.util.List<? extends game.proto.data.HomeRectOrBuilder> 
      getRectOrBuilderList();
  /**
   * <code>repeated .Message.HomeRect rect = 6;</code>
   */
  game.proto.data.HomeRectOrBuilder getRectOrBuilder(
      int index);
}