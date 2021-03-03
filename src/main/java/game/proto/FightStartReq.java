// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 2001 开始战斗
 * </pre>
 *
 * Protobuf type {@code Message.FightStartReq}
 */
public final class FightStartReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FightStartReq)
    FightStartReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FightStartReq.newBuilder() to construct.
  private FightStartReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FightStartReq() {
    pos_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FightStartReq();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FightStartReq(
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
              pos_ = new java.util.ArrayList<game.proto.data.FightHeroPos>();
              mutable_bitField0_ |= 0x00000001;
            }
            pos_.add(
                input.readMessage(game.proto.data.FightHeroPos.parser(), extensionRegistry));
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
        pos_ = java.util.Collections.unmodifiableList(pos_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_FightStartReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FightStartReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FightStartReq.class, game.proto.FightStartReq.Builder.class);
  }

  public static final int POS_FIELD_NUMBER = 1;
  private java.util.List<game.proto.data.FightHeroPos> pos_;
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.FightHeroPos> getPosList() {
    return pos_;
  }
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.FightHeroPosOrBuilder> 
      getPosOrBuilderList() {
    return pos_;
  }
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  @java.lang.Override
  public int getPosCount() {
    return pos_.size();
  }
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  @java.lang.Override
  public game.proto.data.FightHeroPos getPos(int index) {
    return pos_.get(index);
  }
  /**
   * <code>repeated .Message.FightHeroPos pos = 1;</code>
   */
  @java.lang.Override
  public game.proto.data.FightHeroPosOrBuilder getPosOrBuilder(
      int index) {
    return pos_.get(index);
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
    for (int i = 0; i < pos_.size(); i++) {
      output.writeMessage(1, pos_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < pos_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, pos_.get(i));
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
    if (!(obj instanceof game.proto.FightStartReq)) {
      return super.equals(obj);
    }
    game.proto.FightStartReq other = (game.proto.FightStartReq) obj;

    if (!getPosList()
        .equals(other.getPosList())) return false;
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
    if (getPosCount() > 0) {
      hash = (37 * hash) + POS_FIELD_NUMBER;
      hash = (53 * hash) + getPosList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FightStartReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightStartReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightStartReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightStartReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightStartReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FightStartReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightStartReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightStartReq parseFrom(
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
  public static Builder newBuilder(game.proto.FightStartReq prototype) {
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
   * 2001 开始战斗
   * </pre>
   *
   * Protobuf type {@code Message.FightStartReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FightStartReq)
      game.proto.FightStartReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FightStartReq.class, game.proto.FightStartReq.Builder.class);
    }

    // Construct using game.proto.FightStartReq.newBuilder()
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
        getPosFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (posBuilder_ == null) {
        pos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        posBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FightStartReq_descriptor;
    }

    @java.lang.Override
    public game.proto.FightStartReq getDefaultInstanceForType() {
      return game.proto.FightStartReq.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FightStartReq build() {
      game.proto.FightStartReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FightStartReq buildPartial() {
      game.proto.FightStartReq result = new game.proto.FightStartReq(this);
      int from_bitField0_ = bitField0_;
      if (posBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          pos_ = java.util.Collections.unmodifiableList(pos_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.pos_ = pos_;
      } else {
        result.pos_ = posBuilder_.build();
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
      if (other instanceof game.proto.FightStartReq) {
        return mergeFrom((game.proto.FightStartReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FightStartReq other) {
      if (other == game.proto.FightStartReq.getDefaultInstance()) return this;
      if (posBuilder_ == null) {
        if (!other.pos_.isEmpty()) {
          if (pos_.isEmpty()) {
            pos_ = other.pos_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePosIsMutable();
            pos_.addAll(other.pos_);
          }
          onChanged();
        }
      } else {
        if (!other.pos_.isEmpty()) {
          if (posBuilder_.isEmpty()) {
            posBuilder_.dispose();
            posBuilder_ = null;
            pos_ = other.pos_;
            bitField0_ = (bitField0_ & ~0x00000001);
            posBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPosFieldBuilder() : null;
          } else {
            posBuilder_.addAllMessages(other.pos_);
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
      game.proto.FightStartReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FightStartReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<game.proto.data.FightHeroPos> pos_ =
      java.util.Collections.emptyList();
    private void ensurePosIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        pos_ = new java.util.ArrayList<game.proto.data.FightHeroPos>(pos_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.FightHeroPos, game.proto.data.FightHeroPos.Builder, game.proto.data.FightHeroPosOrBuilder> posBuilder_;

    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public java.util.List<game.proto.data.FightHeroPos> getPosList() {
      if (posBuilder_ == null) {
        return java.util.Collections.unmodifiableList(pos_);
      } else {
        return posBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public int getPosCount() {
      if (posBuilder_ == null) {
        return pos_.size();
      } else {
        return posBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public game.proto.data.FightHeroPos getPos(int index) {
      if (posBuilder_ == null) {
        return pos_.get(index);
      } else {
        return posBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder setPos(
        int index, game.proto.data.FightHeroPos value) {
      if (posBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePosIsMutable();
        pos_.set(index, value);
        onChanged();
      } else {
        posBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder setPos(
        int index, game.proto.data.FightHeroPos.Builder builderForValue) {
      if (posBuilder_ == null) {
        ensurePosIsMutable();
        pos_.set(index, builderForValue.build());
        onChanged();
      } else {
        posBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder addPos(game.proto.data.FightHeroPos value) {
      if (posBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePosIsMutable();
        pos_.add(value);
        onChanged();
      } else {
        posBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder addPos(
        int index, game.proto.data.FightHeroPos value) {
      if (posBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePosIsMutable();
        pos_.add(index, value);
        onChanged();
      } else {
        posBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder addPos(
        game.proto.data.FightHeroPos.Builder builderForValue) {
      if (posBuilder_ == null) {
        ensurePosIsMutable();
        pos_.add(builderForValue.build());
        onChanged();
      } else {
        posBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder addPos(
        int index, game.proto.data.FightHeroPos.Builder builderForValue) {
      if (posBuilder_ == null) {
        ensurePosIsMutable();
        pos_.add(index, builderForValue.build());
        onChanged();
      } else {
        posBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder addAllPos(
        java.lang.Iterable<? extends game.proto.data.FightHeroPos> values) {
      if (posBuilder_ == null) {
        ensurePosIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, pos_);
        onChanged();
      } else {
        posBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder clearPos() {
      if (posBuilder_ == null) {
        pos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        posBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public Builder removePos(int index) {
      if (posBuilder_ == null) {
        ensurePosIsMutable();
        pos_.remove(index);
        onChanged();
      } else {
        posBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public game.proto.data.FightHeroPos.Builder getPosBuilder(
        int index) {
      return getPosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public game.proto.data.FightHeroPosOrBuilder getPosOrBuilder(
        int index) {
      if (posBuilder_ == null) {
        return pos_.get(index);  } else {
        return posBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public java.util.List<? extends game.proto.data.FightHeroPosOrBuilder> 
         getPosOrBuilderList() {
      if (posBuilder_ != null) {
        return posBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(pos_);
      }
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public game.proto.data.FightHeroPos.Builder addPosBuilder() {
      return getPosFieldBuilder().addBuilder(
          game.proto.data.FightHeroPos.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public game.proto.data.FightHeroPos.Builder addPosBuilder(
        int index) {
      return getPosFieldBuilder().addBuilder(
          index, game.proto.data.FightHeroPos.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.FightHeroPos pos = 1;</code>
     */
    public java.util.List<game.proto.data.FightHeroPos.Builder> 
         getPosBuilderList() {
      return getPosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.FightHeroPos, game.proto.data.FightHeroPos.Builder, game.proto.data.FightHeroPosOrBuilder> 
        getPosFieldBuilder() {
      if (posBuilder_ == null) {
        posBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.FightHeroPos, game.proto.data.FightHeroPos.Builder, game.proto.data.FightHeroPosOrBuilder>(
                pos_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        pos_ = null;
      }
      return posBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.FightStartReq)
  }

  // @@protoc_insertion_point(class_scope:Message.FightStartReq)
  private static final game.proto.FightStartReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FightStartReq();
  }

  public static game.proto.FightStartReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FightStartReq>
      PARSER = new com.google.protobuf.AbstractParser<FightStartReq>() {
    @java.lang.Override
    public FightStartReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FightStartReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FightStartReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FightStartReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FightStartReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

