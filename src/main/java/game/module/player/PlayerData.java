package game.module.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;
import game.module.scene.SceneData;
import game.module.task.TaskData;
import game.player.Player;
import org.joda.time.LocalDateTime;

import java.util.*;

/**
 * @author Yunzhe.Jin
 * 2021/2/22 11:08
 */
public class PlayerData implements Copy {

    @JsonProperty
    public long version;

    @JsonProperty
    public long pid;

    @JsonProperty
    public String name;

    @JsonProperty
    public String account;

    @JsonProperty
    public long lastLoginTime;

    @JsonProperty
    public long updateTime;

    /**
     * 体力
     */
    @JsonProperty
    public int power;

    /**
     * 恢复一点体力需要多少秒
     */
    @JsonProperty
    public int powerRecoverSecond;

    @JsonProperty
    public int level;

    @JsonProperty
    public int exp;
    @JsonIgnore
    public int needExp;

    @JsonProperty
    public SceneData sceneData;

    //////////////////////////////////////////////////////////////// task

    /**
     * 已完成的任务
     */
    @JsonProperty
    public Set<Integer> completeTask = new HashSet<>();

    /**
     * 可接受的任务
     */
    @JsonProperty
    public Set<Integer> acceptTask = new HashSet<>();

    /**
     * 进行中的任务
     */
    @JsonProperty
    public Map<Integer, TaskData> runTask = new HashMap<>();

    //////////////////////////////////////////////////////////////// task

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
        data.completeTask = new HashSet<>(completeTask);
        data.acceptTask = new HashSet<>(acceptTask);
        Map<Integer, TaskData> temp = new HashMap<>();
        for (Map.Entry<Integer, TaskData> integerTaskDataEntry : runTask.entrySet()) {
            temp.put(integerTaskDataEntry.getKey(), integerTaskDataEntry.getValue().copy());
        }
        data.runTask = temp;
        data.lastLoginTime = lastLoginTime;
        data.updateTime = updateTime;
        data.power = power;
        data.powerRecoverSecond = powerRecoverSecond;
        data.level = level;
        data.exp = exp;
        data.version = version;
        data.sceneData = sceneData.copy();

        return data;

    }
}
