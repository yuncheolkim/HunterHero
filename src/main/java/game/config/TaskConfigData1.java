package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class TaskConfigData1 {


    @JsonProperty
    public int id;

    @JsonProperty
    public String content;

    @JsonProperty
    public int nextId;

    @JsonProperty
    public int optionId;


}
