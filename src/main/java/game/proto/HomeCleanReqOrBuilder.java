// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface HomeCleanReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.HomeCleanReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.HomeType type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.Message.HomeType type = 1;</code>
   * @return The type.
   */
  game.proto.data.HomeType getType();

  /**
   * <code>int32 pos = 3;</code>
   * @return The pos.
   */
  int getPos();

  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  java.util.List<game.proto.data.HomeRect> 
      getRectList();
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  game.proto.data.HomeRect getRect(int index);
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  int getRectCount();
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  java.util.List<? extends game.proto.data.HomeRectOrBuilder> 
      getRectOrBuilderList();
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  game.proto.data.HomeRectOrBuilder getRectOrBuilder(
      int index);
}
