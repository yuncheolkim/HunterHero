package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Map;

/**
 * 每1回合全体恢复血量 {0}%
 * <p>
 * 0: 回血比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DaQiaoSkill2 extends Skill {


    public DaQiaoSkill2() {
        super(41);
        actionPoint.put(ActionPoint.出手结束后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手结束后:
                addAllHp(record, hero);
                break;
        }
    }

    private void addAllHp(final Record record, final Hero hero) {
        final Map<Integer, Hero> friend = hero.getBattle().mySideHeroes(hero.getSide());
        for (final Hero h : friend.values()) {
            if (h.isAlive()) {
                h.addHp(CalcUtil.change100(h.property.maxHp, data[0]));
            }
        }
    }


    /**
     * 每1回合全体恢复血量 15%
     *
     * @param id
     */
    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
