package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class TaskConfigData2 {
    @JsonProperty
    public int id;

    @JsonProperty
    public List<Integer> optionId;


}
