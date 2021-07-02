package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;
import game.module.battle.BattleConstant;
import game.module.battle.CoolDown;
import game.module.battle.SkillType;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class SkillConfigData extends BaseConfigData<SkillConfigData> {

    public int round;

    public int[] data;

    public SkillType skillType;

    public int priority;

    @Override
    protected void fill(DataConfigData d) {

        skillType = d.type == 1 ? SkillType.Z : SkillType.B;
        round = d.round;
        priority = d.priority;

        if (d.list1 != null) {
            data = new int[d.list1.size()];

            for (int i = 0; i < data.length; i++) {
                data[i] = d.list1.get(i);
            }
        }
    }

    public CoolDown getCd() {
        if (round == 0) {
            return BattleConstant.INFINITE;
        }

        return new CoolDown(round);
    }
}
