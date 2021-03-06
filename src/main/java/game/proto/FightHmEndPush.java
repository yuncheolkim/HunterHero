// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 手动战斗结束
 * </pre>
 *
 * Protobuf type {@code Message.FightHmEndPush}
 */
public final class FightHmEndPush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FightHmEndPush)
    FightHmEndPushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FightHmEndPush.newBuilder() to construct.
  private FightHmEndPush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FightHmEndPush() {
    reward_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FightHmEndPush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FightHmEndPush(
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
          case 32: {

            win_ = input.readBool();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              reward_ = new java.util.ArrayList<game.proto.data.Reward>();
              mutable_bitField0_ |= 0x00000001;
            }
            reward_.add(
                input.readMessage(game.proto.data.Reward.parser(), extensionRegistry));
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
        reward_ = java.util.Collections.unmodifiableList(reward_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.MessageOuterClass.internal_static_Message_FightHmEndPush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FightHmEndPush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FightHmEndPush.class, game.proto.FightHmEndPush.Builder.class);
  }

  public static final int WIN_FIELD_NUMBER = 4;
  private boolean win_;
  /**
   * <pre>
   * 是否胜利
   * </pre>
   *
   * <code>bool win = 4;</code>
   * @return The win.
   */
  @java.lang.Override
  public boolean getWin() {
    return win_;
  }

  public static final int REWARD_FIELD_NUMBER = 5;
  private java.util.List<game.proto.data.Reward> reward_;
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  @java.lang.Override
  public java.util.List<game.proto.data.Reward> getRewardList() {
    return reward_;
  }
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  @java.lang.Override
  public java.util.List<? extends game.proto.data.RewardOrBuilder> 
      getRewardOrBuilderList() {
    return reward_;
  }
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  @java.lang.Override
  public int getRewardCount() {
    return reward_.size();
  }
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  @java.lang.Override
  public game.proto.data.Reward getReward(int index) {
    return reward_.get(index);
  }
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>repeated .Message.Reward reward = 5;</code>
   */
  @java.lang.Override
  public game.proto.data.RewardOrBuilder getRewardOrBuilder(
      int index) {
    return reward_.get(index);
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
      output.writeBool(4, win_);
    }
    for (int i = 0; i < reward_.size(); i++) {
      output.writeMessage(5, reward_.get(i));
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
        .computeBoolSize(4, win_);
    }
    for (int i = 0; i < reward_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, reward_.get(i));
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
    if (!(obj instanceof game.proto.FightHmEndPush)) {
      return super.equals(obj);
    }
    game.proto.FightHmEndPush other = (game.proto.FightHmEndPush) obj;

    if (getWin()
        != other.getWin()) return false;
    if (!getRewardList()
        .equals(other.getRewardList())) return false;
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
    if (getRewardCount() > 0) {
      hash = (37 * hash) + REWARD_FIELD_NUMBER;
      hash = (53 * hash) + getRewardList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FightHmEndPush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmEndPush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmEndPush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmEndPush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmEndPush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FightHmEndPush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FightHmEndPush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmEndPush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmEndPush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FightHmEndPush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FightHmEndPush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FightHmEndPush parseFrom(
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
  public static Builder newBuilder(game.proto.FightHmEndPush prototype) {
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
   * 手动战斗结束
   * </pre>
   *
   * Protobuf type {@code Message.FightHmEndPush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FightHmEndPush)
      game.proto.FightHmEndPushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmEndPush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmEndPush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FightHmEndPush.class, game.proto.FightHmEndPush.Builder.class);
    }

    // Construct using game.proto.FightHmEndPush.newBuilder()
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
        getRewardFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      win_ = false;

      if (rewardBuilder_ == null) {
        reward_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        rewardBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FightHmEndPush_descriptor;
    }

    @java.lang.Override
    public game.proto.FightHmEndPush getDefaultInstanceForType() {
      return game.proto.FightHmEndPush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FightHmEndPush build() {
      game.proto.FightHmEndPush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FightHmEndPush buildPartial() {
      game.proto.FightHmEndPush result = new game.proto.FightHmEndPush(this);
      int from_bitField0_ = bitField0_;
      result.win_ = win_;
      if (rewardBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          reward_ = java.util.Collections.unmodifiableList(reward_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.reward_ = reward_;
      } else {
        result.reward_ = rewardBuilder_.build();
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
      if (other instanceof game.proto.FightHmEndPush) {
        return mergeFrom((game.proto.FightHmEndPush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FightHmEndPush other) {
      if (other == game.proto.FightHmEndPush.getDefaultInstance()) return this;
      if (other.getWin() != false) {
        setWin(other.getWin());
      }
      if (rewardBuilder_ == null) {
        if (!other.reward_.isEmpty()) {
          if (reward_.isEmpty()) {
            reward_ = other.reward_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRewardIsMutable();
            reward_.addAll(other.reward_);
          }
          onChanged();
        }
      } else {
        if (!other.reward_.isEmpty()) {
          if (rewardBuilder_.isEmpty()) {
            rewardBuilder_.dispose();
            rewardBuilder_ = null;
            reward_ = other.reward_;
            bitField0_ = (bitField0_ & ~0x00000001);
            rewardBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRewardFieldBuilder() : null;
          } else {
            rewardBuilder_.addAllMessages(other.reward_);
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
      game.proto.FightHmEndPush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FightHmEndPush) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private boolean win_ ;
    /**
     * <pre>
     * 是否胜利
     * </pre>
     *
     * <code>bool win = 4;</code>
     * @return The win.
     */
    @java.lang.Override
    public boolean getWin() {
      return win_;
    }
    /**
     * <pre>
     * 是否胜利
     * </pre>
     *
     * <code>bool win = 4;</code>
     * @param value The win to set.
     * @return This builder for chaining.
     */
    public Builder setWin(boolean value) {
      
      win_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 是否胜利
     * </pre>
     *
     * <code>bool win = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearWin() {
      
      win_ = false;
      onChanged();
      return this;
    }

    private java.util.List<game.proto.data.Reward> reward_ =
      java.util.Collections.emptyList();
    private void ensureRewardIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        reward_ = new java.util.ArrayList<game.proto.data.Reward>(reward_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.Reward, game.proto.data.Reward.Builder, game.proto.data.RewardOrBuilder> rewardBuilder_;

    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public java.util.List<game.proto.data.Reward> getRewardList() {
      if (rewardBuilder_ == null) {
        return java.util.Collections.unmodifiableList(reward_);
      } else {
        return rewardBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public int getRewardCount() {
      if (rewardBuilder_ == null) {
        return reward_.size();
      } else {
        return rewardBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public game.proto.data.Reward getReward(int index) {
      if (rewardBuilder_ == null) {
        return reward_.get(index);
      } else {
        return rewardBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder setReward(
        int index, game.proto.data.Reward value) {
      if (rewardBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRewardIsMutable();
        reward_.set(index, value);
        onChanged();
      } else {
        rewardBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder setReward(
        int index, game.proto.data.Reward.Builder builderForValue) {
      if (rewardBuilder_ == null) {
        ensureRewardIsMutable();
        reward_.set(index, builderForValue.build());
        onChanged();
      } else {
        rewardBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder addReward(game.proto.data.Reward value) {
      if (rewardBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRewardIsMutable();
        reward_.add(value);
        onChanged();
      } else {
        rewardBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder addReward(
        int index, game.proto.data.Reward value) {
      if (rewardBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRewardIsMutable();
        reward_.add(index, value);
        onChanged();
      } else {
        rewardBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder addReward(
        game.proto.data.Reward.Builder builderForValue) {
      if (rewardBuilder_ == null) {
        ensureRewardIsMutable();
        reward_.add(builderForValue.build());
        onChanged();
      } else {
        rewardBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder addReward(
        int index, game.proto.data.Reward.Builder builderForValue) {
      if (rewardBuilder_ == null) {
        ensureRewardIsMutable();
        reward_.add(index, builderForValue.build());
        onChanged();
      } else {
        rewardBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder addAllReward(
        java.lang.Iterable<? extends game.proto.data.Reward> values) {
      if (rewardBuilder_ == null) {
        ensureRewardIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, reward_);
        onChanged();
      } else {
        rewardBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder clearReward() {
      if (rewardBuilder_ == null) {
        reward_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        rewardBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public Builder removeReward(int index) {
      if (rewardBuilder_ == null) {
        ensureRewardIsMutable();
        reward_.remove(index);
        onChanged();
      } else {
        rewardBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public game.proto.data.Reward.Builder getRewardBuilder(
        int index) {
      return getRewardFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public game.proto.data.RewardOrBuilder getRewardOrBuilder(
        int index) {
      if (rewardBuilder_ == null) {
        return reward_.get(index);  } else {
        return rewardBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public java.util.List<? extends game.proto.data.RewardOrBuilder> 
         getRewardOrBuilderList() {
      if (rewardBuilder_ != null) {
        return rewardBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(reward_);
      }
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public game.proto.data.Reward.Builder addRewardBuilder() {
      return getRewardFieldBuilder().addBuilder(
          game.proto.data.Reward.getDefaultInstance());
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public game.proto.data.Reward.Builder addRewardBuilder(
        int index) {
      return getRewardFieldBuilder().addBuilder(
          index, game.proto.data.Reward.getDefaultInstance());
    }
    /**
     * <pre>
     * 奖励
     * </pre>
     *
     * <code>repeated .Message.Reward reward = 5;</code>
     */
    public java.util.List<game.proto.data.Reward.Builder> 
         getRewardBuilderList() {
      return getRewardFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        game.proto.data.Reward, game.proto.data.Reward.Builder, game.proto.data.RewardOrBuilder> 
        getRewardFieldBuilder() {
      if (rewardBuilder_ == null) {
        rewardBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            game.proto.data.Reward, game.proto.data.Reward.Builder, game.proto.data.RewardOrBuilder>(
                reward_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        reward_ = null;
      }
      return rewardBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.FightHmEndPush)
  }

  // @@protoc_insertion_point(class_scope:Message.FightHmEndPush)
  private static final game.proto.FightHmEndPush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FightHmEndPush();
  }

  public static game.proto.FightHmEndPush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FightHmEndPush>
      PARSER = new com.google.protobuf.AbstractParser<FightHmEndPush>() {
    @java.lang.Override
    public FightHmEndPush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FightHmEndPush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FightHmEndPush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FightHmEndPush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FightHmEndPush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

