package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class DataConfigData {
    ///// base

    @JsonProperty
    public int id;

    @JsonProperty
    public String name;

    @JsonProperty
    public int type;

    @JsonProperty
    public int weight;

    @JsonProperty
    public int level;

    @JsonProperty
    public int count;

    @JsonProperty
    public int min;

    @JsonProperty
    public int max;

    @JsonProperty
    public String title;

    @JsonProperty
    public int gold;
    ///// property
    @JsonProperty
    public int hp;

    @JsonProperty
    public int damage;

    @JsonProperty
    public int def;

    @JsonProperty
    public int defBase;

    @JsonProperty
    public int avoid;

    @JsonProperty
    public int avoidBase;

    @JsonProperty
    public int critical;

    @JsonProperty
    public int criticalBase;

    @JsonProperty
    public int criticalDamage;

    @JsonProperty
    public int speed;

    //////

    @JsonProperty
    public int areaId;

    @JsonProperty
    public int enemyAreaId;

    @JsonProperty
    public List<Integer> enemyAreaList;

    @JsonProperty
    public int enemyId;


    @JsonProperty
    public String area;

    @JsonProperty
    public String pos;

    @JsonProperty
    public int inHouse;

    @JsonProperty
    public String houseName;

    @JsonProperty
    public int speakId;


    @JsonProperty
    public int exp;

    @JsonProperty
    public int monsterExp;

    @JsonProperty
    public int taskExp;

    @JsonProperty
    public String content;

    @JsonProperty
    public int nextId;

    @JsonProperty
    public int optionId;

    @JsonProperty
    public List<Integer> optionIdList;

    @JsonProperty("conversationId")
    public int conversationId;


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
    public int contentId;

    @JsonProperty
    public String reward;

    @JsonProperty
    public int completeContentId;

    @JsonProperty
    public int notCompleteContentId;


    @JsonProperty
    public List<Integer> targetList;

    @JsonProperty
    public int processType;

    @JsonProperty
    public int v1;

    @JsonProperty
    public int v2;

    @JsonProperty
    public int v3;

    @JsonProperty
    public int v4;

    @JsonProperty
    public int v5;

    @JsonProperty
    public String content1;
}
