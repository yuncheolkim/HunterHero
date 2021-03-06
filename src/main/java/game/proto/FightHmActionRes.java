// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 手动战斗进行中
 * </pre>
 *
 * Protobuf type {@code Message.FightHmActionRes}
 */
public final class FightHmActionRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FightHmActionRes)
    FightHmActionResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FightHmActionRes.newBuilder() to construct.
  private FightHmActionRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FightHmActionRes() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FightHmActionRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FightHmActionRes(
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
          case 10: {
            game.proto.data.RoundRecord.Builder subBuilder = null;
            if (round_ != null) {
              subBuilder = round_.toBuilder();
            }
            round_ = input.readMessage(game.proto.data.RoundRecord.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(round_);
              round_ = subBuilder.buildPartial();
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
    return game.proto.MessageOuterClass.internal_static_Message_FightHmActionRes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FightHmActionRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FightHmActionRes.class, game.proto.FightHmActionRes.Builder.class);
  }

  public static final int ROUND_FIELD_NUMBER = 1;
  private game.proto.data.RoundRecord round_;
  /**
   * <code>.Message.RoundRecord round = 1;</code>
   * @return Whether the round field is set.
   */
  @java.lang.Override
  public boolean hasRound() {
    return round_ != null;
  }
  /**
   * <code>.Message.RoundRecord round = 1;</code>
   * @return The round.
   */
  @java.lang.Override
  public game.proto.data.RoundRecord getRound() {
    return round_ == null ? game.proto.data.RoundRecord.getDefaultInstance() : round_;
  }
  /**
   * <code>.Message.RoundRecord round = 1;</code>
   */
  @java.lang.Override
  public game.proto.data.RoundRecordOrBuilder getRoundOrBuilder() {
    return getRound();
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
    if (round_ != null) {
      output.writeMessage(1, getRound());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (round_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getRound());
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
    if (!(obj instanceof game.proto.FightHmActionRes)) {
      return super.equals(obj);
    }
    game.proto.FightHmActionRes other = (game.proto.FightHmActionRes) obj;

    if (hasRound() != other.hasRound()) return false;
    if (hasRound()) {
      if (!getRound()
          .equals(other.getRound())) return false;
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
    if (hasRound()) {
      hash = (37 * hash) + ROUND_FIELD_NUMBER;
      hash = (53 * hash) + getRound().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FightHmActionRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmActionRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmActionRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmActionRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmActionRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmActionRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmActionRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmActionRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmActionRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FightHmActionRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmActionRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmActionRes parseFrom(
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
  public static Builder newBuilder(game.proto.FightHmActionRes prototype) {
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
   * 手动战斗进行中
   * </pre>
   *
   * Protobuf type {@code Message.FightHmActionRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FightHmActionRes)
      game.proto.FightHmActionResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmActionRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmActionRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FightHmActionRes.class, game.proto.FightHmActionRes.Builder.class);
    }

    // Construct using game.proto.FightHmActionRes.newBuilder()
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
      if (roundBuilder_ == null) {
        round_ = null;
      } else {
        round_ = null;
        roundBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmActionRes_descriptor;
    }

    @java.lang.Override
    public game.proto.FightHmActionRes getDefaultInstanceForType() {
      return game.proto.FightHmActionRes.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FightHmActionRes build() {
      game.proto.FightHmActionRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FightHmActionRes buildPartial() {
      game.proto.FightHmActionRes result = new game.proto.FightHmActionRes(this);
      if (roundBuilder_ == null) {
        result.round_ = round_;
      } else {
        result.round_ = roundBuilder_.build();
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
      if (other instanceof game.proto.FightHmActionRes) {
        return mergeFrom((game.proto.FightHmActionRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FightHmActionRes other) {
      if (other == game.proto.FightHmActionRes.getDefaultInstance()) return this;
      if (other.hasRound()) {
        mergeRound(other.getRound());
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
      game.proto.FightHmActionRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FightHmActionRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private game.proto.data.RoundRecord round_;
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.RoundRecord, game.proto.data.RoundRecord.Builder, game.proto.data.RoundRecordOrBuilder> roundBuilder_;
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     * @return Whether the round field is set.
     */
    public boolean hasRound() {
      return roundBuilder_ != null || round_ != null;
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     * @return The round.
     */
    public game.proto.data.RoundRecord getRound() {
      if (roundBuilder_ == null) {
        return round_ == null ? game.proto.data.RoundRecord.getDefaultInstance() : round_;
      } else {
        return roundBuilder_.getMessage();
      }
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public Builder setRound(game.proto.data.RoundRecord value) {
      if (roundBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        round_ = value;
        onChanged();
      } else {
        roundBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public Builder setRound(
        game.proto.data.RoundRecord.Builder builderForValue) {
      if (roundBuilder_ == null) {
        round_ = builderForValue.build();
        onChanged();
      } else {
        roundBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public Builder mergeRound(game.proto.data.RoundRecord value) {
      if (roundBuilder_ == null) {
        if (round_ != null) {
          round_ =
            game.proto.data.RoundRecord.newBuilder(round_).mergeFrom(value).buildPartial();
        } else {
          round_ = value;
        }
        onChanged();
      } else {
        roundBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public Builder clearRound() {
      if (roundBuilder_ == null) {
        round_ = null;
        onChanged();
      } else {
        round_ = null;
        roundBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public game.proto.data.RoundRecord.Builder getRoundBuilder() {
      
      onChanged();
      return getRoundFieldBuilder().getBuilder();
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    public game.proto.data.RoundRecordOrBuilder getRoundOrBuilder() {
      if (roundBuilder_ != null) {
        return roundBuilder_.getMessageOrBuilder();
      } else {
        return round_ == null ?
            game.proto.data.RoundRecord.getDefaultInstance() : round_;
      }
    }
    /**
     * <code>.Message.RoundRecord round = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.RoundRecord, game.proto.data.RoundRecord.Builder, game.proto.data.RoundRecordOrBuilder> 
        getRoundFieldBuilder() {
      if (roundBuilder_ == null) {
        roundBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            game.proto.data.RoundRecord, game.proto.data.RoundRecord.Builder, game.proto.data.RoundRecordOrBuilder>(
                getRound(),
                getParentForChildren(),
                isClean());
        round_ = null;
      }
      return roundBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.FightHmActionRes)
  }

  // @@protoc_insertion_point(class_scope:Message.FightHmActionRes)
  private static final game.proto.FightHmActionRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FightHmActionRes();
  }

  public static game.proto.FightHmActionRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FightHmActionRes>
      PARSER = new com.google.protobuf.AbstractParser<FightHmActionRes>() {
    @java.lang.Override
    public FightHmActionRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FightHmActionRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FightHmActionRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FightHmActionRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FightHmActionRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

