package game.module.formation;

import com.google.protobuf.MessageLite;
import game.exception.ModuleAssert;
import game.module.hero.HeroService;
import game.player.Player;
import game.proto.*;
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
     * 创建阵型
     *
     * @param player
     * @param req
     */
    public static MessageLite create(Player player, FormationCreateReq req) {
        ModuleAssert.isTrue(player.pd.getFormationCount() <= 10);

        player.pd.addFormation(Formation.newBuilder()
                .addAllPos(newFormation())
                .build());
        return FormationCreateRes.newBuilder().setIndex(player.nextId()).buildPartial();
    }

    private static List<FormationPos> newFormation() {

        List<FormationPos> pos = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            pos.add(FormationPos.newBuilder()
                    .setIndex(i)
                    .build());
        }

        return pos;
    }

    /**
     * 删除阵型
     *
     * @param player
     * @param req
     */
    public static void delete(Player player, FormationDeleteReq req) {

        ModuleAssert.isTrue(req.getIndex() < player.pd.getFormationCount());

        player.pd.removeFormation(req.getIndex());
    }

    /**
     * 更新阵型
     *
     * @param player
     * @param req
     */
    public static void update(Player player, FormationUpdateReq req) {

        ModuleAssert.isTrue(req.getIndex() < player.pd.getFormationCount());
        FormationPos pos = req.getPos();

        // check hero
        ModuleAssert.isTrue(HeroService.hasHero(player, pos.getHeroId()));
        // todo check enhance

        Formation.Builder formation = player.pd.getFormationBuilder(req.getIndex());
        formation.addPos(req.getIndex(), pos);
    }

    /**
     * 设置阵型用处
     *
     * @param player
     * @param req
     */
    public static void setting(Player player, FormationSettingReq req) {
        ModuleAssert.isTrue(req.getIndex() < player.pd.getFormationCount());

        // todo check name

        Formation.Builder formation = player.pd.getFormationBuilder(req.getIndex());
        formation.setName(req.getName());
        formation.setType(req.getType());
    }
}
