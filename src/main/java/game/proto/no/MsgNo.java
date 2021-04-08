// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: no.proto

package game.proto.no;

/**
 * Protobuf enum {@code No.MsgNo}
 */
public enum MsgNo
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NONE = 0;</code>
   */
  NONE(0),
  /**
   * <pre>
   * 登录
   * </pre>
   *
   * <code>login_req = 1;</code>
   */
  login_req(1),
  /**
   * <pre>
   * 踢下线
   * </pre>
   *
   * <code>kick_push = 2;</code>
   */
  kick_push(2),
  /**
   * <pre>
   * 创建名称
   * </pre>
   *
   * <code>player_create_name = 3;</code>
   */
  player_create_name(3),
  /**
   * <pre>
   * 心跳
   * </pre>
   *
   * <code>heartbeat = 101;</code>
   */
  heartbeat(101),
  /**
   * <pre>
   * 任务
   * </pre>
   *
   * <code>task_accept = 1001;</code>
   */
  task_accept(1001),
  /**
   * <code>task_complete = 1002;</code>
   */
  task_complete(1002),
  /**
   * <code>TaskNewPushNo = 1003;</code>
   */
  TaskNewPushNo(1003),
  /**
   * <code>TaskStatusChangePush = 1004;</code>
   */
  TaskStatusChangePush(1004),
  /**
   * <pre>
   * 开始战斗
   * </pre>
   *
   * <code>fight_start = 2001;</code>
   */
  fight_start(2001),
  /**
   * <pre>
   * 发生战斗push
   * </pre>
   *
   * <code>fight_start_push = 2002;</code>
   */
  fight_start_push(2002),
  /**
   * <pre>
   * 结束战斗
   * </pre>
   *
   * <code>fight_end = 2004;</code>
   */
  fight_end(2004),
  /**
   * <pre>
   * 进入场景
   * </pre>
   *
   * <code>scene_enter = 3001;</code>
   */
  scene_enter(3001),
  /**
   * <pre>
   * 进入战斗区
   * </pre>
   *
   * <code>scene_enter_fight_area = 3002;</code>
   */
  scene_enter_fight_area(3002),
  /**
   * <pre>
   * 离开战斗区
   * </pre>
   *
   * <code>scene_leave_fight_area = 3003;</code>
   */
  scene_leave_fight_area(3003),
  /**
   * <pre>
   * 历练
   * </pre>
   *
   * <code>hero_update_lilian = 4001;</code>
   */
  hero_update_lilian(4001),
  /**
   * <pre>
   * 修炼
   * </pre>
   *
   * <code>hero_update_xiulian = 4002;</code>
   */
  hero_update_xiulian(4002),
  /**
   * <pre>
   * 英雄变化
   * </pre>
   *
   * <code>hero_change = 4003;</code>
   */
  hero_change(4003),
  /**
   * <pre>
   * 装备物品
   * </pre>
   *
   * <code>HeroEquipmentReqNo = 4004;</code>
   */
  HeroEquipmentReqNo(4004),
  /**
   * <pre>
   * 资源变化
   * </pre>
   *
   * <code>resource_change_push = 5001;</code>
   */
  resource_change_push(5001),
  /**
   * <pre>
   * 玩家等级变化
   * </pre>
   *
   * <code>PlayerLevelChangePushNo = 5002;</code>
   */
  PlayerLevelChangePushNo(5002),
  /**
   * <pre>
   * 经验变化推送
   * </pre>
   *
   * <code>ExpChangePushNo = 5003;</code>
   */
  ExpChangePushNo(5003),
  /**
   * <pre>
   * 背包变化
   * </pre>
   *
   * <code>BagInfoChangePushNo = 6001;</code>
   */
  BagInfoChangePushNo(6001),
  /**
   * <code>BagCleanReqNo = 6002;</code>
   */
  BagCleanReqNo(6002),
  /**
   * <pre>
   * 丢弃物品
   * </pre>
   *
   * <code>ItemDiscardReqNo = 7001;</code>
   */
  ItemDiscardReqNo(7001),
  /**
   * <pre>
   * 购买物品
   * </pre>
   *
   * <code>ItemBuyReqNo = 7002;</code>
   */
  ItemBuyReqNo(7002),
  /**
   * <pre>
   * 银行背包,转移物品
   * </pre>
   *
   * <code>ItemExchangeReqNo = 7003;</code>
   */
  ItemExchangeReqNo(7003),
  /**
   * <pre>
   * 出售物品
   * </pre>
   *
   * <code>ItemSellReqNo = 7004;</code>
   */
  ItemSellReqNo(7004),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NONE = 0;</code>
   */
  public static final int NONE_VALUE = 0;
  /**
   * <pre>
   * 登录
   * </pre>
   *
   * <code>login_req = 1;</code>
   */
  public static final int login_req_VALUE = 1;
  /**
   * <pre>
   * 踢下线
   * </pre>
   *
   * <code>kick_push = 2;</code>
   */
  public static final int kick_push_VALUE = 2;
  /**
   * <pre>
   * 创建名称
   * </pre>
   *
   * <code>player_create_name = 3;</code>
   */
  public static final int player_create_name_VALUE = 3;
  /**
   * <pre>
   * 心跳
   * </pre>
   *
   * <code>heartbeat = 101;</code>
   */
  public static final int heartbeat_VALUE = 101;
  /**
   * <pre>
   * 任务
   * </pre>
   *
   * <code>task_accept = 1001;</code>
   */
  public static final int task_accept_VALUE = 1001;
  /**
   * <code>task_complete = 1002;</code>
   */
  public static final int task_complete_VALUE = 1002;
  /**
   * <code>TaskNewPushNo = 1003;</code>
   */
  public static final int TaskNewPushNo_VALUE = 1003;
  /**
   * <code>TaskStatusChangePush = 1004;</code>
   */
  public static final int TaskStatusChangePush_VALUE = 1004;
  /**
   * <pre>
   * 开始战斗
   * </pre>
   *
   * <code>fight_start = 2001;</code>
   */
  public static final int fight_start_VALUE = 2001;
  /**
   * <pre>
   * 发生战斗push
   * </pre>
   *
   * <code>fight_start_push = 2002;</code>
   */
  public static final int fight_start_push_VALUE = 2002;
  /**
   * <pre>
   * 结束战斗
   * </pre>
   *
   * <code>fight_end = 2004;</code>
   */
  public static final int fight_end_VALUE = 2004;
  /**
   * <pre>
   * 进入场景
   * </pre>
   *
   * <code>scene_enter = 3001;</code>
   */
  public static final int scene_enter_VALUE = 3001;
  /**
   * <pre>
   * 进入战斗区
   * </pre>
   *
   * <code>scene_enter_fight_area = 3002;</code>
   */
  public static final int scene_enter_fight_area_VALUE = 3002;
  /**
   * <pre>
   * 离开战斗区
   * </pre>
   *
   * <code>scene_leave_fight_area = 3003;</code>
   */
  public static final int scene_leave_fight_area_VALUE = 3003;
  /**
   * <pre>
   * 历练
   * </pre>
   *
   * <code>hero_update_lilian = 4001;</code>
   */
  public static final int hero_update_lilian_VALUE = 4001;
  /**
   * <pre>
   * 修炼
   * </pre>
   *
   * <code>hero_update_xiulian = 4002;</code>
   */
  public static final int hero_update_xiulian_VALUE = 4002;
  /**
   * <pre>
   * 英雄变化
   * </pre>
   *
   * <code>hero_change = 4003;</code>
   */
  public static final int hero_change_VALUE = 4003;
  /**
   * <pre>
   * 装备物品
   * </pre>
   *
   * <code>HeroEquipmentReqNo = 4004;</code>
   */
  public static final int HeroEquipmentReqNo_VALUE = 4004;
  /**
   * <pre>
   * 资源变化
   * </pre>
   *
   * <code>resource_change_push = 5001;</code>
   */
  public static final int resource_change_push_VALUE = 5001;
  /**
   * <pre>
   * 玩家等级变化
   * </pre>
   *
   * <code>PlayerLevelChangePushNo = 5002;</code>
   */
  public static final int PlayerLevelChangePushNo_VALUE = 5002;
  /**
   * <pre>
   * 经验变化推送
   * </pre>
   *
   * <code>ExpChangePushNo = 5003;</code>
   */
  public static final int ExpChangePushNo_VALUE = 5003;
  /**
   * <pre>
   * 背包变化
   * </pre>
   *
   * <code>BagInfoChangePushNo = 6001;</code>
   */
  public static final int BagInfoChangePushNo_VALUE = 6001;
  /**
   * <code>BagCleanReqNo = 6002;</code>
   */
  public static final int BagCleanReqNo_VALUE = 6002;
  /**
   * <pre>
   * 丢弃物品
   * </pre>
   *
   * <code>ItemDiscardReqNo = 7001;</code>
   */
  public static final int ItemDiscardReqNo_VALUE = 7001;
  /**
   * <pre>
   * 购买物品
   * </pre>
   *
   * <code>ItemBuyReqNo = 7002;</code>
   */
  public static final int ItemBuyReqNo_VALUE = 7002;
  /**
   * <pre>
   * 银行背包,转移物品
   * </pre>
   *
   * <code>ItemExchangeReqNo = 7003;</code>
   */
  public static final int ItemExchangeReqNo_VALUE = 7003;
  /**
   * <pre>
   * 出售物品
   * </pre>
   *
   * <code>ItemSellReqNo = 7004;</code>
   */
  public static final int ItemSellReqNo_VALUE = 7004;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MsgNo valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static MsgNo forNumber(int value) {
    switch (value) {
      case 0: return NONE;
      case 1: return login_req;
      case 2: return kick_push;
      case 3: return player_create_name;
      case 101: return heartbeat;
      case 1001: return task_accept;
      case 1002: return task_complete;
      case 1003: return TaskNewPushNo;
      case 1004: return TaskStatusChangePush;
      case 2001: return fight_start;
      case 2002: return fight_start_push;
      case 2004: return fight_end;
      case 3001: return scene_enter;
      case 3002: return scene_enter_fight_area;
      case 3003: return scene_leave_fight_area;
      case 4001: return hero_update_lilian;
      case 4002: return hero_update_xiulian;
      case 4003: return hero_change;
      case 4004: return HeroEquipmentReqNo;
      case 5001: return resource_change_push;
      case 5002: return PlayerLevelChangePushNo;
      case 5003: return ExpChangePushNo;
      case 6001: return BagInfoChangePushNo;
      case 6002: return BagCleanReqNo;
      case 7001: return ItemDiscardReqNo;
      case 7002: return ItemBuyReqNo;
      case 7003: return ItemExchangeReqNo;
      case 7004: return ItemSellReqNo;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MsgNo>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MsgNo> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MsgNo>() {
          public MsgNo findValueByNumber(int number) {
            return MsgNo.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return game.proto.no.No.getDescriptor().getEnumTypes().get(0);
  }

  private static final MsgNo[] VALUES = values();

  public static MsgNo valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MsgNo(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:No.MsgNo)
}
