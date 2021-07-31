// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * <pre>
 * 地图中位置信息
 * </pre>
 *
 * Protobuf type {@code Message.HomePosData}
 */
public final class HomePosData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.HomePosData)
    HomePosDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HomePosData.newBuilder() to construct.
  private HomePosData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HomePosData() {
    type_ = 0;
    body_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new HomePosData();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private HomePosData(
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

            pos_ = input.readInt32();
            break;
          }
          case 16: {

            id_ = input.readInt32();
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          case 82: {

            body_ = input.readBytes();
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
    return game.proto.data.Data.internal_static_Message_HomePosData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_HomePosData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.HomePosData.class, game.proto.data.HomePosData.Builder.class);
  }

  public static final int POS_FIELD_NUMBER = 1;
  private int pos_;
  /**
   * <pre>
   * |---16:x ---|--- 16:y ---|
   * </pre>
   *
   * <code>int32 pos = 1;</code>
   * @return The pos.
   */
  @java.lang.Override
  public int getPos() {
    return pos_;
  }

  public static final int ID_FIELD_NUMBER = 2;
  private int id_;
  /**
   * <code>int32 id = 2;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int TYPE_FIELD_NUMBER = 3;
  private int type_;
  /**
   * <code>.Message.HomeType type = 3;</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.Message.HomeType type = 3;</code>
   * @return The type.
   */
  @java.lang.Override public game.proto.data.HomeType getType() {
    @SuppressWarnings("deprecation")
    game.proto.data.HomeType result = game.proto.data.HomeType.valueOf(type_);
    return result == null ? game.proto.data.HomeType.UNRECOGNIZED : result;
  }

  public static final int BODY_FIELD_NUMBER = 10;
  private com.google.protobuf.ByteString body_;
  /**
   * <pre>
   * 对应不同类型不同数据结构
   * </pre>
   *
   * <code>bytes body = 10;</code>
   * @return The body.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getBody() {
    return body_;
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
      output.writeInt32(1, pos_);
    }
    if (id_ != 0) {
      output.writeInt32(2, id_);
    }
    if (type_ != game.proto.data.HomeType.H_NONE.getNumber()) {
      output.writeEnum(3, type_);
    }
    if (!body_.isEmpty()) {
      output.writeBytes(10, body_);
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
        .computeInt32Size(1, pos_);
    }
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, id_);
    }
    if (type_ != game.proto.data.HomeType.H_NONE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, type_);
    }
    if (!body_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(10, body_);
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
    if (!(obj instanceof game.proto.data.HomePosData)) {
      return super.equals(obj);
    }
    game.proto.data.HomePosData other = (game.proto.data.HomePosData) obj;

    if (getPos()
        != other.getPos()) return false;
    if (getId()
        != other.getId()) return false;
    if (type_ != other.type_) return false;
    if (!getBody()
        .equals(other.getBody())) return false;
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + BODY_FIELD_NUMBER;
    hash = (53 * hash) + getBody().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.HomePosData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.HomePosData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.HomePosData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.HomePosData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.HomePosData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.HomePosData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.HomePosData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.HomePosData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.HomePosData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.HomePosData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.HomePosData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.HomePosData parseFrom(
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
  public static Builder newBuilder(game.proto.data.HomePosData prototype) {
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
   * 地图中位置信息
   * </pre>
   *
   * Protobuf type {@code Message.HomePosData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.HomePosData)
      game.proto.data.HomePosDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_HomePosData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_HomePosData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.HomePosData.class, game.proto.data.HomePosData.Builder.class);
    }

    // Construct using game.proto.data.HomePosData.newBuilder()
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
      pos_ = 0;

      id_ = 0;

      type_ = 0;

      body_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_HomePosData_descriptor;
    }

    @java.lang.Override
    public game.proto.data.HomePosData getDefaultInstanceForType() {
      return game.proto.data.HomePosData.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.HomePosData build() {
      game.proto.data.HomePosData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.HomePosData buildPartial() {
      game.proto.data.HomePosData result = new game.proto.data.HomePosData(this);
      result.pos_ = pos_;
      result.id_ = id_;
      result.type_ = type_;
      result.body_ = body_;
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
      if (other instanceof game.proto.data.HomePosData) {
        return mergeFrom((game.proto.data.HomePosData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.HomePosData other) {
      if (other == game.proto.data.HomePosData.getDefaultInstance()) return this;
      if (other.getPos() != 0) {
        setPos(other.getPos());
      }
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.getBody() != com.google.protobuf.ByteString.EMPTY) {
        setBody(other.getBody());
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
      game.proto.data.HomePosData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.HomePosData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int pos_ ;
    /**
     * <pre>
     * |---16:x ---|--- 16:y ---|
     * </pre>
     *
     * <code>int32 pos = 1;</code>
     * @return The pos.
     */
    @java.lang.Override
    public int getPos() {
      return pos_;
    }
    /**
     * <pre>
     * |---16:x ---|--- 16:y ---|
     * </pre>
     *
     * <code>int32 pos = 1;</code>
     * @param value The pos to set.
     * @return This builder for chaining.
     */
    public Builder setPos(int value) {
      
      pos_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * |---16:x ---|--- 16:y ---|
     * </pre>
     *
     * <code>int32 pos = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPos() {
      
      pos_ = 0;
      onChanged();
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 2;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 2;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.Message.HomeType type = 3;</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.Message.HomeType type = 3;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Message.HomeType type = 3;</code>
     * @return The type.
     */
    @java.lang.Override
    public game.proto.data.HomeType getType() {
      @SuppressWarnings("deprecation")
      game.proto.data.HomeType result = game.proto.data.HomeType.valueOf(type_);
      return result == null ? game.proto.data.HomeType.UNRECOGNIZED : result;
    }
    /**
     * <code>.Message.HomeType type = 3;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(game.proto.data.HomeType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Message.HomeType type = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString body_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * 对应不同类型不同数据结构
     * </pre>
     *
     * <code>bytes body = 10;</code>
     * @return The body.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getBody() {
      return body_;
    }
    /**
     * <pre>
     * 对应不同类型不同数据结构
     * </pre>
     *
     * <code>bytes body = 10;</code>
     * @param value The body to set.
     * @return This builder for chaining.
     */
    public Builder setBody(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      body_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 对应不同类型不同数据结构
     * </pre>
     *
     * <code>bytes body = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearBody() {
      
      body_ = getDefaultInstance().getBody();
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


    // @@protoc_insertion_point(builder_scope:Message.HomePosData)
  }

  // @@protoc_insertion_point(class_scope:Message.HomePosData)
  private static final game.proto.data.HomePosData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.HomePosData();
  }

  public static game.proto.data.HomePosData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HomePosData>
      PARSER = new com.google.protobuf.AbstractParser<HomePosData>() {
    @java.lang.Override
    public HomePosData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HomePosData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HomePosData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HomePosData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.HomePosData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
