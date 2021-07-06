package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Map;

/**
 * 攻击伤害的{0}%给其他人增加{1}%血量
 * <p>
 * 0: 回血概率
 * 1: 回血比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DaQiaoSkill1 extends Skill {

    public DaQiaoSkill1() {
        super(41);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                if (CalcUtil.happened100(data[0])) {
                    final Hero targetHero = findHero(hero);
                    final int addHp = CalcUtil.change100(targetHero.property.getMaxHp(), data[1]);
                    targetHero.addHp(addHp);
                }
                break;
        }
    }


    private Hero findHero(final Hero hero) {
        final Map<Integer, Hero> friend = hero.getBattle().mySideHeroes(hero.getSide());

        Hero h = hero;
        for (final Hero value : friend.values()) {
            if (value.isAlive()) {
                final int hp = value.hpLose();

                if (hp > h.hpLose()) {
                    h = value;
                }
            }
        }

        return h;
    }

    public void talent1(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent3(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent4(final int id) {
        data[1] += ConfigManager.talentDataBox.findById(id).i1;
        data[2] += ConfigManager.talentDataBox.findById(id).i2;
    }
}
