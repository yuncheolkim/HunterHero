// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * Reward
 * </pre>
 *
 * Protobuf type {@code Message.Reward}
 */
public final class Reward extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.Reward)
    RewardOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Reward.newBuilder() to construct.
  private Reward(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Reward() {
    type_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Reward();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Reward(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            rewardId_ = input.readInt32();
            break;
          }
          case 16: {

            count_ = input.readInt32();
            break;
          }
          case 24: {

            heroId_ = input.readInt32();
            break;
          }
          case 82: {
            game.proto.data.Property.Builder subBuilder = null;
            if (property_ != null) {
              subBuilder = property_.toBuilder();
            }
            property_ = input.readMessage(game.proto.data.Property.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(property_);
              property_ = subBuilder.buildPartial();
            }

            break;
          }
          case 800: {
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.data.Data.internal_static_Message_Reward_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_Reward_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.Reward.class, game.proto.data.Reward.Builder.class);
  }

  public static final int TYPE_FIELD_NUMBER = 100;
  private int type_;
  /**
   * <code>.Message.RewardType type = 100;</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.Message.RewardType type = 100;</code>
   * @return The type.
   */
  @java.lang.Override public game.proto.data.RewardType getType() {
    @SuppressWarnings("deprecation")
    game.proto.data.RewardType result = game.proto.data.RewardType.valueOf(type_);
    return result == null ? game.proto.data.RewardType.UNRECOGNIZED : result;
  }

  public static final int REWARDID_FIELD_NUMBER = 1;
  private int rewardId_;
  /**
   * <code>int32 rewardId = 1;</code>
   * @return The rewardId.
   */
  @java.lang.Override
  public int getRewardId() {
    return rewardId_;
  }

  public static final int COUNT_FIELD_NUMBER = 2;
  private int count_;
  /**
   * <code>int32 count = 2;</code>
   * @return The count.
   */
  @java.lang.Override
  public int getCount() {
    return count_;
  }

  public static final int HEROID_FIELD_NUMBER = 3;
  private int heroId_;
  /**
   * <pre>
   * ?????????????????? 0?????????????????????,??????0?????????????????????
   * </pre>
   *
   * <code>int32 heroId = 3;</code>
   * @return The heroId.
   */
  @java.lang.Override
  public int getHeroId() {
    return heroId_;
  }

  public static final int PROPERTY_FIELD_NUMBER = 10;
  private game.proto.data.Property property_;
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   * @return Whether the property field is set.
   */
  @java.lang.Override
  public boolean hasProperty() {
    return property_ != null;
  }
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   * @return The property.
   */
  @java.lang.Override
  public game.proto.data.Property getProperty() {
    return property_ == null ? game.proto.data.Property.getDefaultInstance() : property_;
  }
  /**
   * <pre>
   * ??????
   * </pre>
   *
   * <code>.Message.Property property = 10;</code>
   */
  @java.lang.Override
  public game.proto.data.PropertyOrBuilder getPropertyOrBuilder() {
    return getProperty();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (rewardId_ != 0) {
      output.writeInt32(1, rewardId_);
    }
    if (count_ != 0) {
      output.writeInt32(2, count_);
    }
    if (heroId_ != 0) {
      output.writeInt32(3, heroId_);
    }
    if (property_ != null) {
      output.writeMessage(10, getProperty());
    }
    if (type_ != game.proto.data.RewardType.REWARD_NORMAL.getNumber()) {
      output.writeEnum(100, type_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (rewardId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, rewardId_);
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, count_);
    }
    if (heroId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, heroId_);
    }
    if (property_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(10, getProperty());
    }
    if (type_ != game.proto.data.RewardType.REWARD_NORMAL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(100, type_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof game.proto.data.Reward)) {
      return super.equals(obj);
    }
    game.proto.data.Reward other = (game.proto.data.Reward) obj;

    if (type_ != other.type_) return false;
    if (getRewardId()
        != other.getRewardId()) return false;
    if (getCount()
        != other.getCount()) return false;
    if (getHeroId()
        != other.getHeroId()) return false;
    if (hasProperty() != other.hasProperty()) return false;
    if (hasProperty()) {
      if (!getProperty()
          .equals(other.getProperty())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + REWARDID_FIELD_NUMBER;
    hash = (53 * hash) + getRewardId();
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (37 * hash) + HEROID_FIELD_NUMBER;
    hash = (53 * hash) + getHeroId();
    if (hasProperty()) {
      hash = (37 * hash) + PROPERTY_FIELD_NUMBER;
      hash = (53 * hash) + getProperty().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.Reward parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Reward parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Reward parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Reward parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Reward parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Reward parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Reward parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Reward parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Reward parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.Reward parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Reward parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Reward parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(game.proto.data.Reward prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Reward
   * </pre>
   *
   * Protobuf type {@code Message.Reward}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.Reward)
      game.proto.data.RewardOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_Reward_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_Reward_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.Reward.class, game.proto.data.Reward.Builder.class);
    }

    // Construct using game.proto.data.Reward.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      type_ = 0;

      rewardId_ = 0;

      count_ = 0;

      heroId_ = 0;

      if (propertyBuilder_ == null) {
        property_ = null;
      } else {
        property_ = null;
        propertyBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_Reward_descriptor;
    }

    @java.lang.Override
    public game.proto.data.Reward getDefaultInstanceForType() {
      return game.proto.data.Reward.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.Reward build() {
      game.proto.data.Reward result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.Reward buildPartial() {
      game.proto.data.Reward result = new game.proto.data.Reward(this);
      result.type_ = type_;
      result.rewardId_ = rewardId_;
      result.count_ = count_;
      result.heroId_ = heroId_;
      if (propertyBuilder_ == null) {
        result.property_ = property_;
      } else {
        result.property_ = propertyBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof game.proto.data.Reward) {
        return mergeFrom((game.proto.data.Reward)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.Reward other) {
      if (other == game.proto.data.Reward.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.getRewardId() != 0) {
        setRewardId(other.getRewardId());
      }
      if (other.getCount() != 0) {
        setCount(other.getCount());
      }
      if (other.getHeroId() != 0) {
        setHeroId(other.getHeroId());
      }
      if (other.hasProperty()) {
        mergeProperty(other.getProperty());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      game.proto.data.Reward parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.Reward) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.Message.RewardType type = 100;</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.Message.RewardType type = 100;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Message.RewardType type = 100;</code>
     * @return The type.
     */
    @java.lang.Override
    public game.proto.data.RewardType getType() {
      @SuppressWarnings("deprecation")
      game.proto.data.RewardType result = game.proto.data.RewardType.valueOf(type_);
      return result == null ? game.proto.data.RewardType.UNRECOGNIZED : result;
    }
    /**
     * <code>.Message.RewardType type = 100;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(game.proto.data.RewardType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Message.RewardType type = 100;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private int rewardId_ ;
    /**
     * <code>int32 rewardId = 1;</code>
     * @return The rewardId.
     */
    @java.lang.Override
    public int getRewardId() {
      return rewardId_;
    }
    /**
     * <code>int32 rewardId = 1;</code>
     * @param value The rewardId to set.
     * @return This builder for chaining.
     */
    public Builder setRewardId(int value) {
      
      rewardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 rewardId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRewardId() {
      
      rewardId_ = 0;
      onChanged();
      return this;
    }

    private int count_ ;
    /**
     * <code>int32 count = 2;</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return count_;
    }
    /**
     * <code>int32 count = 2;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      
      count_ = 0;
      onChanged();
      return this;
    }

    private int heroId_ ;
    /**
     * <pre>
     * ?????????????????? 0?????????????????????,??????0?????????????????????
     * </pre>
     *
     * <code>int32 heroId = 3;</code>
     * @return The heroId.
     */
    @java.lang.Override
    public int getHeroId() {
      return heroId_;
    }
    /**
     * <pre>
     * ?????????????????? 0?????????????????????,??????0?????????????????????
     * </pre>
     *
     * <code>int32 heroId = 3;</code>
     * @param value The heroId to set.
     * @return This builder for chaining.
     */
    public Builder setHeroId(int value) {
      
      heroId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ?????????????????? 0?????????????????????,??????0?????????????????????
     * </pre>
     *
     * <code>int32 heroId = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearHeroId() {
      
      heroId_ = 0;
      onChanged();
      return this;
    }

    private game.proto.data.Property property_;
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.Property, game.proto.data.Property.Builder, game.proto.data.PropertyOrBuilder> propertyBuilder_;
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     * @return Whether the property field is set.
     */
    public boolean hasProperty() {
      return propertyBuilder_ != null || property_ != null;
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     * @return The property.
     */
    public game.proto.data.Property getProperty() {
      if (propertyBuilder_ == null) {
        return property_ == null ? game.proto.data.Property.getDefaultInstance() : property_;
      } else {
        return propertyBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public Builder setProperty(game.proto.data.Property value) {
      if (propertyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        property_ = value;
        onChanged();
      } else {
        propertyBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public Builder setProperty(
        game.proto.data.Property.Builder builderForValue) {
      if (propertyBuilder_ == null) {
        property_ = builderForValue.build();
        onChanged();
      } else {
        propertyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public Builder mergeProperty(game.proto.data.Property value) {
      if (propertyBuilder_ == null) {
        if (property_ != null) {
          property_ =
            game.proto.data.Property.newBuilder(property_).mergeFrom(value).buildPartial();
        } else {
          property_ = value;
        }
        onChanged();
      } else {
        propertyBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public Builder clearProperty() {
      if (propertyBuilder_ == null) {
        property_ = null;
        onChanged();
      } else {
        property_ = null;
        propertyBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public game.proto.data.Property.Builder getPropertyBuilder() {
      
      onChanged();
      return getPropertyFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    public game.proto.data.PropertyOrBuilder getPropertyOrBuilder() {
      if (propertyBuilder_ != null) {
        return propertyBuilder_.getMessageOrBuilder();
      } else {
        return property_ == null ?
            game.proto.data.Property.getDefaultInstance() : property_;
      }
    }
    /**
     * <pre>
     * ??????
     * </pre>
     *
     * <code>.Message.Property property = 10;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.Property, game.proto.data.Property.Builder, game.proto.data.PropertyOrBuilder> 
        getPropertyFieldBuilder() {
      if (propertyBuilder_ == null) {
        propertyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            game.proto.data.Property, game.proto.data.Property.Builder, game.proto.data.PropertyOrBuilder>(
                getProperty(),
                getParentForChildren(),
                isClean());
        property_ = null;
      }
      return propertyBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Message.Reward)
  }

  // @@protoc_insertion_point(class_scope:Message.Reward)
  private static final game.proto.data.Reward DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.Reward();
  }

  public static game.proto.data.Reward getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Reward>
      PARSER = new com.google.protobuf.AbstractParser<Reward>() {
    @java.lang.Override
    public Reward parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Reward(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Reward> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Reward> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.Reward getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

