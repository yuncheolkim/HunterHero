package game.module.formation;

import com.google.protobuf.MessageLite;
import game.anno.GameHandler;
import game.exception.ModuleAssert;
import game.module.hero.HeroService;
import game.module.player.Player;
import game.proto.*;
import game.proto.data.Formation;
import game.proto.data.FormationPos;
import game.proto.data.FormationPosUpdate;
import game.proto.no.No;

import java.util.*;

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
    @GameHandler(No.FormationCreateReq)
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
    @GameHandler(No.FormationDeleteReq)
    public static void delete(Player player, FormationDeleteReq req) {

        Set<Integer> removeKey = new HashSet<>();
        for (int i = 0; i < player.pd.getFormationBuilderList().size(); i++) {
            if (player.pd.getFormation(i).getIndex() == req.getIndex()) {
                player.pd.removeFormation(i);

                for (Map.Entry<Integer, Integer> entry : player.pd.getFormationIndexMap().entrySet()) {
                    if (entry.getValue().equals(req.getIndex())) {
                        removeKey.add(entry.getKey());
                    }
                }
                break;
            }
        }

        for (Integer key : removeKey) {
            player.pd.removeFormationIndex(key);
        }
    }

    /**
     * 更新阵型
     *
     * @param player
     * @param req
     */
    @GameHandler(No.FormationUpdateReq)
    public static FormationUpdateRes update(Player player, FormationUpdateReq req) {

        final FormationPos pos = req.getPos();

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
        boolean heroCalc = false;
        if (posBuilder.getOrder() != pos.getOrder()) {
            int oldOrder = posBuilder.getOrder();
            int newOrder = pos.getOrder();

            FormationPos.Builder changeOtherOrder = formation.getPosBuilderList().stream().filter(builder -> builder.getOrder() == newOrder).findFirst().get();

            if (changeOtherOrder.getHeroId() == pos.getHeroId()) {
                heroCalc = true;
                changeOtherOrder.setHeroId(0);
            }

            changeOtherOrder.setOrder(oldOrder);

            retBuilder.addData(FormationPosUpdate.newBuilder()
                    .setPos(FormationPos.newBuilder(changeOtherOrder.buildPartial())
                    ));
        }
        // 英雄检查
        if (!heroCalc) {
            Optional<FormationPos.Builder> changeOtherOrder = formation.getPosBuilderList().stream().filter(builder -> builder.getHeroId() == pos.getHeroId()).findFirst();
            if (changeOtherOrder.isPresent()) {
                FormationPos.Builder heroPos = changeOtherOrder.get();
                heroPos.setHeroId(0);

                retBuilder.addData(FormationPosUpdate.newBuilder()
                        .setPos(FormationPos.newBuilder(heroPos.buildPartial())
                        ));
            }
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
    @GameHandler(No.FormationSettingReq)
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

        req.getChangedIndexMap().forEach((key, val) -> {
            player.pd.putFormationIndex(key, val);
        });

        return FormationSettingRes.newBuilder()
                .setIndex(req.getIndex())
                .setName(req.getName())
                .setDefaultFormationIndex(req.getDefaultFormationIndex())
                .setArenaFormationIndex(req.getArenaFormationIndex())
                .putAllChangedIndex(req.getChangedIndexMap())
                .build();
    }
}
