// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msgNo.proto

package game.proto.back;

public final class MsgNoOuterClass {
  private MsgNoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013msgNo.proto\022\007Message*s\n\016MsgNoBackInner" +
      "\022\n\n\006B_NONE\020\000\022\n\n\006B_TICK\020\n\022\017\n\013B_DATA_PUSH\020" +
      "\013\022\017\n\013B_HERO_DATA\020\014\022\017\n\013B_FISH_HOOK\020\r\022\026\n\022B" +
      "_FISH_HOOK_EXPIRE\020\016*\267\006\n\005MsgNo\022\010\n\004NONE\020\000\022" +
      "\r\n\tlogin_req\020\001\022\r\n\tkick_push\020\002\022\026\n\022player_" +
      "create_name\020\003\022\r\n\theartbeat\020e\022\024\n\017PlayerMo" +
      "veReqNo\020\311\001\022\020\n\013task_accept\020\351\007\022\022\n\rtask_com" +
      "plete\020\352\007\022\022\n\rTaskNewPushNo\020\353\007\022\033\n\026TaskStat" +
      "usChangePushNo\020\354\007\022\021\n\014TaskNpcReqNo\020\355\007\022\020\n\013" +
      "fight_start\020\321\017\022\025\n\020fight_start_push\020\322\017\022\016\n" +
      "\tfight_end\020\324\017\022\023\n\016FightTestReqNo\020\325\017\022\020\n\013sc" +
      "ene_enter\020\271\027\022\033\n\026scene_enter_fight_area\020\272" +
      "\027\022\033\n\026scene_leave_fight_area\020\273\027\022\027\n\022hero_u" +
      "pdate_lilian\020\241\037\022\030\n\023hero_update_xiulian\020\242" +
      "\037\022\020\n\013hero_change\020\243\037\022\027\n\022HeroEquipmentReqN" +
      "o\020\244\037\022\031\n\024FormationCreateReqNo\020\205 \022\027\n\022Forma" +
      "tionListReqNo\020\206 \022\031\n\024FormationUpdateReqNo" +
      "\020\207 \022\031\n\024FormationDeleteReqNo\020\210 \022\032\n\025Format" +
      "ionSettingReqNo\020\211 \022\031\n\024resource_change_pu" +
      "sh\020\211\'\022\034\n\027PlayerLevelChangePushNo\020\212\'\022\024\n\017E" +
      "xpChangePushNo\020\213\'\022\030\n\023BagInfoChangePushNo" +
      "\020\361.\022\022\n\rBagCleanReqNo\020\362.\022\025\n\020ItemDiscardRe" +
      "qNo\020\3316\022\021\n\014ItemBuyReqNo\020\3326\022\026\n\021ItemExchang" +
      "eReqNo\020\3336\022\022\n\rItemSellReqNo\020\3346\022\016\n\tFishReq" +
      "No\020\301>B\025\n\017game.proto.backH\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
