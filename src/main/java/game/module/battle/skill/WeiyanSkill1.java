package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Map;

/**
 * 吸血30%伤害, 不受buff影响
 * <p>
 * 0:吸血比例
 * 1:护盾持续时间 - T
 *
 * @author Yunzhe.Jin
 * 2021/6/28 15:55
 */
public class WeiyanSkill1 extends Skill {

    private boolean overHpHeal;

    private boolean overHpShield;

    public WeiyanSkill1() {
        super(10);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    protected void process(final Record record, final ActionPoint actionPoint, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        final int i = damageInfo.allSourceDamage();

        final int addHp = CalcUtil.change100(i, data[0]);
        final int old = hero.getHp();

        if (addHp > 0) {
            hero.addHp(addHp);
            if (overHpHeal) {
                int remain = addHp;
                final Map<Integer, Hero> friends = hero.getBattle().mySideHeroes(hero.getSide());
                for (final Hero friend : friends.values()) {
                    if (friend.getId() != hero.getId() && friend.isAlive()) {
                        remain -= friend.addHp(remain);
                        if (remain == 0) {
                            break;
                        }
                    }
                }
            }
            if (overHpShield) {
                hero.addShield(data[1], addHp, null);
            }
        }


    }

    public void talent1(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(final int id) {
        overHpHeal = true;
    }

    public void talent3(final int id) {
        overHpShield = true;
    }
}
