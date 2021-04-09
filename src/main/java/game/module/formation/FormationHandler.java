package game.module.formation;

import com.google.protobuf.MessageLite;
import game.exception.ModuleAssert;
import game.player.Player;
import game.proto.FormationCreateReq;
import game.proto.FormationCreateRes;
import game.proto.data.Formation;
import game.proto.data.FormationPos;

import java.util.ArrayList;
import java.util.List;

/**
 * 阵型
 *
 * @author Yunzhe.Jin
 * 2021/4/8 17:35
 */
public class FormationHandler {

    /**
     * 创建阵容
     *
     * @param player
     * @param req
     */
    public static MessageLite create(Player player, FormationCreateReq req) {
        ModuleAssert.isTrue(player.pd.getFormationCount() <= 10);

        player.pd.addFormation(Formation.newBuilder()
                .addAllPos(newFormation())
                .build());
        return FormationCreateRes.getDefaultInstance();
    }

    private static List<FormationPos> newFormation() {

        List<FormationPos> pos = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            pos.add(FormationPos.newBuilder()
                    .setIndex(i + 1)
                    .build());
        }

        return pos;
    }
}
