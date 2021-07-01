package game.module.battle.skill;

import game.module.battle.BattleConstant;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.buff.hero.LusuBuff1;
import game.module.battle.damage.DamageInfo;
import game.module.battle.find.MultipleBackTargetStrategy;
import game.module.battle.find.MultipleFrontTargetStrategy;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 冰锥,攻击8目标
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class LusuSkill1 extends Skill {

    /**
     * 攻击目标数量
     */
    private int count = 8;

    /**
     * 伤害
     */
    private int rate = 20;

    /**
     * 对有buff敌人伤害加成
     * 百分比
     */
    private int buffDamageRate = 100;

    /**
     * 添加buff的概率
     * 百分比
     */
    private int addBuffRate = 20;

    /**
     * 降低护甲比例
     */
    private int buffDefRate = 5;


    /**
     * 伤害加深比例
     */
    private int buffHarmRate = 2;

    public LusuSkill1() {
        super(10);
        actionPoint.put(ActionPoint.开场, 1);
        actionPoint.put(ActionPoint.出手前, 1);
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 开场:
                hero.addTargetStrategy(new MultipleBackTargetStrategy(count));
                hero.addTargetStrategy(new MultipleFrontTargetStrategy(count));
                hero.addAction(ActionPoint.开场, h -> {
                    h.property.damage = CalcUtil.add100(h.property.damage, rate);
                });
                break;
            case 出手前:
                final DamageInfo damageInfo = hero.damageInfo;
                final boolean buff = damageInfo.target.hasBuff(BattleConstant.buff_lusu_1);

                int addRate = rate;
                if (buff) {
                    addRate = CalcUtil.final100(addRate, buffDamageRate);
                }
                hero.fightingData.damage = CalcUtil.add100(hero.fightingData.damage, addRate);
                break;
            case 出手后:
                if (CalcUtil.happened100(addBuffRate)) {
                    //加buff
                    final Hero target = hero.damageInfo.target;

                    final LusuBuff1 addBuff = new LusuBuff1();
                    addBuff.setDefRate(buffDefRate);
                    addBuff.setHarmRate(buffHarmRate);
                    target.addBuff(addBuff);
                }
                break;
        }

    }

    public void setCount(final int count) {
        this.count = count;
    }

    public void addCount(final int c) {
        this.count += c;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void addRate(final int rate) {
        this.rate += rate;
    }
}
