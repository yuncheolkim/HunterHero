package game.module.player;

import game.proto.back.FightType;

/**
 * @author Yunzhe.Jin
 * 2021/6/2 17:36
 */
public class ResourceService {
    public static int calcPower(final FightType fightType) {

        switch (fightType) {

            case F_BATTLE:
                return 1;
        }

        return 0;
    }

}
