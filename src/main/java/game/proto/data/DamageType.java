// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf enum {@code Message.DamageType}
 */
public enum DamageType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>DAMAGE_NORMAL = 0;</code>
   */
  DAMAGE_NORMAL(0),
  /**
   * <code>DAMAGE_CRITICAL = 1;</code>
   */
  DAMAGE_CRITICAL(1),
  /**
   * <code>DAMAGE_NONE = 2;</code>
   */
  DAMAGE_NONE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>DAMAGE_NORMAL = 0;</code>
   */
  public static final int DAMAGE_NORMAL_VALUE = 0;
  /**
   * <code>DAMAGE_CRITICAL = 1;</code>
   */
  public static final int DAMAGE_CRITICAL_VALUE = 1;
  /**
   * <code>DAMAGE_NONE = 2;</code>
   */
  public static final int DAMAGE_NONE_VALUE = 2;


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
  public static DamageType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static DamageType forNumber(int value) {
    switch (value) {
      case 0: return DAMAGE_NORMAL;
      case 1: return DAMAGE_CRITICAL;
      case 2: return DAMAGE_NONE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DamageType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DamageType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DamageType>() {
          public DamageType findValueByNumber(int number) {
            return DamageType.forNumber(number);
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

  private static final DamageType[] VALUES = values();

  public static DamageType valueOf(
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

  private DamageType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.DamageType)
}

