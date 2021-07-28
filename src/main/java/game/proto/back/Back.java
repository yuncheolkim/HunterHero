// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

public final class Back {
  private Back() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_PlayerBackData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_PlayerBackData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_PlayerBackData_CompleteTaskEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_GameCount_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_GameCount_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_GameCountInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_GameCountInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_SaveData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_SaveData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_FishData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_FishData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nback.proto\022\007Message\032\ndata.proto\"\310\002\n\016Pl" +
      "ayerBackData\022\021\n\tfightTime\030\001 \001(\003\022\021\n\tfight" +
      "Area\030\002 \003(\005\022\030\n\020powerRecoverTime\030\003 \001(\003\022\021\n\t" +
      "loginTime\030\005 \001(\003\022\022\n\nupdateTime\030\006 \001(\003\022\017\n\007l" +
      "ocalId\030\n \001(\005\022!\n\005count\030\013 \001(\0132\022.Message.Ga" +
      "meCount\022%\n\tfightType\030\025 \001(\0162\022.Message.Fig" +
      "htType\022?\n\014completeTask\030d \003(\0132).Message.P" +
      "layerBackData.CompleteTaskEntry\0323\n\021Compl" +
      "eteTaskEntry\022\013\n\003key\030\001 \001(\005\022\r\n\005value\030\002 \001(\010" +
      ":\0028\001\"4\n\tGameCount\022\'\n\007express\030\001 \001(\0132\026.Mes" +
      "sage.GameCountInfo\"2\n\rGameCountInfo\022\r\n\005c" +
      "ount\030\001 \001(\r\022\022\n\nupdateTime\030\002 \001(\004\"V\n\010SaveDa" +
      "ta\022)\n\010backData\030\001 \001(\0132\027.Message.PlayerBac" +
      "kData\022\037\n\002pd\030\002 \001(\0132\023.Message.PlayerData\"\026" +
      "\n\010FishData\022\n\n\002id\030\001 \001(\005*%\n\tFightType\022\n\n\006F" +
      "_NONE\020\000\022\014\n\010F_BATTLE\020\001B\025\n\017game.proto.back" +
      "H\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          game.proto.data.Data.getDescriptor(),
        });
    internal_static_Message_PlayerBackData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_PlayerBackData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_PlayerBackData_descriptor,
        new java.lang.String[] { "FightTime", "FightArea", "PowerRecoverTime", "LoginTime", "UpdateTime", "LocalId", "Count", "FightType", "CompleteTask", });
    internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor =
      internal_static_Message_PlayerBackData_descriptor.getNestedTypes().get(0);
    internal_static_Message_PlayerBackData_CompleteTaskEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Message_GameCount_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Message_GameCount_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_GameCount_descriptor,
        new java.lang.String[] { "Express", });
    internal_static_Message_GameCountInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Message_GameCountInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_GameCountInfo_descriptor,
        new java.lang.String[] { "Count", "UpdateTime", });
    internal_static_Message_SaveData_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Message_SaveData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_SaveData_descriptor,
        new java.lang.String[] { "BackData", "Pd", });
    internal_static_Message_FishData_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Message_FishData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_FishData_descriptor,
        new java.lang.String[] { "Id", });
    game.proto.data.Data.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
