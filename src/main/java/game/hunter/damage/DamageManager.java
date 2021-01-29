package game.hunter.damage;

import game.hunter.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yunzhe.Jin
 * 2021/1/11 16:42
 */
public class DamageManager {

    public static DamageManager INSTANCE = new DamageManager();

    /**
     * 计算攻击伤害逻辑
     */
    private List<DamageProcess> damageProcessList = new ArrayList<>();

    /**
     * 计算受到的伤害
     */
    private List<DamagedProcess> takeDamageProcessList = new ArrayList<>();

    public void init() {
        // 攻击
        damageProcessList.add(new CriticalDamageProcess());
        // 受伤
        takeDamageProcessList.add(new AvoidDamagedProcess());
        takeDamageProcessList.add(new DefDamagedProcess());
        takeDamageProcessList.add(new ShieldDamagedProcess());
    }

    /// 计算给攻击伤害
    public void addAttack(DamageProcess process) {
        damageProcessList.add(process);
    }

    public void removeAttack(Class<?> clazz) {
        damageProcessList.removeIf(process -> process.getClass() == clazz);
    }

    public void calcAttack(Hero hero) {
        for (DamageProcess damageProcess : damageProcessList) {
            damageProcess.process(hero);
        }
    }

    /// 计算受到的伤害
    public void addAttackedProcess(DamagedProcess process) {
        takeDamageProcessList.add(process);
    }

    public void removeAttackedProcess(Class<?> clazz) {
        takeDamageProcessList.removeIf(process -> process.getClass() == clazz);
    }

    public void calcAttackedProcess(Hero hero) {
        for (DamagedProcess damageProcess : takeDamageProcessList) {
            damageProcess.process(hero);
        }
    }
}
