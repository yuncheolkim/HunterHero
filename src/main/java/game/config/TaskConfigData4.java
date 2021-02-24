package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class TaskConfigData4 {
    @JsonProperty
    public int id;

    @JsonProperty
    public int level;

    @JsonProperty
    public int areaId;

    @JsonProperty
    public int npcId;

    @JsonProperty
    public int taskType;

    @JsonProperty
    public int speakType;

    @JsonProperty
    public int beforeTaskId;

    @JsonProperty
    public int completeType;

    @JsonProperty
    public int completeNpcId;

    @JsonProperty
    public String title;

    @JsonProperty
    public int contentId;

    @JsonProperty
    public String reward;

    @JsonProperty
    public int completeContentId;

    @JsonProperty
    public int notCompleteContentId;

    @JsonProperty
    public int conversationId;

    @JsonProperty
    public List<Integer> targets;

}
