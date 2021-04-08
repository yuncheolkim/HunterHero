// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package game.proto;

public interface TaskNpcResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.TaskNpcRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 npcId = 1;</code>
   * @return The npcId.
   */
  int getNpcId();

  /**
   * <code>repeated int32 acceptableTask = 2;</code>
   * @return A list containing the acceptableTask.
   */
  java.util.List<java.lang.Integer> getAcceptableTaskList();
  /**
   * <code>repeated int32 acceptableTask = 2;</code>
   * @return The count of acceptableTask.
   */
  int getAcceptableTaskCount();
  /**
   * <code>repeated int32 acceptableTask = 2;</code>
   * @param index The index of the element to return.
   * @return The acceptableTask at the given index.
   */
  int getAcceptableTask(int index);

  /**
   * <code>map&lt;int32, .Message.RunTask&gt; runTask = 3;</code>
   */
  int getRunTaskCount();
  /**
   * <code>map&lt;int32, .Message.RunTask&gt; runTask = 3;</code>
   */
  boolean containsRunTask(
      int key);
  /**
   * Use {@link #getRunTaskMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.RunTask>
  getRunTask();
  /**
   * <code>map&lt;int32, .Message.RunTask&gt; runTask = 3;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.RunTask>
  getRunTaskMap();
  /**
   * <code>map&lt;int32, .Message.RunTask&gt; runTask = 3;</code>
   */

  game.proto.data.RunTask getRunTaskOrDefault(
      int key,
      game.proto.data.RunTask defaultValue);
  /**
   * <code>map&lt;int32, .Message.RunTask&gt; runTask = 3;</code>
   */

  game.proto.data.RunTask getRunTaskOrThrow(
      int key);
}