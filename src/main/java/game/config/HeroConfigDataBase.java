package game.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Yunzhe.Jin
 * 2021/2/24 17:02
 */
public class HeroConfigDataBase {

    @JsonProperty
    public int id;
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

}
