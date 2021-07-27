package game.config.box;

import game.config.base.MapConfigDataBox;
import game.config.data.ExpressConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:47
 */
public class ExpressDataBox extends MapConfigDataBox<ExpressConfigData> {


    public ExpressDataBox() {
        super("data/express_路线.json");
    }
}
