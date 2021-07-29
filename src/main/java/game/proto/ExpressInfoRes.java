// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 跑镖信息
 * </pre>
 *
 * Protobuf type {@code Message.ExpressInfoRes}
 */
public final class ExpressInfoRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.ExpressInfoRes)
    ExpressInfoResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExpressInfoRes.newBuilder() to construct.
  private ExpressInfoRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExpressInfoRes() {
    info_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExpressInfoRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExpressInfoRes(
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
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              info_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            info_.addInt(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              info_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              info_.addInt(input.readInt32());
            }
            input.popLimit(limit);
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
        info_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_ExpressInfoRes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_ExpressInfoRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.ExpressInfoRes.class, game.proto.ExpressInfoRes.Builder.class);
  }

  public static final int INFO_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.IntList info_;
  /**
   * <code>repeated int32 info = 1;</code>
   * @return A list containing the info.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getInfoList() {
    return info_;
  }
  /**
   * <code>repeated int32 info = 1;</code>
   * @return The count of info.
   */
  public int getInfoCount() {
    return info_.size();
  }
  /**
   * <code>repeated int32 info = 1;</code>
   * @param index The index of the element to return.
   * @return The info at the given index.
   */
  public int getInfo(int index) {
    return info_.getInt(index);
  }
  private int infoMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (getInfoList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(infoMemoizedSerializedSize);
    }
    for (int i = 0; i < info_.size(); i++) {
      output.writeInt32NoTag(info_.getInt(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < info_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(info_.getInt(i));
      }
      size += dataSize;
      if (!getInfoList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      infoMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof game.proto.ExpressInfoRes)) {
      return super.equals(obj);
    }
    game.proto.ExpressInfoRes other = (game.proto.ExpressInfoRes) obj;

    if (!getInfoList()
        .equals(other.getInfoList())) return false;
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
    if (getInfoCount() > 0) {
      hash = (37 * hash) + INFO_FIELD_NUMBER;
      hash = (53 * hash) + getInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.ExpressInfoRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ExpressInfoRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ExpressInfoRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ExpressInfoRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.ExpressInfoRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ExpressInfoRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ExpressInfoRes parseFrom(
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
  public static Builder newBuilder(game.proto.ExpressInfoRes prototype) {
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
   * 跑镖信息
   * </pre>
   *
   * Protobuf type {@code Message.ExpressInfoRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.ExpressInfoRes)
      game.proto.ExpressInfoResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_ExpressInfoRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_ExpressInfoRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.ExpressInfoRes.class, game.proto.ExpressInfoRes.Builder.class);
    }

    // Construct using game.proto.ExpressInfoRes.newBuilder()
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
      info_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_ExpressInfoRes_descriptor;
    }

    @java.lang.Override
    public game.proto.ExpressInfoRes getDefaultInstanceForType() {
      return game.proto.ExpressInfoRes.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.ExpressInfoRes build() {
      game.proto.ExpressInfoRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.ExpressInfoRes buildPartial() {
      game.proto.ExpressInfoRes result = new game.proto.ExpressInfoRes(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        info_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.info_ = info_;
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
      if (other instanceof game.proto.ExpressInfoRes) {
        return mergeFrom((game.proto.ExpressInfoRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.ExpressInfoRes other) {
      if (other == game.proto.ExpressInfoRes.getDefaultInstance()) return this;
      if (!other.info_.isEmpty()) {
        if (info_.isEmpty()) {
          info_ = other.info_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureInfoIsMutable();
          info_.addAll(other.info_);
        }
        onChanged();
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
      game.proto.ExpressInfoRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.ExpressInfoRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.Internal.IntList info_ = emptyIntList();
    private void ensureInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        info_ = mutableCopy(info_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @return A list containing the info.
     */
    public java.util.List<java.lang.Integer>
        getInfoList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(info_) : info_;
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @return The count of info.
     */
    public int getInfoCount() {
      return info_.size();
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @param index The index of the element to return.
     * @return The info at the given index.
     */
    public int getInfo(int index) {
      return info_.getInt(index);
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @param index The index to set the value at.
     * @param value The info to set.
     * @return This builder for chaining.
     */
    public Builder setInfo(
        int index, int value) {
      ensureInfoIsMutable();
      info_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @param value The info to add.
     * @return This builder for chaining.
     */
    public Builder addInfo(int value) {
      ensureInfoIsMutable();
      info_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @param values The info to add.
     * @return This builder for chaining.
     */
    public Builder addAllInfo(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureInfoIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, info_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 info = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearInfo() {
      info_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:Message.ExpressInfoRes)
  }

  // @@protoc_insertion_point(class_scope:Message.ExpressInfoRes)
  private static final game.proto.ExpressInfoRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.ExpressInfoRes();
  }

  public static game.proto.ExpressInfoRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExpressInfoRes>
      PARSER = new com.google.protobuf.AbstractParser<ExpressInfoRes>() {
    @java.lang.Override
    public ExpressInfoRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExpressInfoRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExpressInfoRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExpressInfoRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.ExpressInfoRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

