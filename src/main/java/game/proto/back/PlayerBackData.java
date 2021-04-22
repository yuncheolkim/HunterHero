// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: back.proto

package game.proto.back;

/**
 * <pre>
 * 后端需要的数据
 * </pre>
 *
 * Protobuf type {@code Message.PlayerBackData}
 */
public final class PlayerBackData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.PlayerBackData)
    PlayerBackDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PlayerBackData.newBuilder() to construct.
  private PlayerBackData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PlayerBackData() {
    fightArea_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PlayerBackData();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PlayerBackData(
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
          case 8: {

            fightTime_ = input.readInt64();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              fightArea_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            fightArea_.addInt(input.readInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              fightArea_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              fightArea_.addInt(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 24: {

            powerRecoverTime_ = input.readInt64();
            break;
          }
          case 40: {

            loginTime_ = input.readInt64();
            break;
          }
          case 48: {

            updateTime_ = input.readInt64();
            break;
          }
          case 80: {

            localId_ = input.readInt32();
            break;
          }
          case 802: {
            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
              completeTask_ = com.google.protobuf.MapField.newMapField(
                  CompleteTaskDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000002;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Boolean>
            completeTask__ = input.readMessage(
                CompleteTaskDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            completeTask_.getMutableMap().put(
                completeTask__.getKey(), completeTask__.getValue());
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
        fightArea_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.back.Back.internal_static_Message_PlayerBackData_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 100:
        return internalGetCompleteTask();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.back.Back.internal_static_Message_PlayerBackData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.back.PlayerBackData.class, game.proto.back.PlayerBackData.Builder.class);
  }

  public static final int FIGHTTIME_FIELD_NUMBER = 1;
  private long fightTime_;
  /**
   * <pre>
   * 下一次触发战斗时间
   * </pre>
   *
   * <code>int64 fightTime = 1;</code>
   * @return The fightTime.
   */
  @java.lang.Override
  public long getFightTime() {
    return fightTime_;
  }

  public static final int FIGHTAREA_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.IntList fightArea_;
  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @return A list containing the fightArea.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getFightAreaList() {
    return fightArea_;
  }
  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @return The count of fightArea.
   */
  public int getFightAreaCount() {
    return fightArea_.size();
  }
  /**
   * <code>repeated int32 fightArea = 2;</code>
   * @param index The index of the element to return.
   * @return The fightArea at the given index.
   */
  public int getFightArea(int index) {
    return fightArea_.getInt(index);
  }
  private int fightAreaMemoizedSerializedSize = -1;

  public static final int POWERRECOVERTIME_FIELD_NUMBER = 3;
  private long powerRecoverTime_;
  /**
   * <pre>
   * 体力最后一次恢复时间
   * </pre>
   *
   * <code>int64 powerRecoverTime = 3;</code>
   * @return The powerRecoverTime.
   */
  @java.lang.Override
  public long getPowerRecoverTime() {
    return powerRecoverTime_;
  }

  public static final int LOGINTIME_FIELD_NUMBER = 5;
  private long loginTime_;
  /**
   * <code>int64 loginTime = 5;</code>
   * @return The loginTime.
   */
  @java.lang.Override
  public long getLoginTime() {
    return loginTime_;
  }

  public static final int UPDATETIME_FIELD_NUMBER = 6;
  private long updateTime_;
  /**
   * <code>int64 updateTime = 6;</code>
   * @return The updateTime.
   */
  @java.lang.Override
  public long getUpdateTime() {
    return updateTime_;
  }

  public static final int LOCALID_FIELD_NUMBER = 10;
  private int localId_;
  /**
   * <code>int32 localId = 10;</code>
   * @return The localId.
   */
  @java.lang.Override
  public int getLocalId() {
    return localId_;
  }

  public static final int COMPLETETASK_FIELD_NUMBER = 100;
  private static final class CompleteTaskDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.Boolean> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.Boolean>newDefaultInstance(
                game.proto.back.Back.internal_static_Message_PlayerBackData_CompleteTaskEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.BOOL,
                false);
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, java.lang.Boolean> completeTask_;
  private com.google.protobuf.MapField<java.lang.Integer, java.lang.Boolean>
  internalGetCompleteTask() {
    if (completeTask_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          CompleteTaskDefaultEntryHolder.defaultEntry);
    }
    return completeTask_;
  }

  public int getCompleteTaskCount() {
    return internalGetCompleteTask().getMap().size();
  }
  /**
   * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
   */

  @java.lang.Override
  public boolean containsCompleteTask(
      int key) {
    
    return internalGetCompleteTask().getMap().containsKey(key);
  }
  /**
   * Use {@link #getCompleteTaskMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, java.lang.Boolean> getCompleteTask() {
    return getCompleteTaskMap();
  }
  /**
   * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.Integer, java.lang.Boolean> getCompleteTaskMap() {
    return internalGetCompleteTask().getMap();
  }
  /**
   * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
   */
  @java.lang.Override

  public boolean getCompleteTaskOrDefault(
      int key,
      boolean defaultValue) {
    
    java.util.Map<java.lang.Integer, java.lang.Boolean> map =
        internalGetCompleteTask().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
   */
  @java.lang.Override

  public boolean getCompleteTaskOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, java.lang.Boolean> map =
        internalGetCompleteTask().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    getSerializedSize();
    if (fightTime_ != 0L) {
      output.writeInt64(1, fightTime_);
    }
    if (getFightAreaList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(fightAreaMemoizedSerializedSize);
    }
    for (int i = 0; i < fightArea_.size(); i++) {
      output.writeInt32NoTag(fightArea_.getInt(i));
    }
    if (powerRecoverTime_ != 0L) {
      output.writeInt64(3, powerRecoverTime_);
    }
    if (loginTime_ != 0L) {
      output.writeInt64(5, loginTime_);
    }
    if (updateTime_ != 0L) {
      output.writeInt64(6, updateTime_);
    }
    if (localId_ != 0) {
      output.writeInt32(10, localId_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeIntegerMapTo(
        output,
        internalGetCompleteTask(),
        CompleteTaskDefaultEntryHolder.defaultEntry,
        100);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (fightTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, fightTime_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < fightArea_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(fightArea_.getInt(i));
      }
      size += dataSize;
      if (!getFightAreaList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      fightAreaMemoizedSerializedSize = dataSize;
    }
    if (powerRecoverTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, powerRecoverTime_);
    }
    if (loginTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, loginTime_);
    }
    if (updateTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, updateTime_);
    }
    if (localId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(10, localId_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Boolean> entry
         : internalGetCompleteTask().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Boolean>
      completeTask__ = CompleteTaskDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(100, completeTask__);
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
    if (!(obj instanceof game.proto.back.PlayerBackData)) {
      return super.equals(obj);
    }
    game.proto.back.PlayerBackData other = (game.proto.back.PlayerBackData) obj;

    if (getFightTime()
        != other.getFightTime()) return false;
    if (!getFightAreaList()
        .equals(other.getFightAreaList())) return false;
    if (getPowerRecoverTime()
        != other.getPowerRecoverTime()) return false;
    if (getLoginTime()
        != other.getLoginTime()) return false;
    if (getUpdateTime()
        != other.getUpdateTime()) return false;
    if (getLocalId()
        != other.getLocalId()) return false;
    if (!internalGetCompleteTask().equals(
        other.internalGetCompleteTask())) return false;
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
    hash = (37 * hash) + FIGHTTIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFightTime());
    if (getFightAreaCount() > 0) {
      hash = (37 * hash) + FIGHTAREA_FIELD_NUMBER;
      hash = (53 * hash) + getFightAreaList().hashCode();
    }
    hash = (37 * hash) + POWERRECOVERTIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPowerRecoverTime());
    hash = (37 * hash) + LOGINTIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLoginTime());
    hash = (37 * hash) + UPDATETIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUpdateTime());
    hash = (37 * hash) + LOCALID_FIELD_NUMBER;
    hash = (53 * hash) + getLocalId();
    if (!internalGetCompleteTask().getMap().isEmpty()) {
      hash = (37 * hash) + COMPLETETASK_FIELD_NUMBER;
      hash = (53 * hash) + internalGetCompleteTask().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.back.PlayerBackData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.back.PlayerBackData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.back.PlayerBackData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.back.PlayerBackData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.back.PlayerBackData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.back.PlayerBackData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.back.PlayerBackData parseFrom(
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
  public static Builder newBuilder(game.proto.back.PlayerBackData prototype) {
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
   * 后端需要的数据
   * </pre>
   *
   * Protobuf type {@code Message.PlayerBackData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.PlayerBackData)
      game.proto.back.PlayerBackDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.back.Back.internal_static_Message_PlayerBackData_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 100:
          return internalGetCompleteTask();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 100:
          return internalGetMutableCompleteTask();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.back.Back.internal_static_Message_PlayerBackData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.back.PlayerBackData.class, game.proto.back.PlayerBackData.Builder.class);
    }

    // Construct using game.proto.back.PlayerBackData.newBuilder()
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
      fightTime_ = 0L;

      fightArea_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      powerRecoverTime_ = 0L;

      loginTime_ = 0L;

      updateTime_ = 0L;

      localId_ = 0;

      internalGetMutableCompleteTask().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.back.Back.internal_static_Message_PlayerBackData_descriptor;
    }

    @java.lang.Override
    public game.proto.back.PlayerBackData getDefaultInstanceForType() {
      return game.proto.back.PlayerBackData.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.back.PlayerBackData build() {
      game.proto.back.PlayerBackData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.back.PlayerBackData buildPartial() {
      game.proto.back.PlayerBackData result = new game.proto.back.PlayerBackData(this);
      int from_bitField0_ = bitField0_;
      result.fightTime_ = fightTime_;
      if (((bitField0_ & 0x00000001) != 0)) {
        fightArea_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.fightArea_ = fightArea_;
      result.powerRecoverTime_ = powerRecoverTime_;
      result.loginTime_ = loginTime_;
      result.updateTime_ = updateTime_;
      result.localId_ = localId_;
      result.completeTask_ = internalGetCompleteTask();
      result.completeTask_.makeImmutable();
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
      if (other instanceof game.proto.back.PlayerBackData) {
        return mergeFrom((game.proto.back.PlayerBackData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.back.PlayerBackData other) {
      if (other == game.proto.back.PlayerBackData.getDefaultInstance()) return this;
      if (other.getFightTime() != 0L) {
        setFightTime(other.getFightTime());
      }
      if (!other.fightArea_.isEmpty()) {
        if (fightArea_.isEmpty()) {
          fightArea_ = other.fightArea_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureFightAreaIsMutable();
          fightArea_.addAll(other.fightArea_);
        }
        onChanged();
      }
      if (other.getPowerRecoverTime() != 0L) {
        setPowerRecoverTime(other.getPowerRecoverTime());
      }
      if (other.getLoginTime() != 0L) {
        setLoginTime(other.getLoginTime());
      }
      if (other.getUpdateTime() != 0L) {
        setUpdateTime(other.getUpdateTime());
      }
      if (other.getLocalId() != 0) {
        setLocalId(other.getLocalId());
      }
      internalGetMutableCompleteTask().mergeFrom(
          other.internalGetCompleteTask());
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
      game.proto.back.PlayerBackData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.back.PlayerBackData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long fightTime_ ;
    /**
     * <pre>
     * 下一次触发战斗时间
     * </pre>
     *
     * <code>int64 fightTime = 1;</code>
     * @return The fightTime.
     */
    @java.lang.Override
    public long getFightTime() {
      return fightTime_;
    }
    /**
     * <pre>
     * 下一次触发战斗时间
     * </pre>
     *
     * <code>int64 fightTime = 1;</code>
     * @param value The fightTime to set.
     * @return This builder for chaining.
     */
    public Builder setFightTime(long value) {
      
      fightTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 下一次触发战斗时间
     * </pre>
     *
     * <code>int64 fightTime = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFightTime() {
      
      fightTime_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.IntList fightArea_ = emptyIntList();
    private void ensureFightAreaIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        fightArea_ = mutableCopy(fightArea_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @return A list containing the fightArea.
     */
    public java.util.List<java.lang.Integer>
        getFightAreaList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(fightArea_) : fightArea_;
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @return The count of fightArea.
     */
    public int getFightAreaCount() {
      return fightArea_.size();
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @param index The index of the element to return.
     * @return The fightArea at the given index.
     */
    public int getFightArea(int index) {
      return fightArea_.getInt(index);
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @param index The index to set the value at.
     * @param value The fightArea to set.
     * @return This builder for chaining.
     */
    public Builder setFightArea(
        int index, int value) {
      ensureFightAreaIsMutable();
      fightArea_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @param value The fightArea to add.
     * @return This builder for chaining.
     */
    public Builder addFightArea(int value) {
      ensureFightAreaIsMutable();
      fightArea_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @param values The fightArea to add.
     * @return This builder for chaining.
     */
    public Builder addAllFightArea(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureFightAreaIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, fightArea_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 fightArea = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFightArea() {
      fightArea_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private long powerRecoverTime_ ;
    /**
     * <pre>
     * 体力最后一次恢复时间
     * </pre>
     *
     * <code>int64 powerRecoverTime = 3;</code>
     * @return The powerRecoverTime.
     */
    @java.lang.Override
    public long getPowerRecoverTime() {
      return powerRecoverTime_;
    }
    /**
     * <pre>
     * 体力最后一次恢复时间
     * </pre>
     *
     * <code>int64 powerRecoverTime = 3;</code>
     * @param value The powerRecoverTime to set.
     * @return This builder for chaining.
     */
    public Builder setPowerRecoverTime(long value) {
      
      powerRecoverTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 体力最后一次恢复时间
     * </pre>
     *
     * <code>int64 powerRecoverTime = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPowerRecoverTime() {
      
      powerRecoverTime_ = 0L;
      onChanged();
      return this;
    }

    private long loginTime_ ;
    /**
     * <code>int64 loginTime = 5;</code>
     * @return The loginTime.
     */
    @java.lang.Override
    public long getLoginTime() {
      return loginTime_;
    }
    /**
     * <code>int64 loginTime = 5;</code>
     * @param value The loginTime to set.
     * @return This builder for chaining.
     */
    public Builder setLoginTime(long value) {
      
      loginTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 loginTime = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearLoginTime() {
      
      loginTime_ = 0L;
      onChanged();
      return this;
    }

    private long updateTime_ ;
    /**
     * <code>int64 updateTime = 6;</code>
     * @return The updateTime.
     */
    @java.lang.Override
    public long getUpdateTime() {
      return updateTime_;
    }
    /**
     * <code>int64 updateTime = 6;</code>
     * @param value The updateTime to set.
     * @return This builder for chaining.
     */
    public Builder setUpdateTime(long value) {
      
      updateTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 updateTime = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearUpdateTime() {
      
      updateTime_ = 0L;
      onChanged();
      return this;
    }

    private int localId_ ;
    /**
     * <code>int32 localId = 10;</code>
     * @return The localId.
     */
    @java.lang.Override
    public int getLocalId() {
      return localId_;
    }
    /**
     * <code>int32 localId = 10;</code>
     * @param value The localId to set.
     * @return This builder for chaining.
     */
    public Builder setLocalId(int value) {
      
      localId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 localId = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearLocalId() {
      
      localId_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.Boolean> completeTask_;
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Boolean>
    internalGetCompleteTask() {
      if (completeTask_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            CompleteTaskDefaultEntryHolder.defaultEntry);
      }
      return completeTask_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Boolean>
    internalGetMutableCompleteTask() {
      onChanged();;
      if (completeTask_ == null) {
        completeTask_ = com.google.protobuf.MapField.newMapField(
            CompleteTaskDefaultEntryHolder.defaultEntry);
      }
      if (!completeTask_.isMutable()) {
        completeTask_ = completeTask_.copy();
      }
      return completeTask_;
    }

    public int getCompleteTaskCount() {
      return internalGetCompleteTask().getMap().size();
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */

    @java.lang.Override
    public boolean containsCompleteTask(
        int key) {
      
      return internalGetCompleteTask().getMap().containsKey(key);
    }
    /**
     * Use {@link #getCompleteTaskMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Boolean> getCompleteTask() {
      return getCompleteTaskMap();
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.Integer, java.lang.Boolean> getCompleteTaskMap() {
      return internalGetCompleteTask().getMap();
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */
    @java.lang.Override

    public boolean getCompleteTaskOrDefault(
        int key,
        boolean defaultValue) {
      
      java.util.Map<java.lang.Integer, java.lang.Boolean> map =
          internalGetCompleteTask().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */
    @java.lang.Override

    public boolean getCompleteTaskOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, java.lang.Boolean> map =
          internalGetCompleteTask().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearCompleteTask() {
      internalGetMutableCompleteTask().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */

    public Builder removeCompleteTask(
        int key) {
      
      internalGetMutableCompleteTask().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Boolean>
    getMutableCompleteTask() {
      return internalGetMutableCompleteTask().getMutableMap();
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */
    public Builder putCompleteTask(
        int key,
        boolean value) {
      
      
      internalGetMutableCompleteTask().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, bool&gt; completeTask = 100;</code>
     */

    public Builder putAllCompleteTask(
        java.util.Map<java.lang.Integer, java.lang.Boolean> values) {
      internalGetMutableCompleteTask().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:Message.PlayerBackData)
  }

  // @@protoc_insertion_point(class_scope:Message.PlayerBackData)
  private static final game.proto.back.PlayerBackData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.back.PlayerBackData();
  }

  public static game.proto.back.PlayerBackData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PlayerBackData>
      PARSER = new com.google.protobuf.AbstractParser<PlayerBackData>() {
    @java.lang.Override
    public PlayerBackData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PlayerBackData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PlayerBackData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PlayerBackData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.back.PlayerBackData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

