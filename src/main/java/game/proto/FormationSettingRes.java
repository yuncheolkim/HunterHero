// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * Protobuf type {@code Message.FormationSettingRes}
 */
public final class FormationSettingRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.FormationSettingRes)
    FormationSettingResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FormationSettingRes.newBuilder() to construct.
  private FormationSettingRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FormationSettingRes() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FormationSettingRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FormationSettingRes(
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

            index_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 24: {

            defaultFormationIndex_ = input.readInt32();
            break;
          }
          case 32: {

            arenaFormationIndex_ = input.readInt32();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              changedIndex_ = com.google.protobuf.MapField.newMapField(
                  ChangedIndexDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
            changedIndex__ = input.readMessage(
                ChangedIndexDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            changedIndex_.getMutableMap().put(
                changedIndex__.getKey(), changedIndex__.getValue());
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
    return game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 5:
        return internalGetChangedIndex();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.FormationSettingRes.class, game.proto.FormationSettingRes.Builder.class);
  }

  public static final int INDEX_FIELD_NUMBER = 1;
  private int index_;
  /**
   * <code>int32 index = 1;</code>
   * @return The index.
   */
  @java.lang.Override
  public int getIndex() {
    return index_;
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DEFAULTFORMATIONINDEX_FIELD_NUMBER = 3;
  private int defaultFormationIndex_;
  /**
   * <code>int32 defaultFormationIndex = 3;</code>
   * @return The defaultFormationIndex.
   */
  @java.lang.Override
  public int getDefaultFormationIndex() {
    return defaultFormationIndex_;
  }

  public static final int ARENAFORMATIONINDEX_FIELD_NUMBER = 4;
  private int arenaFormationIndex_;
  /**
   * <code>int32 arenaFormationIndex = 4;</code>
   * @return The arenaFormationIndex.
   */
  @java.lang.Override
  public int getArenaFormationIndex() {
    return arenaFormationIndex_;
  }

  public static final int CHANGEDINDEX_FIELD_NUMBER = 5;
  private static final class ChangedIndexDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.Integer> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.Integer>newDefaultInstance(
                game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_ChangedIndexEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.INT32,
                0);
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, java.lang.Integer> changedIndex_;
  private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
  internalGetChangedIndex() {
    if (changedIndex_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          ChangedIndexDefaultEntryHolder.defaultEntry);
    }
    return changedIndex_;
  }

  public int getChangedIndexCount() {
    return internalGetChangedIndex().getMap().size();
  }
  /**
   * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
   */

  @java.lang.Override
  public boolean containsChangedIndex(
      int key) {
    
    return internalGetChangedIndex().getMap().containsKey(key);
  }
  /**
   * Use {@link #getChangedIndexMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, java.lang.Integer> getChangedIndex() {
    return getChangedIndexMap();
  }
  /**
   * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.Integer, java.lang.Integer> getChangedIndexMap() {
    return internalGetChangedIndex().getMap();
  }
  /**
   * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
   */
  @java.lang.Override

  public int getChangedIndexOrDefault(
      int key,
      int defaultValue) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetChangedIndex().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
   */
  @java.lang.Override

  public int getChangedIndexOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetChangedIndex().getMap();
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
    if (index_ != 0) {
      output.writeInt32(1, index_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (defaultFormationIndex_ != 0) {
      output.writeInt32(3, defaultFormationIndex_);
    }
    if (arenaFormationIndex_ != 0) {
      output.writeInt32(4, arenaFormationIndex_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeIntegerMapTo(
        output,
        internalGetChangedIndex(),
        ChangedIndexDefaultEntryHolder.defaultEntry,
        5);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (index_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, index_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (defaultFormationIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, defaultFormationIndex_);
    }
    if (arenaFormationIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, arenaFormationIndex_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
         : internalGetChangedIndex().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
      changedIndex__ = ChangedIndexDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(5, changedIndex__);
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
    if (!(obj instanceof game.proto.FormationSettingRes)) {
      return super.equals(obj);
    }
    game.proto.FormationSettingRes other = (game.proto.FormationSettingRes) obj;

    if (getIndex()
        != other.getIndex()) return false;
    if (!getName()
        .equals(other.getName())) return false;
    if (getDefaultFormationIndex()
        != other.getDefaultFormationIndex()) return false;
    if (getArenaFormationIndex()
        != other.getArenaFormationIndex()) return false;
    if (!internalGetChangedIndex().equals(
        other.internalGetChangedIndex())) return false;
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
    hash = (37 * hash) + INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getIndex();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + DEFAULTFORMATIONINDEX_FIELD_NUMBER;
    hash = (53 * hash) + getDefaultFormationIndex();
    hash = (37 * hash) + ARENAFORMATIONINDEX_FIELD_NUMBER;
    hash = (53 * hash) + getArenaFormationIndex();
    if (!internalGetChangedIndex().getMap().isEmpty()) {
      hash = (37 * hash) + CHANGEDINDEX_FIELD_NUMBER;
      hash = (53 * hash) + internalGetChangedIndex().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.FormationSettingRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationSettingRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationSettingRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationSettingRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationSettingRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.FormationSettingRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.FormationSettingRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FormationSettingRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FormationSettingRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.FormationSettingRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.FormationSettingRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.FormationSettingRes parseFrom(
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
  public static Builder newBuilder(game.proto.FormationSettingRes prototype) {
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
   * Protobuf type {@code Message.FormationSettingRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.FormationSettingRes)
      game.proto.FormationSettingResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 5:
          return internalGetChangedIndex();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 5:
          return internalGetMutableChangedIndex();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.FormationSettingRes.class, game.proto.FormationSettingRes.Builder.class);
    }

    // Construct using game.proto.FormationSettingRes.newBuilder()
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
      index_ = 0;

      name_ = "";

      defaultFormationIndex_ = 0;

      arenaFormationIndex_ = 0;

      internalGetMutableChangedIndex().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_FormationSettingRes_descriptor;
    }

    @java.lang.Override
    public game.proto.FormationSettingRes getDefaultInstanceForType() {
      return game.proto.FormationSettingRes.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.FormationSettingRes build() {
      game.proto.FormationSettingRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.FormationSettingRes buildPartial() {
      game.proto.FormationSettingRes result = new game.proto.FormationSettingRes(this);
      int from_bitField0_ = bitField0_;
      result.index_ = index_;
      result.name_ = name_;
      result.defaultFormationIndex_ = defaultFormationIndex_;
      result.arenaFormationIndex_ = arenaFormationIndex_;
      result.changedIndex_ = internalGetChangedIndex();
      result.changedIndex_.makeImmutable();
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
      if (other instanceof game.proto.FormationSettingRes) {
        return mergeFrom((game.proto.FormationSettingRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.FormationSettingRes other) {
      if (other == game.proto.FormationSettingRes.getDefaultInstance()) return this;
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getDefaultFormationIndex() != 0) {
        setDefaultFormationIndex(other.getDefaultFormationIndex());
      }
      if (other.getArenaFormationIndex() != 0) {
        setArenaFormationIndex(other.getArenaFormationIndex());
      }
      internalGetMutableChangedIndex().mergeFrom(
          other.internalGetChangedIndex());
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
      game.proto.FormationSettingRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.FormationSettingRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int index_ ;
    /**
     * <code>int32 index = 1;</code>
     * @return The index.
     */
    @java.lang.Override
    public int getIndex() {
      return index_;
    }
    /**
     * <code>int32 index = 1;</code>
     * @param value The index to set.
     * @return This builder for chaining.
     */
    public Builder setIndex(int value) {
      
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 index = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIndex() {
      
      index_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private int defaultFormationIndex_ ;
    /**
     * <code>int32 defaultFormationIndex = 3;</code>
     * @return The defaultFormationIndex.
     */
    @java.lang.Override
    public int getDefaultFormationIndex() {
      return defaultFormationIndex_;
    }
    /**
     * <code>int32 defaultFormationIndex = 3;</code>
     * @param value The defaultFormationIndex to set.
     * @return This builder for chaining.
     */
    public Builder setDefaultFormationIndex(int value) {
      
      defaultFormationIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 defaultFormationIndex = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDefaultFormationIndex() {
      
      defaultFormationIndex_ = 0;
      onChanged();
      return this;
    }

    private int arenaFormationIndex_ ;
    /**
     * <code>int32 arenaFormationIndex = 4;</code>
     * @return The arenaFormationIndex.
     */
    @java.lang.Override
    public int getArenaFormationIndex() {
      return arenaFormationIndex_;
    }
    /**
     * <code>int32 arenaFormationIndex = 4;</code>
     * @param value The arenaFormationIndex to set.
     * @return This builder for chaining.
     */
    public Builder setArenaFormationIndex(int value) {
      
      arenaFormationIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 arenaFormationIndex = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearArenaFormationIndex() {
      
      arenaFormationIndex_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.Integer> changedIndex_;
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetChangedIndex() {
      if (changedIndex_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ChangedIndexDefaultEntryHolder.defaultEntry);
      }
      return changedIndex_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetMutableChangedIndex() {
      onChanged();;
      if (changedIndex_ == null) {
        changedIndex_ = com.google.protobuf.MapField.newMapField(
            ChangedIndexDefaultEntryHolder.defaultEntry);
      }
      if (!changedIndex_.isMutable()) {
        changedIndex_ = changedIndex_.copy();
      }
      return changedIndex_;
    }

    public int getChangedIndexCount() {
      return internalGetChangedIndex().getMap().size();
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */

    @java.lang.Override
    public boolean containsChangedIndex(
        int key) {
      
      return internalGetChangedIndex().getMap().containsKey(key);
    }
    /**
     * Use {@link #getChangedIndexMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer> getChangedIndex() {
      return getChangedIndexMap();
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.Integer, java.lang.Integer> getChangedIndexMap() {
      return internalGetChangedIndex().getMap();
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */
    @java.lang.Override

    public int getChangedIndexOrDefault(
        int key,
        int defaultValue) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetChangedIndex().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */
    @java.lang.Override

    public int getChangedIndexOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetChangedIndex().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearChangedIndex() {
      internalGetMutableChangedIndex().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */

    public Builder removeChangedIndex(
        int key) {
      
      internalGetMutableChangedIndex().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer>
    getMutableChangedIndex() {
      return internalGetMutableChangedIndex().getMutableMap();
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */
    public Builder putChangedIndex(
        int key,
        int value) {
      
      
      internalGetMutableChangedIndex().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, int32&gt; changedIndex = 5;</code>
     */

    public Builder putAllChangedIndex(
        java.util.Map<java.lang.Integer, java.lang.Integer> values) {
      internalGetMutableChangedIndex().getMutableMap()
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


    // @@protoc_insertion_point(builder_scope:Message.FormationSettingRes)
  }

  // @@protoc_insertion_point(class_scope:Message.FormationSettingRes)
  private static final game.proto.FormationSettingRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.FormationSettingRes();
  }

  public static game.proto.FormationSettingRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FormationSettingRes>
      PARSER = new com.google.protobuf.AbstractParser<FormationSettingRes>() {
    @java.lang.Override
    public FormationSettingRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FormationSettingRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FormationSettingRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FormationSettingRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.FormationSettingRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

