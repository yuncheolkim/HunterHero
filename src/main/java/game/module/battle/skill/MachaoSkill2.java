package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 0:增加护甲的比例
 * 1:回合数
 * 2:队友增加护甲的比例
 * 3:队友回合数
 *
 * @author Yunzhe.Jin
 * 2021/6/30 14:10
 */
public class MachaoSkill2 extends Skill {

    public MachaoSkill2() {
        super(16);
        actionPoint.put(ActionPoint.暴击后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        switch (actionPoint) {
            case 暴击后:
                final int rate = data[0];
                final int round = data[1];
                final int i = CalcUtil.change100(hero.origin.getMaxHp(), rate);
                hero.addShield(round, i, ActionPoint.出手后);

                final int friendRate = data[2];
                if (friendRate > 0) {
                    final int friendRound = data[3];

                    final int friendShield = CalcUtil.change100(i, friendRate);

                    for (final Hero value : hero.getBattle().mySideHeroes(hero.getSide()).values()) {
                        if (value.isAlive()) {
                            value.addShield(friendRound, friendShield, ActionPoint.出手后);
                        }
                    }
                }

                break;
        }
    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
        data[1] = ConfigManager.talentDataBox.findById(id).i2;
    }

    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
        data[3] = ConfigManager.talentDataBox.findById(id).i2;

    }
}
