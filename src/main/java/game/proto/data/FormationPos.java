// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * 阵型位置
 * </pre>
 *
 * Protobuf type {@code Message.FormationPos}
 */
public final class FormationPos extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FormationPos)
    FormationPosOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FormationPos.newBuilder() to construct.
  private FormationPos(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FormationPos() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FormationPos();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FormationPos(
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
          case 16: {

            heroId_ = input.readInt32();
            break;
          }
          case 24: {

            order_ = input.readInt32();
            break;
          }
          case 32: {

            enhance_ = input.readInt32();
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
    return game.proto.data.Data.internal_static_Message_FormationPos_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_FormationPos_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.FormationPos.class, game.proto.data.FormationPos.Builder.class);
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

  public static final int HEROID_FIELD_NUMBER = 2;
  private int heroId_;
  /**
   * <code>int32 heroId = 2;</code>
   * @return The heroId.
   */
  @java.lang.Override
  public int getHeroId() {
    return heroId_;
  }

  public static final int ORDER_FIELD_NUMBER = 3;
  private int order_;
  /**
   * <code>int32 order = 3;</code>
   * @return The order.
   */
  @java.lang.Override
  public int getOrder() {
    return order_;
  }

  public static final int ENHANCE_FIELD_NUMBER = 4;
  private int enhance_;
  /**
   * <pre>
   * 法阵
   * </pre>
   *
   * <code>int32 enhance = 4;</code>
   * @return The enhance.
   */
  @java.lang.Override
  public int getEnhance() {
    return enhance_;
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
    if (heroId_ != 0) {
      output.writeInt32(2, heroId_);
    }
    if (order_ != 0) {
      output.writeInt32(3, order_);
    }
    if (enhance_ != 0) {
      output.writeInt32(4, enhance_);
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
    if (heroId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, heroId_);
    }
    if (order_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, order_);
    }
    if (enhance_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, enhance_);
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
    if (!(obj instanceof game.proto.data.FormationPos)) {
      return super.equals(obj);
    }
    game.proto.data.FormationPos other = (game.proto.data.FormationPos) obj;

    if (getIndex()
        != other.getIndex()) return false;
    if (getHeroId()
        != other.getHeroId()) return false;
    if (getOrder()
        != other.getOrder()) return false;
    if (getEnhance()
        != other.getEnhance()) return false;
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
    hash = (37 * hash) + HEROID_FIELD_NUMBER;
    hash = (53 * hash) + getHeroId();
    hash = (37 * hash) + ORDER_FIELD_NUMBER;
    hash = (53 * hash) + getOrder();
    hash = (37 * hash) + ENHANCE_FIELD_NUMBER;
    hash = (53 * hash) + getEnhance();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.FormationPos parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.FormationPos parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.FormationPos parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.FormationPos parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.FormationPos parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.FormationPos parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.FormationPos parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.FormationPos parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.FormationPos parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.FormationPos parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.FormationPos parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.FormationPos parseFrom(
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
  public static Builder newBuilder(game.proto.data.FormationPos prototype) {
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
   * 阵型位置
   * </pre>
   *
   * Protobuf type {@code Message.FormationPos}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FormationPos)
      game.proto.data.FormationPosOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_FormationPos_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_FormationPos_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.FormationPos.class, game.proto.data.FormationPos.Builder.class);
    }

    // Construct using game.proto.data.FormationPos.newBuilder()
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

      heroId_ = 0;

      order_ = 0;

      enhance_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_FormationPos_descriptor;
    }

    @java.lang.Override
    public game.proto.data.FormationPos getDefaultInstanceForType() {
      return game.proto.data.FormationPos.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.FormationPos build() {
      game.proto.data.FormationPos result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.FormationPos buildPartial() {
      game.proto.data.FormationPos result = new game.proto.data.FormationPos(this);
      result.index_ = index_;
      result.heroId_ = heroId_;
      result.order_ = order_;
      result.enhance_ = enhance_;
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
      if (other instanceof game.proto.data.FormationPos) {
        return mergeFrom((game.proto.data.FormationPos)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.FormationPos other) {
      if (other == game.proto.data.FormationPos.getDefaultInstance()) return this;
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
      }
      if (other.getHeroId() != 0) {
        setHeroId(other.getHeroId());
      }
      if (other.getOrder() != 0) {
        setOrder(other.getOrder());
      }
      if (other.getEnhance() != 0) {
        setEnhance(other.getEnhance());
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
      game.proto.data.FormationPos parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.FormationPos) e.getUnfinishedMessage();
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

    private int heroId_ ;
    /**
     * <code>int32 heroId = 2;</code>
     * @return The heroId.
     */
    @java.lang.Override
    public int getHeroId() {
      return heroId_;
    }
    /**
     * <code>int32 heroId = 2;</code>
     * @param value The heroId to set.
     * @return This builder for chaining.
     */
    public Builder setHeroId(int value) {
      
      heroId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 heroId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearHeroId() {
      
      heroId_ = 0;
      onChanged();
      return this;
    }

    private int order_ ;
    /**
     * <code>int32 order = 3;</code>
     * @return The order.
     */
    @java.lang.Override
    public int getOrder() {
      return order_;
    }
    /**
     * <code>int32 order = 3;</code>
     * @param value The order to set.
     * @return This builder for chaining.
     */
    public Builder setOrder(int value) {
      
      order_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 order = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOrder() {
      
      order_ = 0;
      onChanged();
      return this;
    }

    private int enhance_ ;
    /**
     * <pre>
     * 法阵
     * </pre>
     *
     * <code>int32 enhance = 4;</code>
     * @return The enhance.
     */
    @java.lang.Override
    public int getEnhance() {
      return enhance_;
    }
    /**
     * <pre>
     * 法阵
     * </pre>
     *
     * <code>int32 enhance = 4;</code>
     * @param value The enhance to set.
     * @return This builder for chaining.
     */
    public Builder setEnhance(int value) {
      
      enhance_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 法阵
     * </pre>
     *
     * <code>int32 enhance = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearEnhance() {
      
      enhance_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Message.FormationPos)
  }

  // @@protoc_insertion_point(class_scope:Message.FormationPos)
  private static final game.proto.data.FormationPos DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.FormationPos();
  }

  public static game.proto.data.FormationPos getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FormationPos>
      PARSER = new com.google.protobuf.AbstractParser<FormationPos>() {
    @java.lang.Override
    public FormationPos parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FormationPos(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FormationPos> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FormationPos> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.FormationPos getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

