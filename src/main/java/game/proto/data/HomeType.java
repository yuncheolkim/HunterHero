// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf enum {@code Message.HomeType}
 */
public enum HomeType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 空地
   * </pre>
   *
   * <code>H_NONE = 0;</code>
   */
  H_NONE(0),
  /**
   * <pre>
   * 土地
   * </pre>
   *
   * <code>H_LAND = 1;</code>
   */
  H_LAND(1),
  /**
   * <pre>
   * 农作物
   * </pre>
   *
   * <code>H_FARM = 2;</code>
   */
  H_FARM(2),
  /**
   * <pre>
   * 建筑物
   * </pre>
   *
   * <code>H_BUILD = 3;</code>
   */
  H_BUILD(3),
  /**
   * <pre>
   * 墙
   * </pre>
   *
   * <code>H_WALL = 4;</code>
   */
  H_WALL(4),
  /**
   * <pre>
   * 地毯
   * </pre>
   *
   * <code>H_CARPET = 5;</code>
   */
  H_CARPET(5),
  /**
   * <pre>
   * 路
   * </pre>
   *
   * <code>H_ROAD = 6;</code>
   */
  H_ROAD(6),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * 空地
   * </pre>
   *
   * <code>H_NONE = 0;</code>
   */
  public static final int H_NONE_VALUE = 0;
  /**
   * <pre>
   * 土地
   * </pre>
   *
   * <code>H_LAND = 1;</code>
   */
  public static final int H_LAND_VALUE = 1;
  /**
   * <pre>
   * 农作物
   * </pre>
   *
   * <code>H_FARM = 2;</code>
   */
  public static final int H_FARM_VALUE = 2;
  /**
   * <pre>
   * 建筑物
   * </pre>
   *
   * <code>H_BUILD = 3;</code>
   */
  public static final int H_BUILD_VALUE = 3;
  /**
   * <pre>
   * 墙
   * </pre>
   *
   * <code>H_WALL = 4;</code>
   */
  public static final int H_WALL_VALUE = 4;
  /**
   * <pre>
   * 地毯
   * </pre>
   *
   * <code>H_CARPET = 5;</code>
   */
  public static final int H_CARPET_VALUE = 5;
  /**
   * <pre>
   * 路
   * </pre>
   *
   * <code>H_ROAD = 6;</code>
   */
  public static final int H_ROAD_VALUE = 6;


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
  public static HomeType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static HomeType forNumber(int value) {
    switch (value) {
      case 0: return H_NONE;
      case 1: return H_LAND;
      case 2: return H_FARM;
      case 3: return H_BUILD;
      case 4: return H_WALL;
      case 5: return H_CARPET;
      case 6: return H_ROAD;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<HomeType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      HomeType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<HomeType>() {
          public HomeType findValueByNumber(int number) {
            return HomeType.forNumber(number);
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
    return game.proto.data.Data.getDescriptor().getEnumTypes().get(11);
  }

  private static final HomeType[] VALUES = values();

  public static HomeType valueOf(
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

  private HomeType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Message.HomeType)
}

