package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Hero;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.record.Record;
import game.utils.CalcUtil;

/**
 * 每次被攻击增加闪避10%,如果闪避成功则重新计算
 * <p>
 * 0:闪避比例
 * 1:增加护甲比例
 * 2:伤害加成增加量
 * 3:闪避次数
 * 4:
 *
 * @author Yunzhe.Jin
 * 2021/6/19 23:38
 */
public class ZhaoyunSkill1 extends Skill {

    private int avoid;
    private int def;
    private int damage;
    private int attCount;

    public ZhaoyunSkill1() {
        super(6);
        actionPoint.put(ActionPoint.被攻击之前, 1);
        actionPoint.put(ActionPoint.闪避之后, 1);
        actionPoint.put(ActionPoint.受到伤害之后, 1);
        actionPoint.put(ActionPoint.出手结束后, 1);
    }

    @Override
    protected void process(Record record, ActionPoint actionPoint, Hero hero) {
        final int avoidRate = data[0];
        final int defRate = data[1];
        final int damageRate = data[2];
        final int count = data[3];

        switch (actionPoint) {
            case 闪避之后:
                if (--attCount == 0) {
                    avoid = 0;
                    def = 0;
                }
                break;
            case 受到伤害之后:
                avoid += avoidRate;
                def += defRate;
                break;
            case 被攻击之前:
                hero.fightingData.setAvoid(CalcUtil.final100(hero.fightingData.getAvoid(), avoid));
                hero.fightingData.setDef(CalcUtil.final100(hero.fightingData.getDef(), def));
                // 加攻击
                damage += damageRate;
                break;
            case 出手结束后:
                damage = 0;
                attCount = count;
                break;
            case 出手前:
                hero.fightingData.setDamage(CalcUtil.final100(hero.fightingData.getDamage(), damage));
                break;
        }
    }


    public void talent1(int id) {
        data[0] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent2(int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent3(int id) {
        data[2] = ConfigManager.talentDataBox.findById(id).i1;
    }

    public void talent4(int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
    }
}
