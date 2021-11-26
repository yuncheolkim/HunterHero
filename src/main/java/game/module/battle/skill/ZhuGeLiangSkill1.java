package game.module.battle.skill;

import game.manager.ConfigManager;
import game.module.battle.Formation;
import game.module.battle.Hero;
import game.module.battle.Pos;
import game.module.battle.Skill;
import game.module.battle.action.ActionPoint;
import game.module.battle.damage.DamageInfo;
import game.module.battle.record.Record;
import game.proto.data.DamageType;
import game.utils.CalcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 额外攻击{0}个目标,每次减少50%伤害,闪电连接,每击中一个敌人增加1点雷电
 * <p>
 * 0: 个数
 * 1: 削减比例
 * 2: 攻击获得雷能数
 * 3: 暴击获得能量数
 *
 * @author Yunzhe.Jin
 * 2021/5/8 22:15
 */
public class ZhuGeLiangSkill1 extends Skill {

    /**
     * 雷电能量
     */
    private int acc;

    public ZhuGeLiangSkill1() {
        super(35);
        needRecord = true;
        actionPoint.put(ActionPoint.出手后, 1);
    }

    @Override
    public void process(final Record record, final ActionPoint point, final Hero hero) {

        switch (point) {
            case 出手后:
                attack(record, hero);
                break;
            case 暴击后:
                afterCritical(record, hero);
                break;
        }
    }

    /**
     * 暴击后
     *
     * @param record
     * @param hero
     */
    private void afterCritical(final Record record, final Hero hero) {
        acc++;
    }

    /**
     * 闪电链
     *
     * @param record
     * @param hero
     */
    private void attack(final Record record, final Hero hero) {
        final DamageInfo damageInfo = hero.getBattle().getDamageInfo();
        final Pos pos = damageInfo.target.getPos();
        final Formation formation = hero.getBattle().getFormation();
        int remain = data[0];
        final List<Hero> enemyList = new ArrayList<>(remain);

        final List<Integer> around = formation.around(pos);
        final Map<Integer, Hero> enemyMap = hero.getBattle().oppositeHeroes(hero.getSide());
        acc++;

        for (final Integer index : around) {
            if (remain == 0) {
                break;
            }
            final Hero enemy = enemyMap.get(index);
            if (enemy != null && enemy.isAlive()) {
                remain -= 1;
                acc++;
                enemyList.add(enemy);
            }
        }

        // 攻击敌人
        record.targetList = enemyList.stream().map(h -> h.getPos().getIndex()).collect(Collectors.toList());

        final int rate = data[1];
        int damage = damageInfo.allSourceDamage();

        for (final Hero target : enemyList) {
            damage -= CalcUtil.change100(damage, rate);
            final DamageInfo tempInfo = new DamageInfo();
            tempInfo.sourceId = id;
            tempInfo.type = DamageType.DAMAGE_SKILL;
            tempInfo.source = hero;
            tempInfo.target = target;
            tempInfo.origin = hero;
            tempInfo.sourceDamage = damage;
            hero.damage(tempInfo);
        }
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(final int acc) {
        this.acc = acc;
    }

    /**
     * 伤害减少20%
     *
     * @param id
     */
    public void talent1(final int id) {
        data[1] = ConfigManager.talentDataBox.findById(id).i1;
    }

    /**
     * 暴击增加1点能量
     *
     * @param id
     */
    public void talent2(final int id) {
        data[3] = ConfigManager.talentDataBox.findById(id).i1;
        actionPoint.put(ActionPoint.暴击后, 1);
    }

}
