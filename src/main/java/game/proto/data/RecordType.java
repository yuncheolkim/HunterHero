// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf enum {@code Message.RecordType}
 */
public enum RecordType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ACTION = 0;</code>
   */
  ACTION(0),
  /**
   * <code>ATTACK = 1;</code>
   */
  ATTACK(1),
  /**
   * <code>HEALTH_CHANGE = 2;</code>
   */
  HEALTH_CHANGE(2),
  /**
   * <code>AVOID = 3;</code>
   */
  AVOID(3),
  /**
   * <code>BUFF_ADD = 4;</code>
   */
  BUFF_ADD(4),
  /**
   * <code>BUFF_REMOVE = 5;</code>
   */
  BUFF_REMOVE(5),
  /**
   * <code>BUFF_UPDATE = 6;</code>
   */
  BUFF_UPDATE(6),
  /**
   * <code>HERO_ACTION = 7;</code>
   */
  HERO_ACTION(7),
  /**
   * <code>SKILL_USE = 8;</code>
   */
  SKILL_USE(8),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>ACTION = 0;</code>
   */
  public static final int ACTION_VALUE = 0;
  /**
   * <code>ATTACK = 1;</code>
   */
  public static final int ATTACK_VALUE = 1;
  /**
   * <code>HEALTH_CHANGE = 2;</code>
   */
  public static final int HEALTH_CHANGE_VALUE = 2;
  /**
   * <code>AVOID = 3;</code>
   */
  public static final int AVOID_VALUE = 3;
  /**
   * <code>BUFF_ADD = 4;</code>
   */
  public static final int BUFF_ADD_VALUE = 4;
  /**
   * <code>BUFF_REMOVE = 5;</code>
   */
  public static final int BUFF_REMOVE_VALUE = 5;
  /**
   * <code>BUFF_UPDATE = 6;</code>
   */
  public static final int BUFF_UPDATE_VALUE = 6;
  /**
   * <code>HERO_ACTION = 7;</code>
   */
  public static final int HERO_ACTION_VALUE = 7;
  /**
   * <code>SKILL_USE = 8;</code>
   */
  public static final int SKILL_USE_VALUE = 8;


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
  public static RecordType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static RecordType forNumber(int value) {
    switch (value) {
      case 0: return ACTION;
      case 1: return ATTACK;
      case 2: return HEALTH_CHANGE;
      case 3: return AVOID;
      case 4: return BUFF_ADD;
      case 5: return BUFF_REMOVE;
      case 6: return BUFF_UPDATE;
      case 7: return HERO_ACTION;
      case 8: return SKILL_USE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<RecordType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      RecordType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<RecordType>() {
          public RecordType findValueByNumber(int number) {
            return RecordType.forNumber(number);
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

  private static final RecordType[] VALUES = values();

  public static RecordType valueOf(
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

  private RecordType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.RecordType)
}

