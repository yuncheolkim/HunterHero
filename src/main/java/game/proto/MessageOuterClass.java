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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_Success_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_Success_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LoginReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LoginReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LoginRes_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LoginRes_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_KickPush_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_KickPush_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_PlayerCreateNameReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_PlayerCreateNameReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_TaskReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_TaskReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmessage.proto\022\007Message\"S\n\007Message\022\017\n\007v" +
      "ersion\030\001 \001(\005\022\r\n\005msgNo\030\002 \001(\005\022\r\n\005error\030\003 \001" +
      "(\005\022\013\n\003seq\030\004 \001(\005\022\014\n\004body\030\n \001(\014\"\007\n\005Empty\"\t" +
      "\n\007Success\"*\n\010LoginReq\022\020\n\010playerId\030\001 \001(\003\022" +
      "\014\n\004code\030\002 \001(\t\"9\n\010LoginRes\022\020\n\010playerId\030\001 " +
      "\001(\003\022\014\n\004name\030\002 \001(\t\022\r\n\005first\030\003 \001(\010\"\n\n\010Kick" +
      "Push\"#\n\023PlayerCreateNameReq\022\014\n\004name\030\001 \001(" +
      "\t\"\t\n\007TaskReqB\020\n\ngame.protoH\001P\001b\006proto3"
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
        new java.lang.String[] { "Version", "MsgNo", "Error", "Seq", "Body", });
    internal_static_Message_Empty_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Message_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_Message_Success_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Message_Success_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_Success_descriptor,
        new java.lang.String[] { });
    internal_static_Message_LoginReq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Message_LoginReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LoginReq_descriptor,
        new java.lang.String[] { "PlayerId", "Code", });
    internal_static_Message_LoginRes_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Message_LoginRes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LoginRes_descriptor,
        new java.lang.String[] { "PlayerId", "Name", "First", });
    internal_static_Message_KickPush_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Message_KickPush_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_KickPush_descriptor,
        new java.lang.String[] { });
    internal_static_Message_PlayerCreateNameReq_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Message_PlayerCreateNameReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_PlayerCreateNameReq_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_Message_TaskReq_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Message_TaskReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_TaskReq_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
