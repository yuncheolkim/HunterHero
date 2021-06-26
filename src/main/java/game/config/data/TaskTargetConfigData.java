package game.config.data;

import game.config.base.BaseConfigData;
import game.config.base.DataConfigData;

/**
 * @author Yunzhe.Jin
 * 2021/6/8 14:22
 */
public class TaskTargetConfigData extends BaseConfigData<TaskTargetConfigData> {

    public int type;
    public int v1;
    public int v2;
    public int v3;
    public int v4;
    public int v5;

    @Override
    protected void fill(DataConfigData d) {
        type = d.type;
        v1 = d.v1;
        v2 = d.v2;
        v3 = d.v3;
        v4 = d.v4;
        v5 = d.v5;

    }
}
