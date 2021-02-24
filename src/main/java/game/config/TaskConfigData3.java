package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class TaskConfigData3 {
    @JsonProperty
    public int id;

    @JsonProperty
    public String name;

    @JsonProperty("conversationId")
    public int conversationId;


}
