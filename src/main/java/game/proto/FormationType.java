// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * Protobuf enum {@code Message.FormationType}
 */
public enum FormationType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>FORMATION_NONE = 0;</code>
   */
  FORMATION_NONE(0),
  /**
   * <pre>
   *默认阵型
   * </pre>
   *
   * <code>FORMATION_DEFAULT = 1;</code>
   */
  FORMATION_DEFAULT(1),
  /**
   * <pre>
   *默认阵型
   * </pre>
   *
   * <code>FORMATION_FIGHT = 2;</code>
   */
  FORMATION_FIGHT(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>FORMATION_NONE = 0;</code>
   */
  public static final int FORMATION_NONE_VALUE = 0;
  /**
   * <pre>
   *默认阵型
   * </pre>
   *
   * <code>FORMATION_DEFAULT = 1;</code>
   */
  public static final int FORMATION_DEFAULT_VALUE = 1;
  /**
   * <pre>
   *默认阵型
   * </pre>
   *
   * <code>FORMATION_FIGHT = 2;</code>
   */
  public static final int FORMATION_FIGHT_VALUE = 2;


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
  public static FormationType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static FormationType forNumber(int value) {
    switch (value) {
      case 0: return FORMATION_NONE;
      case 1: return FORMATION_DEFAULT;
      case 2: return FORMATION_FIGHT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<FormationType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      FormationType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<FormationType>() {
          public FormationType findValueByNumber(int number) {
            return FormationType.forNumber(number);
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
    return game.proto.MessageOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final FormationType[] VALUES = values();

  public static FormationType valueOf(
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

  private FormationType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.FormationType)
}
