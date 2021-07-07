package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.ZhuFuBuff;
import game.module.battle.record.Record;

/**
 * 添加祝福光环，减少5%伤害
 * <p>
 * 0: 减伤比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DaQiaoSkill3 extends Skill {


    public DaQiaoSkill3() {
        super(42);
        actionPoint.put(ActionPoint.开场, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {
        final ZhuFuBuff buff = new ZhuFuBuff(hero.getId());

        hero.getBattle().mySideHeroes(hero.getSide()).values().forEach(h -> {
            h.addBuff(buff);
        });

    }

    public void talent1(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }

}
