// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: no.proto

package game.proto.no;

public final class NoOuterClass {
  private NoOuterClass() {}
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
      "\n\010no.proto\022\tMessageNo*\365\r\n\002No\022\010\n\004NONE\020\000\022\014" +
      "\n\010LoginReq\020\001\022\014\n\010KickPush\020\002\022\027\n\023PlayerCrea" +
      "teNameReq\020\003\022\n\n\006B_TICK\020\n\022\017\n\013B_DATA_PUSH\020\013" +
      "\022\017\n\013B_HERO_DATA\020\014\022\017\n\013B_FISH_HOOK\020\r\022\026\n\022B_" +
      "FISH_HOOK_EXPIRE\020\016\022\022\n\016B_LADDER_START\020\017\022\020" +
      "\n\014LadderResult\020\020\022\020\n\014HeartbeatReq\020e\022\022\n\rPl" +
      "ayerMoveReq\020\311\001\022\025\n\020PlayerGoHotelReq\020\312\001\022\031\n" +
      "\024PlayerChooseHotelReq\020\313\001\022\024\n\017FeatureOpenP" +
      "ush\020\314\001\022\023\n\016TitleChooseReq\020\255\002\022\021\n\014TitleNewP" +
      "ush\020\256\002\022\022\n\rTaskAcceptReq\020\351\007\022\024\n\017TaskComple" +
      "teReq\020\352\007\022\020\n\013TaskNewPush\020\353\007\022\031\n\024TaskStatus" +
      "ChangePush\020\354\007\022\017\n\nTaskNpcReq\020\355\007\022\023\n\016TaskAb" +
      "andonReq\020\356\007\022\025\n\020HomeOpenAreaRqRs\020\315\010\022\022\n\rHo" +
      "meChangeReq\020\316\010\022\023\n\016HomeHarvestReq\020\317\010\022\021\n\014H" +
      "omeCleanReq\020\320\010\022\024\n\017HomeLevelChange\020\321\010\022\024\n\017" +
      "HomeItemAddPush\020\322\010\022\027\n\022HomeUpgradeCookReq" +
      "\020\323\010\022\023\n\016HomeProductReq\020\324\010\022\030\n\023HomeTaskComp" +
      "leteReq\020\325\010\022\027\n\022HomeNewTaskDayPush\020\326\010\022\022\n\rF" +
      "ightStartReq\020\321\017\022\023\n\016FightStartPush\020\322\017\022\020\n\013" +
      "FightEndReq\020\324\017\022\021\n\014FightTestReq\020\325\017\022\024\n\017Fig" +
      "htHmStartReq\020\333\017\022\024\n\017FightHmStartRes\020\334\017\022\025\n" +
      "\020FightHmActionReq\020\335\017\022\023\n\016FightHmEndPush\020\336" +
      "\017\022\032\n\025LadderSetFormationReq\020\345\017\022\023\n\016BattleE" +
      "nterReq\020\356\017\022\022\n\rBattleEndPush\020\357\017\022\024\n\017Dungeo" +
      "nEnterReq\020\265\020\022\024\n\017DungeonFightReq\020\266\020\022\023\n\016Du" +
      "ngeonExitReq\020\267\020\022\022\n\rEnterSceneReq\020\271\027\022\026\n\021E" +
      "nterFightAreaReq\020\272\027\022\025\n\020ExitFightAreaReq\020" +
      "\273\027\022\026\n\021NpcShowChangePush\020\235\030\022\016\n\tHeroUpReq\020" +
      "\241\037\022\030\n\023HeroTalentChangeReq\020\242\037\022\023\n\016HeroChan" +
      "gePush\020\243\037\022\025\n\020HeroEquipmentReq\020\244\037\022\020\n\013NewH" +
      "eroPush\020\245\037\022\027\n\022FormationCreateReq\020\205 \022\025\n\020F" +
      "ormationListReq\020\206 \022\027\n\022FormationUpdateReq" +
      "\020\207 \022\027\n\022FormationDeleteReq\020\210 \022\030\n\023Formatio" +
      "nSettingReq\020\211 \022\027\n\022ResourceChangePush\020\211\'\022" +
      "\032\n\025PlayerLevelChangePush\020\212\'\022\022\n\rExpChange" +
      "Push\020\213\'\022\027\n\022MaxPowerChangePush\020\214\'\022\024\n\017Reco" +
      "verPowerReq\020\215\'\022\025\n\020ExpressStartRqRs\020\355\'\022\027\n" +
      "\022ExpressCompleteReq\020\356\'\022\023\n\016ExpressOpenReq" +
      "\020\357\'\022\026\n\021BagInfoChangePush\020\361.\022\020\n\013BagCleanR" +
      "eq\020\362.\022\023\n\016ItemDiscardReq\020\3316\022\017\n\nItemBuyReq" +
      "\020\3326\022\024\n\017ItemExchangeReq\020\3336\022\020\n\013ItemSellReq" +
      "\020\3346\022\025\n\020TempleHeroBuyReq\020\2757\022\014\n\007FishReq\020\301>" +
      "\022\020\n\013FishHookReq\020\302>\022\025\n\020FishEnterAreaReq\020\303" +
      ">\022\024\n\017FishExitAreaReq\020\304>\022\021\n\014FishHookPush\020" +
      "\305>\022\023\n\016ChatMessageReq\020\251F\022\024\n\017ChatMessagePu" +
      "sh\020\252FB\023\n\rgame.proto.noH\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
