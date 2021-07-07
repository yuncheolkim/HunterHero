package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.HuiChunBuff;
import game.module.battle.record.Record;

import java.util.Map;

/**
 * 攻击伤害的给友方添加回春buff
 * <p>
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
                final Map<Integer, Hero> heroMap = hero.getBattle().mySideHeroes(hero.getSide());
                for (final Hero value : heroMap.values()) {
                    if (value.isAlive() && !value.hasBuff(BattleConstant.buff_huichun)) {
                        final HuiChunBuff huichun = new HuiChunBuff(hero.getId());
                        value.addBuff(huichun);
                        break;
                    }
                }
                break;
        }
    }

    public void talent1(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
