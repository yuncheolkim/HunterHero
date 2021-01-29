package game.hunter.record;

import game.hunter.CoolDown;
import game.hunter.action.ActionPoint;

import java.util.List;

/**
 * 使用技能
 *
 * @author Yunzhe.Jin
 * 2021/1/18 15:21
 */
public class UseSkillRecord extends Record {

    public ActionPoint actionPoint;

    public HeroRecordSimple hero;

    public List<HeroRecordSimple> target;

    public int skillId;

    public CoolDown cd;

    public UseSkillRecord(int skillId) {
        this.skillId = skillId;
        type = RecordTypeEnum.SKILL_USE;
    }

}
