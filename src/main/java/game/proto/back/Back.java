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
    internal_static_Message_LadderData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LadderData_fieldAccessorTable;
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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_VipData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_VipData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LadderPrepare_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LadderPrepare_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LadderResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LadderResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LadderCancelInner_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LadderCancelInner_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_LadderFightAutoEndInner_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_LadderFightAutoEndInner_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nback.proto\022\007Message\032\ndata.proto\"\361\002\n\016Pl" +
      "ayerBackData\022\021\n\tfightTime\030\001 \001(\003\022\021\n\tfight" +
      "Area\030\002 \003(\005\022\030\n\020powerRecoverTime\030\003 \001(\003\022\021\n\t" +
      "loginTime\030\005 \001(\003\022\022\n\nupdateTime\030\006 \001(\003\022\'\n\nl" +
      "adderData\030\007 \001(\0132\023.Message.LadderData\022\017\n\007" +
      "localId\030\n \001(\005\022!\n\005count\030\013 \001(\0132\022.Message.G" +
      "ameCount\022%\n\tfightType\030\025 \001(\0162\022.Message.Fi" +
      "ghtType\022?\n\014completeTask\030d \003(\0132).Message." +
      "PlayerBackData.CompleteTaskEntry\0323\n\021Comp" +
      "leteTaskEntry\022\013\n\003key\030\001 \001(\005\022\r\n\005value\030\002 \001(" +
      "\010:\0028\001\"A\n\nLadderData\022\031\n\021ladderSingleScore" +
      "\030\007 \001(\005\022\030\n\020ladderMultiScore\030\010 \001(\005\"b\n\tGame" +
      "Count\022\'\n\007express\030\001 \001(\0132\026.Message.GameCou" +
      "ntInfo\022,\n\014expressCount\030\002 \001(\0132\026.Message.G" +
      "ameCountInfo\"2\n\rGameCountInfo\022\r\n\005count\030\001" +
      " \001(\r\022\022\n\nupdateTime\030\002 \001(\004\"V\n\010SaveData\022)\n\010" +
      "backData\030\001 \001(\0132\027.Message.PlayerBackData\022" +
      "\037\n\002pd\030\002 \001(\0132\023.Message.PlayerData\"\026\n\010Fish" +
      "Data\022\n\n\002id\030\001 \001(\005\"\t\n\007VipData\"K\n\rLadderPre" +
      "pare\022\017\n\007matchId\030\001 \001(\003\022\014\n\004auto\030\002 \001(\010\022\014\n\004t" +
      "ype\030\003 \001(\005\022\r\n\005order\030\004 \001(\005\"\307\001\n\014LadderResul" +
      "t\022\020\n\010userName\030\001 \001(\t\022\r\n\005score\030\002 \001(\005\022\014\n\004ty" +
      "pe\030\003 \001(\005\022$\n\006record\030\004 \001(\0132\024.Message.Fight" +
      "Record\022\020\n\010firstUid\030\005 \001(\003\022\'\n\002p1\030\006 \001(\0132\033.M" +
      "essage.LadderSinglePlayer\022\'\n\002p2\030\007 \001(\0132\033." +
      "Message.LadderSinglePlayer\"\037\n\021LadderCanc" +
      "elInner\022\n\n\002id\030\001 \001(\003\"*\n\027LadderFightAutoEn" +
      "dInner\022\017\n\007matchId\030\001 \001(\003B\025\n\017game.proto.ba" +
      "ckH\001P\001b\006proto3"
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
        new java.lang.String[] { "FightTime", "FightArea", "PowerRecoverTime", "LoginTime", "UpdateTime", "LadderData", "LocalId", "Count", "FightType", "CompleteTask", });
    internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor =
      internal_static_Message_PlayerBackData_descriptor.getNestedTypes().get(0);
    internal_static_Message_PlayerBackData_CompleteTaskEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Message_LadderData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Message_LadderData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LadderData_descriptor,
        new java.lang.String[] { "LadderSingleScore", "LadderMultiScore", });
    internal_static_Message_GameCount_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Message_GameCount_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_GameCount_descriptor,
        new java.lang.String[] { "Express", "ExpressCount", });
    internal_static_Message_GameCountInfo_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Message_GameCountInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_GameCountInfo_descriptor,
        new java.lang.String[] { "Count", "UpdateTime", });
    internal_static_Message_SaveData_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Message_SaveData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_SaveData_descriptor,
        new java.lang.String[] { "BackData", "Pd", });
    internal_static_Message_FishData_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Message_FishData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_FishData_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_Message_VipData_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Message_VipData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_VipData_descriptor,
        new java.lang.String[] { });
    internal_static_Message_LadderPrepare_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Message_LadderPrepare_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LadderPrepare_descriptor,
        new java.lang.String[] { "MatchId", "Auto", "Type", "Order", });
    internal_static_Message_LadderResult_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Message_LadderResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LadderResult_descriptor,
        new java.lang.String[] { "UserName", "Score", "Type", "Record", "FirstUid", "P1", "P2", });
    internal_static_Message_LadderCancelInner_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Message_LadderCancelInner_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LadderCancelInner_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_Message_LadderFightAutoEndInner_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Message_LadderFightAutoEndInner_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_LadderFightAutoEndInner_descriptor,
        new java.lang.String[] { "MatchId", });
    game.proto.data.Data.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
