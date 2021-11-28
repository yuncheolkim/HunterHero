package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.HuiChunBuff;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

import java.util.Map;

/**
 * 攻击伤害的给友方添加回春buff
 * <p>
 * 0:回复血量比例
 * 1:伤害提高比例
 * 2:暴击提高比例
 * 3:护甲提高比例
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class DaQiaoSkill1 extends Skill {

    public DaQiaoSkill1() {
        super(40);
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
                        huichun.setHpRate(data[0]);
                        huichun.setDamageRate(data[1]);
                        huichun.setCriticalRate(data[2]);
                        huichun.setDefRate(data[3]);
                        value.addBuff(huichun);
                        break;
                    }
                }
                break;
        }
    }

    /**
     * 提高回春的治疗效果100%
     *
     * @param id
     */
    public void talent1(final int id) {
        data[0] = CalcUtil.final100(data[0], ConfigManager.talentDataBox.findById(id).i1);
    }

    /**
     * 回春提高20%伤害
     *
     * @param id
     */
    public void talent2(final int id) {
        data[1] = CalcUtil.final100(data[0], ConfigManager.talentDataBox.findById(id).i1);
    }

    /**
     * 回春提高20%暴击
     *
     * @param id
     */
    public void talent3(final int id) {
        data[2] = CalcUtil.final100(data[0], ConfigManager.talentDataBox.findById(id).i1);
    }

    /**
     * 回春提高20%护甲
     *
     * @param id
     */
    public void talent4(final int id) {
        data[3] = CalcUtil.final100(data[0], ConfigManager.talentDataBox.findById(id).i1);
    }
}
