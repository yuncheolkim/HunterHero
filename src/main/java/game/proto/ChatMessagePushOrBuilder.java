// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface ChatMessagePushOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.ChatMessagePush)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Message.ChatChannel channel = 1;</code>
   * @return The enum numeric value on the wire for channel.
   */
  int getChannelValue();
  /**
   * <code>.Message.ChatChannel channel = 1;</code>
   * @return The channel.
   */
  game.proto.ChatChannel getChannel();

  /**
   * <code>int64 fromUser = 2;</code>
   * @return The fromUser.
   */
  long getFromUser();

  /**
   * <code>int64 time = 3;</code>
   * @return The time.
   */
  long getTime();

  /**
   * <code>string content = 10;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <code>string content = 10;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();
}
