// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public final class MessageOuterClass {
  private MessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmessage.proto\022\007Message\"F\n\007Message\022\017\n\007v" +
      "ersion\030\001 \001(\005\022\r\n\005msgNo\030\002 \001(\005\022\r\n\005error\030\003 \001" +
      "(\005\022\014\n\004body\030\005 \001(\014B\020\n\ngame.protoH\001P\001b\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Message_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_Message_descriptor,
        new java.lang.String[] { "Version", "MsgNo", "Error", "Body", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
