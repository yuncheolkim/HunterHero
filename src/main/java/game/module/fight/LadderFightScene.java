package game.module.fight;

import game.game.scene.GameScene;
import game.module.fight.data.FightCancel;
import game.module.fight.data.FightFormation;

/**
 * 玩家之间的战斗执行
 *
 * @author Yunzhe.Jin
 * 2021/8/28 21:25
 */
public class LadderFightScene extends GameScene {

    @Override
    protected void process(Object msg) {

        if (msg instanceof FightCancel) {

        } else if (msg instanceof FightFormation) {

        }
    }
}
