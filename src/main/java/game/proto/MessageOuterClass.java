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
      "\n\rmessage.proto\022\007Message\"d\n\007Message\022\n\n\002i" +
      "d\030\001 \001(\003\022\r\n\005msgNo\030\002 \001(\005\022\014\n\004body\030\003 \001(\014\022\021\n\t" +
      "serviceNo\030\004 \001(\005\022\r\n\005appNo\030\005 \001(\005\022\016\n\006idType" +
      "\030\006 \001(\005B\020\n\ngame.protoH\001P\001b\006proto3"
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
        new java.lang.String[] { "Id", "MsgNo", "Body", "ServiceNo", "AppNo", "IdType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
