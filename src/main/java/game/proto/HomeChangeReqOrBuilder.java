// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface HomeChangeReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.HomeChangeReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>.Message.HomeType type = 2;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.Message.HomeType type = 2;</code>
   * @return The type.
   */
  game.proto.data.HomeType getType();

  /**
   * <code>int32 pos = 3;</code>
   * @return The pos.
   */
  int getPos();
}
