// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 2002 发生战斗推送
 * </pre>
 *
 * Protobuf type {@code Message.FightStartPush}
 */
public final class FightStartPush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FightStartPush)
    FightStartPushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FightStartPush.newBuilder() to construct.
  private FightStartPush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FightStartPush() {
    info_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FightStartPush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FightStartPush(
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              info_ = new java.util.ArrayList<game.proto.data.FightEnemyInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            info_.add(
                input.readMessage(game.proto.data.FightEnemyInfo.parser(), extensionRegistry));
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
        info_ = java.util.Collections.unmodifiableList(info_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_FightStartPush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FightStartPush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FightStartPush.class, game.proto.FightStartPush.Builder.class);
  }

  public static final int INFO_FIELD_NUMBER = 1;
  private java.util.List<game.proto.data.FightEnemyInfo> info_;
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.FightEnemyInfo> getInfoList() {
    return info_;
  }
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.FightEnemyInfoOrBuilder> 
      getInfoOrBuilderList() {
    return info_;
  }
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  @java.lang.Override
  public int getInfoCount() {
    return info_.size();
  }
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  @java.lang.Override
  public game.proto.data.FightEnemyInfo getInfo(int index) {
    return info_.get(index);
  }
  /**
   * <code>repeated .Message.FightEnemyInfo info = 1;</code>
   */
  @java.lang.Override
  public game.proto.data.FightEnemyInfoOrBuilder getInfoOrBuilder(
      int index) {
    return info_.get(index);
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
    for (int i = 0; i < info_.size(); i++) {
      output.writeMessage(1, info_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < info_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, info_.get(i));
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
    if (!(obj instanceof game.proto.FightStartPush)) {
      return super.equals(obj);
    }
    game.proto.FightStartPush other = (game.proto.FightStartPush) obj;

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

  public static game.proto.FightStartPush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartPush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartPush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartPush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartPush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartPush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartPush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightStartPush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightStartPush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FightStartPush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightStartPush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightStartPush parseFrom(
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
  public static Builder newBuilder(game.proto.FightStartPush prototype) {
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
   * 2002 发生战斗推送
   * </pre>
   *
   * Protobuf type {@code Message.FightStartPush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FightStartPush)
      game.proto.FightStartPushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartPush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartPush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FightStartPush.class, game.proto.FightStartPush.Builder.class);
    }

    // Construct using game.proto.FightStartPush.newBuilder()
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
        getInfoFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (infoBuilder_ == null) {
        info_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        infoBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartPush_descriptor;
    }

    @java.lang.Override
    public game.proto.FightStartPush getDefaultInstanceForType() {
      return game.proto.FightStartPush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FightStartPush build() {
      game.proto.FightStartPush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FightStartPush buildPartial() {
      game.proto.FightStartPush result = new game.proto.FightStartPush(this);
      int from_bitField0_ = bitField0_;
      if (infoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          info_ = java.util.Collections.unmodifiableList(info_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.info_ = info_;
      } else {
        result.info_ = infoBuilder_.build();
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
      if (other instanceof game.proto.FightStartPush) {
        return mergeFrom((game.proto.FightStartPush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FightStartPush other) {
      if (other == game.proto.FightStartPush.getDefaultInstance()) return this;
      if (infoBuilder_ == null) {
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
      } else {
        if (!other.info_.isEmpty()) {
          if (infoBuilder_.isEmpty()) {
            infoBuilder_.dispose();
            infoBuilder_ = null;
            info_ = other.info_;
            bitField0_ = (bitField0_ & ~0x00000001);
            infoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInfoFieldBuilder() : null;
          } else {
            infoBuilder_.addAllMessages(other.info_);
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
      game.proto.FightStartPush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FightStartPush) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<game.proto.data.FightEnemyInfo> info_ =
      java.util.Collections.emptyList();
    private void ensureInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        info_ = new java.util.ArrayList<game.proto.data.FightEnemyInfo>(info_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.FightEnemyInfo, game.proto.data.FightEnemyInfo.Builder, game.proto.data.FightEnemyInfoOrBuilder> infoBuilder_;

    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public java.util.List<game.proto.data.FightEnemyInfo> getInfoList() {
      if (infoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(info_);
      } else {
        return infoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public int getInfoCount() {
      if (infoBuilder_ == null) {
        return info_.size();
      } else {
        return infoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public game.proto.data.FightEnemyInfo getInfo(int index) {
      if (infoBuilder_ == null) {
        return info_.get(index);
      } else {
        return infoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder setInfo(
        int index, game.proto.data.FightEnemyInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.set(index, value);
        onChanged();
      } else {
        infoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder setInfo(
        int index, game.proto.data.FightEnemyInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.set(index, builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder addInfo(game.proto.data.FightEnemyInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.add(value);
        onChanged();
      } else {
        infoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder addInfo(
        int index, game.proto.data.FightEnemyInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.add(index, value);
        onChanged();
      } else {
        infoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder addInfo(
        game.proto.data.FightEnemyInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.add(builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder addInfo(
        int index, game.proto.data.FightEnemyInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.add(index, builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder addAllInfo(
        java.lang.Iterable<? extends game.proto.data.FightEnemyInfo> values) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, info_);
        onChanged();
      } else {
        infoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder clearInfo() {
      if (infoBuilder_ == null) {
        info_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        infoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public Builder removeInfo(int index) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.remove(index);
        onChanged();
      } else {
        infoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public game.proto.data.FightEnemyInfo.Builder getInfoBuilder(
        int index) {
      return getInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public game.proto.data.FightEnemyInfoOrBuilder getInfoOrBuilder(
        int index) {
      if (infoBuilder_ == null) {
        return info_.get(index);  } else {
        return infoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public java.util.List<? extends game.proto.data.FightEnemyInfoOrBuilder> 
         getInfoOrBuilderList() {
      if (infoBuilder_ != null) {
        return infoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(info_);
      }
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public game.proto.data.FightEnemyInfo.Builder addInfoBuilder() {
      return getInfoFieldBuilder().addBuilder(
          game.proto.data.FightEnemyInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public game.proto.data.FightEnemyInfo.Builder addInfoBuilder(
        int index) {
      return getInfoFieldBuilder().addBuilder(
          index, game.proto.data.FightEnemyInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.FightEnemyInfo info = 1;</code>
     */
    public java.util.List<game.proto.data.FightEnemyInfo.Builder> 
         getInfoBuilderList() {
      return getInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.FightEnemyInfo, game.proto.data.FightEnemyInfo.Builder, game.proto.data.FightEnemyInfoOrBuilder> 
        getInfoFieldBuilder() {
      if (infoBuilder_ == null) {
        infoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.FightEnemyInfo, game.proto.data.FightEnemyInfo.Builder, game.proto.data.FightEnemyInfoOrBuilder>(
                info_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        info_ = null;
      }
      return infoBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.FightStartPush)
  }

  // @@protoc_insertion_point(class_scope:Message.FightStartPush)
  private static final game.proto.FightStartPush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FightStartPush();
  }

  public static game.proto.FightStartPush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FightStartPush>
      PARSER = new com.google.protobuf.AbstractParser<FightStartPush>() {
    @java.lang.Override
    public FightStartPush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FightStartPush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FightStartPush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FightStartPush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FightStartPush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

