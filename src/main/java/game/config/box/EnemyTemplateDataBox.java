package game.config.box;

import game.config.base.ListConfigDataBox;
import game.config.data.EnemyTemplatePropertyConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:38
 */
public class EnemyTemplateDataBox extends ListConfigDataBox<EnemyTemplatePropertyConfigData> {
    public EnemyTemplateDataBox() {
        super("data/data_21-怪模版.json");
    }

}
