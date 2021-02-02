package game.hunter.hero;

import game.hunter.Hero;
import game.hunter.find.MaxHpFindTargetStrategy;
import game.hunter.find.OneAttackBuffFindTargetStrategy;
import game.hunter.skill.GuanyuSkill1;
import game.hunter.skill.GuanyuSkill2;
import game.hunter.skill.ZhangfeiSkill1;

/**
 * 张飞
 * @author Yunzhe.Jin
 * 2021/2/1 14:32
 */
public class Zhangfei extends Hero {

    public Zhangfei() {

        id = 100002;
        addSkill(new ZhangfeiSkill1());
    }

}
