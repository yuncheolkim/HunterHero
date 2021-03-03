// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * 资源
 * </pre>
 *
 * Protobuf type {@code Message.Resource}
 */
public final class Resource extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.Resource)
    ResourceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Resource.newBuilder() to construct.
  private Resource(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Resource() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Resource();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Resource(
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
          case 48: {

            power_ = input.readInt32();
            break;
          }
          case 56: {

            maxPower_ = input.readInt32();
            break;
          }
          case 64: {

            powerRecoverSecond_ = input.readInt32();
            break;
          }
          case 80: {

            exp_ = input.readInt32();
            break;
          }
          case 88: {

            needExp_ = input.readInt32();
            break;
          }
          case 96: {

            gold_ = input.readInt64();
            break;
          }
          case 104: {

            lei_ = input.readInt32();
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
    return game.proto.data.Data.internal_static_Message_Resource_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_Resource_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.Resource.class, game.proto.data.Resource.Builder.class);
  }

  public static final int EXP_FIELD_NUMBER = 10;
  private int exp_;
  /**
   * <code>int32 exp = 10;</code>
   * @return The exp.
   */
  @java.lang.Override
  public int getExp() {
    return exp_;
  }

  public static final int NEEDEXP_FIELD_NUMBER = 11;
  private int needExp_;
  /**
   * <code>int32 needExp = 11;</code>
   * @return The needExp.
   */
  @java.lang.Override
  public int getNeedExp() {
    return needExp_;
  }

  public static final int GOLD_FIELD_NUMBER = 12;
  private long gold_;
  /**
   * <code>int64 gold = 12;</code>
   * @return The gold.
   */
  @java.lang.Override
  public long getGold() {
    return gold_;
  }

  public static final int LEI_FIELD_NUMBER = 13;
  private int lei_;
  /**
   * <code>int32 lei = 13;</code>
   * @return The lei.
   */
  @java.lang.Override
  public int getLei() {
    return lei_;
  }

  public static final int POWER_FIELD_NUMBER = 6;
  private int power_;
  /**
   * <code>int32 power = 6;</code>
   * @return The power.
   */
  @java.lang.Override
  public int getPower() {
    return power_;
  }

  public static final int MAXPOWER_FIELD_NUMBER = 7;
  private int maxPower_;
  /**
   * <code>int32 maxPower = 7;</code>
   * @return The maxPower.
   */
  @java.lang.Override
  public int getMaxPower() {
    return maxPower_;
  }

  public static final int POWERRECOVERSECOND_FIELD_NUMBER = 8;
  private int powerRecoverSecond_;
  /**
   * <code>int32 powerRecoverSecond = 8;</code>
   * @return The powerRecoverSecond.
   */
  @java.lang.Override
  public int getPowerRecoverSecond() {
    return powerRecoverSecond_;
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
    if (power_ != 0) {
      output.writeInt32(6, power_);
    }
    if (maxPower_ != 0) {
      output.writeInt32(7, maxPower_);
    }
    if (powerRecoverSecond_ != 0) {
      output.writeInt32(8, powerRecoverSecond_);
    }
    if (exp_ != 0) {
      output.writeInt32(10, exp_);
    }
    if (needExp_ != 0) {
      output.writeInt32(11, needExp_);
    }
    if (gold_ != 0L) {
      output.writeInt64(12, gold_);
    }
    if (lei_ != 0) {
      output.writeInt32(13, lei_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (power_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, power_);
    }
    if (maxPower_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, maxPower_);
    }
    if (powerRecoverSecond_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, powerRecoverSecond_);
    }
    if (exp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(10, exp_);
    }
    if (needExp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(11, needExp_);
    }
    if (gold_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(12, gold_);
    }
    if (lei_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, lei_);
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
    if (!(obj instanceof game.proto.data.Resource)) {
      return super.equals(obj);
    }
    game.proto.data.Resource other = (game.proto.data.Resource) obj;

    if (getExp()
        != other.getExp()) return false;
    if (getNeedExp()
        != other.getNeedExp()) return false;
    if (getGold()
        != other.getGold()) return false;
    if (getLei()
        != other.getLei()) return false;
    if (getPower()
        != other.getPower()) return false;
    if (getMaxPower()
        != other.getMaxPower()) return false;
    if (getPowerRecoverSecond()
        != other.getPowerRecoverSecond()) return false;
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
    hash = (37 * hash) + EXP_FIELD_NUMBER;
    hash = (53 * hash) + getExp();
    hash = (37 * hash) + NEEDEXP_FIELD_NUMBER;
    hash = (53 * hash) + getNeedExp();
    hash = (37 * hash) + GOLD_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getGold());
    hash = (37 * hash) + LEI_FIELD_NUMBER;
    hash = (53 * hash) + getLei();
    hash = (37 * hash) + POWER_FIELD_NUMBER;
    hash = (53 * hash) + getPower();
    hash = (37 * hash) + MAXPOWER_FIELD_NUMBER;
    hash = (53 * hash) + getMaxPower();
    hash = (37 * hash) + POWERRECOVERSECOND_FIELD_NUMBER;
    hash = (53 * hash) + getPowerRecoverSecond();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.Resource parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Resource parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Resource parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Resource parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Resource parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Resource parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Resource parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Resource parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Resource parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.Resource parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Resource parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Resource parseFrom(
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
  public static Builder newBuilder(game.proto.data.Resource prototype) {
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
   * 资源
   * </pre>
   *
   * Protobuf type {@code Message.Resource}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.Resource)
      game.proto.data.ResourceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_Resource_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_Resource_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.Resource.class, game.proto.data.Resource.Builder.class);
    }

    // Construct using game.proto.data.Resource.newBuilder()
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
      exp_ = 0;

      needExp_ = 0;

      gold_ = 0L;

      lei_ = 0;

      power_ = 0;

      maxPower_ = 0;

      powerRecoverSecond_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_Resource_descriptor;
    }

    @java.lang.Override
    public game.proto.data.Resource getDefaultInstanceForType() {
      return game.proto.data.Resource.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.Resource build() {
      game.proto.data.Resource result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.Resource buildPartial() {
      game.proto.data.Resource result = new game.proto.data.Resource(this);
      result.exp_ = exp_;
      result.needExp_ = needExp_;
      result.gold_ = gold_;
      result.lei_ = lei_;
      result.power_ = power_;
      result.maxPower_ = maxPower_;
      result.powerRecoverSecond_ = powerRecoverSecond_;
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
      if (other instanceof game.proto.data.Resource) {
        return mergeFrom((game.proto.data.Resource)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.Resource other) {
      if (other == game.proto.data.Resource.getDefaultInstance()) return this;
      if (other.getExp() != 0) {
        setExp(other.getExp());
      }
      if (other.getNeedExp() != 0) {
        setNeedExp(other.getNeedExp());
      }
      if (other.getGold() != 0L) {
        setGold(other.getGold());
      }
      if (other.getLei() != 0) {
        setLei(other.getLei());
      }
      if (other.getPower() != 0) {
        setPower(other.getPower());
      }
      if (other.getMaxPower() != 0) {
        setMaxPower(other.getMaxPower());
      }
      if (other.getPowerRecoverSecond() != 0) {
        setPowerRecoverSecond(other.getPowerRecoverSecond());
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
      game.proto.data.Resource parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.Resource) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int exp_ ;
    /**
     * <code>int32 exp = 10;</code>
     * @return The exp.
     */
    @java.lang.Override
    public int getExp() {
      return exp_;
    }
    /**
     * <code>int32 exp = 10;</code>
     * @param value The exp to set.
     * @return This builder for chaining.
     */
    public Builder setExp(int value) {
      
      exp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 exp = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearExp() {
      
      exp_ = 0;
      onChanged();
      return this;
    }

    private int needExp_ ;
    /**
     * <code>int32 needExp = 11;</code>
     * @return The needExp.
     */
    @java.lang.Override
    public int getNeedExp() {
      return needExp_;
    }
    /**
     * <code>int32 needExp = 11;</code>
     * @param value The needExp to set.
     * @return This builder for chaining.
     */
    public Builder setNeedExp(int value) {
      
      needExp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 needExp = 11;</code>
     * @return This builder for chaining.
     */
    public Builder clearNeedExp() {
      
      needExp_ = 0;
      onChanged();
      return this;
    }

    private long gold_ ;
    /**
     * <code>int64 gold = 12;</code>
     * @return The gold.
     */
    @java.lang.Override
    public long getGold() {
      return gold_;
    }
    /**
     * <code>int64 gold = 12;</code>
     * @param value The gold to set.
     * @return This builder for chaining.
     */
    public Builder setGold(long value) {
      
      gold_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 gold = 12;</code>
     * @return This builder for chaining.
     */
    public Builder clearGold() {
      
      gold_ = 0L;
      onChanged();
      return this;
    }

    private int lei_ ;
    /**
     * <code>int32 lei = 13;</code>
     * @return The lei.
     */
    @java.lang.Override
    public int getLei() {
      return lei_;
    }
    /**
     * <code>int32 lei = 13;</code>
     * @param value The lei to set.
     * @return This builder for chaining.
     */
    public Builder setLei(int value) {
      
      lei_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 lei = 13;</code>
     * @return This builder for chaining.
     */
    public Builder clearLei() {
      
      lei_ = 0;
      onChanged();
      return this;
    }

    private int power_ ;
    /**
     * <code>int32 power = 6;</code>
     * @return The power.
     */
    @java.lang.Override
    public int getPower() {
      return power_;
    }
    /**
     * <code>int32 power = 6;</code>
     * @param value The power to set.
     * @return This builder for chaining.
     */
    public Builder setPower(int value) {
      
      power_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 power = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearPower() {
      
      power_ = 0;
      onChanged();
      return this;
    }

    private int maxPower_ ;
    /**
     * <code>int32 maxPower = 7;</code>
     * @return The maxPower.
     */
    @java.lang.Override
    public int getMaxPower() {
      return maxPower_;
    }
    /**
     * <code>int32 maxPower = 7;</code>
     * @param value The maxPower to set.
     * @return This builder for chaining.
     */
    public Builder setMaxPower(int value) {
      
      maxPower_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 maxPower = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearMaxPower() {
      
      maxPower_ = 0;
      onChanged();
      return this;
    }

    private int powerRecoverSecond_ ;
    /**
     * <code>int32 powerRecoverSecond = 8;</code>
     * @return The powerRecoverSecond.
     */
    @java.lang.Override
    public int getPowerRecoverSecond() {
      return powerRecoverSecond_;
    }
    /**
     * <code>int32 powerRecoverSecond = 8;</code>
     * @param value The powerRecoverSecond to set.
     * @return This builder for chaining.
     */
    public Builder setPowerRecoverSecond(int value) {
      
      powerRecoverSecond_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 powerRecoverSecond = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearPowerRecoverSecond() {
      
      powerRecoverSecond_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:Message.Resource)
  }

  // @@protoc_insertion_point(class_scope:Message.Resource)
  private static final game.proto.data.Resource DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.Resource();
  }

  public static game.proto.data.Resource getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Resource>
      PARSER = new com.google.protobuf.AbstractParser<Resource>() {
    @java.lang.Override
    public Resource parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Resource(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Resource> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Resource> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.Resource getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
