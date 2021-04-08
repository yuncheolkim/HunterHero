// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

/**
 * <pre>
 * 任务发生变化
 * </pre>
 *
 * Protobuf type {@code Message.TaskStatusChangePush}
 */
public final class TaskStatusChangePush extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Message.TaskStatusChangePush)
    TaskStatusChangePushOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskStatusChangePush.newBuilder() to construct.
  private TaskStatusChangePush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskStatusChangePush() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskStatusChangePush();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskStatusChangePush(
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
          case 80: {

            npcId_ = input.readInt32();
            break;
          }
          case 160: {

            taskId_ = input.readInt32();
            break;
          }
          case 240: {

            complete_ = input.readBool();
            break;
          }
          case 280: {

            status_ = input.readInt32();
            break;
          }
          case 320: {

            count_ = input.readInt32();
            break;
          }
          case 400: {

            targetId_ = input.readInt32();
            break;
          }
          case 480: {

            accept_ = input.readBool();
            break;
          }
          case 562: {
            game.proto.data.RunTask.Builder subBuilder = null;
            if (runTask_ != null) {
              subBuilder = runTask_.toBuilder();
            }
            runTask_ = input.readMessage(game.proto.data.RunTask.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(runTask_);
              runTask_ = subBuilder.buildPartial();
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
    return game.proto.MessageOuterClass.internal_static_Message_TaskStatusChangePush_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return game.proto.MessageOuterClass.internal_static_Message_TaskStatusChangePush_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            game.proto.TaskStatusChangePush.class, game.proto.TaskStatusChangePush.Builder.class);
  }

  public static final int NPCID_FIELD_NUMBER = 10;
  private int npcId_;
  /**
   * <code>int32 npcId = 10;</code>
   * @return The npcId.
   */
  @java.lang.Override
  public int getNpcId() {
    return npcId_;
  }

  public static final int TASKID_FIELD_NUMBER = 20;
  private int taskId_;
  /**
   * <code>int32 taskId = 20;</code>
   * @return The taskId.
   */
  @java.lang.Override
  public int getTaskId() {
    return taskId_;
  }

  public static final int COMPLETE_FIELD_NUMBER = 30;
  private boolean complete_;
  /**
   * <code>bool complete = 30;</code>
   * @return The complete.
   */
  @java.lang.Override
  public boolean getComplete() {
    return complete_;
  }

  public static final int STATUS_FIELD_NUMBER = 35;
  private int status_;
  /**
   * <pre>
   * 1:完成未提交,2:完成已提交
   * </pre>
   *
   * <code>int32 status = 35;</code>
   * @return The status.
   */
  @java.lang.Override
  public int getStatus() {
    return status_;
  }

  public static final int COUNT_FIELD_NUMBER = 40;
  private int count_;
  /**
   * <pre>
   * 任务进度
   * </pre>
   *
   * <code>int32 count = 40;</code>
   * @return The count.
   */
  @java.lang.Override
  public int getCount() {
    return count_;
  }

  public static final int TARGETID_FIELD_NUMBER = 50;
  private int targetId_;
  /**
   * <code>int32 targetId = 50;</code>
   * @return The targetId.
   */
  @java.lang.Override
  public int getTargetId() {
    return targetId_;
  }

  public static final int ACCEPT_FIELD_NUMBER = 60;
  private boolean accept_;
  /**
   * <pre>
   * 第一次接受任务
   * </pre>
   *
   * <code>bool accept = 60;</code>
   * @return The accept.
   */
  @java.lang.Override
  public boolean getAccept() {
    return accept_;
  }

  public static final int RUNTASK_FIELD_NUMBER = 70;
  private game.proto.data.RunTask runTask_;
  /**
   * <code>.Message.RunTask runTask = 70;</code>
   * @return Whether the runTask field is set.
   */
  @java.lang.Override
  public boolean hasRunTask() {
    return runTask_ != null;
  }
  /**
   * <code>.Message.RunTask runTask = 70;</code>
   * @return The runTask.
   */
  @java.lang.Override
  public game.proto.data.RunTask getRunTask() {
    return runTask_ == null ? game.proto.data.RunTask.getDefaultInstance() : runTask_;
  }
  /**
   * <code>.Message.RunTask runTask = 70;</code>
   */
  @java.lang.Override
  public game.proto.data.RunTaskOrBuilder getRunTaskOrBuilder() {
    return getRunTask();
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
    if (npcId_ != 0) {
      output.writeInt32(10, npcId_);
    }
    if (taskId_ != 0) {
      output.writeInt32(20, taskId_);
    }
    if (complete_ != false) {
      output.writeBool(30, complete_);
    }
    if (status_ != 0) {
      output.writeInt32(35, status_);
    }
    if (count_ != 0) {
      output.writeInt32(40, count_);
    }
    if (targetId_ != 0) {
      output.writeInt32(50, targetId_);
    }
    if (accept_ != false) {
      output.writeBool(60, accept_);
    }
    if (runTask_ != null) {
      output.writeMessage(70, getRunTask());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (npcId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(10, npcId_);
    }
    if (taskId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(20, taskId_);
    }
    if (complete_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(30, complete_);
    }
    if (status_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(35, status_);
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(40, count_);
    }
    if (targetId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(50, targetId_);
    }
    if (accept_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(60, accept_);
    }
    if (runTask_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(70, getRunTask());
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
    if (!(obj instanceof game.proto.TaskStatusChangePush)) {
      return super.equals(obj);
    }
    game.proto.TaskStatusChangePush other = (game.proto.TaskStatusChangePush) obj;

    if (getNpcId()
        != other.getNpcId()) return false;
    if (getTaskId()
        != other.getTaskId()) return false;
    if (getComplete()
        != other.getComplete()) return false;
    if (getStatus()
        != other.getStatus()) return false;
    if (getCount()
        != other.getCount()) return false;
    if (getTargetId()
        != other.getTargetId()) return false;
    if (getAccept()
        != other.getAccept()) return false;
    if (hasRunTask() != other.hasRunTask()) return false;
    if (hasRunTask()) {
      if (!getRunTask()
          .equals(other.getRunTask())) return false;
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
    hash = (37 * hash) + NPCID_FIELD_NUMBER;
    hash = (53 * hash) + getNpcId();
    hash = (37 * hash) + TASKID_FIELD_NUMBER;
    hash = (53 * hash) + getTaskId();
    hash = (37 * hash) + COMPLETE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getComplete());
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus();
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (37 * hash) + TARGETID_FIELD_NUMBER;
    hash = (53 * hash) + getTargetId();
    hash = (37 * hash) + ACCEPT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAccept());
    if (hasRunTask()) {
      hash = (37 * hash) + RUNTASK_FIELD_NUMBER;
      hash = (53 * hash) + getRunTask().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static game.proto.TaskStatusChangePush parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.TaskStatusChangePush parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static game.proto.TaskStatusChangePush parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.TaskStatusChangePush parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static game.proto.TaskStatusChangePush parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static game.proto.TaskStatusChangePush parseFrom(
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
  public static Builder newBuilder(game.proto.TaskStatusChangePush prototype) {
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
   * 任务发生变化
   * </pre>
   *
   * Protobuf type {@code Message.TaskStatusChangePush}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Message.TaskStatusChangePush)
      game.proto.TaskStatusChangePushOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return game.proto.MessageOuterClass.internal_static_Message_TaskStatusChangePush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return game.proto.MessageOuterClass.internal_static_Message_TaskStatusChangePush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              game.proto.TaskStatusChangePush.class, game.proto.TaskStatusChangePush.Builder.class);
    }

    // Construct using game.proto.TaskStatusChangePush.newBuilder()
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
      npcId_ = 0;

      taskId_ = 0;

      complete_ = false;

      status_ = 0;

      count_ = 0;

      targetId_ = 0;

      accept_ = false;

      if (runTaskBuilder_ == null) {
        runTask_ = null;
      } else {
        runTask_ = null;
        runTaskBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return game.proto.MessageOuterClass.internal_static_Message_TaskStatusChangePush_descriptor;
    }

    @java.lang.Override
    public game.proto.TaskStatusChangePush getDefaultInstanceForType() {
      return game.proto.TaskStatusChangePush.getDefaultInstance();
    }

    @java.lang.Override
    public game.proto.TaskStatusChangePush build() {
      game.proto.TaskStatusChangePush result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public game.proto.TaskStatusChangePush buildPartial() {
      game.proto.TaskStatusChangePush result = new game.proto.TaskStatusChangePush(this);
      result.npcId_ = npcId_;
      result.taskId_ = taskId_;
      result.complete_ = complete_;
      result.status_ = status_;
      result.count_ = count_;
      result.targetId_ = targetId_;
      result.accept_ = accept_;
      if (runTaskBuilder_ == null) {
        result.runTask_ = runTask_;
      } else {
        result.runTask_ = runTaskBuilder_.build();
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
      if (other instanceof game.proto.TaskStatusChangePush) {
        return mergeFrom((game.proto.TaskStatusChangePush)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(game.proto.TaskStatusChangePush other) {
      if (other == game.proto.TaskStatusChangePush.getDefaultInstance()) return this;
      if (other.getNpcId() != 0) {
        setNpcId(other.getNpcId());
      }
      if (other.getTaskId() != 0) {
        setTaskId(other.getTaskId());
      }
      if (other.getComplete() != false) {
        setComplete(other.getComplete());
      }
      if (other.getStatus() != 0) {
        setStatus(other.getStatus());
      }
      if (other.getCount() != 0) {
        setCount(other.getCount());
      }
      if (other.getTargetId() != 0) {
        setTargetId(other.getTargetId());
      }
      if (other.getAccept() != false) {
        setAccept(other.getAccept());
      }
      if (other.hasRunTask()) {
        mergeRunTask(other.getRunTask());
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
      game.proto.TaskStatusChangePush parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (game.proto.TaskStatusChangePush) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int npcId_ ;
    /**
     * <code>int32 npcId = 10;</code>
     * @return The npcId.
     */
    @java.lang.Override
    public int getNpcId() {
      return npcId_;
    }
    /**
     * <code>int32 npcId = 10;</code>
     * @param value The npcId to set.
     * @return This builder for chaining.
     */
    public Builder setNpcId(int value) {
      
      npcId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 npcId = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearNpcId() {
      
      npcId_ = 0;
      onChanged();
      return this;
    }

    private int taskId_ ;
    /**
     * <code>int32 taskId = 20;</code>
     * @return The taskId.
     */
    @java.lang.Override
    public int getTaskId() {
      return taskId_;
    }
    /**
     * <code>int32 taskId = 20;</code>
     * @param value The taskId to set.
     * @return This builder for chaining.
     */
    public Builder setTaskId(int value) {
      
      taskId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 taskId = 20;</code>
     * @return This builder for chaining.
     */
    public Builder clearTaskId() {
      
      taskId_ = 0;
      onChanged();
      return this;
    }

    private boolean complete_ ;
    /**
     * <code>bool complete = 30;</code>
     * @return The complete.
     */
    @java.lang.Override
    public boolean getComplete() {
      return complete_;
    }
    /**
     * <code>bool complete = 30;</code>
     * @param value The complete to set.
     * @return This builder for chaining.
     */
    public Builder setComplete(boolean value) {
      
      complete_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool complete = 30;</code>
     * @return This builder for chaining.
     */
    public Builder clearComplete() {
      
      complete_ = false;
      onChanged();
      return this;
    }

    private int status_ ;
    /**
     * <pre>
     * 1:完成未提交,2:完成已提交
     * </pre>
     *
     * <code>int32 status = 35;</code>
     * @return The status.
     */
    @java.lang.Override
    public int getStatus() {
      return status_;
    }
    /**
     * <pre>
     * 1:完成未提交,2:完成已提交
     * </pre>
     *
     * <code>int32 status = 35;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 1:完成未提交,2:完成已提交
     * </pre>
     *
     * <code>int32 status = 35;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private int count_ ;
    /**
     * <pre>
     * 任务进度
     * </pre>
     *
     * <code>int32 count = 40;</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return count_;
    }
    /**
     * <pre>
     * 任务进度
     * </pre>
     *
     * <code>int32 count = 40;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 任务进度
     * </pre>
     *
     * <code>int32 count = 40;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      
      count_ = 0;
      onChanged();
      return this;
    }

    private int targetId_ ;
    /**
     * <code>int32 targetId = 50;</code>
     * @return The targetId.
     */
    @java.lang.Override
    public int getTargetId() {
      return targetId_;
    }
    /**
     * <code>int32 targetId = 50;</code>
     * @param value The targetId to set.
     * @return This builder for chaining.
     */
    public Builder setTargetId(int value) {
      
      targetId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 targetId = 50;</code>
     * @return This builder for chaining.
     */
    public Builder clearTargetId() {
      
      targetId_ = 0;
      onChanged();
      return this;
    }

    private boolean accept_ ;
    /**
     * <pre>
     * 第一次接受任务
     * </pre>
     *
     * <code>bool accept = 60;</code>
     * @return The accept.
     */
    @java.lang.Override
    public boolean getAccept() {
      return accept_;
    }
    /**
     * <pre>
     * 第一次接受任务
     * </pre>
     *
     * <code>bool accept = 60;</code>
     * @param value The accept to set.
     * @return This builder for chaining.
     */
    public Builder setAccept(boolean value) {
      
      accept_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 第一次接受任务
     * </pre>
     *
     * <code>bool accept = 60;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccept() {
      
      accept_ = false;
      onChanged();
      return this;
    }

    private game.proto.data.RunTask runTask_;
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.RunTask, game.proto.data.RunTask.Builder, game.proto.data.RunTaskOrBuilder> runTaskBuilder_;
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     * @return Whether the runTask field is set.
     */
    public boolean hasRunTask() {
      return runTaskBuilder_ != null || runTask_ != null;
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     * @return The runTask.
     */
    public game.proto.data.RunTask getRunTask() {
      if (runTaskBuilder_ == null) {
        return runTask_ == null ? game.proto.data.RunTask.getDefaultInstance() : runTask_;
      } else {
        return runTaskBuilder_.getMessage();
      }
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public Builder setRunTask(game.proto.data.RunTask value) {
      if (runTaskBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        runTask_ = value;
        onChanged();
      } else {
        runTaskBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public Builder setRunTask(
        game.proto.data.RunTask.Builder builderForValue) {
      if (runTaskBuilder_ == null) {
        runTask_ = builderForValue.build();
        onChanged();
      } else {
        runTaskBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public Builder mergeRunTask(game.proto.data.RunTask value) {
      if (runTaskBuilder_ == null) {
        if (runTask_ != null) {
          runTask_ =
            game.proto.data.RunTask.newBuilder(runTask_).mergeFrom(value).buildPartial();
        } else {
          runTask_ = value;
        }
        onChanged();
      } else {
        runTaskBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public Builder clearRunTask() {
      if (runTaskBuilder_ == null) {
        runTask_ = null;
        onChanged();
      } else {
        runTask_ = null;
        runTaskBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public game.proto.data.RunTask.Builder getRunTaskBuilder() {
      
      onChanged();
      return getRunTaskFieldBuilder().getBuilder();
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    public game.proto.data.RunTaskOrBuilder getRunTaskOrBuilder() {
      if (runTaskBuilder_ != null) {
        return runTaskBuilder_.getMessageOrBuilder();
      } else {
        return runTask_ == null ?
            game.proto.data.RunTask.getDefaultInstance() : runTask_;
      }
    }
    /**
     * <code>.Message.RunTask runTask = 70;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        game.proto.data.RunTask, game.proto.data.RunTask.Builder, game.proto.data.RunTaskOrBuilder> 
        getRunTaskFieldBuilder() {
      if (runTaskBuilder_ == null) {
        runTaskBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            game.proto.data.RunTask, game.proto.data.RunTask.Builder, game.proto.data.RunTaskOrBuilder>(
                getRunTask(),
                getParentForChildren(),
                isClean());
        runTask_ = null;
      }
      return runTaskBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Message.TaskStatusChangePush)
  }

  // @@protoc_insertion_point(class_scope:Message.TaskStatusChangePush)
  private static final game.proto.TaskStatusChangePush DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new game.proto.TaskStatusChangePush();
  }

  public static game.proto.TaskStatusChangePush getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskStatusChangePush>
      PARSER = new com.google.protobuf.AbstractParser<TaskStatusChangePush>() {
    @java.lang.Override
    public TaskStatusChangePush parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaskStatusChangePush(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskStatusChangePush> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskStatusChangePush> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public game.proto.TaskStatusChangePush getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
