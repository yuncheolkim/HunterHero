package game.module.formation;

import com.google.protobuf.MessageLite;
import game.exception.ModuleAssert;
import game.module.hero.HeroService;
import game.player.Player;
import game.proto.*;
import game.proto.data.Formation;
import game.proto.data.FormationPos;
import game.proto.data.FormationPosUpdate;

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

        int id = player.nextId();
        player.pd.addFormation(Formation.newBuilder()
                .setName("未命名")
                .setIndex(id)
                .addAllPos(newFormation())
                .build());
        return FormationCreateRes.newBuilder().setFormationId(id).buildPartial();
    }

    private static List<FormationPos> newFormation() {

        List<FormationPos> pos = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            pos.add(FormationPos.newBuilder()
                    .setIndex(i)
                    .setOrder(i + 1)
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

        for (int i = 0; i < player.pd.getFormationBuilderList().size(); i++) {
            if (player.pd.getFormation(i).getIndex() == req.getIndex()) {
                player.pd.removeFormation(i);
                break;
            }
        }
    }

    /**
     * 更新阵型
     *
     * @param player
     * @param req
     */
    public static FormationUpdateRes update(Player player, FormationUpdateReq req) {

        FormationPos pos = req.getPos();

        // check hero
        if (pos.getHeroId() > 0) {
            ModuleAssert.isTrue(HeroService.hasHero(player, pos.getHeroId()));
        }
        // todo check enhance

        Formation.Builder formation = player.pd.getFormationBuilderList()
                .stream().filter(builder -> builder.getIndex() == req.getFormationId()).findFirst().get();

        // order 切换
        FormationPos.Builder posBuilder = formation.getPosBuilder(req.getPos().getIndex());
        FormationUpdateRes.Builder retBuilder = FormationUpdateRes.newBuilder();
        retBuilder.setFormationId(req.getFormationId());
        if (posBuilder.getOrder() != pos.getOrder()) {
            int oldOrder = posBuilder.getOrder();
            int newOrder = pos.getOrder();

            FormationPos.Builder changeOtherOrder = formation.getPosBuilderList().stream().filter(builder -> builder.getOrder() == newOrder).findFirst().get();

            changeOtherOrder.setOrder(oldOrder);

            retBuilder.addData(FormationPosUpdate.newBuilder()

                    .setPos(FormationPos.newBuilder(changeOtherOrder.buildPartial())
                    )
                    .build());

        }

        formation.setPos(req.getPos().getIndex(), pos);

        retBuilder.addData(FormationPosUpdate.newBuilder().setPos(FormationPos.newBuilder(pos)));

        return retBuilder.buildPartial();
    }

    /**
     * 设置阵型用处
     *
     * @param player
     * @param req
     */
    public static FormationSettingRes setting(Player player, FormationSettingReq req) {

        // todo check name

        Formation.Builder formation = player.pd.getFormationBuilderList().stream().filter(builder -> builder.getIndex() == req.getIndex()).findFirst().get();
        formation.setName(req.getName());


        if (req.getDefaultFormationIndex() != 0 || req.getIndex() == player.pd.getDefaultFormationIndex()) {
            player.pd.setDefaultFormationIndex(req.getDefaultFormationIndex());

        }
        if (req.getArenaFormationIndex() != 0 || req.getIndex() == player.pd.getArenaFormationIndex()) {
            player.pd.setArenaFormationIndex(req.getArenaFormationIndex());
        }

        return FormationSettingRes.newBuilder()
                .setIndex(req.getIndex())
                .setName(req.getName())
                .setDefaultFormationIndex(req.getDefaultFormationIndex())
                .setArenaFormationIndex(req.getArenaFormationIndex())
                .build();
    }
}
