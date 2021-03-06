// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf type {@code Message.BuffRecord}
 */
public final class BuffRecord extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.BuffRecord)
    BuffRecordOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BuffRecord.newBuilder() to construct.
  private BuffRecord(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BuffRecord() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BuffRecord();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BuffRecord(
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

            buffId_ = input.readInt32();
            break;
          }
          case 16: {

            round_ = input.readInt32();
            break;
          }
          case 24: {

            remainRound_ = input.readInt32();
            break;
          }
          case 32: {

            i1_ = input.readInt32();
            break;
          }
          case 40: {

            i2_ = input.readInt32();
            break;
          }
          case 48: {

            i3_ = input.readInt32();
            break;
          }
          case 173: {

            f1_ = input.readFloat();
            break;
          }
          case 181: {

            f2_ = input.readFloat();
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
    return game.proto.data.Data.internal_static_Message_BuffRecord_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_BuffRecord_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.BuffRecord.class, game.proto.data.BuffRecord.Builder.class);
  }

  public static final int BUFFID_FIELD_NUMBER = 1;
  private int buffId_;
  /**
   * <code>int32 buffId = 1;</code>
   * @return The buffId.
   */
  @java.lang.Override
  public int getBuffId() {
    return buffId_;
  }

  public static final int ROUND_FIELD_NUMBER = 2;
  private int round_;
  /**
   * <code>int32 round = 2;</code>
   * @return The round.
   */
  @java.lang.Override
  public int getRound() {
    return round_;
  }

  public static final int REMAINROUND_FIELD_NUMBER = 3;
  private int remainRound_;
  /**
   * <code>int32 remainRound = 3;</code>
   * @return The remainRound.
   */
  @java.lang.Override
  public int getRemainRound() {
    return remainRound_;
  }

  public static final int I1_FIELD_NUMBER = 4;
  private int i1_;
  /**
   * <code>int32 i1 = 4;</code>
   * @return The i1.
   */
  @java.lang.Override
  public int getI1() {
    return i1_;
  }

  public static final int I2_FIELD_NUMBER = 5;
  private int i2_;
  /**
   * <code>int32 i2 = 5;</code>
   * @return The i2.
   */
  @java.lang.Override
  public int getI2() {
    return i2_;
  }

  public static final int I3_FIELD_NUMBER = 6;
  private int i3_;
  /**
   * <code>int32 i3 = 6;</code>
   * @return The i3.
   */
  @java.lang.Override
  public int getI3() {
    return i3_;
  }

  public static final int F1_FIELD_NUMBER = 21;
  private float f1_;
  /**
   * <code>float f1 = 21;</code>
   * @return The f1.
   */
  @java.lang.Override
  public float getF1() {
    return f1_;
  }

  public static final int F2_FIELD_NUMBER = 22;
  private float f2_;
  /**
   * <code>float f2 = 22;</code>
   * @return The f2.
   */
  @java.lang.Override
  public float getF2() {
    return f2_;
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
    if (buffId_ != 0) {
      output.writeInt32(1, buffId_);
    }
    if (round_ != 0) {
      output.writeInt32(2, round_);
    }
    if (remainRound_ != 0) {
      output.writeInt32(3, remainRound_);
    }
    if (i1_ != 0) {
      output.writeInt32(4, i1_);
    }
    if (i2_ != 0) {
      output.writeInt32(5, i2_);
    }
    if (i3_ != 0) {
      output.writeInt32(6, i3_);
    }
    if (f1_ != 0F) {
      output.writeFloat(21, f1_);
    }
    if (f2_ != 0F) {
      output.writeFloat(22, f2_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (buffId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, buffId_);
    }
    if (round_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, round_);
    }
    if (remainRound_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, remainRound_);
    }
    if (i1_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, i1_);
    }
    if (i2_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, i2_);
    }
    if (i3_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, i3_);
    }
    if (f1_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(21, f1_);
    }
    if (f2_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(22, f2_);
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
    if (!(obj instanceof game.proto.data.BuffRecord)) {
      return super.equals(obj);
    }
    game.proto.data.BuffRecord other = (game.proto.data.BuffRecord) obj;

    if (getBuffId()
        != other.getBuffId()) return false;
    if (getRound()
        != other.getRound()) return false;
    if (getRemainRound()
        != other.getRemainRound()) return false;
    if (getI1()
        != other.getI1()) return false;
    if (getI2()
        != other.getI2()) return false;
    if (getI3()
        != other.getI3()) return false;
    if (java.lang.Float.floatToIntBits(getF1())
        != java.lang.Float.floatToIntBits(
            other.getF1())) return false;
    if (java.lang.Float.floatToIntBits(getF2())
        != java.lang.Float.floatToIntBits(
            other.getF2())) return false;
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
    hash = (37 * hash) + BUFFID_FIELD_NUMBER;
    hash = (53 * hash) + getBuffId();
    hash = (37 * hash) + ROUND_FIELD_NUMBER;
    hash = (53 * hash) + getRound();
    hash = (37 * hash) + REMAINROUND_FIELD_NUMBER;
    hash = (53 * hash) + getRemainRound();
    hash = (37 * hash) + I1_FIELD_NUMBER;
    hash = (53 * hash) + getI1();
    hash = (37 * hash) + I2_FIELD_NUMBER;
    hash = (53 * hash) + getI2();
    hash = (37 * hash) + I3_FIELD_NUMBER;
    hash = (53 * hash) + getI3();
    hash = (37 * hash) + F1_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getF1());
    hash = (37 * hash) + F2_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getF2());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.BuffRecord parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.BuffRecord parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.BuffRecord parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.BuffRecord parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.BuffRecord parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.BuffRecord parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.BuffRecord parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.BuffRecord parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.BuffRecord parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.BuffRecord parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.BuffRecord parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.BuffRecord parseFrom(
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
  public static Builder newBuilder(game.proto.data.BuffRecord prototype) {
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
   * Protobuf type {@code Message.BuffRecord}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.BuffRecord)
      game.proto.data.BuffRecordOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_BuffRecord_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_BuffRecord_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.BuffRecord.class, game.proto.data.BuffRecord.Builder.class);
    }

    // Construct using game.proto.data.BuffRecord.newBuilder()
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
      buffId_ = 0;

      round_ = 0;

      remainRound_ = 0;

      i1_ = 0;

      i2_ = 0;

      i3_ = 0;

      f1_ = 0F;

      f2_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_BuffRecord_descriptor;
    }

    @java.lang.Override
    public game.proto.data.BuffRecord getDefaultInstanceForType() {
      return game.proto.data.BuffRecord.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.BuffRecord build() {
      game.proto.data.BuffRecord result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.BuffRecord buildPartial() {
      game.proto.data.BuffRecord result = new game.proto.data.BuffRecord(this);
      result.buffId_ = buffId_;
      result.round_ = round_;
      result.remainRound_ = remainRound_;
      result.i1_ = i1_;
      result.i2_ = i2_;
      result.i3_ = i3_;
      result.f1_ = f1_;
      result.f2_ = f2_;
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
      if (other instanceof game.proto.data.BuffRecord) {
        return mergeFrom((game.proto.data.BuffRecord)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.BuffRecord other) {
      if (other == game.proto.data.BuffRecord.getDefaultInstance()) return this;
      if (other.getBuffId() != 0) {
        setBuffId(other.getBuffId());
      }
      if (other.getRound() != 0) {
        setRound(other.getRound());
      }
      if (other.getRemainRound() != 0) {
        setRemainRound(other.getRemainRound());
      }
      if (other.getI1() != 0) {
        setI1(other.getI1());
      }
      if (other.getI2() != 0) {
        setI2(other.getI2());
      }
      if (other.getI3() != 0) {
        setI3(other.getI3());
      }
      if (other.getF1() != 0F) {
        setF1(other.getF1());
      }
      if (other.getF2() != 0F) {
        setF2(other.getF2());
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
      game.proto.data.BuffRecord parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.BuffRecord) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int buffId_ ;
    /**
     * <code>int32 buffId = 1;</code>
     * @return The buffId.
     */
    @java.lang.Override
    public int getBuffId() {
      return buffId_;
    }
    /**
     * <code>int32 buffId = 1;</code>
     * @param value The buffId to set.
     * @return This builder for chaining.
     */
    public Builder setBuffId(int value) {
      
      buffId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 buffId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBuffId() {
      
      buffId_ = 0;
      onChanged();
      return this;
    }

    private int round_ ;
    /**
     * <code>int32 round = 2;</code>
     * @return The round.
     */
    @java.lang.Override
    public int getRound() {
      return round_;
    }
    /**
     * <code>int32 round = 2;</code>
     * @param value The round to set.
     * @return This builder for chaining.
     */
    public Builder setRound(int value) {
      
      round_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 round = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRound() {
      
      round_ = 0;
      onChanged();
      return this;
    }

    private int remainRound_ ;
    /**
     * <code>int32 remainRound = 3;</code>
     * @return The remainRound.
     */
    @java.lang.Override
    public int getRemainRound() {
      return remainRound_;
    }
    /**
     * <code>int32 remainRound = 3;</code>
     * @param value The remainRound to set.
     * @return This builder for chaining.
     */
    public Builder setRemainRound(int value) {
      
      remainRound_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 remainRound = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearRemainRound() {
      
      remainRound_ = 0;
      onChanged();
      return this;
    }

    private int i1_ ;
    /**
     * <code>int32 i1 = 4;</code>
     * @return The i1.
     */
    @java.lang.Override
    public int getI1() {
      return i1_;
    }
    /**
     * <code>int32 i1 = 4;</code>
     * @param value The i1 to set.
     * @return This builder for chaining.
     */
    public Builder setI1(int value) {
      
      i1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 i1 = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearI1() {
      
      i1_ = 0;
      onChanged();
      return this;
    }

    private int i2_ ;
    /**
     * <code>int32 i2 = 5;</code>
     * @return The i2.
     */
    @java.lang.Override
    public int getI2() {
      return i2_;
    }
    /**
     * <code>int32 i2 = 5;</code>
     * @param value The i2 to set.
     * @return This builder for chaining.
     */
    public Builder setI2(int value) {
      
      i2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 i2 = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearI2() {
      
      i2_ = 0;
      onChanged();
      return this;
    }

    private int i3_ ;
    /**
     * <code>int32 i3 = 6;</code>
     * @return The i3.
     */
    @java.lang.Override
    public int getI3() {
      return i3_;
    }
    /**
     * <code>int32 i3 = 6;</code>
     * @param value The i3 to set.
     * @return This builder for chaining.
     */
    public Builder setI3(int value) {
      
      i3_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 i3 = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearI3() {
      
      i3_ = 0;
      onChanged();
      return this;
    }

    private float f1_ ;
    /**
     * <code>float f1 = 21;</code>
     * @return The f1.
     */
    @java.lang.Override
    public float getF1() {
      return f1_;
    }
    /**
     * <code>float f1 = 21;</code>
     * @param value The f1 to set.
     * @return This builder for chaining.
     */
    public Builder setF1(float value) {
      
      f1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float f1 = 21;</code>
     * @return This builder for chaining.
     */
    public Builder clearF1() {
      
      f1_ = 0F;
      onChanged();
      return this;
    }

    private float f2_ ;
    /**
     * <code>float f2 = 22;</code>
     * @return The f2.
     */
    @java.lang.Override
    public float getF2() {
      return f2_;
    }
    /**
     * <code>float f2 = 22;</code>
     * @param value The f2 to set.
     * @return This builder for chaining.
     */
    public Builder setF2(float value) {
      
      f2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float f2 = 22;</code>
     * @return This builder for chaining.
     */
    public Builder clearF2() {
      
      f2_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:Message.BuffRecord)
  }

  // @@protoc_insertion_point(class_scope:Message.BuffRecord)
  private static final game.proto.data.BuffRecord DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.BuffRecord();
  }

  public static game.proto.data.BuffRecord getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BuffRecord>
      PARSER = new com.google.protobuf.AbstractParser<BuffRecord>() {
    @java.lang.Override
    public BuffRecord parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BuffRecord(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BuffRecord> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BuffRecord> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.BuffRecord getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

