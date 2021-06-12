package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/12 19:08
 */
public class FishAreaConfigData extends BaseConfigData<FishAreaConfigData> {
    public int sceneId;

    @Override
    public FishAreaConfigData convert(DataConfigData data) {
        FishAreaConfigData convert = super.convert(data);
        convert.sceneId = data.i1;
        return convert;
    }
}
