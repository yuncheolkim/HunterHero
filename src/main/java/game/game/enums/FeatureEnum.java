package game.game.enums;

import game.player.Player;
import game.proto.HomeOpenAreaRqRs;
import game.proto.data.HomeData;
import game.proto.no.No;

/**
 * @author Yunzhe.Jin
 * 2021/6/16 20:29
 */
public enum FeatureEnum {
    银行(0),
    钓鱼(1),
    跑镖(2),
    家园(3) {
        @Override
        public void openPrepare(Player player) {
            player.pd.setHomeData(HomeData.newBuilder().setOpenArea(1 << 24));

            player.send(No.HomeOpenAreaRqRs, HomeOpenAreaRqRs.newBuilder()
                    .setId(24).buildPartial());
        }
    },
    ;

    public final int id;

    public final int index;

    FeatureEnum(int i) {
        index = i;
        id = 1 << i;
    }

    public void openPrepare(Player player) {

    }
}
