package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.SkillConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class SkillDataBox extends MapConfigDataBox<SkillConfigData> {


    public SkillDataBox() {
        super("data/hero_skill.json");
    }
}
