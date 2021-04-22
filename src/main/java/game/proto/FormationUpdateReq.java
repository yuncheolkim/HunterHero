// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 *&#47;/ 查询阵型
 *message FormationListReq {
 *}
 * // 查询阵型res
 *message FormationListRes {
 *}
 * 更新阵型
 * </pre>
 *
 * Protobuf type {@code Message.FormationUpdateReq}
 */
public final class FormationUpdateReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FormationUpdateReq)
    FormationUpdateReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FormationUpdateReq.newBuilder() to construct.
  private FormationUpdateReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FormationUpdateReq() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FormationUpdateReq();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FormationUpdateReq(
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

            index_ = input.readInt32();
            break;
          }
          case 18: {
            game.proto.data.FormationPos.Builder subBuilder = null;
            if (pos_ != null) {
              subBuilder = pos_.toBuilder();
            }
            pos_ = input.readMessage(game.proto.data.FormationPos.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(pos_);
              pos_ = subBuilder.buildPartial();
            }

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
    return game.proto.MessageOuterClass.internal_static_Message_FormationUpdateReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FormationUpdateReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FormationUpdateReq.class, game.proto.FormationUpdateReq.Builder.class);
  }

  public static final int INDEX_FIELD_NUMBER = 1;
  private int index_;
  /**
   * <code>int32 index = 1;</code>
   * @return The index.
   */
  @java.lang.Override
  public int getIndex() {
    return index_;
  }

  public static final int POS_FIELD_NUMBER = 2;
  private game.proto.data.FormationPos pos_;
  /**
   * <code>.Message.FormationPos pos = 2;</code>
   * @return Whether the pos field is set.
   */
  @java.lang.Override
  public boolean hasPos() {
    return pos_ != null;
  }
  /**
   * <code>.Message.FormationPos pos = 2;</code>
   * @return The pos.
   */
  @java.lang.Override
  public game.proto.data.FormationPos getPos() {
    return pos_ == null ? game.proto.data.FormationPos.getDefaultInstance() : pos_;
  }
  /**
   * <code>.Message.FormationPos pos = 2;</code>
   */
  @java.lang.Override
  public game.proto.data.FormationPosOrBuilder getPosOrBuilder() {
    return getPos();
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
    if (index_ != 0) {
      output.writeInt32(1, index_);
    }
    if (pos_ != null) {
      output.writeMessage(2, getPos());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (index_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, index_);
    }
    if (pos_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPos());
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
    if (!(obj instanceof game.proto.FormationUpdateReq)) {
      return super.equals(obj);
    }
    game.proto.FormationUpdateReq other = (game.proto.FormationUpdateReq) obj;

    if (getIndex()
        != other.getIndex()) return false;
    if (hasPos() != other.hasPos()) return false;
    if (hasPos()) {
      if (!getPos()
          .equals(other.getPos())) return false;
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
    hash = (37 * hash) + INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getIndex();
    if (hasPos()) {
      hash = (37 * hash) + POS_FIELD_NUMBER;
      hash = (53 * hash) + getPos().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FormationUpdateReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationUpdateReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationUpdateReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FormationUpdateReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FormationUpdateReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FormationUpdateReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FormationUpdateReq parseFrom(
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
  public static Builder newBuilder(game.proto.FormationUpdateReq prototype) {
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
   *&#47;/ 查询阵型
   *message FormationListReq {
   *}
   * // 查询阵型res
   *message FormationListRes {
   *}
   * 更新阵型
   * </pre>
   *
   * Protobuf type {@code Message.FormationUpdateReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FormationUpdateReq)
      game.proto.FormationUpdateReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationUpdateReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationUpdateReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FormationUpdateReq.class, game.proto.FormationUpdateReq.Builder.class);
    }

    // Construct using game.proto.FormationUpdateReq.newBuilder()
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
      index_ = 0;

      if (posBuilder_ == null) {
        pos_ = null;
      } else {
        pos_ = null;
        posBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationUpdateReq_descriptor;
    }

    @java.lang.Override
    public game.proto.FormationUpdateReq getDefaultInstanceForType() {
      return game.proto.FormationUpdateReq.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FormationUpdateReq build() {
      game.proto.FormationUpdateReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FormationUpdateReq buildPartial() {
      game.proto.FormationUpdateReq result = new game.proto.FormationUpdateReq(this);
      result.index_ = index_;
      if (posBuilder_ == null) {
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
      if (other instanceof game.proto.FormationUpdateReq) {
        return mergeFrom((game.proto.FormationUpdateReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FormationUpdateReq other) {
      if (other == game.proto.FormationUpdateReq.getDefaultInstance()) return this;
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
      }
      if (other.hasPos()) {
        mergePos(other.getPos());
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
      game.proto.FormationUpdateReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FormationUpdateReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int index_ ;
    /**
     * <code>int32 index = 1;</code>
     * @return The index.
     */
    @java.lang.Override
    public int getIndex() {
      return index_;
    }
    /**
     * <code>int32 index = 1;</code>
     * @param value The index to set.
     * @return This builder for chaining.
     */
    public Builder setIndex(int value) {
      
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 index = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIndex() {
      
      index_ = 0;
      onChanged();
      return this;
    }

    private game.proto.data.FormationPos pos_;
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.FormationPos, game.proto.data.FormationPos.Builder, game.proto.data.FormationPosOrBuilder> posBuilder_;
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     * @return Whether the pos field is set.
     */
    public boolean hasPos() {
      return posBuilder_ != null || pos_ != null;
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     * @return The pos.
     */
    public game.proto.data.FormationPos getPos() {
      if (posBuilder_ == null) {
        return pos_ == null ? game.proto.data.FormationPos.getDefaultInstance() : pos_;
      } else {
        return posBuilder_.getMessage();
      }
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public Builder setPos(game.proto.data.FormationPos value) {
      if (posBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pos_ = value;
        onChanged();
      } else {
        posBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public Builder setPos(
        game.proto.data.FormationPos.Builder builderForValue) {
      if (posBuilder_ == null) {
        pos_ = builderForValue.build();
        onChanged();
      } else {
        posBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public Builder mergePos(game.proto.data.FormationPos value) {
      if (posBuilder_ == null) {
        if (pos_ != null) {
          pos_ =
            game.proto.data.FormationPos.newBuilder(pos_).mergeFrom(value).buildPartial();
        } else {
          pos_ = value;
        }
        onChanged();
      } else {
        posBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public Builder clearPos() {
      if (posBuilder_ == null) {
        pos_ = null;
        onChanged();
      } else {
        pos_ = null;
        posBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public game.proto.data.FormationPos.Builder getPosBuilder() {
      
      onChanged();
      return getPosFieldBuilder().getBuilder();
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    public game.proto.data.FormationPosOrBuilder getPosOrBuilder() {
      if (posBuilder_ != null) {
        return posBuilder_.getMessageOrBuilder();
      } else {
        return pos_ == null ?
            game.proto.data.FormationPos.getDefaultInstance() : pos_;
      }
    }
    /**
     * <code>.Message.FormationPos pos = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.FormationPos, game.proto.data.FormationPos.Builder, game.proto.data.FormationPosOrBuilder> 
        getPosFieldBuilder() {
      if (posBuilder_ == null) {
        posBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            game.proto.data.FormationPos, game.proto.data.FormationPos.Builder, game.proto.data.FormationPosOrBuilder>(
                getPos(),
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


    // @@protoc_insertion_point(builder_scope:Message.FormationUpdateReq)
  }

  // @@protoc_insertion_point(class_scope:Message.FormationUpdateReq)
  private static final game.proto.FormationUpdateReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FormationUpdateReq();
  }

  public static game.proto.FormationUpdateReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FormationUpdateReq>
      PARSER = new com.google.protobuf.AbstractParser<FormationUpdateReq>() {
    @java.lang.Override
    public FormationUpdateReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FormationUpdateReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FormationUpdateReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FormationUpdateReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FormationUpdateReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

