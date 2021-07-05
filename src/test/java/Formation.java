import game.module.battle.Pos;
import org.junit.Test;

/**
 * @author Yunzhe.Jin
 * 2021/7/5 15:04
 */
public class Formation {

    /**
     * 23 22 21 20
     * 19 18 17 16
     * -------------
     * 0 1 2
     * 3 4 5
     */
    @Test
    public void test1() {
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(0)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(1)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(2)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(3)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(4)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(5)));
        System.out.println("-------------");
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(16)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(17)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(18)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(19)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(20)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(21)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(22)));
        System.out.println(game.module.battle.Formation.A_3_3_B_4_4.around(Pos.from(23)));
    }
}
