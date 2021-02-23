package game.module.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;
import game.player.Player;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:08
 */
public class PlayerData implements Copy {

    @JsonProperty
    public long pid;

    @JsonProperty
    public String name;

    @JsonProperty
    public String account;

    /**
     * 已完成的任务
     */
    @JsonProperty
    public List<Integer> completeTask = new ArrayList<>();

    /**
     * 可接受的任务
     */
    @JsonProperty
    public List<Integer> acceptTask = new ArrayList<>();

    /**
     * 进行中的任务
     */
    @JsonProperty
    public List<TaskData> runTask = new ArrayList<>();

    @JsonProperty
    public long lastLoginTime;

    @JsonProperty
    public long updateTime;


    public void read(Player player) {

        lastLoginTime = player.getLoginTime().toDate().getTime();
        updateTime = player.getUpdateTime().toDate().getTime();
    }

    public void write(Player player) {

        player.setUpdateTime(LocalDateTime.fromDateFields(new Date(updateTime)));
    }

    public PlayerData copy() {

        PlayerData data = new PlayerData();
        data.pid = pid;
        data.name = name;
        data.account = account;
        data.completeTask = new ArrayList<>(completeTask);
        data.acceptTask = new ArrayList<>(acceptTask);
        data.runTask = runTask.stream().map(TaskData::copy).collect(Collectors.toList());
        return data;

    }
}
