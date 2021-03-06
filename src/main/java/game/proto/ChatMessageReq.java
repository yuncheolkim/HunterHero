// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * Protobuf type {@code Message.ChatMessageReq}
 */
public final class ChatMessageReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.ChatMessageReq)
    ChatMessageReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChatMessageReq.newBuilder() to construct.
  private ChatMessageReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatMessageReq() {
    channel_ = 0;
    content_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChatMessageReq();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChatMessageReq(
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
            int rawValue = input.readEnum();

            channel_ = rawValue;
            break;
          }
          case 16: {

            toUser_ = input.readInt64();
            break;
          }
          case 82: {
            java.lang.String s = input.readStringRequireUtf8();

            content_ = s;
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
    return game.proto.MessageOuterClass.internal_static_Message_ChatMessageReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_ChatMessageReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.ChatMessageReq.class, game.proto.ChatMessageReq.Builder.class);
  }

  public static final int CHANNEL_FIELD_NUMBER = 1;
  private int channel_;
  /**
   * <code>.Message.ChatChannel channel = 1;</code>
   * @return The enum numeric value on the wire for channel.
   */
  @java.lang.Override public int getChannelValue() {
    return channel_;
  }
  /**
   * <code>.Message.ChatChannel channel = 1;</code>
   * @return The channel.
   */
  @java.lang.Override public game.proto.ChatChannel getChannel() {
    @SuppressWarnings("deprecation")
    game.proto.ChatChannel result = game.proto.ChatChannel.valueOf(channel_);
    return result == null ? game.proto.ChatChannel.UNRECOGNIZED : result;
  }

  public static final int TOUSER_FIELD_NUMBER = 2;
  private long toUser_;
  /**
   * <code>int64 toUser = 2;</code>
   * @return The toUser.
   */
  @java.lang.Override
  public long getToUser() {
    return toUser_;
  }

  public static final int CONTENT_FIELD_NUMBER = 10;
  private volatile java.lang.Object content_;
  /**
   * <code>string content = 10;</code>
   * @return The content.
   */
  @java.lang.Override
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      content_ = s;
      return s;
    }
  }
  /**
   * <code>string content = 10;</code>
   * @return The bytes for content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (channel_ != game.proto.ChatChannel.C_NONE.getNumber()) {
      output.writeEnum(1, channel_);
    }
    if (toUser_ != 0L) {
      output.writeInt64(2, toUser_);
    }
    if (!getContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 10, content_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (channel_ != game.proto.ChatChannel.C_NONE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, channel_);
    }
    if (toUser_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, toUser_);
    }
    if (!getContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, content_);
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
    if (!(obj instanceof game.proto.ChatMessageReq)) {
      return super.equals(obj);
    }
    game.proto.ChatMessageReq other = (game.proto.ChatMessageReq) obj;

    if (channel_ != other.channel_) return false;
    if (getToUser()
        != other.getToUser()) return false;
    if (!getContent()
        .equals(other.getContent())) return false;
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
    hash = (37 * hash) + CHANNEL_FIELD_NUMBER;
    hash = (53 * hash) + channel_;
    hash = (37 * hash) + TOUSER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getToUser());
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.ChatMessageReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessageReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessageReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessageReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessageReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessageReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessageReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessageReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ChatMessageReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessageReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ChatMessageReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessageReq parseFrom(
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
  public static Builder newBuilder(game.proto.ChatMessageReq prototype) {
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
   * Protobuf type {@code Message.ChatMessageReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.ChatMessageReq)
      game.proto.ChatMessageReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessageReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessageReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.ChatMessageReq.class, game.proto.ChatMessageReq.Builder.class);
    }

    // Construct using game.proto.ChatMessageReq.newBuilder()
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
      channel_ = 0;

      toUser_ = 0L;

      content_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessageReq_descriptor;
    }

    @java.lang.Override
    public game.proto.ChatMessageReq getDefaultInstanceForType() {
      return game.proto.ChatMessageReq.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.ChatMessageReq build() {
      game.proto.ChatMessageReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.ChatMessageReq buildPartial() {
      game.proto.ChatMessageReq result = new game.proto.ChatMessageReq(this);
      result.channel_ = channel_;
      result.toUser_ = toUser_;
      result.content_ = content_;
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
      if (other instanceof game.proto.ChatMessageReq) {
        return mergeFrom((game.proto.ChatMessageReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.ChatMessageReq other) {
      if (other == game.proto.ChatMessageReq.getDefaultInstance()) return this;
      if (other.channel_ != 0) {
        setChannelValue(other.getChannelValue());
      }
      if (other.getToUser() != 0L) {
        setToUser(other.getToUser());
      }
      if (!other.getContent().isEmpty()) {
        content_ = other.content_;
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
      game.proto.ChatMessageReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.ChatMessageReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int channel_ = 0;
    /**
     * <code>.Message.ChatChannel channel = 1;</code>
     * @return The enum numeric value on the wire for channel.
     */
    @java.lang.Override public int getChannelValue() {
      return channel_;
    }
    /**
     * <code>.Message.ChatChannel channel = 1;</code>
     * @param value The enum numeric value on the wire for channel to set.
     * @return This builder for chaining.
     */
    public Builder setChannelValue(int value) {
      
      channel_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Message.ChatChannel channel = 1;</code>
     * @return The channel.
     */
    @java.lang.Override
    public game.proto.ChatChannel getChannel() {
      @SuppressWarnings("deprecation")
      game.proto.ChatChannel result = game.proto.ChatChannel.valueOf(channel_);
      return result == null ? game.proto.ChatChannel.UNRECOGNIZED : result;
    }
    /**
     * <code>.Message.ChatChannel channel = 1;</code>
     * @param value The channel to set.
     * @return This builder for chaining.
     */
    public Builder setChannel(game.proto.ChatChannel value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      channel_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Message.ChatChannel channel = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearChannel() {
      
      channel_ = 0;
      onChanged();
      return this;
    }

    private long toUser_ ;
    /**
     * <code>int64 toUser = 2;</code>
     * @return The toUser.
     */
    @java.lang.Override
    public long getToUser() {
      return toUser_;
    }
    /**
     * <code>int64 toUser = 2;</code>
     * @param value The toUser to set.
     * @return This builder for chaining.
     */
    public Builder setToUser(long value) {
      
      toUser_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 toUser = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearToUser() {
      
      toUser_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>string content = 10;</code>
     * @return The content.
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string content = 10;</code>
     * @return The bytes for content.
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string content = 10;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      content_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string content = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      
      content_ = getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    /**
     * <code>string content = 10;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      content_ = value;
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


    // @@protoc_insertion_point(builder_scope:Message.ChatMessageReq)
  }

  // @@protoc_insertion_point(class_scope:Message.ChatMessageReq)
  private static final game.proto.ChatMessageReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.ChatMessageReq();
  }

  public static game.proto.ChatMessageReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatMessageReq>
      PARSER = new com.google.protobuf.AbstractParser<ChatMessageReq>() {
    @java.lang.Override
    public ChatMessageReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChatMessageReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatMessageReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatMessageReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.ChatMessageReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

