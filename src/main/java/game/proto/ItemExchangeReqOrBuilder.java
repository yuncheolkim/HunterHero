// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface ItemExchangeReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.ItemExchangeReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 1: bank -&gt; bag, 2: bag -&gt; bank
   * </pre>
   *
   * <code>int32 type = 1;</code>
   * @return The type.
   */
  int getType();

  /**
   * <code>int32 slotId = 2;</code>
   * @return The slotId.
   */
  int getSlotId();

  /**
   * <code>int32 count = 3;</code>
   * @return The count.
   */
  int getCount();
}