// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface LoginResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LoginRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.PlayerData data = 1;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <code>.Message.PlayerData data = 1;</code>
   * @return The data.
   */
  game.proto.data.PlayerData getData();
  /**
   * <code>.Message.PlayerData data = 1;</code>
   */
  game.proto.data.PlayerDataOrBuilder getDataOrBuilder();

  /**
   * <code>bool first = 3;</code>
   * @return The first.
   */
  boolean getFirst();
}
