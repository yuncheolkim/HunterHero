package game.hunter.action;

/**
 * 动作时机
 *
 * @author Yunzhe.Jin
 * 2021/1/8 18:13
 */
public enum ActionPoint {
    开场,
    出手前,
    出手后,
    回合开始前,
    回合结束后,
    死之前,
    死之后,
    出手,
    攻击方计算伤害前,
    攻击方计算伤害后,
    被攻击之前,
    //
    受到伤害之前,
    受到伤害之后,
    闪避之前,
    闪避之后,
    //
    增加buff后,
    buff移除后,
    重新计算属性,

}
