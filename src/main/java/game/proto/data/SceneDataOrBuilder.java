// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface SceneDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.SceneData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>.Message.ScenePos pos = 2;</code>
   * @return Whether the pos field is set.
   */
  boolean hasPos();
  /**
   * <code>.Message.ScenePos pos = 2;</code>
   * @return The pos.
   */
  game.proto.data.ScenePos getPos();
  /**
   * <code>.Message.ScenePos pos = 2;</code>
   */
  game.proto.data.ScenePosOrBuilder getPosOrBuilder();
}
