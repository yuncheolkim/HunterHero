// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf type {@code Message.ScenePos}
 */
public final class ScenePos extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.ScenePos)
    ScenePosOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ScenePos.newBuilder() to construct.
  private ScenePos(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ScenePos() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ScenePos();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ScenePos(
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
          case 13: {

            x_ = input.readFloat();
            break;
          }
          case 21: {

            y_ = input.readFloat();
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
    return game.proto.data.Data.internal_static_Message_ScenePos_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_ScenePos_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.ScenePos.class, game.proto.data.ScenePos.Builder.class);
  }

  public static final int X_FIELD_NUMBER = 1;
  private float x_;
  /**
   * <code>float x = 1;</code>
   * @return The x.
   */
  @java.lang.Override
  public float getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private float y_;
  /**
   * <code>float y = 2;</code>
   * @return The y.
   */
  @java.lang.Override
  public float getY() {
    return y_;
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
    if (x_ != 0F) {
      output.writeFloat(1, x_);
    }
    if (y_ != 0F) {
      output.writeFloat(2, y_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (x_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, x_);
    }
    if (y_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, y_);
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
    if (!(obj instanceof game.proto.data.ScenePos)) {
      return super.equals(obj);
    }
    game.proto.data.ScenePos other = (game.proto.data.ScenePos) obj;

    if (java.lang.Float.floatToIntBits(getX())
        != java.lang.Float.floatToIntBits(
            other.getX())) return false;
    if (java.lang.Float.floatToIntBits(getY())
        != java.lang.Float.floatToIntBits(
            other.getY())) return false;
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
    hash = (37 * hash) + X_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getX());
    hash = (37 * hash) + Y_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getY());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.ScenePos parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.ScenePos parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.ScenePos parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.ScenePos parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.ScenePos parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.ScenePos parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.ScenePos parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.ScenePos parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.ScenePos parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.ScenePos parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.ScenePos parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.ScenePos parseFrom(
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
  public static Builder newBuilder(game.proto.data.ScenePos prototype) {
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
   * Protobuf type {@code Message.ScenePos}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.ScenePos)
      game.proto.data.ScenePosOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_ScenePos_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_ScenePos_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.ScenePos.class, game.proto.data.ScenePos.Builder.class);
    }

    // Construct using game.proto.data.ScenePos.newBuilder()
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
      x_ = 0F;

      y_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_ScenePos_descriptor;
    }

    @java.lang.Override
    public game.proto.data.ScenePos getDefaultInstanceForType() {
      return game.proto.data.ScenePos.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.ScenePos build() {
      game.proto.data.ScenePos result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.ScenePos buildPartial() {
      game.proto.data.ScenePos result = new game.proto.data.ScenePos(this);
      result.x_ = x_;
      result.y_ = y_;
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
      if (other instanceof game.proto.data.ScenePos) {
        return mergeFrom((game.proto.data.ScenePos)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.ScenePos other) {
      if (other == game.proto.data.ScenePos.getDefaultInstance()) return this;
      if (other.getX() != 0F) {
        setX(other.getX());
      }
      if (other.getY() != 0F) {
        setY(other.getY());
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
      game.proto.data.ScenePos parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.ScenePos) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float x_ ;
    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public float getX() {
      return x_;
    }
    /**
     * <code>float x = 1;</code>
     * @param value The x to set.
     * @return This builder for chaining.
     */
    public Builder setX(float value) {
      
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float x = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearX() {
      
      x_ = 0F;
      onChanged();
      return this;
    }

    private float y_ ;
    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public float getY() {
      return y_;
    }
    /**
     * <code>float y = 2;</code>
     * @param value The y to set.
     * @return This builder for chaining.
     */
    public Builder setY(float value) {
      
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float y = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearY() {
      
      y_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:Message.ScenePos)
  }

  // @@protoc_insertion_point(class_scope:Message.ScenePos)
  private static final game.proto.data.ScenePos DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.ScenePos();
  }

  public static game.proto.data.ScenePos getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ScenePos>
      PARSER = new com.google.protobuf.AbstractParser<ScenePos>() {
    @java.lang.Override
    public ScenePos parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ScenePos(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ScenePos> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScenePos> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.ScenePos getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

