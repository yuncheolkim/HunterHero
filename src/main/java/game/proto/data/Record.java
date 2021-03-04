// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

/**
 * Protobuf type {@code Message.Record}
 */
public final class Record extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.Record)
    RecordOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Record.newBuilder() to construct.
  private Record(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Record() {
    type_ = 0;
    target_ = emptyIntList();
    damageType_ = 0;
    actionPoint_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Record();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Record(
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
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          case 16: {

            heroId_ = input.readInt32();
            break;
          }
          case 24: {

            id_ = input.readInt32();
            break;
          }
          case 88: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              target_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            target_.addInt(input.readInt32());
            break;
          }
          case 90: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              target_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              target_.addInt(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 168: {
            int rawValue = input.readEnum();

            damageType_ = rawValue;
            break;
          }
          case 176: {

            value_ = input.readInt32();
            break;
          }
          case 258: {
            java.lang.String s = input.readStringRequireUtf8();

            actionPoint_ = s;
            break;
          }
          case 330: {
            game.proto.data.BuffRecord.Builder subBuilder = null;
            if (buffRecord_ != null) {
              subBuilder = buffRecord_.toBuilder();
            }
            buffRecord_ = input.readMessage(game.proto.data.BuffRecord.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(buffRecord_);
              buffRecord_ = subBuilder.buildPartial();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        target_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return game.proto.data.Data.internal_static_Message_Record_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.data.Data.internal_static_Message_Record_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.data.Record.class, game.proto.data.Record.Builder.class);
  }

  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_;
  /**
   * <code>.Message.RecordType type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.Message.RecordType type = 1;</code>
   * @return The type.
   */
  @java.lang.Override public game.proto.data.RecordType getType() {
    @SuppressWarnings("deprecation")
    game.proto.data.RecordType result = game.proto.data.RecordType.valueOf(type_);
    return result == null ? game.proto.data.RecordType.UNRECOGNIZED : result;
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

  public static final int ID_FIELD_NUMBER = 3;
  private int id_;
  /**
   * <code>int32 id = 3;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int TARGET_FIELD_NUMBER = 11;
  private com.google.protobuf.Internal.IntList target_;
  /**
   * <code>repeated int32 target = 11;</code>
   * @return A list containing the target.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getTargetList() {
    return target_;
  }
  /**
   * <code>repeated int32 target = 11;</code>
   * @return The count of target.
   */
  public int getTargetCount() {
    return target_.size();
  }
  /**
   * <code>repeated int32 target = 11;</code>
   * @param index The index of the element to return.
   * @return The target at the given index.
   */
  public int getTarget(int index) {
    return target_.getInt(index);
  }
  private int targetMemoizedSerializedSize = -1;

  public static final int DAMAGETYPE_FIELD_NUMBER = 21;
  private int damageType_;
  /**
   * <code>.Message.DamageType damageType = 21;</code>
   * @return The enum numeric value on the wire for damageType.
   */
  @java.lang.Override public int getDamageTypeValue() {
    return damageType_;
  }
  /**
   * <code>.Message.DamageType damageType = 21;</code>
   * @return The damageType.
   */
  @java.lang.Override public game.proto.data.DamageType getDamageType() {
    @SuppressWarnings("deprecation")
    game.proto.data.DamageType result = game.proto.data.DamageType.valueOf(damageType_);
    return result == null ? game.proto.data.DamageType.UNRECOGNIZED : result;
  }

  public static final int VALUE_FIELD_NUMBER = 22;
  private int value_;
  /**
   * <code>int32 value = 22;</code>
   * @return The value.
   */
  @java.lang.Override
  public int getValue() {
    return value_;
  }

  public static final int ACTIONPOINT_FIELD_NUMBER = 32;
  private volatile java.lang.Object actionPoint_;
  /**
   * <code>string actionPoint = 32;</code>
   * @return The actionPoint.
   */
  @java.lang.Override
  public java.lang.String getActionPoint() {
    java.lang.Object ref = actionPoint_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      actionPoint_ = s;
      return s;
    }
  }
  /**
   * <code>string actionPoint = 32;</code>
   * @return The bytes for actionPoint.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getActionPointBytes() {
    java.lang.Object ref = actionPoint_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      actionPoint_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BUFFRECORD_FIELD_NUMBER = 41;
  private game.proto.data.BuffRecord buffRecord_;
  /**
   * <code>.Message.BuffRecord buffRecord = 41;</code>
   * @return Whether the buffRecord field is set.
   */
  @java.lang.Override
  public boolean hasBuffRecord() {
    return buffRecord_ != null;
  }
  /**
   * <code>.Message.BuffRecord buffRecord = 41;</code>
   * @return The buffRecord.
   */
  @java.lang.Override
  public game.proto.data.BuffRecord getBuffRecord() {
    return buffRecord_ == null ? game.proto.data.BuffRecord.getDefaultInstance() : buffRecord_;
  }
  /**
   * <code>.Message.BuffRecord buffRecord = 41;</code>
   */
  @java.lang.Override
  public game.proto.data.BuffRecordOrBuilder getBuffRecordOrBuilder() {
    return getBuffRecord();
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
    if (type_ != game.proto.data.RecordType.ACTION.getNumber()) {
      output.writeEnum(1, type_);
    }
    if (heroId_ != 0) {
      output.writeInt32(2, heroId_);
    }
    if (id_ != 0) {
      output.writeInt32(3, id_);
    }
    if (getTargetList().size() > 0) {
      output.writeUInt32NoTag(90);
      output.writeUInt32NoTag(targetMemoizedSerializedSize);
    }
    for (int i = 0; i < target_.size(); i++) {
      output.writeInt32NoTag(target_.getInt(i));
    }
    if (damageType_ != game.proto.data.DamageType.DAMAGE_NORMAL.getNumber()) {
      output.writeEnum(21, damageType_);
    }
    if (value_ != 0) {
      output.writeInt32(22, value_);
    }
    if (!getActionPointBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 32, actionPoint_);
    }
    if (buffRecord_ != null) {
      output.writeMessage(41, getBuffRecord());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (type_ != game.proto.data.RecordType.ACTION.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (heroId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, heroId_);
    }
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, id_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < target_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(target_.getInt(i));
      }
      size += dataSize;
      if (!getTargetList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      targetMemoizedSerializedSize = dataSize;
    }
    if (damageType_ != game.proto.data.DamageType.DAMAGE_NORMAL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(21, damageType_);
    }
    if (value_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(22, value_);
    }
    if (!getActionPointBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(32, actionPoint_);
    }
    if (buffRecord_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(41, getBuffRecord());
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
    if (!(obj instanceof game.proto.data.Record)) {
      return super.equals(obj);
    }
    game.proto.data.Record other = (game.proto.data.Record) obj;

    if (type_ != other.type_) return false;
    if (getHeroId()
        != other.getHeroId()) return false;
    if (getId()
        != other.getId()) return false;
    if (!getTargetList()
        .equals(other.getTargetList())) return false;
    if (damageType_ != other.damageType_) return false;
    if (getValue()
        != other.getValue()) return false;
    if (!getActionPoint()
        .equals(other.getActionPoint())) return false;
    if (hasBuffRecord() != other.hasBuffRecord()) return false;
    if (hasBuffRecord()) {
      if (!getBuffRecord()
          .equals(other.getBuffRecord())) return false;
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
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + HEROID_FIELD_NUMBER;
    hash = (53 * hash) + getHeroId();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    if (getTargetCount() > 0) {
      hash = (37 * hash) + TARGET_FIELD_NUMBER;
      hash = (53 * hash) + getTargetList().hashCode();
    }
    hash = (37 * hash) + DAMAGETYPE_FIELD_NUMBER;
    hash = (53 * hash) + damageType_;
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue();
    hash = (37 * hash) + ACTIONPOINT_FIELD_NUMBER;
    hash = (53 * hash) + getActionPoint().hashCode();
    if (hasBuffRecord()) {
      hash = (37 * hash) + BUFFRECORD_FIELD_NUMBER;
      hash = (53 * hash) + getBuffRecord().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.data.Record parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Record parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Record parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Record parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Record parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.data.Record parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.data.Record parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Record parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Record parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.data.Record parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.data.Record parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.data.Record parseFrom(
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
  public static Builder newBuilder(game.proto.data.Record prototype) {
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
   * Protobuf type {@code Message.Record}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.Record)
      game.proto.data.RecordOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.data.Data.internal_static_Message_Record_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.data.Data.internal_static_Message_Record_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.data.Record.class, game.proto.data.Record.Builder.class);
    }

    // Construct using game.proto.data.Record.newBuilder()
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
      type_ = 0;

      heroId_ = 0;

      id_ = 0;

      target_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      damageType_ = 0;

      value_ = 0;

      actionPoint_ = "";

      if (buffRecordBuilder_ == null) {
        buffRecord_ = null;
      } else {
        buffRecord_ = null;
        buffRecordBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.data.Data.internal_static_Message_Record_descriptor;
    }

    @java.lang.Override
    public game.proto.data.Record getDefaultInstanceForType() {
      return game.proto.data.Record.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.data.Record build() {
      game.proto.data.Record result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.data.Record buildPartial() {
      game.proto.data.Record result = new game.proto.data.Record(this);
      int from_bitField0_ = bitField0_;
      result.type_ = type_;
      result.heroId_ = heroId_;
      result.id_ = id_;
      if (((bitField0_ & 0x00000001) != 0)) {
        target_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.target_ = target_;
      result.damageType_ = damageType_;
      result.value_ = value_;
      result.actionPoint_ = actionPoint_;
      if (buffRecordBuilder_ == null) {
        result.buffRecord_ = buffRecord_;
      } else {
        result.buffRecord_ = buffRecordBuilder_.build();
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
      if (other instanceof game.proto.data.Record) {
        return mergeFrom((game.proto.data.Record)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.data.Record other) {
      if (other == game.proto.data.Record.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.getHeroId() != 0) {
        setHeroId(other.getHeroId());
      }
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.target_.isEmpty()) {
        if (target_.isEmpty()) {
          target_ = other.target_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTargetIsMutable();
          target_.addAll(other.target_);
        }
        onChanged();
      }
      if (other.damageType_ != 0) {
        setDamageTypeValue(other.getDamageTypeValue());
      }
      if (other.getValue() != 0) {
        setValue(other.getValue());
      }
      if (!other.getActionPoint().isEmpty()) {
        actionPoint_ = other.actionPoint_;
        onChanged();
      }
      if (other.hasBuffRecord()) {
        mergeBuffRecord(other.getBuffRecord());
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
      game.proto.data.Record parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.data.Record) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int type_ = 0;
    /**
     * <code>.Message.RecordType type = 1;</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.Message.RecordType type = 1;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Message.RecordType type = 1;</code>
     * @return The type.
     */
    @java.lang.Override
    public game.proto.data.RecordType getType() {
      @SuppressWarnings("deprecation")
      game.proto.data.RecordType result = game.proto.data.RecordType.valueOf(type_);
      return result == null ? game.proto.data.RecordType.UNRECOGNIZED : result;
    }
    /**
     * <code>.Message.RecordType type = 1;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(game.proto.data.RecordType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Message.RecordType type = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = 0;
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

    private int id_ ;
    /**
     * <code>int32 id = 3;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 3;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.IntList target_ = emptyIntList();
    private void ensureTargetIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        target_ = mutableCopy(target_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @return A list containing the target.
     */
    public java.util.List<java.lang.Integer>
        getTargetList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(target_) : target_;
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @return The count of target.
     */
    public int getTargetCount() {
      return target_.size();
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @param index The index of the element to return.
     * @return The target at the given index.
     */
    public int getTarget(int index) {
      return target_.getInt(index);
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @param index The index to set the value at.
     * @param value The target to set.
     * @return This builder for chaining.
     */
    public Builder setTarget(
        int index, int value) {
      ensureTargetIsMutable();
      target_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @param value The target to add.
     * @return This builder for chaining.
     */
    public Builder addTarget(int value) {
      ensureTargetIsMutable();
      target_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @param values The target to add.
     * @return This builder for chaining.
     */
    public Builder addAllTarget(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureTargetIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, target_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 target = 11;</code>
     * @return This builder for chaining.
     */
    public Builder clearTarget() {
      target_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private int damageType_ = 0;
    /**
     * <code>.Message.DamageType damageType = 21;</code>
     * @return The enum numeric value on the wire for damageType.
     */
    @java.lang.Override public int getDamageTypeValue() {
      return damageType_;
    }
    /**
     * <code>.Message.DamageType damageType = 21;</code>
     * @param value The enum numeric value on the wire for damageType to set.
     * @return This builder for chaining.
     */
    public Builder setDamageTypeValue(int value) {
      
      damageType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.Message.DamageType damageType = 21;</code>
     * @return The damageType.
     */
    @java.lang.Override
    public game.proto.data.DamageType getDamageType() {
      @SuppressWarnings("deprecation")
      game.proto.data.DamageType result = game.proto.data.DamageType.valueOf(damageType_);
      return result == null ? game.proto.data.DamageType.UNRECOGNIZED : result;
    }
    /**
     * <code>.Message.DamageType damageType = 21;</code>
     * @param value The damageType to set.
     * @return This builder for chaining.
     */
    public Builder setDamageType(game.proto.data.DamageType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      damageType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.Message.DamageType damageType = 21;</code>
     * @return This builder for chaining.
     */
    public Builder clearDamageType() {
      
      damageType_ = 0;
      onChanged();
      return this;
    }

    private int value_ ;
    /**
     * <code>int32 value = 22;</code>
     * @return The value.
     */
    @java.lang.Override
    public int getValue() {
      return value_;
    }
    /**
     * <code>int32 value = 22;</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(int value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 value = 22;</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      
      value_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object actionPoint_ = "";
    /**
     * <code>string actionPoint = 32;</code>
     * @return The actionPoint.
     */
    public java.lang.String getActionPoint() {
      java.lang.Object ref = actionPoint_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        actionPoint_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string actionPoint = 32;</code>
     * @return The bytes for actionPoint.
     */
    public com.google.protobuf.ByteString
        getActionPointBytes() {
      java.lang.Object ref = actionPoint_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        actionPoint_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string actionPoint = 32;</code>
     * @param value The actionPoint to set.
     * @return This builder for chaining.
     */
    public Builder setActionPoint(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      actionPoint_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string actionPoint = 32;</code>
     * @return This builder for chaining.
     */
    public Builder clearActionPoint() {
      
      actionPoint_ = getDefaultInstance().getActionPoint();
      onChanged();
      return this;
    }
    /**
     * <code>string actionPoint = 32;</code>
     * @param value The bytes for actionPoint to set.
     * @return This builder for chaining.
     */
    public Builder setActionPointBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      actionPoint_ = value;
      onChanged();
      return this;
    }

    private game.proto.data.BuffRecord buffRecord_;
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.BuffRecord, game.proto.data.BuffRecord.Builder, game.proto.data.BuffRecordOrBuilder> buffRecordBuilder_;
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     * @return Whether the buffRecord field is set.
     */
    public boolean hasBuffRecord() {
      return buffRecordBuilder_ != null || buffRecord_ != null;
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     * @return The buffRecord.
     */
    public game.proto.data.BuffRecord getBuffRecord() {
      if (buffRecordBuilder_ == null) {
        return buffRecord_ == null ? game.proto.data.BuffRecord.getDefaultInstance() : buffRecord_;
      } else {
        return buffRecordBuilder_.getMessage();
      }
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public Builder setBuffRecord(game.proto.data.BuffRecord value) {
      if (buffRecordBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        buffRecord_ = value;
        onChanged();
      } else {
        buffRecordBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public Builder setBuffRecord(
        game.proto.data.BuffRecord.Builder builderForValue) {
      if (buffRecordBuilder_ == null) {
        buffRecord_ = builderForValue.build();
        onChanged();
      } else {
        buffRecordBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public Builder mergeBuffRecord(game.proto.data.BuffRecord value) {
      if (buffRecordBuilder_ == null) {
        if (buffRecord_ != null) {
          buffRecord_ =
            game.proto.data.BuffRecord.newBuilder(buffRecord_).mergeFrom(value).buildPartial();
        } else {
          buffRecord_ = value;
        }
        onChanged();
      } else {
        buffRecordBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public Builder clearBuffRecord() {
      if (buffRecordBuilder_ == null) {
        buffRecord_ = null;
        onChanged();
      } else {
        buffRecord_ = null;
        buffRecordBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public game.proto.data.BuffRecord.Builder getBuffRecordBuilder() {
      
      onChanged();
      return getBuffRecordFieldBuilder().getBuilder();
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    public game.proto.data.BuffRecordOrBuilder getBuffRecordOrBuilder() {
      if (buffRecordBuilder_ != null) {
        return buffRecordBuilder_.getMessageOrBuilder();
      } else {
        return buffRecord_ == null ?
            game.proto.data.BuffRecord.getDefaultInstance() : buffRecord_;
      }
    }
    /**
     * <code>.Message.BuffRecord buffRecord = 41;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.BuffRecord, game.proto.data.BuffRecord.Builder, game.proto.data.BuffRecordOrBuilder> 
        getBuffRecordFieldBuilder() {
      if (buffRecordBuilder_ == null) {
        buffRecordBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            game.proto.data.BuffRecord, game.proto.data.BuffRecord.Builder, game.proto.data.BuffRecordOrBuilder>(
                getBuffRecord(),
                getParentForChildren(),
                isClean());
        buffRecord_ = null;
      }
      return buffRecordBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.Record)
  }

  // @@protoc_insertion_point(class_scope:Message.Record)
  private static final game.proto.data.Record DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.data.Record();
  }

  public static game.proto.data.Record getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Record>
      PARSER = new com.google.protobuf.AbstractParser<Record>() {
    @java.lang.Override
    public Record parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Record(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Record> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Record> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.data.Record getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

