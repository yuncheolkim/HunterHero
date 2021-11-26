package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.ZhuoShaoBuff;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 攻击施加灼烧buff
 * <p>
 * 0: 施加buff概率
 * 1: 持续时间
 * 2: 提高灼烧效果 - T
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class ZhouyuSkill1 extends Skill {


    protected int rate = 100;


    public ZhouyuSkill1() {
        super(30);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                // todo test
                final int addBuffRate = rate; //data[0];
                if (CalcUtil.happened100(addBuffRate)) {
                    rate = 0;
                    //加buff
                    final Hero target = hero.getBattle().getDamageInfo().target;
                    final ZhuoShaoBuff addBuff = new ZhuoShaoBuff(hero.getId());
                    addBuff.setDamage(hero.property.getDamage());

                    if (data[1] > 0) {
                        addBuff.SetCd(data[1]).cold();
                    }

                    addBuff.addDamageRate(data[2]);
                    target.addBuff(addBuff);
                }
                break;
        }
    }


    /**
     * 灼烧额外持续1回合
     *
     * @param id
     */
    public void talent1(final int id) {
        data[1] += ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 灼烧概率提高到80%
     *
     * @param id
     */
    public void talent2(final int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 灼烧效果提高100%
     *
     * @param id
     */
    public void talent3(final int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
