// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * Protobuf type {@code Message.HomeHarvestRes}
 */
public final class HomeHarvestRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.HomeHarvestRes)
    HomeHarvestResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HomeHarvestRes.newBuilder() to construct.
  private HomeHarvestRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HomeHarvestRes() {
    rect_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new HomeHarvestRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private HomeHarvestRes(
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
          case 24: {

            pos_ = input.readInt32();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              rect_ = new java.util.ArrayList<game.proto.data.HomeRect>();
              mutable_bitField0_ |= 0x00000001;
            }
            rect_.add(
                input.readMessage(game.proto.data.HomeRect.parser(), extensionRegistry));
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
        rect_ = java.util.Collections.unmodifiableList(rect_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_HomeHarvestRes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_HomeHarvestRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.HomeHarvestRes.class, game.proto.HomeHarvestRes.Builder.class);
  }

  public static final int POS_FIELD_NUMBER = 3;
  private int pos_;
  /**
   * <code>int32 pos = 3;</code>
   * @return The pos.
   */
  @java.lang.Override
  public int getPos() {
    return pos_;
  }

  public static final int RECT_FIELD_NUMBER = 4;
  private java.util.List<game.proto.data.HomeRect> rect_;
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.HomeRect> getRectList() {
    return rect_;
  }
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.HomeRectOrBuilder> 
      getRectOrBuilderList() {
    return rect_;
  }
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  @java.lang.Override
  public int getRectCount() {
    return rect_.size();
  }
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  @java.lang.Override
  public game.proto.data.HomeRect getRect(int index) {
    return rect_.get(index);
  }
  /**
   * <code>repeated .Message.HomeRect rect = 4;</code>
   */
  @java.lang.Override
  public game.proto.data.HomeRectOrBuilder getRectOrBuilder(
      int index) {
    return rect_.get(index);
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
    if (pos_ != 0) {
      output.writeInt32(3, pos_);
    }
    for (int i = 0; i < rect_.size(); i++) {
      output.writeMessage(4, rect_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (pos_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, pos_);
    }
    for (int i = 0; i < rect_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, rect_.get(i));
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
    if (!(obj instanceof game.proto.HomeHarvestRes)) {
      return super.equals(obj);
    }
    game.proto.HomeHarvestRes other = (game.proto.HomeHarvestRes) obj;

    if (getPos()
        != other.getPos()) return false;
    if (!getRectList()
        .equals(other.getRectList())) return false;
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
    hash = (37 * hash) + POS_FIELD_NUMBER;
    hash = (53 * hash) + getPos();
    if (getRectCount() > 0) {
      hash = (37 * hash) + RECT_FIELD_NUMBER;
      hash = (53 * hash) + getRectList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.HomeHarvestRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.HomeHarvestRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.HomeHarvestRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.HomeHarvestRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.HomeHarvestRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.HomeHarvestRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.HomeHarvestRes parseFrom(
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
  public static Builder newBuilder(game.proto.HomeHarvestRes prototype) {
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
   * Protobuf type {@code Message.HomeHarvestRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.HomeHarvestRes)
      game.proto.HomeHarvestResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_HomeHarvestRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_HomeHarvestRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.HomeHarvestRes.class, game.proto.HomeHarvestRes.Builder.class);
    }

    // Construct using game.proto.HomeHarvestRes.newBuilder()
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
        getRectFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pos_ = 0;

      if (rectBuilder_ == null) {
        rect_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        rectBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_HomeHarvestRes_descriptor;
    }

    @java.lang.Override
    public game.proto.HomeHarvestRes getDefaultInstanceForType() {
      return game.proto.HomeHarvestRes.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.HomeHarvestRes build() {
      game.proto.HomeHarvestRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.HomeHarvestRes buildPartial() {
      game.proto.HomeHarvestRes result = new game.proto.HomeHarvestRes(this);
      int from_bitField0_ = bitField0_;
      result.pos_ = pos_;
      if (rectBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          rect_ = java.util.Collections.unmodifiableList(rect_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.rect_ = rect_;
      } else {
        result.rect_ = rectBuilder_.build();
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
      if (other instanceof game.proto.HomeHarvestRes) {
        return mergeFrom((game.proto.HomeHarvestRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.HomeHarvestRes other) {
      if (other == game.proto.HomeHarvestRes.getDefaultInstance()) return this;
      if (other.getPos() != 0) {
        setPos(other.getPos());
      }
      if (rectBuilder_ == null) {
        if (!other.rect_.isEmpty()) {
          if (rect_.isEmpty()) {
            rect_ = other.rect_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRectIsMutable();
            rect_.addAll(other.rect_);
          }
          onChanged();
        }
      } else {
        if (!other.rect_.isEmpty()) {
          if (rectBuilder_.isEmpty()) {
            rectBuilder_.dispose();
            rectBuilder_ = null;
            rect_ = other.rect_;
            bitField0_ = (bitField0_ & ~0x00000001);
            rectBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRectFieldBuilder() : null;
          } else {
            rectBuilder_.addAllMessages(other.rect_);
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
      game.proto.HomeHarvestRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.HomeHarvestRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int pos_ ;
    /**
     * <code>int32 pos = 3;</code>
     * @return The pos.
     */
    @java.lang.Override
    public int getPos() {
      return pos_;
    }
    /**
     * <code>int32 pos = 3;</code>
     * @param value The pos to set.
     * @return This builder for chaining.
     */
    public Builder setPos(int value) {
      
      pos_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 pos = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPos() {
      
      pos_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<game.proto.data.HomeRect> rect_ =
      java.util.Collections.emptyList();
    private void ensureRectIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        rect_ = new java.util.ArrayList<game.proto.data.HomeRect>(rect_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HomeRect, game.proto.data.HomeRect.Builder, game.proto.data.HomeRectOrBuilder> rectBuilder_;

    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public java.util.List<game.proto.data.HomeRect> getRectList() {
      if (rectBuilder_ == null) {
        return java.util.Collections.unmodifiableList(rect_);
      } else {
        return rectBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public int getRectCount() {
      if (rectBuilder_ == null) {
        return rect_.size();
      } else {
        return rectBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public game.proto.data.HomeRect getRect(int index) {
      if (rectBuilder_ == null) {
        return rect_.get(index);
      } else {
        return rectBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder setRect(
        int index, game.proto.data.HomeRect value) {
      if (rectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRectIsMutable();
        rect_.set(index, value);
        onChanged();
      } else {
        rectBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder setRect(
        int index, game.proto.data.HomeRect.Builder builderForValue) {
      if (rectBuilder_ == null) {
        ensureRectIsMutable();
        rect_.set(index, builderForValue.build());
        onChanged();
      } else {
        rectBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder addRect(game.proto.data.HomeRect value) {
      if (rectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRectIsMutable();
        rect_.add(value);
        onChanged();
      } else {
        rectBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder addRect(
        int index, game.proto.data.HomeRect value) {
      if (rectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRectIsMutable();
        rect_.add(index, value);
        onChanged();
      } else {
        rectBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder addRect(
        game.proto.data.HomeRect.Builder builderForValue) {
      if (rectBuilder_ == null) {
        ensureRectIsMutable();
        rect_.add(builderForValue.build());
        onChanged();
      } else {
        rectBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder addRect(
        int index, game.proto.data.HomeRect.Builder builderForValue) {
      if (rectBuilder_ == null) {
        ensureRectIsMutable();
        rect_.add(index, builderForValue.build());
        onChanged();
      } else {
        rectBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder addAllRect(
        java.lang.Iterable<? extends game.proto.data.HomeRect> values) {
      if (rectBuilder_ == null) {
        ensureRectIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, rect_);
        onChanged();
      } else {
        rectBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder clearRect() {
      if (rectBuilder_ == null) {
        rect_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        rectBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public Builder removeRect(int index) {
      if (rectBuilder_ == null) {
        ensureRectIsMutable();
        rect_.remove(index);
        onChanged();
      } else {
        rectBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public game.proto.data.HomeRect.Builder getRectBuilder(
        int index) {
      return getRectFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public game.proto.data.HomeRectOrBuilder getRectOrBuilder(
        int index) {
      if (rectBuilder_ == null) {
        return rect_.get(index);  } else {
        return rectBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public java.util.List<? extends game.proto.data.HomeRectOrBuilder> 
         getRectOrBuilderList() {
      if (rectBuilder_ != null) {
        return rectBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(rect_);
      }
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public game.proto.data.HomeRect.Builder addRectBuilder() {
      return getRectFieldBuilder().addBuilder(
          game.proto.data.HomeRect.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public game.proto.data.HomeRect.Builder addRectBuilder(
        int index) {
      return getRectFieldBuilder().addBuilder(
          index, game.proto.data.HomeRect.getDefaultInstance());
    }
    /**
     * <code>repeated .Message.HomeRect rect = 4;</code>
     */
    public java.util.List<game.proto.data.HomeRect.Builder> 
         getRectBuilderList() {
      return getRectFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.HomeRect, game.proto.data.HomeRect.Builder, game.proto.data.HomeRectOrBuilder> 
        getRectFieldBuilder() {
      if (rectBuilder_ == null) {
        rectBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.HomeRect, game.proto.data.HomeRect.Builder, game.proto.data.HomeRectOrBuilder>(
                rect_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        rect_ = null;
      }
      return rectBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.HomeHarvestRes)
  }

  // @@protoc_insertion_point(class_scope:Message.HomeHarvestRes)
  private static final game.proto.HomeHarvestRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.HomeHarvestRes();
  }

  public static game.proto.HomeHarvestRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HomeHarvestRes>
      PARSER = new com.google.protobuf.AbstractParser<HomeHarvestRes>() {
    @java.lang.Override
    public HomeHarvestRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HomeHarvestRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HomeHarvestRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HomeHarvestRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.HomeHarvestRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
