// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface HomeHarvestResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.HomeHarvestRes)
    com.google.protobuf.MessageOrBuilder {

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
