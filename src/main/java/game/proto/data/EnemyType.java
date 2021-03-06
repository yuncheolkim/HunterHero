// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf enum {@code Message.EnemyType}
 */
public enum EnemyType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CREATURE = 0;</code>
   */
  CREATURE(0),
  /**
   * <code>PLAYER = 1;</code>
   */
  PLAYER(1),
  /**
   * <code>NPC = 2;</code>
   */
  NPC(2),
  /**
   * <code>EXERCISE = 3;</code>
   */
  EXERCISE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CREATURE = 0;</code>
   */
  public static final int CREATURE_VALUE = 0;
  /**
   * <code>PLAYER = 1;</code>
   */
  public static final int PLAYER_VALUE = 1;
  /**
   * <code>NPC = 2;</code>
   */
  public static final int NPC_VALUE = 2;
  /**
   * <code>EXERCISE = 3;</code>
   */
  public static final int EXERCISE_VALUE = 3;


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
  public static EnemyType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EnemyType forNumber(int value) {
    switch (value) {
      case 0: return CREATURE;
      case 1: return PLAYER;
      case 2: return NPC;
      case 3: return EXERCISE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EnemyType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EnemyType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EnemyType>() {
          public EnemyType findValueByNumber(int number) {
            return EnemyType.forNumber(number);
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
    return game.proto.data.Data.getDescriptor().getEnumTypes().get(8);
  }

  private static final EnemyType[] VALUES = values();

  public static EnemyType valueOf(
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

  private EnemyType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.EnemyType)
}

