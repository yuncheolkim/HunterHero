// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 战役结果通知
 * </pre>
 *
 * Protobuf type {@code Message.BattleEndPush}
 */
public final class BattleEndPush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.BattleEndPush)
    BattleEndPushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BattleEndPush.newBuilder() to construct.
  private BattleEndPush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BattleEndPush() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BattleEndPush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BattleEndPush(
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

            win_ = input.readBool();
            break;
          }
          case 16: {

            battleId_ = input.readInt32();
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
    return game.proto.MessageOuterClass.internal_static_Message_BattleEndPush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_BattleEndPush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.BattleEndPush.class, game.proto.BattleEndPush.Builder.class);
  }

  public static final int WIN_FIELD_NUMBER = 1;
  private boolean win_;
  /**
   * <code>bool win = 1;</code>
   * @return The win.
   */
  @java.lang.Override
  public boolean getWin() {
    return win_;
  }

  public static final int BATTLEID_FIELD_NUMBER = 2;
  private int battleId_;
  /**
   * <code>int32 battleId = 2;</code>
   * @return The battleId.
   */
  @java.lang.Override
  public int getBattleId() {
    return battleId_;
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
    if (win_ != false) {
      output.writeBool(1, win_);
    }
    if (battleId_ != 0) {
      output.writeInt32(2, battleId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (win_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, win_);
    }
    if (battleId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, battleId_);
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
    if (!(obj instanceof game.proto.BattleEndPush)) {
      return super.equals(obj);
    }
    game.proto.BattleEndPush other = (game.proto.BattleEndPush) obj;

    if (getWin()
        != other.getWin()) return false;
    if (getBattleId()
        != other.getBattleId()) return false;
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
    hash = (37 * hash) + WIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getWin());
    hash = (37 * hash) + BATTLEID_FIELD_NUMBER;
    hash = (53 * hash) + getBattleId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.BattleEndPush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.BattleEndPush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.BattleEndPush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.BattleEndPush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.BattleEndPush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.BattleEndPush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.BattleEndPush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.BattleEndPush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.BattleEndPush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.BattleEndPush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.BattleEndPush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.BattleEndPush parseFrom(
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
  public static Builder newBuilder(game.proto.BattleEndPush prototype) {
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
   * 战役结果通知
   * </pre>
   *
   * Protobuf type {@code Message.BattleEndPush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.BattleEndPush)
      game.proto.BattleEndPushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_BattleEndPush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_BattleEndPush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.BattleEndPush.class, game.proto.BattleEndPush.Builder.class);
    }

    // Construct using game.proto.BattleEndPush.newBuilder()
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
      win_ = false;

      battleId_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_BattleEndPush_descriptor;
    }

    @java.lang.Override
    public game.proto.BattleEndPush getDefaultInstanceForType() {
      return game.proto.BattleEndPush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.BattleEndPush build() {
      game.proto.BattleEndPush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.BattleEndPush buildPartial() {
      game.proto.BattleEndPush result = new game.proto.BattleEndPush(this);
      result.win_ = win_;
      result.battleId_ = battleId_;
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
      if (other instanceof game.proto.BattleEndPush) {
        return mergeFrom((game.proto.BattleEndPush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.BattleEndPush other) {
      if (other == game.proto.BattleEndPush.getDefaultInstance()) return this;
      if (other.getWin() != false) {
        setWin(other.getWin());
      }
      if (other.getBattleId() != 0) {
        setBattleId(other.getBattleId());
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
      game.proto.BattleEndPush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.BattleEndPush) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean win_ ;
    /**
     * <code>bool win = 1;</code>
     * @return The win.
     */
    @java.lang.Override
    public boolean getWin() {
      return win_;
    }
    /**
     * <code>bool win = 1;</code>
     * @param value The win to set.
     * @return This builder for chaining.
     */
    public Builder setWin(boolean value) {
      
      win_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool win = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearWin() {
      
      win_ = false;
      onChanged();
      return this;
    }

    private int battleId_ ;
    /**
     * <code>int32 battleId = 2;</code>
     * @return The battleId.
     */
    @java.lang.Override
    public int getBattleId() {
      return battleId_;
    }
    /**
     * <code>int32 battleId = 2;</code>
     * @param value The battleId to set.
     * @return This builder for chaining.
     */
    public Builder setBattleId(int value) {
      
      battleId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 battleId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBattleId() {
      
      battleId_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Message.BattleEndPush)
  }

  // @@protoc_insertion_point(class_scope:Message.BattleEndPush)
  private static final game.proto.BattleEndPush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.BattleEndPush();
  }

  public static game.proto.BattleEndPush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BattleEndPush>
      PARSER = new com.google.protobuf.AbstractParser<BattleEndPush>() {
    @java.lang.Override
    public BattleEndPush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BattleEndPush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BattleEndPush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BattleEndPush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.BattleEndPush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

