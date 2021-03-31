// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface TaskStatusChangePushOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.TaskStatusChangePush)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 taskId = 1;</code>
   * @return The taskId.
   */
  int getTaskId();

  /**
   * <pre>
   * 0:不可用,1:可以接受,2:进行中,3:已完成未提交,4:完成提交
   * </pre>
   *
   * <code>bool complete = 2;</code>
   * @return The complete.
   */
  boolean getComplete();

  /**
   * <pre>
   * 任务进度
   * </pre>
   *
   * <code>int32 count = 3;</code>
   * @return The count.
   */
  int getCount();

  /**
   * <code>int32 targetId = 4;</code>
   * @return The targetId.
   */
  int getTargetId();

  /**
   * <pre>
   * 接受任务
   * </pre>
   *
   * <code>bool accept = 5;</code>
   * @return The accept.
   */
  boolean getAccept();
}
