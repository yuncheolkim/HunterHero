//package game.module.battle.skill;
//
//import game.module.battle.Hero;
//import game.module.battle.Skill;
//import game.module.battle.action.ActionPoint;
//import game.module.battle.buff.hero.ZhaoyunBuff1;
//import game.module.battle.record.Record;
//
///**
// * 每次被攻击增加闪避10%,如果闪避成功则重新计算
// *
// * @author Yunzhe.Jin
// * 2021/6/19 23:38
// */
//public class ZhaoyunSkill1 extends Skill {
//
//    public ZhaoyunSkill1() {
//        id = 6;
//        actionPoint.put(ActionPoint.开场, 1);
//
//    }
//
//    @Override
//    protected void process(Record record, ActionPoint actionPoint, Hero hero) {
//        hero.addBuff(new ZhaoyunBuff1());
//    }
//}
