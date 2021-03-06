// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msgNo.proto

package game.proto.back;

/**
 * Protobuf enum {@code Message.MsgNo}
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
   * <code>heartbeat = 4;</code>
   */
  heartbeat(4),
  /**
   * <pre>
   * 接受任务
   * </pre>
   *
   * <code>task_accept = 1001;</code>
   */
  task_accept(1001),
  /**
   * <pre>
   * 完成任务
   * </pre>
   *
   * <code>task_complete = 1002;</code>
   */
  task_complete(1002),
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
   * <code>heartbeat = 4;</code>
   */
  public static final int heartbeat_VALUE = 4;
  /**
   * <pre>
   * 接受任务
   * </pre>
   *
   * <code>task_accept = 1001;</code>
   */
  public static final int task_accept_VALUE = 1001;
  /**
   * <pre>
   * 完成任务
   * </pre>
   *
   * <code>task_complete = 1002;</code>
   */
  public static final int task_complete_VALUE = 1002;
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
      case 4: return heartbeat;
      case 1001: return task_accept;
      case 1002: return task_complete;
      case 2001: return fight_start;
      case 2002: return fight_start_push;
      case 2004: return fight_end;
      case 3001: return scene_enter;
      case 3002: return scene_enter_fight_area;
      case 3003: return scene_leave_fight_area;
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
    return game.proto.back.MsgNoOuterClass.getDescriptor().getEnumTypes().get(0);
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

  // @@protoc_insertion_point(enum_scope:Message.MsgNo)
}

