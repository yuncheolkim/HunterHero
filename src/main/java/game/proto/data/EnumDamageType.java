// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * 伤害类型
 * </pre>
 *
 * Protobuf enum {@code Message.EnumDamageType}
 */
public enum EnumDamageType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 普通
   * </pre>
   *
   * <code>D_NONE = 0;</code>
   */
  D_NONE(0),
  /**
   * <pre>
   * 火焰
   * </pre>
   *
   * <code>D_FIRE = 1;</code>
   */
  D_FIRE(1),
  /**
   * <pre>
   * 闪电
   * </pre>
   *
   * <code>D_LIGHT = 2;</code>
   */
  D_LIGHT(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * 普通
   * </pre>
   *
   * <code>D_NONE = 0;</code>
   */
  public static final int D_NONE_VALUE = 0;
  /**
   * <pre>
   * 火焰
   * </pre>
   *
   * <code>D_FIRE = 1;</code>
   */
  public static final int D_FIRE_VALUE = 1;
  /**
   * <pre>
   * 闪电
   * </pre>
   *
   * <code>D_LIGHT = 2;</code>
   */
  public static final int D_LIGHT_VALUE = 2;


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
  public static EnumDamageType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EnumDamageType forNumber(int value) {
    switch (value) {
      case 0: return D_NONE;
      case 1: return D_FIRE;
      case 2: return D_LIGHT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EnumDamageType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EnumDamageType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EnumDamageType>() {
          public EnumDamageType findValueByNumber(int number) {
            return EnumDamageType.forNumber(number);
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
    return game.proto.data.Data.getDescriptor().getEnumTypes().get(2);
  }

  private static final EnumDamageType[] VALUES = values();

  public static EnumDamageType valueOf(
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

  private EnumDamageType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.EnumDamageType)
}

