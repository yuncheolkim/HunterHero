package game.module.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import game.base.Copy;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        List<String> collect = Arrays.stream(PlayerData.class.getFields()).
                map(field -> "data." + field.getName() + " = " + field.getName()).collect(Collectors.toList());
        System.out.println(collect.stream().collect(Collectors.joining(";\n")));
        String s = "import com.thoughtworks.qdox.JavaProjectBuilder\nimport java.nio.charset.StandardCharsets\nimport java.util.stream.Collectors\ndef builder = new JavaProjectBuilder();\nbuilder.setEncoding(StandardCharsets.UTF_8.toString())\ndef file = new File(\"/Users/jinyunzhe/develop/gitee/HunterHero/src/main/java/game/module/data/PlayerData.java\")\nbuilder.addSource(file)\ndef clazz = builder.getClasses().iterator().next();\ndef fieldNames = clazz.getFields().stream().filter({ f -> !f.isStatic() }).map({ f -> \"data.\" + f.getName() + \" = \" + f.getName() }).collect(Collectors.toList())\ndef s = clazz.getName() + \" data = new \" + clazz.getName() + \"();\\n\" + fieldNames.stream().collect(Collectors.joining(\";\\n\"));\ns = s + \" return data;\"\nreturn s";
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
