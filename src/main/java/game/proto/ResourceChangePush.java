// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 5001 资源变化
 * </pre>
 *
 * Protobuf type {@code Message.ResourceChangePush}
 */
public final class ResourceChangePush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.ResourceChangePush)
    ResourceChangePushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResourceChangePush.newBuilder() to construct.
  private ResourceChangePush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResourceChangePush() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResourceChangePush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ResourceChangePush(
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

            resourceId_ = input.readInt32();
            break;
          }
          case 16: {

            heroId_ = input.readInt32();
            break;
          }
          case 24: {

            count_ = input.readInt32();
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
    return game.proto.MessageOuterClass.internal_static_Message_ResourceChangePush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_ResourceChangePush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.ResourceChangePush.class, game.proto.ResourceChangePush.Builder.class);
  }

  public static final int RESOURCEID_FIELD_NUMBER = 1;
  private int resourceId_;
  /**
   * <code>int32 resourceId = 1;</code>
   * @return The resourceId.
   */
  @java.lang.Override
  public int getResourceId() {
    return resourceId_;
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

  public static final int COUNT_FIELD_NUMBER = 3;
  private int count_;
  /**
   * <code>int32 count = 3;</code>
   * @return The count.
   */
  @java.lang.Override
  public int getCount() {
    return count_;
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
    if (resourceId_ != 0) {
      output.writeInt32(1, resourceId_);
    }
    if (heroId_ != 0) {
      output.writeInt32(2, heroId_);
    }
    if (count_ != 0) {
      output.writeInt32(3, count_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (resourceId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, resourceId_);
    }
    if (heroId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, heroId_);
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, count_);
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
    if (!(obj instanceof game.proto.ResourceChangePush)) {
      return super.equals(obj);
    }
    game.proto.ResourceChangePush other = (game.proto.ResourceChangePush) obj;

    if (getResourceId()
        != other.getResourceId()) return false;
    if (getHeroId()
        != other.getHeroId()) return false;
    if (getCount()
        != other.getCount()) return false;
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
    hash = (37 * hash) + RESOURCEID_FIELD_NUMBER;
    hash = (53 * hash) + getResourceId();
    hash = (37 * hash) + HEROID_FIELD_NUMBER;
    hash = (53 * hash) + getHeroId();
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.ResourceChangePush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ResourceChangePush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ResourceChangePush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ResourceChangePush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ResourceChangePush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ResourceChangePush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ResourceChangePush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ResourceChangePush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ResourceChangePush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.ResourceChangePush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ResourceChangePush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ResourceChangePush parseFrom(
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
  public static Builder newBuilder(game.proto.ResourceChangePush prototype) {
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
   * 5001 资源变化
   * </pre>
   *
   * Protobuf type {@code Message.ResourceChangePush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.ResourceChangePush)
      game.proto.ResourceChangePushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_ResourceChangePush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_ResourceChangePush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.ResourceChangePush.class, game.proto.ResourceChangePush.Builder.class);
    }

    // Construct using game.proto.ResourceChangePush.newBuilder()
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
      resourceId_ = 0;

      heroId_ = 0;

      count_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_ResourceChangePush_descriptor;
    }

    @java.lang.Override
    public game.proto.ResourceChangePush getDefaultInstanceForType() {
      return game.proto.ResourceChangePush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.ResourceChangePush build() {
      game.proto.ResourceChangePush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.ResourceChangePush buildPartial() {
      game.proto.ResourceChangePush result = new game.proto.ResourceChangePush(this);
      result.resourceId_ = resourceId_;
      result.heroId_ = heroId_;
      result.count_ = count_;
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
      if (other instanceof game.proto.ResourceChangePush) {
        return mergeFrom((game.proto.ResourceChangePush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.ResourceChangePush other) {
      if (other == game.proto.ResourceChangePush.getDefaultInstance()) return this;
      if (other.getResourceId() != 0) {
        setResourceId(other.getResourceId());
      }
      if (other.getHeroId() != 0) {
        setHeroId(other.getHeroId());
      }
      if (other.getCount() != 0) {
        setCount(other.getCount());
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
      game.proto.ResourceChangePush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.ResourceChangePush) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int resourceId_ ;
    /**
     * <code>int32 resourceId = 1;</code>
     * @return The resourceId.
     */
    @java.lang.Override
    public int getResourceId() {
      return resourceId_;
    }
    /**
     * <code>int32 resourceId = 1;</code>
     * @param value The resourceId to set.
     * @return This builder for chaining.
     */
    public Builder setResourceId(int value) {
      
      resourceId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 resourceId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearResourceId() {
      
      resourceId_ = 0;
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

    private int count_ ;
    /**
     * <code>int32 count = 3;</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return count_;
    }
    /**
     * <code>int32 count = 3;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 count = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      
      count_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Message.ResourceChangePush)
  }

  // @@protoc_insertion_point(class_scope:Message.ResourceChangePush)
  private static final game.proto.ResourceChangePush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.ResourceChangePush();
  }

  public static game.proto.ResourceChangePush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResourceChangePush>
      PARSER = new com.google.protobuf.AbstractParser<ResourceChangePush>() {
    @java.lang.Override
    public ResourceChangePush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ResourceChangePush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResourceChangePush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResourceChangePush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.ResourceChangePush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

