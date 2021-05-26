// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * Protobuf type {@code Message.ChatMessagePush}
 */
public final class ChatMessagePush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.ChatMessagePush)
    ChatMessagePushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChatMessagePush.newBuilder() to construct.
  private ChatMessagePush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatMessagePush() {
    channel_ = 0;
    content_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChatMessagePush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChatMessagePush(
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

            fromUser_ = input.readInt64();
            break;
          }
          case 24: {

            time_ = input.readInt64();
            break;
          }
          case 32: {

            id_ = input.readInt64();
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
    return game.proto.MessageOuterClass.internal_static_Message_ChatMessagePush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_ChatMessagePush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.ChatMessagePush.class, game.proto.ChatMessagePush.Builder.class);
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

  public static final int FROMUSER_FIELD_NUMBER = 2;
  private long fromUser_;
  /**
   * <code>int64 fromUser = 2;</code>
   * @return The fromUser.
   */
  @java.lang.Override
  public long getFromUser() {
    return fromUser_;
  }

  public static final int TIME_FIELD_NUMBER = 3;
  private long time_;
  /**
   * <code>int64 time = 3;</code>
   * @return The time.
   */
  @java.lang.Override
  public long getTime() {
    return time_;
  }

  public static final int ID_FIELD_NUMBER = 4;
  private long id_;
  /**
   * <code>int64 id = 4;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
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
    if (fromUser_ != 0L) {
      output.writeInt64(2, fromUser_);
    }
    if (time_ != 0L) {
      output.writeInt64(3, time_);
    }
    if (id_ != 0L) {
      output.writeInt64(4, id_);
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
    if (fromUser_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, fromUser_);
    }
    if (time_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, time_);
    }
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, id_);
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
    if (!(obj instanceof game.proto.ChatMessagePush)) {
      return super.equals(obj);
    }
    game.proto.ChatMessagePush other = (game.proto.ChatMessagePush) obj;

    if (channel_ != other.channel_) return false;
    if (getFromUser()
        != other.getFromUser()) return false;
    if (getTime()
        != other.getTime()) return false;
    if (getId()
        != other.getId()) return false;
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
    hash = (37 * hash) + FROMUSER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFromUser());
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTime());
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.ChatMessagePush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessagePush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessagePush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessagePush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessagePush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.ChatMessagePush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.ChatMessagePush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessagePush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ChatMessagePush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessagePush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.ChatMessagePush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.ChatMessagePush parseFrom(
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
  public static Builder newBuilder(game.proto.ChatMessagePush prototype) {
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
   * Protobuf type {@code Message.ChatMessagePush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.ChatMessagePush)
      game.proto.ChatMessagePushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessagePush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessagePush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.ChatMessagePush.class, game.proto.ChatMessagePush.Builder.class);
    }

    // Construct using game.proto.ChatMessagePush.newBuilder()
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

      fromUser_ = 0L;

      time_ = 0L;

      id_ = 0L;

      content_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_ChatMessagePush_descriptor;
    }

    @java.lang.Override
    public game.proto.ChatMessagePush getDefaultInstanceForType() {
      return game.proto.ChatMessagePush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.ChatMessagePush build() {
      game.proto.ChatMessagePush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.ChatMessagePush buildPartial() {
      game.proto.ChatMessagePush result = new game.proto.ChatMessagePush(this);
      result.channel_ = channel_;
      result.fromUser_ = fromUser_;
      result.time_ = time_;
      result.id_ = id_;
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
      if (other instanceof game.proto.ChatMessagePush) {
        return mergeFrom((game.proto.ChatMessagePush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.ChatMessagePush other) {
      if (other == game.proto.ChatMessagePush.getDefaultInstance()) return this;
      if (other.channel_ != 0) {
        setChannelValue(other.getChannelValue());
      }
      if (other.getFromUser() != 0L) {
        setFromUser(other.getFromUser());
      }
      if (other.getTime() != 0L) {
        setTime(other.getTime());
      }
      if (other.getId() != 0L) {
        setId(other.getId());
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
      game.proto.ChatMessagePush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.ChatMessagePush) e.getUnfinishedMessage();
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

    private long fromUser_ ;
    /**
     * <code>int64 fromUser = 2;</code>
     * @return The fromUser.
     */
    @java.lang.Override
    public long getFromUser() {
      return fromUser_;
    }
    /**
     * <code>int64 fromUser = 2;</code>
     * @param value The fromUser to set.
     * @return This builder for chaining.
     */
    public Builder setFromUser(long value) {
      
      fromUser_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 fromUser = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFromUser() {
      
      fromUser_ = 0L;
      onChanged();
      return this;
    }

    private long time_ ;
    /**
     * <code>int64 time = 3;</code>
     * @return The time.
     */
    @java.lang.Override
    public long getTime() {
      return time_;
    }
    /**
     * <code>int64 time = 3;</code>
     * @param value The time to set.
     * @return This builder for chaining.
     */
    public Builder setTime(long value) {
      
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 time = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearTime() {
      
      time_ = 0L;
      onChanged();
      return this;
    }

    private long id_ ;
    /**
     * <code>int64 id = 4;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 4;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Message.ChatMessagePush)
  }

  // @@protoc_insertion_point(class_scope:Message.ChatMessagePush)
  private static final game.proto.ChatMessagePush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.ChatMessagePush();
  }

  public static game.proto.ChatMessagePush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatMessagePush>
      PARSER = new com.google.protobuf.AbstractParser<ChatMessagePush>() {
    @java.lang.Override
    public ChatMessagePush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChatMessagePush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatMessagePush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatMessagePush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.ChatMessagePush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
