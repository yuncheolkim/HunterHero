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
    public int type1;

    @JsonProperty
    public int type2;

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

    @JsonProperty
    public int stack;

    @JsonProperty
    public int round;

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

    @JsonProperty
    public int resourceId;

    @JsonProperty
    public int value;

    @JsonProperty
    public int itemId;

    @JsonProperty
    public int sell;

    //////////// list
    @JsonProperty
    public List<Integer> enemyIdList;

    @JsonProperty
    public List<Integer> enemyAreaList;

    @JsonProperty
    public List<Integer> targetList;

    @JsonProperty
    public List<Integer> list1;

    @JsonProperty
    public List<Integer> list2;

    public int i1;

    public int i2;

    public int i3;

    public int i4;

    public int i5;

    public int i6;

    public int i7;

    public int i8;

    public int i9;

    public int i10;

    public int i11;

    public int i12;

    public int i13;

    public int i14;

    public int i15;

    public int i16;

    public int i17;

    public int i18;

    public int i19;

    public int i20;

    public String s1;

    public String s2;

    public String s3;

    public String s4;

    public String s5;

    public float f1;

    public float f2;

    public float f3;

    public float f4;

    public float f5;
}
