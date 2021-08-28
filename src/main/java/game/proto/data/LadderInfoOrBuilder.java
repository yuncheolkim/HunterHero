// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package game.proto.data;

public interface LadderInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Message.LadderInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 单挑是否先手, 1:先手 2:后手
   * </pre>
   *
   * <code>int32 order = 1;</code>
   * @return The order.
   */
  int getOrder();

  /**
   * <pre>
   * 分数
   * </pre>
   *
   * <code>int32 score = 2;</code>
   * @return The score.
   */
  int getScore();

  /**
   * <pre>
   * 先手
   * </pre>
   *
   * <code>int32 win1 = 3;</code>
   * @return The win1.
   */
  int getWin1();

  /**
   * <pre>
   * 后手
   * </pre>
   *
   * <code>int32 win2 = 4;</code>
   * @return The win2.
   */
  int getWin2();

  /**
   * <pre>
   *先手
   * </pre>
   *
   * <code>int32 lose1 = 5;</code>
   * @return The lose1.
   */
  int getLose1();

  /**
   * <pre>
   *后手
   * </pre>
   *
   * <code>int32 lose2 = 6;</code>
   * @return The lose2.
   */
  int getLose2();

  /**
   * <pre>
   * 出战英雄
   * </pre>
   *
   * <code>int32 heroId = 7;</code>
   * @return The heroId.
   */
  int getHeroId();

  /**
   * <code>bool inMatch = 8;</code>
   * @return The inMatch.
   */
  boolean getInMatch();

  /**
   * <code>map&lt;int32, .Message.LadderHeroScore&gt; heroScore = 9;</code>
   */
  int getHeroScoreCount();
  /**
   * <code>map&lt;int32, .Message.LadderHeroScore&gt; heroScore = 9;</code>
   */
  boolean containsHeroScore(
      int key);
  /**
   * Use {@link #getHeroScoreMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, game.proto.data.LadderHeroScore>
  getHeroScore();
  /**
   * <code>map&lt;int32, .Message.LadderHeroScore&gt; heroScore = 9;</code>
   */
  java.util.Map<java.lang.Integer, game.proto.data.LadderHeroScore>
  getHeroScoreMap();
  /**
   * <code>map&lt;int32, .Message.LadderHeroScore&gt; heroScore = 9;</code>
   */

  game.proto.data.LadderHeroScore getHeroScoreOrDefault(
      int key,
      game.proto.data.LadderHeroScore defaultValue);
  /**
   * <code>map&lt;int32, .Message.LadderHeroScore&gt; heroScore = 9;</code>
   */

  game.proto.data.LadderHeroScore getHeroScoreOrThrow(
      int key);

  /**
   * <pre>
   * 最近20次
   * </pre>
   *
   * <code>repeated .Message.LadderSingleReport report = 10;</code>
   */
  java.util.List<game.proto.data.LadderSingleReport> 
      getReportList();
  /**
   * <pre>
   * 最近20次
   * </pre>
   *
   * <code>repeated .Message.LadderSingleReport report = 10;</code>
   */
  game.proto.data.LadderSingleReport getReport(int index);
  /**
   * <pre>
   * 最近20次
   * </pre>
   *
   * <code>repeated .Message.LadderSingleReport report = 10;</code>
   */
  int getReportCount();
  /**
   * <pre>
   * 最近20次
   * </pre>
   *
   * <code>repeated .Message.LadderSingleReport report = 10;</code>
   */
  java.util.List<? extends game.proto.data.LadderSingleReportOrBuilder> 
      getReportOrBuilderList();
  /**
   * <pre>
   * 最近20次
   * </pre>
   *
   * <code>repeated .Message.LadderSingleReport report = 10;</code>
   */
  game.proto.data.LadderSingleReportOrBuilder getReportOrBuilder(
      int index);
}
