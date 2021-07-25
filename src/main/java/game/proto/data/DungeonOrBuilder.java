// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface DungeonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.Dungeon)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <pre>
   * 当前战斗的boss
   * </pre>
   *
   * <code>int32 bossId = 2;</code>
   * @return The bossId.
   */
  int getBossId();

  /**
   * <pre>
   * </pre>
   *
   * <code>repeated int32 defeated = 3;</code>
   * @return A list containing the defeated.
   */
  java.util.List<java.lang.Integer> getDefeatedList();
  /**
   * <pre>
   * </pre>
   *
   * <code>repeated int32 defeated = 3;</code>
   * @return The count of defeated.
   */
  int getDefeatedCount();
  /**
   * <pre>
   * </pre>
   *
   * <code>repeated int32 defeated = 3;</code>
   * @param index The index of the element to return.
   * @return The defeated at the given index.
   */
  int getDefeated(int index);
}
