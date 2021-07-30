// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * 手动战斗,执行的动作
 * </pre>
 *
 * Protobuf enum {@code Message.ManualActionType}
 */
public enum ManualActionType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>MA_NONE = 0;</code>
   */
  MA_NONE(0),
  /**
   * <pre>
   * 攻击
   * </pre>
   *
   * <code>MA_ATTACK = 1;</code>
   */
  MA_ATTACK(1),
  /**
   * <pre>
   * 使用技能
   * </pre>
   *
   * <code>MA_SKILL = 2;</code>
   */
  MA_SKILL(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>MA_NONE = 0;</code>
   */
  public static final int MA_NONE_VALUE = 0;
  /**
   * <pre>
   * 攻击
   * </pre>
   *
   * <code>MA_ATTACK = 1;</code>
   */
  public static final int MA_ATTACK_VALUE = 1;
  /**
   * <pre>
   * 使用技能
   * </pre>
   *
   * <code>MA_SKILL = 2;</code>
   */
  public static final int MA_SKILL_VALUE = 2;


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
  public static ManualActionType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ManualActionType forNumber(int value) {
    switch (value) {
      case 0: return MA_NONE;
      case 1: return MA_ATTACK;
      case 2: return MA_SKILL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ManualActionType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ManualActionType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ManualActionType>() {
          public ManualActionType findValueByNumber(int number) {
            return ManualActionType.forNumber(number);
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
    return game.proto.data.Data.getDescriptor().getEnumTypes().get(9);
  }

  private static final ManualActionType[] VALUES = values();

  public static ManualActionType valueOf(
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

  private ManualActionType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.ManualActionType)
}
