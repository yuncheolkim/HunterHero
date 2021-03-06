// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 手动战斗开始
 * </pre>
 *
 * Protobuf type {@code Message.FightHmStartRes}
 */
public final class FightHmStartRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FightHmStartRes)
    FightHmStartResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FightHmStartRes.newBuilder() to construct.
  private FightHmStartRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FightHmStartRes() {
    sideA_ = java.util.Collections.emptyList();
    sideB_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FightHmStartRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FightHmStartRes(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              sideA_ = new java.util.ArrayList<game.proto.data.HeroDataRecord>();
              mutable_bitField0_ |= 0x00000001;
            }
            sideA_.add(
                input.readMessage(game.proto.data.HeroDataRecord.parser(), extensionRegistry));
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
              sideB_ = new java.util.ArrayList<game.proto.data.HeroDataRecord>();
              mutable_bitField0_ |= 0x00000002;
            }
            sideB_.add(
                input.readMessage(game.proto.data.HeroDataRecord.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        sideA_ = java.util.Collections.unmodifiableList(sideA_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        sideB_ = java.util.Collections.unmodifiableList(sideB_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_FightHmStartRes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FightHmStartRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FightHmStartRes.class, game.proto.FightHmStartRes.Builder.class);
  }

  public static final int SIDEA_FIELD_NUMBER = 2;
  private java.util.List<game.proto.data.HeroDataRecord> sideA_;
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.HeroDataRecord> getSideAList() {
    return sideA_;
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
      getSideAOrBuilderList() {
    return sideA_;
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  @java.lang.Override
  public int getSideACount() {
    return sideA_.size();
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  @java.lang.Override
  public game.proto.data.HeroDataRecord getSideA(int index) {
    return sideA_.get(index);
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
   */
  @java.lang.Override
  public game.proto.data.HeroDataRecordOrBuilder getSideAOrBuilder(
      int index) {
    return sideA_.get(index);
  }

  public static final int SIDEB_FIELD_NUMBER = 3;
  private java.util.List<game.proto.data.HeroDataRecord> sideB_;
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.HeroDataRecord> getSideBList() {
    return sideB_;
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
      getSideBOrBuilderList() {
    return sideB_;
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  @java.lang.Override
  public int getSideBCount() {
    return sideB_.size();
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  @java.lang.Override
  public game.proto.data.HeroDataRecord getSideB(int index) {
    return sideB_.get(index);
  }
  /**
   * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
   */
  @java.lang.Override
  public game.proto.data.HeroDataRecordOrBuilder getSideBOrBuilder(
      int index) {
    return sideB_.get(index);
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
    for (int i = 0; i < sideA_.size(); i++) {
      output.writeMessage(2, sideA_.get(i));
    }
    for (int i = 0; i < sideB_.size(); i++) {
      output.writeMessage(3, sideB_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < sideA_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, sideA_.get(i));
    }
    for (int i = 0; i < sideB_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, sideB_.get(i));
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
    if (!(obj instanceof game.proto.FightHmStartRes)) {
      return super.equals(obj);
    }
    game.proto.FightHmStartRes other = (game.proto.FightHmStartRes) obj;

    if (!getSideAList()
        .equals(other.getSideAList())) return false;
    if (!getSideBList()
        .equals(other.getSideBList())) return false;
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
    if (getSideACount() > 0) {
      hash = (37 * hash) + SIDEA_FIELD_NUMBER;
      hash = (53 * hash) + getSideAList().hashCode();
    }
    if (getSideBCount() > 0) {
      hash = (37 * hash) + SIDEB_FIELD_NUMBER;
      hash = (53 * hash) + getSideBList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FightHmStartRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmStartRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmStartRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmStartRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmStartRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmStartRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmStartRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmStartRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmStartRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FightHmStartRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmStartRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmStartRes parseFrom(
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
  public static Builder newBuilder(game.proto.FightHmStartRes prototype) {
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
   * 手动战斗开始
   * </pre>
   *
   * Protobuf type {@code Message.FightHmStartRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FightHmStartRes)
      game.proto.FightHmStartResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmStartRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmStartRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FightHmStartRes.class, game.proto.FightHmStartRes.Builder.class);
    }

    // Construct using game.proto.FightHmStartRes.newBuilder()
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
        getSideAFieldBuilder();
        getSideBFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (sideABuilder_ == null) {
        sideA_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        sideABuilder_.clear();
      }
      if (sideBBuilder_ == null) {
        sideB_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        sideBBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmStartRes_descriptor;
    }

    @java.lang.Override
    public game.proto.FightHmStartRes getDefaultInstanceForType() {
      return game.proto.FightHmStartRes.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FightHmStartRes build() {
      game.proto.FightHmStartRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FightHmStartRes buildPartial() {
      game.proto.FightHmStartRes result = new game.proto.FightHmStartRes(this);
      int from_bitField0_ = bitField0_;
      if (sideABuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          sideA_ = java.util.Collections.unmodifiableList(sideA_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.sideA_ = sideA_;
      } else {
        result.sideA_ = sideABuilder_.build();
      }
      if (sideBBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          sideB_ = java.util.Collections.unmodifiableList(sideB_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.sideB_ = sideB_;
      } else {
        result.sideB_ = sideBBuilder_.build();
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
      if (other instanceof game.proto.FightHmStartRes) {
        return mergeFrom((game.proto.FightHmStartRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FightHmStartRes other) {
      if (other == game.proto.FightHmStartRes.getDefaultInstance()) return this;
      if (sideABuilder_ == null) {
        if (!other.sideA_.isEmpty()) {
          if (sideA_.isEmpty()) {
            sideA_ = other.sideA_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureSideAIsMutable();
            sideA_.addAll(other.sideA_);
          }
          onChanged();
        }
      } else {
        if (!other.sideA_.isEmpty()) {
          if (sideABuilder_.isEmpty()) {
            sideABuilder_.dispose();
            sideABuilder_ = null;
            sideA_ = other.sideA_;
            bitField0_ = (bitField0_ & ~0x00000001);
            sideABuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSideAFieldBuilder() : null;
          } else {
            sideABuilder_.addAllMessages(other.sideA_);
          }
        }
      }
      if (sideBBuilder_ == null) {
        if (!other.sideB_.isEmpty()) {
          if (sideB_.isEmpty()) {
            sideB_ = other.sideB_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureSideBIsMutable();
            sideB_.addAll(other.sideB_);
          }
          onChanged();
        }
      } else {
        if (!other.sideB_.isEmpty()) {
          if (sideBBuilder_.isEmpty()) {
            sideBBuilder_.dispose();
            sideBBuilder_ = null;
            sideB_ = other.sideB_;
            bitField0_ = (bitField0_ & ~0x00000002);
            sideBBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSideBFieldBuilder() : null;
          } else {
            sideBBuilder_.addAllMessages(other.sideB_);
          }
        }
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
      game.proto.FightHmStartRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FightHmStartRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<game.proto.data.HeroDataRecord> sideA_ =
      java.util.Collections.emptyList();
    private void ensureSideAIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        sideA_ = new java.util.ArrayList<game.proto.data.HeroDataRecord>(sideA_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder> sideABuilder_;

    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public java.util.List<game.proto.data.HeroDataRecord> getSideAList() {
      if (sideABuilder_ == null) {
        return java.util.Collections.unmodifiableList(sideA_);
      } else {
        return sideABuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public int getSideACount() {
      if (sideABuilder_ == null) {
        return sideA_.size();
      } else {
        return sideABuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public game.proto.data.HeroDataRecord getSideA(int index) {
      if (sideABuilder_ == null) {
        return sideA_.get(index);
      } else {
        return sideABuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder setSideA(
        int index, game.proto.data.HeroDataRecord value) {
      if (sideABuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideAIsMutable();
        sideA_.set(index, value);
        onChanged();
      } else {
        sideABuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder setSideA(
        int index, game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideABuilder_ == null) {
        ensureSideAIsMutable();
        sideA_.set(index, builderForValue.build());
        onChanged();
      } else {
        sideABuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder addSideA(game.proto.data.HeroDataRecord value) {
      if (sideABuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideAIsMutable();
        sideA_.add(value);
        onChanged();
      } else {
        sideABuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder addSideA(
        int index, game.proto.data.HeroDataRecord value) {
      if (sideABuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideAIsMutable();
        sideA_.add(index, value);
        onChanged();
      } else {
        sideABuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder addSideA(
        game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideABuilder_ == null) {
        ensureSideAIsMutable();
        sideA_.add(builderForValue.build());
        onChanged();
      } else {
        sideABuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder addSideA(
        int index, game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideABuilder_ == null) {
        ensureSideAIsMutable();
        sideA_.add(index, builderForValue.build());
        onChanged();
      } else {
        sideABuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder addAllSideA(
        java.lang.Iterable<? extends game.proto.data.HeroDataRecord> values) {
      if (sideABuilder_ == null) {
        ensureSideAIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, sideA_);
        onChanged();
      } else {
        sideABuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder clearSideA() {
      if (sideABuilder_ == null) {
        sideA_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        sideABuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public Builder removeSideA(int index) {
      if (sideABuilder_ == null) {
        ensureSideAIsMutable();
        sideA_.remove(index);
        onChanged();
      } else {
        sideABuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public game.proto.data.HeroDataRecord.Builder getSideABuilder(
        int index) {
      return getSideAFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public game.proto.data.HeroDataRecordOrBuilder getSideAOrBuilder(
        int index) {
      if (sideABuilder_ == null) {
        return sideA_.get(index);  } else {
        return sideABuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
         getSideAOrBuilderList() {
      if (sideABuilder_ != null) {
        return sideABuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(sideA_);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public game.proto.data.HeroDataRecord.Builder addSideABuilder() {
      return getSideAFieldBuilder().addBuilder(
          game.proto.data.HeroDataRecord.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public game.proto.data.HeroDataRecord.Builder addSideABuilder(
        int index) {
      return getSideAFieldBuilder().addBuilder(
          index, game.proto.data.HeroDataRecord.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideA = 2;</code>
     */
    public java.util.List<game.proto.data.HeroDataRecord.Builder> 
         getSideABuilderList() {
      return getSideAFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder> 
        getSideAFieldBuilder() {
      if (sideABuilder_ == null) {
        sideABuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder>(
                sideA_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        sideA_ = null;
      }
      return sideABuilder_;
    }

    private java.util.List<game.proto.data.HeroDataRecord> sideB_ =
      java.util.Collections.emptyList();
    private void ensureSideBIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        sideB_ = new java.util.ArrayList<game.proto.data.HeroDataRecord>(sideB_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder> sideBBuilder_;

    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public java.util.List<game.proto.data.HeroDataRecord> getSideBList() {
      if (sideBBuilder_ == null) {
        return java.util.Collections.unmodifiableList(sideB_);
      } else {
        return sideBBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public int getSideBCount() {
      if (sideBBuilder_ == null) {
        return sideB_.size();
      } else {
        return sideBBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public game.proto.data.HeroDataRecord getSideB(int index) {
      if (sideBBuilder_ == null) {
        return sideB_.get(index);
      } else {
        return sideBBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder setSideB(
        int index, game.proto.data.HeroDataRecord value) {
      if (sideBBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideBIsMutable();
        sideB_.set(index, value);
        onChanged();
      } else {
        sideBBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder setSideB(
        int index, game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideBBuilder_ == null) {
        ensureSideBIsMutable();
        sideB_.set(index, builderForValue.build());
        onChanged();
      } else {
        sideBBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder addSideB(game.proto.data.HeroDataRecord value) {
      if (sideBBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideBIsMutable();
        sideB_.add(value);
        onChanged();
      } else {
        sideBBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder addSideB(
        int index, game.proto.data.HeroDataRecord value) {
      if (sideBBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSideBIsMutable();
        sideB_.add(index, value);
        onChanged();
      } else {
        sideBBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder addSideB(
        game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideBBuilder_ == null) {
        ensureSideBIsMutable();
        sideB_.add(builderForValue.build());
        onChanged();
      } else {
        sideBBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder addSideB(
        int index, game.proto.data.HeroDataRecord.Builder builderForValue) {
      if (sideBBuilder_ == null) {
        ensureSideBIsMutable();
        sideB_.add(index, builderForValue.build());
        onChanged();
      } else {
        sideBBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder addAllSideB(
        java.lang.Iterable<? extends game.proto.data.HeroDataRecord> values) {
      if (sideBBuilder_ == null) {
        ensureSideBIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, sideB_);
        onChanged();
      } else {
        sideBBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder clearSideB() {
      if (sideBBuilder_ == null) {
        sideB_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        sideBBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public Builder removeSideB(int index) {
      if (sideBBuilder_ == null) {
        ensureSideBIsMutable();
        sideB_.remove(index);
        onChanged();
      } else {
        sideBBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public game.proto.data.HeroDataRecord.Builder getSideBBuilder(
        int index) {
      return getSideBFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public game.proto.data.HeroDataRecordOrBuilder getSideBOrBuilder(
        int index) {
      if (sideBBuilder_ == null) {
        return sideB_.get(index);  } else {
        return sideBBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public java.util.List<? extends game.proto.data.HeroDataRecordOrBuilder> 
         getSideBOrBuilderList() {
      if (sideBBuilder_ != null) {
        return sideBBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(sideB_);
      }
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public game.proto.data.HeroDataRecord.Builder addSideBBuilder() {
      return getSideBFieldBuilder().addBuilder(
          game.proto.data.HeroDataRecord.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public game.proto.data.HeroDataRecord.Builder addSideBBuilder(
        int index) {
      return getSideBFieldBuilder().addBuilder(
          index, game.proto.data.HeroDataRecord.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HeroDataRecord sideB = 3;</code>
     */
    public java.util.List<game.proto.data.HeroDataRecord.Builder> 
         getSideBBuilderList() {
      return getSideBFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder> 
        getSideBFieldBuilder() {
      if (sideBBuilder_ == null) {
        sideBBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.HeroDataRecord, game.proto.data.HeroDataRecord.Builder, game.proto.data.HeroDataRecordOrBuilder>(
                sideB_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        sideB_ = null;
      }
      return sideBBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.FightHmStartRes)
  }

  // @@protoc_insertion_point(class_scope:Message.FightHmStartRes)
  private static final game.proto.FightHmStartRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FightHmStartRes();
  }

  public static game.proto.FightHmStartRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FightHmStartRes>
      PARSER = new com.google.protobuf.AbstractParser<FightHmStartRes>() {
    @java.lang.Override
    public FightHmStartRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FightHmStartRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FightHmStartRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FightHmStartRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FightHmStartRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

