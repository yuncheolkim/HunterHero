// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface LadderReportOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderReport)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 uid = 1;</code>
   * @return The uid.
   */
  long getUid();

  /**
   * <code>.Message.FormationPos formation = 2;</code>
   * @return Whether the formation field is set.
   */
  boolean hasFormation();
  /**
   * <code>.Message.FormationPos formation = 2;</code>
   * @return The formation.
   */
  game.proto.data.FormationPos getFormation();
  /**
   * <code>.Message.FormationPos formation = 2;</code>
   */
  game.proto.data.FormationPosOrBuilder getFormationOrBuilder();

  /**
   * <code>string name = 5;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 5;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
